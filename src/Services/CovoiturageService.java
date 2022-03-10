/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entites.Covoiturage;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author anice
 */
public interface CovoiturageService {
    public void ajouter(Covoiturage cov);
    public void modifier(String depart, String destination,float prix, int nbr_place,int num_tel,int id);
    public void supprimer(int id);
    public ObservableList<Covoiturage> afficher();
}
