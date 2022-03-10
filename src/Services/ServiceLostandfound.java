/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.LostandFound;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ConnexionBd;

/**
 *
 * @author anice
 */
public class ServiceLostandfound implements ServiceLaf{
         Connection c ;
     public ServiceLostandfound() {
        
         c = ConnexionBd.getInstance().getConncetion();
    }

    @Override
    public void ajouter(LostandFound l) {
             try {
          
           String query="INSERT INTO lost_and_found(id,description,photo,num_tel,titre,id_utilisateur) values(?,?,?,?,?,?)";
                PreparedStatement smt = c.prepareStatement(query);
                smt.setInt(1, l.getId());              
                smt.setString(2, l.getDescription());
                smt.setString(3, l.getPhoto()); 
                smt.setInt(4, l.getNum_tel());
                smt.setString(5, l.getTitre());
                smt.setInt(6, 5);
                smt.executeUpdate();
                System.out.println("ajout avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
           
       }
    }
              /*smt.setInt(1, num_tel);
                smt.setString(2, description);
                smt.setString(3, photo);               
                smt.setString(4, titre);
                smt.setInt(5, id);
                smt.setInt(6, 5);*/
//int num_tel,String description,String photo,int id,String titre,int id_utilisateur
    @Override
    public void modifier(int num_tel,String description,String photo,int id,String titre) {
           try {
       String query2="update lost_and_found set num_tel=?,description=?,photo=?,titre=?  where id=?";
                PreparedStatement smt = c.prepareStatement(query2);
                smt.setInt(1, num_tel);
                smt.setString(2, description);
                smt.setString(3, photo);               
                smt.setString(4, titre);
                smt.setInt(5, id);
               // smt.setInt(6, 5);
               
                smt.executeUpdate();
                System.out.println("modification avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
       
    }

    @Override
    public void supprimer(int id) {
            try {
       String query2="delete from lost_and_found where id=?";
                PreparedStatement smt = c.prepareStatement(query2);
                smt.setInt(1, id);
                smt.executeUpdate();
                System.out.println("suppression avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }
    }

    @Override
    public ObservableList<LostandFound> afficher() {
        
     ObservableList<LostandFound> l = FXCollections.observableArrayList();


        
        try {
       String query2="select * from lost_and_found";
                PreparedStatement smt = c.prepareStatement(query2);
                LostandFound f;
                ResultSet rs= smt.executeQuery();
                while(rs.next()){
                   f=new LostandFound(rs.getInt("id"),rs.getInt("num_tel"),rs.getInt("id_utilisateur"),rs.getString("description"),rs.getString("photo"),rs.getString("titre"));
                   l.add(f);
                }
                System.out.println(l);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
    }

        return l;
    
   
    
}
    
}
