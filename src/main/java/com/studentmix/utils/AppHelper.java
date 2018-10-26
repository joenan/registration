/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.utils;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author Nandom Gusen
 */
@ManagedBean
@SessionScope
public class AppHelper implements Serializable {

   private Long studentid;
   private Long courseid;
   private Long registrationid;
   private String username;
   private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public Long getRegistrationid() {
        return registrationid;
    }

    public void setRegistrationid(Long registrationid) {
        this.registrationid = registrationid;
    }

        

}
