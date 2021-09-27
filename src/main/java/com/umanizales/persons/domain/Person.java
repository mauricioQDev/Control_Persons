package com.umanizales.persons.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    @NotEmpty
    private String name;

    @NotEmpty
    private String identification;

    @Positive
    private byte age;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
}
