package com.hcl.abcstock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.abcstock.models.Transaction;
import com.hcl.abcstock.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
