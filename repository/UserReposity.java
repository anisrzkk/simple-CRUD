package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.models.User;

public interface UserReposity extends JpaRepository<User,Long>{

}
