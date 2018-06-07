package com.ucbcba.demo.repository;

import com.ucbcba.demo.Entities.City;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CityRepository extends CrudRepository<City, Integer> {

}
