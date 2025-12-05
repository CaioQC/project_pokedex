package com.project.pokedex.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pokedex.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

}
