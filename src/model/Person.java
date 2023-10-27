package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Person {
    //private List<Person> list = new ArrayList<Person>();
    private int id;
    private String nome;
    private String cognome;
    private int eta;

    private String email;
    private String tel;


    public Person(int id, String nome, String cognome, int eta, String email, String tel) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.email = email;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getEmail() {
        return email;
        setChanged();
        notifyObservers(nuovaEmail);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}