/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Covoiturage;
import Entites.Reservation;
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
public class ReservationServiceImpl implements ResrevationService {
    Connection c ;
    public ReservationServiceImpl (){
          c = ConnexionBd.getInstance().getConncetion();
    }

    @Override
    public void ajouter(Reservation res) {
                  try {
          
           String query="INSERT INTO reservation(id_res,nb_places,status,id_cov) values(?,?,?,?)";
                PreparedStatement smt = c.prepareStatement(query);
                smt.setInt(1, res.getId_res());
                smt.setInt(2, res.getNb_places());
                smt.setString(3, res.getStatus());
                smt.setInt(4, res.getId_cov());
               /* smt.setFloat(4, cov.getPrix()); 
                smt.setInt(5, cov.getNum_tel());
                smt.setInt(6, cov.getNbr_place());
                smt.setInt(7, 5);
                smt.setInt(8, 2); */      
                smt.executeUpdate();
                System.out.println("ajout avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }

    @Override
    public void supprimer(String a) {
         Reservation cv= new Reservation();   
          int s=0;
        try {
         String query2="select * from reservation WHERE status ='" + a + "'";
                PreparedStatement smt = c.prepareStatement(query2);
               
// Reservation cv;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                     s = rs.getInt(1);
                     System.out.println("sssssss"+s);
                  cv=new Reservation(rs.getInt("nb_places"),rs.getString("status"));
                    System.out.println("cvvvvvvvvvv"+cv);
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
        
        try {
             System.out.println("cvvvvvvvvvv111111111111111111"+cv.getId_res());
       String query2="delete from reservation where id_res='" +s+ "'";
                PreparedStatement smt = c.prepareStatement(query2);
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Voulez-vous vraiment supprimer la reservation?");
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.OK)
                smt.executeUpdate();
                System.out.println("suppression avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
    }

    @Override
    public ObservableList<Reservation> afficher() {
        
     ObservableList<Reservation> l = FXCollections.observableArrayList();
        
        try {
       String query2="select * from reservation";
                PreparedStatement smt = c.prepareStatement(query2);
                Reservation cv;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                  cv=new Reservation(rs.getInt("nb_places"),rs.getString("status"));
                   l.add(cv);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }
      /* public List<Reservation> res(){
    //ObservableList<Reservation> l = FXCollections.observableArrayList();
            ArrayList l=new ArrayList();   
        try {
       String query2="select * from reservation r left join covoiturage c on r.id_cov=c.id";
                PreparedStatement smt = c.prepareStatement(query2);
                Reservation r;
                Covoiturage cv;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                  r=new Reservation(rs.getInt("nb_places"),rs.getString("status"));
                  cv=new Covoiturage(rs.getInt("id"),rs.getString("depart"),rs.getString("destination"),rs.getFloat("prix"),rs.getInt("nbr_place"),rs.getInt("num_tel"),rs.getInt("id_utilisateur"),rs.getInt("id_disp"));
                   l.add(r);
                   l.add(cv);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
}*/
    
     public ObservableList<Reservation> afficherById(int a) {
        
     ObservableList<Reservation> l = FXCollections.observableArrayList();
    /*    SELECT *
FROM table1
INNER JOIN table2 ON table1.id = table2.fk_id*/
        try {
       String query2="select * from reservation WHERE id_cov ='" + a + "'";
                PreparedStatement smt = c.prepareStatement(query2);
                Reservation cv;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                  cv=new Reservation(rs.getInt("nb_places"),rs.getString("status"));
                  l.add(cv);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    }
    
    }
    

