package com.simul.wisdompet.data.repositories;

import com.simul.wisdompet.data.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
