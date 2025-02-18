package com.dikshant.user.service.repositories;

import com.dikshant.user.service.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
