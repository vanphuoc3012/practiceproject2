package com.likelion.spring.repository;

import com.likelion.spring.dto.DepartmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Long> {
}
