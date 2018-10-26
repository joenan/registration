/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.utils;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nandom Gusen
 */
@ManagedBean
@SessionScoped
public class InfoController implements Serializable{
    private String adminHeaderText;
    private String headerText;
    @PostConstruct
    public void init(){
        headerText="Dashboard";
    }
    public String updateDashBoard(String text) {
        switch (text) {
            case "not":
                headerText = "Notification Management";
                return "notification.html?faces-redirect=true";
            case "test":
                headerText = "Test Module";
                return "test.html?faces-redirect=true";
            case "assignment":
                headerText = "Assignment Module";
                return "task.html?faces-redirect=true";
                
             case "settings":
                headerText = "Account Settings";
                return "settings.html?faces-redirect=true";   
                 case "events":
                headerText = "School Events";
                return "events.html?faces-redirect=true";   
            
            default:
                headerText = "Application Dashboard";
                return "dashboard.html?faces-redirect=true";
        }

    }

    public String getAdminHeaderText() {
        return adminHeaderText;
    }

    public void setAdminHeaderText(String adminHeaderText) {
        this.adminHeaderText = adminHeaderText;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }
    

}
