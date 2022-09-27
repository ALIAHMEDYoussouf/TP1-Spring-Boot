package com.pwa22.demo;

import lombok.Data;

@Data
public class Personne {
    final long id;
    static long nextId = 0;

    public Personne() {
        this.id = nextId++;
    }

    public Personne(String nom, String prenom, int age, String Adresse) {
        this();
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.Adresse = Adresse;

    }

    String nom;
    String prenom;
    int age;
    String Adresse;

}
