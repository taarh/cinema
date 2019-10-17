package com.gestion.repository;

import com.gestion.modele.Programme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgrammeRepository extends MongoRepository<Programme,Long> {


}
