/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nandom Gusen
 */
@Service
@Transactional
public class AppService {
@Autowired
StudentRepo studentRepo;
@Autowired
CourseRepo courseRepo;
@Autowired
RegistrationRepo registrationRepo;

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public CourseRepo getCourseRepo() {
        return courseRepo;
    }

    public RegistrationRepo getRegistrationRepo() {
        return registrationRepo;
    }

}
