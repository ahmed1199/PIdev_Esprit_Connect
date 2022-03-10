/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entites.Covoiturage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import utils.ConnexionBd;

/**
 *
 * @author anice
 */
public class ServiceCovoiturage implements CovoiturageService{
 Connection c ;
 public ServiceCovoiturage (){
     c = ConnexionBd.getInstance().getConncetion();
 }
    @Override
    public void ajouter(Covoiturage cov) {
               try {
          
           String query="INSERT INTO covoiturage(id,depart,destination,prix,num_tel,nbr_place,id_utilisateur,id_disp) values(?,?,?,?,?,?,?,?)";
                PreparedStatement smt = c.prepareStatement(query);
                smt.setInt(1, cov.getId());
                smt.setString(2, cov.getDepart());
                smt.setString(3, cov.getDestination());
                smt.setFloat(4, cov.getPrix()); 
                smt.setInt(5, cov.getNum_tel());
                smt.setInt(6, cov.getNbr_place());
                smt.setInt(7, 5);
                smt.setInt(8, 2);       
                smt.executeUpdate();
                System.out.println("ajout avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
        
    }

    
    @Override
    public void modifier(String depart, String destination,float prix, int nbr_place,int num_tel,int id) {
                  try {
       String query2="update covoiturage set depart=?,destination=?,prix=?,nbr_place=?,num_tel=? where id=?";
                PreparedStatement smt = c.prepareStatement(query2);                          
                smt.setString(1, depart);
                smt.setString(2, destination);
                smt.setFloat(3, prix); 
                smt.setInt(4, nbr_place);
                smt.setInt(5, num_tel);
                smt.setInt(6, id);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Voulez-vous vraiment modifier le covoiturage?");
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.OK)
                smt.executeUpdate();
                System.out.println("modification avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
       
    }

    @Override
    public void supprimer(int id) {
                try {
       String query2="delete from covoiturage where id=?";
                PreparedStatement smt = c.prepareStatement(query2);
                smt.setInt(1, id);Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Voulez-vous vraiment supprimer le covoiturage?");
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.OK)
                smt.executeUpdate();
                System.out.println("suppression avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
    }

    @Override
    public ObservableList<Covoiturage> afficher() {
        
        ObservableList<Covoiturage> l = FXCollections.observableArrayList();
        
        try {
       String query2="select * from covoiturage";
                PreparedStatement smt = c.prepareStatement(query2);
                Covoiturage cv;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                  cv=new Covoiturage(rs.getInt("id"),rs.getString("depart"),rs.getString("destination"),rs.getFloat("prix"),rs.getInt("nbr_place"),rs.getInt("num_tel"),rs.getInt("id_utilisateur"),rs.getInt("id_disp"));
                   l.add(cv);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }
    
    
    
}
