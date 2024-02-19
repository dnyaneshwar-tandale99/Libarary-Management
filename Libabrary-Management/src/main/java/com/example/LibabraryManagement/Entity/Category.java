package com.example.LibabraryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",length = 50,nullable = false)
    private String name;
    @ManyToMany(mappedBy = "categories",cascade = {CascadeType.ALL})
    private Set<Book> books=new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}
