package com.example.soundlifeapi.repository;

import com.example.soundlifeapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    @Query("select qd from UserEntity qd where qd.username = :#{#req.username}")
    Optional<UserEntity> findQuestionDetails(@Param("req") UserEntity req);

}
