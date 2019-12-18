package com.gestion.utiles;

import com.gestion.modele.FilmSequences;
import com.gestion.modele.Sequences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * classe générique permettant d'incrementer la sequence.
 * @param <T>
 *  T correspond au type de sequence.
 */
@Service
public class NextSequenceService <T extends  Sequences>{
        @Autowired
        private MongoOperations mongo;
        private Class<T> typeOfT;


         @Bean
        public Class<T> getTypeOfT() {
           return typeOfT;
        }

         public void setTypeOfT(Class<T> typeOfT) {
            this.typeOfT = typeOfT;
        }

        public long getNextSequence(String seqName)
        {
            T counter = mongo.findAndModify(
                    Query.query(where("_id").is(seqName)),
                    new Update().inc("seq",1),
                    FindAndModifyOptions.options().returnNew(true).upsert(true),typeOfT);
            return counter.getSeq();
        }
    }


