package com.example.GreetingApp.repository;

import com.example.GreetingApp.dto.GreetingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingDTO, Long> {
}
