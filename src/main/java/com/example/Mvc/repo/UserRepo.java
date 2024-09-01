package com.example.Mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mvc.model.Security;

@Repository
public interface UserRepo extends JpaRepository<Security,Integer>  {
  Security findByUsername(String username);
}
