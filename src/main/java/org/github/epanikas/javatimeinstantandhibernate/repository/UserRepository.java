package org.github.epanikas.javatimeinstantandhibernate.repository;

import org.github.epanikas.javatimeinstantandhibernate.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}