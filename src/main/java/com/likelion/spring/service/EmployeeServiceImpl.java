package com.likelion.spring.service;

import com.likelion.spring.dto.EmployeeDTO;
import com.likelion.spring.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepo;

    private final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        LOG.debug("Saving new employee name: {}", employeeDTO.getName());
        return employeeRepo.save(employeeDTO);
    }

    public List<EmployeeDTO> getAllEmployee() {
        LOG.debug("Get all employee");
        return employeeRepo.findAll();
    }
}
