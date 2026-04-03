package com.jobportal.repository;

import com.jobportal.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> {
    Optional<UsersType> findByUserTypeNameIgnoreCase(String userTypeName);
}
