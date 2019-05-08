package com.myspring.springbootmybatis.service;

import com.myspring.springbootmybatis.bean.Student;

public interface StudentService {

    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);
}
