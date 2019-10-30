package com.sda.project.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(@Param("email") String email);
//    Optional<User> findByFirstName(@Param("firstName") String firstName);
}


