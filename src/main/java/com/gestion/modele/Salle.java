package com.gestion.modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Salle")
public class Salle {
    @Id
    private int id;
    private String sale_name;
    private String sale_adresse;
    private String salle_nbrePieces;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSale_name() {
        return sale_name;
    }

    public void setSale_name(String sale_name) {
        this.sale_name = sale_name;
    }

    public String getSale_adresse() {
        return sale_adresse;
    }

    public void setSale_adresse(String sale_adresse) {
        this.sale_adresse = sale_adresse;
    }

    public String getSalle_nbrePieces() {
        return salle_nbrePieces;
    }

    public void setSalle_nbrePieces(String salle_nbrePieces) {
        this.salle_nbrePieces = salle_nbrePieces;
    }


}

