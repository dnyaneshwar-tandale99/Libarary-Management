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
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 50,unique = true,nullable = false)
    private String name;
    @ManyToMany(mappedBy = "publishers",cascade = {CascadeType.ALL})
    private Set<Book> books=new HashSet<>();

    public Publisher(String name) {
        this.name = name;
    }
}
