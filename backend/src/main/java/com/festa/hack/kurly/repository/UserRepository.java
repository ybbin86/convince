package com.festa.hack.kurly.repository;

import com.festa.hack.kurly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

}
