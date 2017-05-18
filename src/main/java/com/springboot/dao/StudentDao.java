package com.springboot.dao;

import com.springboot.entity.Student;

import java.util.Collection;

/**
 * Created by kevinjanvier on 17/05/2017.
 */
public interface StudentDao {
    //
    Collection<Student> getAllStudent();

    Student getStudentById(int id);

    void removeStudentById(int id);

    //update
    void updateStudent(Student student);

    void insertStudent(Student student);
}
