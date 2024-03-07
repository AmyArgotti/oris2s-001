package com.example.oris2s001.repositories;

import com.example.oris2s001.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<User,Long> {

}