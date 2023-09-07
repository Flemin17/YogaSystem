package com.springboot.couchbase.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.couchbase.entity.Yoga;
import com.springboot.couchbase.exception.EntityNotFound;
import com.springboot.couchbase.repository.YogaRepository;

//spring annotation
@Service
public class YogaService {

    @Autowired
    YogaRepository repository;

    //save new employee in the couchbase
    public void save(final Yoga e) {
        repository.save(e);
    }

    //get total count in the couchbase
    public long count() {
        return repository.count();
    }

    //get all employees from the couchbase
    public List<Yoga> getUsers() {
        final Iterable<Yoga> yogaIterable = repository.findAll();
        return StreamSupport.stream(yogaIterable.spliterator(), false).collect(Collectors.toList());
    }

    //get employee by id from the couchbase
    public Yoga getUser(final String eid) throws EntityNotFound {
        return repository.findById(eid).orElseThrow(EntityNotFound::new);
    }

  //insert employee by id from the couchbase
    public Yoga insertUser(final Yoga user) throws EntityNotFound {
        return repository.save(user);
    }
    
  //update employee by id from the couchbase
    public Yoga updateUser(final Yoga user) throws EntityNotFound {
        return repository.save(user);
    }
    
  //delete employee by id from the couchbase
    public void deleteUser(final String Id) throws EntityNotFound{
        repository.deleteById(Id);
    }
    //get employees by department from the couchbase
	/*
	 * public List<Yoga> getUsersByAddress(final String address) { return
	 * repository.findAllByAddress(address); }
	 */
}
