package com.likelion.spring.restcontroller;

import com.likelion.spring.dto.DepartmentDTO;
import com.likelion.spring.repository.DepartmentRepository;
import com.likelion.spring.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @PostMapping
    public ResponseEntity createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO,
                                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors().stream()
                    .map(f -> f.getDefaultMessage())
                    .collect(Collectors.toList()));
        }
        return ResponseEntity.ok(departmentService.save(departmentDTO));
    }
}
