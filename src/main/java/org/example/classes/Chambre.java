package org.example.classes;

public class Chambre {

    private int number;
    private boolean status;
    private int nbBed;
    private double price;

    public Chambre(int number, int nbBed, double price) {
        this.nbBed = nbBed;
        this.price = price;
        this.number = number;
        this.status = false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNbBed() {
        return nbBed;
    }

    public void setNbBed(int nbBed) {
        this.nbBed = nbBed;
    }

    public double getPrice() {
        return price;
    }

    public void setTarif(double price) {
        this.price = price;
    }

    public boolean changeStatus() {
        return this.status = !this.status;
    }

    @Override
    public String toString() {
        return "Chambre n°" + this.number
                + ", Contient " + this.nbBed
                + " lit(s), et coûte "
                + this.price + "€. Status = " + this.isStatus();
    }
}
