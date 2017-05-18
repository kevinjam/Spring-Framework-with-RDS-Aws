package com.springboot.service;

import com.springboot.dao.StudentDao;
import com.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by kevinjanvier on 17/05/2017.
 */
@Service
public class StudentService {

    @Autowired
    @Qualifier("mysqlData")
    private StudentDao studentDao;

    public Collection<Student> getAllStudent(){

        return studentDao.getAllStudent();
    }


    public Student getStudentById(int id){

        return studentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
       studentDao.updateStudent(student);
    }

    public void insetStudent(Student student) {
        studentDao.insertStudent(student);
    }
}
