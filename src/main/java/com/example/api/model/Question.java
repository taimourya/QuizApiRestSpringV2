package com.example.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libele;

    private String reponses;
    private String reponseCorrect;

    public Question() {
    }

    public Question(String libele, String reponses, String reponseCorrect) {
        this.libele = libele;
        this.reponses = reponses;
        this.reponseCorrect = reponseCorrect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getReponses() {
        return reponses;
    }

    public void setReponses(String reponses) {
        this.reponses = reponses;
    }

    public String getReponseCorrect() {
        return reponseCorrect;
    }

    public void setReponseCorrect(String reponseCorrect) {
        this.reponseCorrect = reponseCorrect;
    }
}
