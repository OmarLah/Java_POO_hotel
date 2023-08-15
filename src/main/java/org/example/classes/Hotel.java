package org.example.classes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hotel {

    private ArrayList<Client> clients;
    private ArrayList<Chambre> chambres;
    private ArrayList<Reservation> reservations;
    private String name;

    public static int compt;

    public Hotel(String name) {
        this.clients = new Client().clientsList();;
        this.chambres = this.createChambresList();
        this.reservations = new ArrayList<>();
        compt = this.clients.size();
        this.name = name;
    }
    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Chambre> createChambresList() {
        ArrayList<Chambre> chambres = new ArrayList<>();

        Random random = new Random();
        int nb = random.nextInt(1, 51);

        for(int i = 1; i < nb; i++) {
            int nbBed = random.nextInt(1,4);
            int nbPrice = random.nextInt(29, 101);
            chambres.add(new Chambre(i, nbBed, nbPrice));
        }
        return chambres;
    }

    public void createReservation(Client client) {
        ArrayList<Chambre> chambres = new ArrayList<>();

        for(int i = 0; i < this.getChambres().size(); i++) {
            if (this.chambres.get(i).isStatus() == true) {
                chambres.add(this.chambres.get(i));
            }
        }

        Reservation res = new Reservation(chambres, client);
        this.reservations.add(res);

        for(int i = 0; i < this.reservations.size(); i++) {
            this.reservations.get(i).statusReservate(this.chambres.get(i));
        }
    }

    public void DeleteReservation(Client client) {
        if (!reservationByClient(client).isEmpty()) {
            System.out.println(reservationByClient(client));

            Scanner sc = new Scanner(System.in);
            System.out.print("Quelle réservation voulez-vous Annuler ? ");
            int nb = sc.nextInt();

            boolean rem = false;
            for (int i = 0; i < this.reservations.size(); i++) {
                if (this.reservations.get(i).getId() == nb
                        && this.reservations.get(i).getClient().getLastname().equals(client.getLastname())
                        && this.reservations.get(i).getClient().getFirstname().equals(client.getFirstname())) {

                    this.reservations.remove(i);
                    this.reservations.get(i).statusNotReservate(this.chambres.get(i));
                    rem = true;
                    System.out.println("La réservation à été annulée avec succès !");
                }
            }
            if (!rem) {
                System.out.println("Le numéro de réservation pour ce client n'existe pas");
            }
        } else {
            System.out.println("Pas de réservation pour ce client.");
        }
    }

    public  String reservationByClient(Client client) {
        String str = "";
        int count = 0;
        for(int i = 0; i < this.reservations.size(); i++) {
            if(this.reservations.get(i).getClient().getLastname().equals(client.getLastname()) && this.reservations.get(i).getClient().getFirstname().equals(client.getFirstname())){
                count++;
                str += "Reservation n°" + count + "): Numéro de résevation "
                        + this.reservations.get(i).getId()
                        + ", pour client : " + this.reservations.get(i).getClient().getLastname() + " " + this.reservations.get(i).getClient().getFirstname()
                        + ", chambre n°" + this.chambres.get(i).getNumber()
                        + ", nombre de lit(s) = " + this.chambres.get(i).getNbBed()
                        + ", au prix de " + this.chambres.get(i).getPrice() + "€.\n";
            }
        }
        return str;
    }

    public String reservationList() {
        String str = "";
        for(int i = 0; i < this.reservations.size(); i++) {
            str += "Reservation n°"
                    + this.reservations.get(i).getId()
                    + ", pour client : " + this.reservations.get(i).getClient().getLastname() + " " + this.reservations.get(i).getClient().getFirstname()
                    + ", chambre n°" + this.chambres.get(i).getNumber()
                    + ", nombre de lit(s) = " + this.chambres.get(i).getNbBed()
                    + ", au prix de " + this.chambres.get(i).getPrice() + "€.\n";
        }
        return str;
    }

}
