package it.marconi.repositories;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import it.marconi.domains.Login;

public interface LoginRepository extends JpaRepository<Login, UUID>{

    
} 