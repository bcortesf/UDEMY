package com.company.springbootjparelationship.entitys;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;

    // @joi
    /*
     * Prohibido CascadeType."REMOVE":
     * - por reglas de integridad y FORANEAS a otros MUCHOS-A-MUCHOS
     * - porque es compartido uno ID con el otro ID y visceversa
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Course> courses;


    public Student() {
        // this.courses = new HashSet<>();   //No mantiene orden
        this.courses = new LinkedHashSet<>();//mantiene orden
    }
    public Student(String name, String lastname) {
        this(); //->llama constrctor vacio: por si necesito instanciar la lista."course" para datos
        this.name = name;
        this.lastname = lastname;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


    @Override
    public String toString() {
        return "{id=" + id +
                ", name=" + name +
                ", lastname=" + lastname +
                ", courses=" + courses +
                "]";
    }

}