/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author anice
 */
public class Covoiturage {
    public int id,nbr_place,num_tel,id_disp,id_utilisateur;
    public String depart,destination;
    public float prix;

    public Covoiturage(int id,String depart, String destination,   float prix, int nbr_place ,int num_tel, int id_utilisateur ,int id_disp) {
        this.id = id;
        this.nbr_place = nbr_place;
        this.num_tel = num_tel;
        this.id_disp = id_disp;
        this.id_utilisateur = id_utilisateur;
        this.depart = depart;
        this.destination = destination;
        this.prix = prix;
    }
    
    public Covoiturage(String depart, String destination,   float prix,int nbr_place ,int num_tel, int id_utilisateur ,int id_disp) {
       
        this.nbr_place = nbr_place;
        this.num_tel = num_tel;
        this.id_disp = id_disp;
        this.id_utilisateur = id_utilisateur;
        this.depart = depart;
        this.destination = destination;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbr_place() {
        return nbr_place;
    }

    public void setNbr_place(int nbr_place) {
        this.nbr_place = nbr_place;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public int getId_disp() {
        return id_disp;
    }

    public void setId_disp(int id_disp) {
        this.id_disp = id_disp;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Covoiturage{" + "id=" + id + ", nbr_palce=" + nbr_place + ", num_tel=" + num_tel + ", id_disp=" + id_disp + ", id_utilisateur=" + id_utilisateur + ", depart=" + depart + ", destination=" + destination + ", prix=" + prix + '}';
    }

 
   
   
}
