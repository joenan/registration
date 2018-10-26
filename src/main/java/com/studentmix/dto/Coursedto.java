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
public class Coursedto implements Dto {
    private Long courseid;
    
    private String coursecode;
    
    
    private String coursedescription;
    
    private List<Registrationdto> registrationList;

    public Coursedto() {
    }

    public Coursedto(Long courseid) {
        this.courseid = courseid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription;
    }

    
    public List<Registrationdto> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registrationdto> registrationList) {
        this.registrationList = registrationList;
    }

    
}
