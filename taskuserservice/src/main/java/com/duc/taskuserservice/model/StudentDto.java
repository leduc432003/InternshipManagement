package com.duc.taskuserservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long studentId;
    private String name;
    private String email;
    private String major;
    private String phone;
    private String diaChi;
}
