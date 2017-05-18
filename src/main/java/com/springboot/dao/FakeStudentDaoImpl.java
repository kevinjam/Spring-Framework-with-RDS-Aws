package com.springboot.dao;

import com.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevinjanvier on 17/05/2017.
 */

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {
    private static Map<Integer , Student> students;

    static {

        students = new HashMap<Integer, Student>(){

            {
                put(1, new Student(1, "kevin", "computer"));
                put(2, new Student(2, "Janvier", "computer"));
                put(3, new Student(3, "Isabella", "computer"));
                put(4, new Student(4, "Samuel", "computer"));

            }
        };
    }

    //
    @Override
    public Collection<Student> getAllStudent(){
        return students.values();
    }

    @Override
    public Student getStudentById(int id){

        return students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        students.remove(id);

    }

    //update
    @Override
    public void updateStudent(Student student){
        Student std = students.get(student.getId());
        std.setCourse(student.getCourse());
        std.setName(student.getName());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
