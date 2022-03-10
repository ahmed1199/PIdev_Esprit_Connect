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
public class LostandFound {
    private int id;
     private int num_tel;
    private int  id_utilisateur;
     private String description;
     private String photo;
            
     private String titre;

    public LostandFound(int id, int num_tel, int id_utilisateur, String description, String photo, String titre) {
        this.id = id;
        this.num_tel = num_tel;
        this.id_utilisateur = id_utilisateur;
        this.description = description;
        this.photo = photo;
        this.titre = titre;
    }

    public LostandFound(int num_tel, int id_utilisateur, String description, String photo, String titre) {
        this.num_tel = num_tel;
        this.id_utilisateur = id_utilisateur;
        this.description = description;
        this.photo = photo;
        this.titre = titre;
    }

    public LostandFound(String photo, String titre) {
        this.photo = photo;
        this.titre = titre;
    }

    public LostandFound() {
       //To change body of generated methods, choose Tools | Templates.
    }
    

   

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
   

    public int getId() {
        return id;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    @Override
    public String toString() {
        return "LostAndFound{" + "id=" + id + ", num_tel=" + num_tel + ", id_utilisateur=" + id_utilisateur + ", description=" + description + ", photo=" + photo + '}';
    }
    

    
    
   
}
