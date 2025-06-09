package com.nuevaeps.auth.infrastruture.output.persistence.repositories;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import com.nuevaeps.auth.infrastruture.input.models.FilterUserRequest;
import com.nuevaeps.auth.infrastruture.output.persistence.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    boolean existsByEmail(String email);
    boolean existsByEmailAndActiveTrue(String email);
    UserEntity findByEmail(String email);
    Set<UserEntity> findByUserIdIn(Set<Integer> userIds); 


   
    @Query("SELECT u FROM UserEntity u " +
        "WHERE (:#{#filter.numberDocument} IS NULL OR u.numberDocument = :#{#filter.numberDocument})" +
        "AND (:#{#filter.names} IS NULL OR :#{#filter.names} = '' OR LOWER(u.names) LIKE CONCAT('%', LOWER(:#{#filter.names}), '%'))" +
        "AND (:#{#filter.lastNames} IS NULL OR :#{#filter.lastNames} = '' OR  LOWER(u.lastNames) LIKE CONCAT('%',  LOWER(:#{#filter.lastNames}), '%'))" +
        "AND (:#{#filter.email} IS NULL OR :#{#filter.email} = '' OR  LOWER(u.email) LIKE CONCAT('%',  LOWER(:#{#filter.email}), '%'))" +
        "AND (:#{#filter.active} IS NULL OR u.active = :#{#filter.active})"
    )
    Page<UserEntity> filterAndPaginateUsers(@Param("filter") FilterUserRequest filter,Pageable pageable);
}
