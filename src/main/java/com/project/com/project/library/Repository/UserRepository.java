package com.project.com.project.library.Repository;

import com.project.com.project.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
