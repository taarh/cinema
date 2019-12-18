package com.gestion.repository;

import com.gestion.modele.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

        User findByUsername(String username);

}
