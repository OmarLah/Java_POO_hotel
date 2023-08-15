package org.example.classes;

import java.util.ArrayList;

public class Reservation {

    private int id;
    private boolean status;
    private ArrayList<Chambre> chambres = new ArrayList<>();

    private Client client;
    private static int compt;

    public Reservation(ArrayList<Chambre> chambres, Client client) {
        compt++;
        id = compt;
        this.status = true;
        this.chambres = chambres;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Chambre> getListeRoom() {
        return chambres;
    }

    public void setListeRoom(ArrayList<Chambre> listeRoom) {
        this.chambres = listeRoom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean statusReservate(Chambre chambre) {
        if(!chambre.isStatus()) {
            chambre.changeStatus();
            this.status = true;
        }
        return this.status;
    }

    public boolean statusNotReservate(Chambre chambre) {
        if(chambre.isStatus()) {
            chambre.changeStatus();
            this.status = false;
        }
        return this.status;
    }

}
