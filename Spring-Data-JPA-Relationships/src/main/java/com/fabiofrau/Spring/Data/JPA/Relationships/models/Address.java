package com.fabiofrau.Spring.Data.JPA.Relationships.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    private String streetName;

    private String houseNumber;

    private String zipCode;


}
