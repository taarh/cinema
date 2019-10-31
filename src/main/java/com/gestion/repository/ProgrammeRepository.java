package com.gestion.repository;

import com.gestion.modele.Programme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface ProgrammeRepository extends MongoRepository<Programme,Long> {


}
