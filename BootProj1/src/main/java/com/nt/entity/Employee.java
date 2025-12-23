package com.nt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee")
public class Employee {

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 30)
    @NonNull
    private String name;
    
    @Column(length = 30)
    @NonNull
    private String addr;
    
    private Double salary;
}
