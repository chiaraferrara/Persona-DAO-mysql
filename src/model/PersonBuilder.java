package model;

//https://italiancoders.it/builder-pattern-un-ottima-alternativa-al-costruttore/
public class PersonBuilder {
    //private List<Person> list = new ArrayList<Person>();
    private int id;
    private String nome;
    private String cognome;
    private int eta;

    private String email;
    private String tel;

public PersonBuilder(int id){
    this.id = id;
}
public static PersonBuilder newBuilder(int id){
    return new PersonBuilder(id);
}

public PersonBuilder nome(String nome){
    this.nome = nome;
    return this;
}

public PersonBuilder cognome(String cognome){
    this.cognome = cognome;
    return this;
}

public PersonBuilder eta(int eta){
    this.eta = eta;
    return this;
}

public PersonBuilder email(String email){
    this.email = email;
    return this;
}

public PersonBuilder tel(String tel){
    this.tel = tel;
    return this;
}

public Person build(){
    return new Person(id, nome, cognome, eta, email, tel);

}

}