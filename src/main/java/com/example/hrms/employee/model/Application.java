package com.example.hrms.employee.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    private String id;
    private String applicantName;
    private String jobTitle;
}
