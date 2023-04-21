package com.bah.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.bah.demo.domain.Products;
import com.bah.demo.domain.Users;
import com.bah.demo.exception.UserNotFoundException;
import com.bah.demo.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository userRepo;

    // ! --------------------------- getAll ---------------------------
    @Override
    public List<Users> getAll() {
        return userRepo.findAll();
    }
    // ! --------------------------- /getAll ---------------------------

    // ! --------------------------- getById ---------------------------
    @Override
    public Users getById(String id) {
        return getExistingUserById(id);
    }
    // ! --------------------------- /getById ---------------------------

    // ! --------------------------- createUser ---------------------------
    @Override
    public Users createUser(Users user) {
        return userRepo.save(user);
    }
    // ! --------------------------- /createUser ---------------------------

    // ! --------------------------- updateUser ---------------------------
    @Override
    public Users updateUser(Users userUpdates) {
        validateUser(userUpdates);
        Users existingUser = getExistingUserById(userUpdates.getId());
        existingUser = mergeUpdates(existingUser, userUpdates);
        return userRepo.save(existingUser);
    }
    // ! --------------------------- /updateUser ---------------------------

    // ! --------------------------- deleteById ---------------------------
    @Override
    public void deleteById(String id) {
        if (id != null) {
            userRepo.deleteById(id);
        }
        // else null User.id does not exist. No delete necessary
    }
    // ! --------------------------- /deleteById ---------------------------

    // ? --------------------------- Internal Methods ---------------------------
    /**
     * Returns {@link Users} if id exists, else throws {@link UserNotFoundException}
     * 
     * @param user
     * @return {@link Users} from db
     */
    private Users getExistingUserById(@NonNull String id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Throws {@link UserNotFoundException} for null {@link Users} or blank Users.id
     * 
     * @param user
     * @return true for valid Users
     */
    private Boolean validateUser(Users user) {
        if (user == null || user.getId() == null) {
            throw new UserNotFoundException("NULL");
        }

        return true;
    }

    /**
     * sets user fields to nonnull values in updates
     * 
     * @param user    - base {@link Users} to update
     * @param updates - updates to apply to user
     * @return {@link Users} with updates applied
     */
    public Users mergeUpdates(Users user, Users updates) {
        if (updates.getFirstName() != null) {
            user.setFirstName(updates.getFirstName());
        }
        if (updates.getLastName() != null) {
            user.setLastName(updates.getLastName());
        }
        if (updates.getProducts() != null) {
            if (user.getProducts() == null) {
                user.setProducts(updates.getProducts());
            } else {
                user.getProducts().addAll(updates.getProducts());
            }
        }

        return user;
    }

}
