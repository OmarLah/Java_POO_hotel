package org.example.ihm;
import org.example.classes.Hotel;
import org.example.classes.Client;

import java.util.Scanner;

public class ConsoleIhm {

    private static Scanner sc = new Scanner(System.in);
    private static Hotel hotel;

    public void start() {
        System.out.print("Quel est le nom de l'hôtel ? ");
        String name = sc.nextLine();
        hotel = new Hotel(name);
        System.out.println(hotel.getName() + " créé avec succès !");

        int num;
        do {
            System.out.println("=== Menu Principal ===");
            System.out.println();
            System.out.println("1. Ajouter un client");
            System.out.println("2. Afficher la liste des clients");
            System.out.println("3. Afficher les réservations d'un client");
            System.out.println("4. Ajouter une reservation");
            System.out.println("5. Annuler une reservation");
            System.out.println("6. Afficher la liste des reservations");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            num = sc.nextInt();

            switch (num) {
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    listClients();
                    break;
                case 3:
                    reservationClient();
                    break;
                case 4:
                    ajouterReservation();
                    break;
                case 5:
                    annulerReservation();
                    break;
                case 6:
                    listReservation();
                    break;
                case 0:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Valeur séléctionné non valide. Choisir une valeur valide !!!");

            }

        } while(num != 0);

        bye();
    }

    public void ajouterClient() {
        System.out.println("=== Ajout d'un client ===");
        System.out.println();
        sc.nextLine();
        System.out.println("Quel est le nom du client? ");
        String lastname = sc.nextLine();
        System.out.println("Quel est le prénom du client? ");
        String firstname = sc.nextLine();
        System.out.println("Quel est le numéro de téléphone du client? ");
        String numberfone = sc.nextLine();
        Client client = new Client(lastname, firstname, numberfone);
        hotel.getClients().add(client);
        System.out.println("Client ajouté avec succès !");
    }

    public void listClients() {
        System.out.println("=== Liste des clients ===");
        System.out.println();
        for(int i = 0; i < hotel.getClients().size(); i++) {
            System.out.println(hotel.getClients().get(i).toString());
        }
    }

    public void reservationClient() {
        System.out.println("=== Réservations par client ===");
        System.out.println();
        System.out.println("Quel est le nom du client dont vous voulez la liste de réservations ?");
        sc.nextLine();
        String lastname = sc.nextLine();
        System.out.println("Quel est le prénom du client dont vous voulez la liste de réservations ?");
        String firstname = sc.nextLine();
        System.out.println(hotel.reservationByClient(new Client(lastname, firstname)));
        System.out.println(hotel.getChambres());
        System.out.println();
        System.out.println(hotel.reservationList());
    }

    public void ajouterReservation() {
        System.out.println("=== Ajouter une réservation ===");
        System.out.println();
        System.out.println("1. Souhaitez-vous ajouter une réservation pour un client déjà enregistré dans l'hôtel");
        System.out.println("2. Souhaitez-vous ajouter une réservation pour un nouveau client ");
        int nb = sc.nextInt();
        if(nb == 1) {
            sc.nextLine();
            System.out.println("Quel est le nom du client? ");
            String lastname = sc.nextLine();
            System.out.println("Quel est le prénom du client? ");
            String firstname = sc.nextLine();
            String str = "";
            for(int i = 0; i < hotel.getClients().size(); i++) {
                if(hotel.getClients().get(i).getLastname().equals(lastname) && hotel.getClients().get(i).getFirstname().equals(firstname)){
                    hotel.createReservation(hotel.getClients().get(i));
                    str = "Réservation effectué avec succès pour " + lastname + " " + firstname;
                    break;
                }


            }
            if(str.equals("")) {
                System.out.println("Le client demandé n'existe pas dans cette hôtel.");
                System.out.println("Enregistrez le en tant que nouveau client !");
            } else {
                System.out.println(str);
            }
        }
        else if(nb == 2) {
            sc.nextLine();
            System.out.println("Quel est le nom du client? ");
            String lastname = sc.nextLine();
            System.out.println("Quel est le prénom du client? ");
            String firstname = sc.nextLine();
            System.out.println("Quel est le numéro de téléphone du client? ");
            String numberfone = sc.nextLine();
            Client client = new Client(lastname, firstname, numberfone);
            hotel.getClients().add(client);
            hotel.createReservation(client);
            System.out.println("Réservation effectué avec succès pour " + lastname + " " + firstname);
        }
        else if(nb != 1 && nb !=2) {
            System.out.println("vous devez séléctionner une option entre la 1 et la 2.");
        }

    }

    public void annulerReservation() {
        System.out.println("=== Annuler une réservation ===");
        System.out.println();

        System.out.println("Pour quel client souhaitez-vous annuler une réservation ?");
        System.out.print("Nom du client : ");
        sc.nextLine();
        String lastname = sc.nextLine();
        System.out.print("Prénom du client : ");
        String firstname = sc.nextLine();
        hotel.DeleteReservation(new Client(lastname, firstname));
    }

    public void listReservation() {
        System.out.println("=== Liste des réservations de l'hotel ===");
        System.out.println();
        System.out.println(hotel.reservationList());
    }

    public void bye() {
        System.out.println();
        System.out.println("Merci de votre visite");
        System.out.println("***************");
        System.out.println(" A bientot !!!");
        System.out.println("***************");
    }
}
