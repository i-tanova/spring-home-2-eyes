package com.tanovait.home2eye.repository;

import com.tanovait.home2eye.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
