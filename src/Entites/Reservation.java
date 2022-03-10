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
public class Reservation {
    private int id_res,nb_places,id_cov;
    private String status;

    public Reservation() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
      public Reservation(int nb_places, String status) {
        this.nb_places = nb_places;
        
        this.status = status;
    }

    public Reservation(int nb_places, String status,int id_cov) {
        this.nb_places = nb_places;
        
        this.status = status;
        this.id_cov=id_cov;
    }
    

    

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public int getId_cov() {
        return id_cov;
    }

    public void setId_cov(int id_cov) {
        this.id_cov = id_cov;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_res=" + id_res + ", nb_places=" + nb_places + ", id_cov=" + id_cov + ", status=" + status + '}';
    }

   

   
    
    
}
