package com.likelion.spring.service;

import com.likelion.spring.dto.DepartmentDTO;
import com.likelion.spring.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl {

    @Autowired
    private DepartmentRepository departmentRepo;

    private final Logger LOG = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        LOG.debug("Saving new department: {}", departmentDTO.getDeptName());
        return departmentRepo.save(departmentDTO);
    }

    public List<DepartmentDTO> getAllDepartment() {
        LOG.debug("Getting all department from database");
        return departmentRepo.findAll();
    }
}
