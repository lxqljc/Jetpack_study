package com.lxqljc.roomdemo.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lxqljc.roomdemo.model.Student;

import java.util.List;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/15
 * description: 描述
 */
@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    @Update
    void updateStudent(Student student);

    @Query("select * from student")
    List<Student> getStudentList();

    @Query("select * from student where id = :id")
    Student getStudentById(int id);
}
