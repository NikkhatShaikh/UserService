package com.nikkhat.user.service.repository;

import com.nikkhat.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
