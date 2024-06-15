package org.example.demoexams3.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Hamster")
public class Hamster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String data;
    private String color;
    private String characteristics;
}
