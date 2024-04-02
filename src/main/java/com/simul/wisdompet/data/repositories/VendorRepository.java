package com.simul.wisdompet.data.repositories;

import com.simul.wisdompet.data.entities.VendorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VendorRepository extends CrudRepository<VendorEntity, Long> {

}
