package com.likelion.spring.restcontroller;

import com.likelion.spring.dto.EmployeeDTO;
import com.likelion.spring.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl  employeeService;

    private final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public ResponseEntity createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,
                                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors()
                    .stream()
                    .map(f -> f.getDefaultMessage().toString())
                    .collect(Collectors.toList()));
        }
        return ResponseEntity.ok(employeeService.save(employeeDTO));
    }

    @GetMapping
    public ResponseEntity getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

}
