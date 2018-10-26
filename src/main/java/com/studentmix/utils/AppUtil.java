/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

/**
 *
 * @author Nandom Gusen
 */
public class AppUtil {
    public final static String LOGIN_USER ="user";
    public final static Severity SUCCESS_TAG = FacesMessage.SEVERITY_INFO;
    public final static Severity ERROR_TAG = FacesMessage.SEVERITY_ERROR;
    public final static Severity WARNING_TAG = FacesMessage.SEVERITY_WARN;
    public final static Severity FATAL_TAG = FacesMessage.SEVERITY_FATAL;
    public final static String SERVER_ERROR = "An Error Occur Please Contact Administrator";
    public final static String DELETE_MESSAGE = "Record Deleted Successfully";
    public final static String CREATED = "Record Created Successfully";
    public final static String SUCCESS = "Success";
    public final static String UPDATED = "Record Updated Successfully";
}
