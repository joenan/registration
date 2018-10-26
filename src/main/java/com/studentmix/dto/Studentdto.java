/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.dto;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Studentdto implements Dto {
    private Long studentid;
    private String email;
    
    private String firstname;
    
    
    private String lastname;
    // 
    
    
    private String phone;
    
    
    private String gender;
    
    private List<Registrationdto> registrationList;

    public Studentdto() {
    }

    public Studentdto(Long studentid) {
        this.studentid = studentid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public List<Registrationdto> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registrationdto> registrationList) {
        this.registrationList = registrationList;
    }

    
    
}
