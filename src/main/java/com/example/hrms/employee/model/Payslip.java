package com.example.hrms.employee.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Payslip {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String employeeName;
    private BigDecimal amount;}
