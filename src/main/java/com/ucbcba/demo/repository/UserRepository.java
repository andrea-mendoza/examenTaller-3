package com.ucbcba.demo.repository;

import com.ucbcba.demo.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u ORDER BY u.cantComentarios DESC")
    Iterable<User> findTop3UsuariosCometadores();

    User findByUsername(String username);

}