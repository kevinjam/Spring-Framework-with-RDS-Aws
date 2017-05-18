package com.springboot.dao;

import com.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by kevinjanvier on 17/05/2017.
 */
@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {


    @Override
    public Collection<Student> getAllStudent() {
        return new ArrayList<Student>(){
            {
                add(new Student(1, "Emodeck", "Nothing"));
                add(new Student(2, "Ivan Mworozi", "Java"));

            }

        };
    }


    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
