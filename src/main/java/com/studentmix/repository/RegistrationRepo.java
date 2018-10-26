/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.repository;

import com.studentmix.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nandom Gusen
 */
public interface RegistrationRepo extends JpaRepository<Registration,Long> {
    
}
