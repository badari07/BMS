package com.example.bookmyshow.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// automatically generate the id, auto increment
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
