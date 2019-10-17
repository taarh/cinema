package com.gestion.repository;

import com.gestion.modele.Salle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends MongoRepository<Salle,Long> {


}
