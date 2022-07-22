package com.example.uzcard.repository;

import com.example.uzcard.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, String> {

    Optional<ProfileEntity> findById(String s);

    Optional<ProfileEntity> findByUsername(String username);
}
