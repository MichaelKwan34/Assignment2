package com.cmpt276.assignment2.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Integer>{
    // List<Student> findByName(String name);
    // List<Student> findByHeightAndWeight(int height, int weight);
    List<Student> deleteById(int id);

}
