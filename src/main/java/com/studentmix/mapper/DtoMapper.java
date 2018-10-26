/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.mapper;

import com.studentmix.dto.Coursedto;
import com.studentmix.dto.Registrationdto;
import com.studentmix.dto.Studentdto;
import com.studentmix.model.Course;
import com.studentmix.model.Registration;
import com.studentmix.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class DtoMapper {
public static Course maptoCourse(Coursedto mapfrom){
    if(mapfrom ==null){
        return null;
    }
    Course mapto = new Course();
    mapto.setCoursecode(mapfrom.getCoursecode());
    mapto.setCoursedescription(mapfrom.getCoursedescription());
    mapto.setCourseid(mapfrom.getCourseid());
    return mapto;
}
public static Coursedto maptoCoursedto(Course mapfrom){
    if(mapfrom ==null){
        return null;
    }
    Coursedto mapto = new Coursedto();
    mapto.setCoursecode(mapfrom.getCoursecode());
    mapto.setCoursedescription(mapfrom.getCoursedescription());
    mapto.setCourseid(mapfrom.getCourseid());
    return mapto;
}
public static List<Coursedto> maptoCourseList(List<Course> mapfrom){
    if(mapfrom ==null){
        return null;
    }
    List<Coursedto> list = new ArrayList<>();
    for(Course rs: mapfrom){
        list.add(maptoCoursedto(rs));
    }
    return list;
}
public static Student maptoStudent(Studentdto mapfrom){
    if(mapfrom ==null){
        return null;
    }
    Student mapto = new Student();
   mapto.setEmail(mapfrom.getEmail());
   mapto.setFirstname(mapfrom.getFirstname());
   mapto.setGender(mapfrom.getGender());
   mapto.setLastname(mapfrom.getLastname());
   mapto.setPhone(mapfrom.getPhone());
   mapto.setStudentid(mapfrom.getStudentid());
   return mapto;
}
public static Studentdto maptoStudentdto(Student mapfrom){
    if(mapfrom ==null){
        return null;
    }
    Studentdto mapto = new Studentdto();
   mapto.setEmail(mapfrom.getEmail());
   mapto.setFirstname(mapfrom.getFirstname());
   mapto.setGender(mapfrom.getGender());
   mapto.setLastname(mapfrom.getLastname());
   mapto.setPhone(mapfrom.getPhone());
   mapto.setStudentid(mapfrom.getStudentid());
   return mapto;
}
public static List<Studentdto> maptoStudentList(List<Student> mapfrom){
    if(mapfrom==null){
        return null;
    }
    List<Studentdto> list = new ArrayList<>();
    for(Student rs:mapfrom){
        list.add(maptoStudentdto(rs));
    }
    return list;
}
public static Registration maptoRegistration(Registrationdto mapfrom){
    if(mapfrom ==null){
        return null;
    }
    Registration mapto = new Registration();
    mapto.setCourseid(maptoCourse(mapfrom.getCourseid()));
    mapto.setDetailsid(mapfrom.getDetailsid());
    mapto.setStudentid(maptoStudent(mapfrom.getStudentid()));
    return mapto;
}
public static Registrationdto maptoRegistrationdto(Registration mapfrom){
    if(mapfrom ==null){
        return null;
    }
    Registrationdto mapto = new Registrationdto();
    mapto.setCourseid(maptoCoursedto(mapfrom.getCourseid()));
    mapto.setDetailsid(mapfrom.getDetailsid());
    mapto.setStudentid(maptoStudentdto(mapfrom.getStudentid()));
    return mapto;
}
public static List<Registrationdto> maptoRegistrationList(List<Registration> mapfrom){
    if(mapfrom ==null){
        return null;
    }
    List<Registrationdto> list = new ArrayList<>();
    for(Registration rs: mapfrom){
        list.add(maptoRegistrationdto(rs));
        
    }
    return list;
}
}
