/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nandom Gusen
 */
@Entity
@Table(name = "registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findByDetailsid", query = "SELECT r FROM Registration r WHERE r.detailsid = :detailsid")})
public class Registration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "detailsid")
    private Long detailsid;
    @JoinColumn(name = "courseid", referencedColumnName = "courseid")
    @ManyToOne
    private Course courseid;
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    @ManyToOne
    private Student studentid;

    public Registration() {
    }

    public Registration(Long detailsid) {
        this.detailsid = detailsid;
    }

    public Long getDetailsid() {
        return detailsid;
    }

    public void setDetailsid(Long detailsid) {
        this.detailsid = detailsid;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailsid != null ? detailsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.detailsid == null && other.detailsid != null) || (this.detailsid != null && !this.detailsid.equals(other.detailsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.studentmix.model.Registration[ detailsid=" + detailsid + " ]";
    }
    
}
