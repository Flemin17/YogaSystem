package com.springboot.couchbase.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.couchbase.entity.Yoga;

//couchbase annotations
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "employee")
//spring annotation
@Repository
public interface YogaRepository extends CrudRepository<Yoga, String> {

	//List<Yoga> findAllByAddress(String address);
}
