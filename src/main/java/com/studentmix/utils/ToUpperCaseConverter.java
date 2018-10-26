package com.studentmix.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("toUpperCaseConverter")
public class ToUpperCaseConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
    	if(submittedValue==null){
    		return null;
    	}
    	else{
    		String [] results =submittedValue.split(" ");
            String output="";
            for(String rs:results){
                output+=rs.substring(0,1).toUpperCase()+rs.substring(1,rs.length())+ " ";
            }	
    	return output;
    	}
    	
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        return (modelValue != null) ? modelValue.toString() : "";
    }

}