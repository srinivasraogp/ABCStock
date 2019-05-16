package com.hcl.abcstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.abcstock.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
