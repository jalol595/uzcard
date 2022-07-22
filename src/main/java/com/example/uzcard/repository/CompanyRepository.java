package com.example.uzcard.repository;

import com.example.uzcard.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {


    Optional<CompanyEntity> findByUsername(String username);
    boolean existsByName(String username);
    Optional<CompanyEntity> findByUsernameAndPassword(String username, String password);
}
