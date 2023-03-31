package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import domain.Products;

public interface ProductsRepository extends MongoRepository <Products, Long> {

}
