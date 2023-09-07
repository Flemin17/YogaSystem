package com.springboot.couchbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.couchbase.entity.Yoga;
import com.springboot.couchbase.exception.EntityNotFound;
import com.springboot.couchbase.service.YogaService;


import lombok.extern.slf4j.Slf4j;

//lombok annotation
@Slf4j
//spring annotations
@RestController
@RequestMapping("/api")
public class YogaController {

    @Autowired
    YogaService service;

    //URL - http://localhost:9300/api/employees
    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Yoga> getUsers() {
        return service.getUsers();
    }

    //URL - http://localhost:9300/api/employee/<eid>
    //Example - http://localhost:9300/api/employee/73a02968-70a8-426a-b6d8-deaa96a597df
    @GetMapping("/employee/{eid}")
    @ResponseStatus(HttpStatus.OK)
    public Yoga getUSer(@PathVariable String eid)
            throws EntityNotFound {
        return service.getUser(eid);
    }

    //URL - http://localhost:9300/api/employee/<work_department>
    //Example - http://localhost:9300/api/employees/Health
	/*
	 * @GetMapping("/employees/{work_department}")
	 * 
	 * @ResponseStatus(HttpStatus.OK) public List<Yoga>
	 * getUSersByAddress(@PathVariable(name = "work_department") String address) {
	 * return service.getUsersByAddress(address); }
	 */

    //URL - http://localhost:9300/api/employees/count
    @GetMapping("/employees/count")
    @ResponseStatus(HttpStatus.OK)
    public long getTotalUsers() {
        return service.count();
    }
    
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public Yoga registerUser(@RequestBody Yoga y) throws EntityNotFound {
        return service.insertUser(y);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Yoga updateUser(@RequestBody Yoga y) throws EntityNotFound {
        return service.updateUser(y);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteUser(@PathVariable("id") String id) throws EntityNotFound {
        service.deleteUser(id);
        
        return "User deleted successfully";
    }
}
