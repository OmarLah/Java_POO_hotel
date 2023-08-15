package org.example.classes;

import java.util.ArrayList;

public class Client {

    private int id;
    private String lastname;
    private String firstname;
    private String nbPhone;
    private static int compt = 0;


    public Client() {
    }
    public Client(int id, String lastname, String firstname, String nbPhone) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.nbPhone = nbPhone;
        this.id = id;
    }
    public Client(String lastname, String firstname, String nbPhone) {
        compt++;
        this.lastname = lastname;
        this.firstname = firstname;
        this.nbPhone = nbPhone;
        this.id = compt;
    }

    public Client(String lastname, String firstname) {
        compt++;
        this.lastname = lastname;
        this.firstname = firstname;
        this.id = compt;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getNbPhone() {
        return nbPhone;
    }

    public void setNbPhone(String nbPhone) {
        this.nbPhone = nbPhone;
    }

    @Override
    public String toString() {
        return "Client(e) n°" + this.getId() +
                ": nom = " + this.getLastname() +
                ", prénom = " + this.getFirstname() +
                ", numéro de téléphone = " + this.getNbPhone();
    }

    public ArrayList<Client> clientsList() {
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client ( "Dupont", "Marc",  "0649784512"));
        clients.add(new Client( "Martin", "Benoit",  "0651224935"));
        clients.add(new Client("Crin", "Annie",  "0745129641"));
        clients.add(new Client( "Vaillant", "Claire",  "0612553195"));

        return clients;
    }


}
