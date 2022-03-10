/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Reservation;
import javafx.collections.ObservableList;

/**
 *
 * @author anice
 */
public interface ResrevationService {
    
     public void ajouter(Reservation res);
    //public void modifier(String depart, String destination,float prix, int nbr_place,int num_tel,int id);
    public void supprimer(String a);
    public ObservableList<Reservation> afficher();
}
