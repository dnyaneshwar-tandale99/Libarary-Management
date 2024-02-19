package com.example.LibabraryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 100,nullable = false, unique = true)
    private String name;
    @Column(name="description",length = 255,nullable = false)
    private String description;
    @ManyToMany(mappedBy = "authors",cascade = {CascadeType.ALL})
    private Set<Book> books=new HashSet<>();

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Author author = (Author) obj;
        return Objects.equals(id, author.id);
    }

}
