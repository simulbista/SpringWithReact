package com.simul.wisdompet.data.repositories;

import com.simul.wisdompet.data.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {

}
