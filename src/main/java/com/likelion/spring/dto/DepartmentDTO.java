package com.likelion.spring.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class DepartmentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotBlank(message = "Department name is mandatory")
    @Length(min = 10, max = 50)
    private String deptName;

    private String description;

    @OneToMany
    private List<@Valid EmployeeDTO> employeeList;
}
