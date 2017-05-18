package com.springboot.dao;

import com.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by kevinjanvier on 18/05/2017.
 */
@Repository("mysqlData")
public class MysqlStudentImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Student> getAllStudent() {
        //        SELECT column_name(s) FROM table_name
        //Select data from my table
        final String sql = "SELECT id, name, course FROM students";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
//        SELECT column_name(s) FROM table_name where colomus  = values
        final String sql = "SELECT id, name, course FROM students where id =?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override
    public void removeStudentById(int id) {
//        DELETE FROM table_name
//        WHERE some_column = some_value
        String sql = "DELETE FROM students WHERE id =?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public void updateStudent(Student student) {
//        UPDATE table_name
//        SET column1=value, column2=value2,...
//        WHERE some_column=some_value
        final String sql = "UPDATE students SET name = ?, course = ? WHERE id = ?";
        final int id = student.getId();
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[]{name, course, id});
    }

    @Override
    public void insertStudent(Student student) {
//        INSERT INTO table_name (column1, column2, column3,...)
//        VALUES (value1, value2, value3,...)
        final String sql = "INSERT into students (name, course) VALUES(?,?)";
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[]{name, course});

    }

    private static class StudentRowMapper implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setCourse(rs.getString("course"));
            return student;
        }
    }

}
