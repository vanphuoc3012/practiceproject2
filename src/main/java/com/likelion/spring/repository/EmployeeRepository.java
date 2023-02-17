package com.likelion.spring.repository;

import com.likelion.spring.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {
}
