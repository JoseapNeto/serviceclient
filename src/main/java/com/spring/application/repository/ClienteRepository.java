package com.spring.application.repository;

import com.spring.application.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {


}
