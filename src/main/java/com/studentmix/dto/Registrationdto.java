/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.dto;
    
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Registrationdto implements Dto {
    private Long detailsid;
    
    
    private Coursedto courseid;
    
    
    private Studentdto studentid;

    public Registrationdto() {
    }

    public Registrationdto(Long detailsid) {
        this.detailsid = detailsid;
    }

    public Long getDetailsid() {
        return detailsid;
    }

    public void setDetailsid(Long detailsid) {
        this.detailsid = detailsid;
    }

    public Coursedto getCourseid() {
        return courseid;
    }

    public void setCourseid(Coursedto courseid) {
        this.courseid = courseid;
    }

    public Studentdto getStudentid() {
        return studentid;
    }

    public void setStudentid(Studentdto studentid) {
        this.studentid = studentid;
    }

    
}
