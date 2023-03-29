package com.workshop.kartaca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private Date lastdate;
    private Integer price;

}