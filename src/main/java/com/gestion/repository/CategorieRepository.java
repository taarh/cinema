package com.gestion.repository;

import com.gestion.modele.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends MongoRepository<Categorie,Long> {


}
