/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.controller;

import com.studentmix.dto.Coursedto;
import com.studentmix.dto.Registrationdto;
import com.studentmix.dto.Studentdto;
import com.studentmix.mapper.DtoMapper;
import com.studentmix.model.Course;
import com.studentmix.model.Registration;
import com.studentmix.model.Student;
import com.studentmix.repository.AppService;
import com.studentmix.utils.AppHelper;
import com.studentmix.utils.AppUtil;
import com.studentmix.utils.FacesUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nandom Gusen
 */
@SuppressWarnings("serial")
@Scope("session")
@Component
@ManagedBean
public class AppController implements Serializable {

    @Autowired
    AppService service;
    @Autowired
    ServletContext context;
    private List<Studentdto> studentList;
    private List<Coursedto> courseList;
    private List<Registrationdto> registrationList;
    private List<String> selectedCourses;
    @PostConstruct
    public void init() {
        selectedCourses = new ArrayList<>();
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
        registrationList = new ArrayList<>();
        reloadStudent();
        reloadCourse();
        reloadRegistration();
    }
   //login demo change this to dynamic from database
    public String checkLogin(){
        AppHelper app =(AppHelper)FacesUtils.getManagedBean("appHelper");
        if(app.getUsername().equals("admin")&& app.getPassword().equals("1234")){
            return "./apps/data/student.html?faces-redirect=true";
        }else{
            printMessage("Either Username/Password Not Correct", "Invalid Login", AppUtil.ERROR_TAG);
            return null;
        }
    }
    public void resetStudent(){
        reset("studentdto");
        selectedCourses = new ArrayList<>();
    }
//working with student data
    public void reloadStudent(){
        studentList =DtoMapper.maptoStudentList(service.getStudentRepo().findAll());
    }
    public void createStudent(ActionEvent e){
        service.getStudentRepo().save(getStudent());
        reloadStudent();
        printMessage(AppUtil.CREATED, AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
        reset("studentdto");
        selectedCourses = new ArrayList<>();
        
    }
    public Student getStudent(){
        Studentdto student =(Studentdto)FacesUtils.getManagedBean("studentdto");
        Student main =DtoMapper.maptoStudent(student);
        List<Registration> regList = new ArrayList<>();
        for(String rs:selectedCourses){
           Course c = new Course(Long.valueOf(rs));
           Registration reg = new Registration();
           reg.setCourseid(c);
           reg.setStudentid(main);
           regList.add(reg);
        }
        main.setRegistrationList(regList);
        return main;
    }
    public void deleteStudent(Long id){
        service.getStudentRepo().delete(id);
        reloadStudent();
        printMessage(AppUtil.DELETE_MESSAGE, AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
    }
   ///////////////working with course
    public void reloadCourse(){
        courseList =DtoMapper.maptoCourseList(service.getCourseRepo().findAll());
    }
    public void createCourse(ActionEvent e){
        Coursedto course =(Coursedto)FacesUtils.getManagedBean("coursedto");
        service.getCourseRepo().save(DtoMapper.maptoCourse(course));
        reloadCourse();
        printMessage(AppUtil.CREATED, AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
        reset("coursedto");
    }
    public void deleteCourse(Long id){
        service.getCourseRepo().delete(id);
        reloadCourse();
        printMessage(AppUtil.DELETE_MESSAGE, AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
    }
          ////////////////////////working with registration
    public void reloadRegistration(){
        registrationList =DtoMapper.maptoRegistrationList(service.getRegistrationRepo().findAll());
    }
    public void createRegistration(ActionEvent e){
        Registrationdto registration =(Registrationdto)FacesUtils.getManagedBean("registrationdto");
        AppHelper app =(AppHelper)FacesUtils.getManagedBean("appHelper");
        registration.setCourseid(new Coursedto(app.getCourseid()));
        registration.setStudentid(new Studentdto(app.getStudentid()));
        service.getRegistrationRepo().save(DtoMapper.maptoRegistration(registration));
        reloadRegistration();
        printMessage(AppUtil.CREATED, AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
        reset("registrationdto");
    }
    public void deleteRegistration(Long id){
        service.getRegistrationRepo().delete(id);
        reloadRegistration();
        printMessage(AppUtil.DELETE_MESSAGE, AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
    }
    
             public void printMessage(String message, String title, Severity messageType) {
        FacesContext contexts = FacesContext.getCurrentInstance();
        contexts.addMessage(null, new FacesMessage(messageType, title, message));
    }

    public void reset(String beanname) {
        FacesUtils.resetManagedBean(beanname);
    }

    public void storeToSession(String name, Object t) {
        HttpSession session = FacesUtils.getHttpSession(false);
        session.setAttribute(name, t);
    }
            public AppService getService() {
        return service;
    }

    public void setService(AppService service) {
        this.service = service;
    }

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public List<Studentdto> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Studentdto> studentList) {
        this.studentList = studentList;
    }

    public List<Coursedto> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Coursedto> courseList) {
        this.courseList = courseList;
    }

    public List<Registrationdto> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registrationdto> registrationList) {
        this.registrationList = registrationList;
    }

    public List<String> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(List<String> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }


}
