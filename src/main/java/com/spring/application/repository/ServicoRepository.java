package com.spring.application.repository;

import com.spring.application.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Integer> {
}
