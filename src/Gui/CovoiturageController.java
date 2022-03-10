/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.Covoiturage;
import Entites.Reservation;
import Services.ReservationServiceImpl;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import services.ServiceCovoiturage;
import utils.ConnexionBd;

/**
 * FXML Controller class
 *
 * @author anice
 */
public class CovoiturageController implements Initializable {

    @FXML
    private TextField tfdepart;
    @FXML
    private TextField tfdest;
    @FXML
    private Button btnadd;
    @FXML
    private TableView<Covoiturage> table;
    @FXML
    private TableColumn<Covoiturage, Integer> colid;
    @FXML
    private TableColumn<Covoiturage, String> coldep;
    @FXML
    private TableColumn<Covoiturage, String> coldest;
    @FXML
    private TableColumn<Covoiturage, Float> colprix;
    @FXML
        private TableColumn<Covoiturage, Integer> colnum;
    @FXML
    private TableColumn<Covoiturage, Integer> colnbr;
    @FXML
    private Button btna1;
    @FXML
    private Button btna4;
    @FXML
    private Button btna2;
    @FXML
    private Button btna3;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfnum;
    @FXML
    private TextField tfnbr;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnupdate;
    @FXML
    private Label m;
    private boolean bt1;
    private boolean bt2;
    private boolean bt3;
    private boolean bt4;
    private int id;
   public URL url;
          public  ResourceBundle rb;
     String green = "-fx-background-color:#39FF14";
     String red = "-fx-background-color:#D1CCCA";
   public ServiceCovoiturage sc=new ServiceCovoiturage();
   public   ReservationServiceImpl sr=new ReservationServiceImpl();
    @FXML
    private Button btna11;
    @FXML
    private Button btna111;
    @FXML
    private TextField tfrecherche;
    private final ObservableList<Covoiturage> cov = FXCollections.observableArrayList();
  

    /**
     * Initializes the controller class.
     */private void search(){
          List Covoiturage = sc.afficher();
         ObservableList cov = FXCollections.observableArrayList(Covoiturage);
        table.setItems(cov);
        
           ObservableList<Covoiturage> list = afficher();
        colid.setCellValueFactory(new PropertyValueFactory<Covoiturage, Integer>("id"));
        coldep.setCellValueFactory(new PropertyValueFactory<Covoiturage, String>("depart"));
        coldest.setCellValueFactory(new PropertyValueFactory<Covoiturage, String>("destination"));
        colprix.setCellValueFactory(new PropertyValueFactory<Covoiturage, Float>("prix"));
        colnbr.setCellValueFactory(new PropertyValueFactory<Covoiturage, Integer>("nbr_place")); 
        colnum.setCellValueFactory(new PropertyValueFactory<Covoiturage, Integer>("num_tel"));       
        table.setItems(list);
        FilteredList<Covoiturage> f = new FilteredList<>(cov , b -> true);
        tfrecherche.textProperty().addListener((  Observable,oldValue, newValue)-> {
         f.setPredicate(c -> { 
            
                 if (newValue==null|| newValue.isEmpty()){
                return true;
                }
                 String lowerCaseFilter = newValue.toLowerCase();
                  if (c.getDepart().toLowerCase().indexOf(lowerCaseFilter) != -1 ){
                return true;
                }else if (c.getDestination().toLowerCase().indexOf(lowerCaseFilter) != -1 )
                return true;
                else if (String.valueOf(c.getNbr_place()).indexOf(lowerCaseFilter) != -1) 
                return true;
                else if (String.valueOf(c.getNum_tel()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else if    (String.valueOf(c.getPrix()).indexOf(lowerCaseFilter) != -1)
                    return true ;
                else 
                    return false;
                
                });
                });
         
        SortedList<Covoiturage> sortedData = new SortedList<>(f);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     search();
           
        this.afficherRes();
         //btna1.setStyle(green);
         btna1.setStyle(red);
         btna2.setStyle(red);
         btna3.setStyle(red);
         btna4.setStyle(red);
         System.out.println(afficherRes());
      List<Reservation>reservations=afficherRes();
         afficherRes().forEach(action->{
            int i=0;
            if(action.getStatus().equalsIgnoreCase("btna1")){
                bt1=true;
                btna1.setStyle(green);
                
            } else if(action.getStatus().equalsIgnoreCase("btna2")){
                 bt2=true;
                 btna2.setStyle(green);
            } else if(action.getStatus().equalsIgnoreCase("btna3")){
                 bt3=true;
                 btna3.setStyle(green);
            } else if(action.getStatus().equalsIgnoreCase("btna4")){
                 bt4=true;
                 btna4.setStyle(green);
            }
            i++;
        });
        
        // affichercovoiturage(); 
         dropshadowEffect();
        // TODO
        // ObservableList<Covoiturage> list = sc.afficher();
            
         
    }
     public void dropshadowEffect(){
         DropShadow original = new DropShadow(60,Color.valueOf("#CE09FA"));
         m.setEffect(original);
         original.setRadius(30);
         m.setOnMouseEntered((MouseEvent event) -> {
             DropShadow shadow = new DropShadow(20,Color.valueOf("#CE09FA"));
             m.setStyle("-fx-text-fill:#FF6200");
             m.setEffect(original);
         });
         m.setOnMouseExited((MouseEvent event) -> {
              m.setStyle("-fx-text-fill:#FA1009");
             m.setEffect(original);
         });
     }
   

    private void ajouterReservation (String nameButton){
        
        sr.ajouter(new Reservation(1,nameButton,this.id));
        System.out.println("bonjour bonjour");
       this.initialize(url, rb);
    }
   
    private void ajouter() {
        try{
            if (tfdepart.getText().isEmpty()
                    | tfdest.getText().isEmpty()

                    | tfprix.getText().isEmpty()
                    | tfnbr.getText().isEmpty()
                    | tfnum.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Esprit-Connect :: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Verifier Tous Les Champs !!");
                alert.showAndWait();
            }
                    
            else{
           sc.ajouter(new Covoiturage( tfdepart.getText(), tfdest.getText(),Float.parseFloat(tfprix.getText()), Integer.parseInt(tfnbr.getText()),
           Integer.parseInt(tfnum.getText()),5,2));       
           affichercovoiturage();
           search();
                    }
           
         } catch (Exception ex) {
                System.out.println(ex.getMessage());
            
        }
       /* sc.ajouter(new Covoiturage( tfdepart.getText(), tfdest.getText(),Float.parseFloat(tfprix.getText()), Integer.parseInt(tfnbr.getText()),
                Integer.parseInt(tfnum.getText()),5,2));
         affichercovoiturage(); */
    }
    private void supprimer(){
        sc.supprimer(Integer.parseInt(tfid.getText()));
        affichercovoiturage(); 
        search();
      
    }
    private void modifier(){
      sc.modifier(tfdepart.getText(), tfdest.getText(),Float.parseFloat(tfprix.getText()), Integer.parseInt(tfnbr.getText()),Integer.parseInt(tfnum.getText()),Integer.parseInt(tfid.getText()));
      affichercovoiturage(); 
      search(); 
    }
    private ObservableList <Covoiturage>  afficher(){
      return sc.afficher();
        
       
    }
    private ObservableList <Reservation>  afficherRes(){
      return sr.afficher();
        
       
    }
     
    public  ObservableList<Reservation> listReservation(){
       ObservableList<Reservation> list = afficherRes();
        
        
        
        return list;
    }
    
    public void affichercovoiturage(){
       ObservableList<Covoiturage> list = afficher();
        
        
        
        colid.setCellValueFactory(new PropertyValueFactory<Covoiturage, Integer>("id"));
        coldep.setCellValueFactory(new PropertyValueFactory<Covoiturage, String>("depart"));
        coldest.setCellValueFactory(new PropertyValueFactory<Covoiturage, String>("destination"));
        colprix.setCellValueFactory(new PropertyValueFactory<Covoiturage, Float>("prix"));
        colnbr.setCellValueFactory(new PropertyValueFactory<Covoiturage, Integer>("nbr_place")); 
        colnum.setCellValueFactory(new PropertyValueFactory<Covoiturage, Integer>("num_tel"));       
        table.setItems(list);
    }
   
   // public void 
    @FXML
      public void select(){
           URL urll = null;
           ResourceBundle rbb = null;
        List<Reservation> reserv=new ArrayList<>();   
         Covoiturage c =table.getSelectionModel().getSelectedItem();
        int num;
      
       reserv= sr.afficherById(c.getId());
       // System.out.println("reeeeeeeeessssssss"+reserv);
         reserv.forEach(action->{
            int i=0;
            if(action.getStatus().equalsIgnoreCase("btna1")){
                bt1=true;
                btna1.setStyle(green);
                System.out.println("aaaaaa"+action);
            } else if(action.getStatus().equalsIgnoreCase("btna2")){
                 bt2=true;
                 btna2.setStyle(green);
                 System.out.println("aaaaaa"+action);
            } else if(action.getStatus().equalsIgnoreCase("btna3")){
                 bt3=true;
                 btna3.setStyle(green);
                 System.out.println("aaaaaa"+action);
            } else if(action.getStatus().equalsIgnoreCase("btna4")){
                 bt4=true;
                 btna4.setStyle(green);
                 System.out.println("aaaaaa"+action);
            }
            i++;
        });
        num = table.getSelectionModel().getSelectedIndex();
         if(-1 > (num-1)){
             return;
         } else {
             this.id=c.getId();
           //  System.out.println("frrrrrr"+ this.id); 
             tfid.setText(String.valueOf(c.getId()));
             tfdepart.setText(c.getDepart());
             tfnbr.setText(String.valueOf(c.getNbr_place()));
             tfdest.setText(c.getDestination());
             tfnum.setText(String.valueOf(c.getNum_tel()));
             tfprix.setText(String.valueOf(c.getPrix()));
         //  initialize(urll, rbb);
            /* String picture ="file :" + user.getPicture();
             Image image = new Image(picture, 110, 110, false, true);
           
           
            file_path.setText(user.getPicture());*/
             
             
         }
       //  reserv=null;
        // initialize(url, rb);
         
     }
   
   
   
    @FXML
    public void handler(ActionEvent event){
         System.out.println(bt1);
          System.out.println(bt2);
           System.out.println(bt3);
            System.out.println(bt4);
        if (event.getSource() == btnadd){
            ajouter();
    }else if (event.getSource()==btndelete){
        supprimer();
    }else if (event.getSource()==btnupdate){
        modifier();
    }else if (event.getSource()==btna1){
        if(bt1==false)   {
            ajouterReservation("btna1");
            btna1.setStyle(green);
            bt1=true;
        }else{
            deleteReservation("btna1");
            btna1.setStyle(red);
            bt1=false;
        }
        
        
    }else if (event.getSource()==btna2){
         if(bt2==false)   {
           ajouterReservation("btna2");
           btna2.setStyle(green);
           bt2=true;
        }else{
            deleteReservation("btna2");
            btna2.setStyle(red);
            bt2=false;
        }
      
    }else if (event.getSource()==btna3){
       if(bt3==false)   {
           System.out.println();
           ajouterReservation("btna3");
           btna3.setStyle(green);
           bt3=true;
        }else{
            deleteReservation("btna3");
            btna3.setStyle(red);
            bt3=false;
        }
    }else if (event.getSource()==btna4){
       if(bt4==false)   {
           ajouterReservation("btna4");
           btna4.setStyle(green);
           bt4=true;
        }else{
            deleteReservation("btna4");
            btna4.setStyle(red);
            bt4=false;
        }
    }
}

    private void deleteReservation(String a) {
        sr.supprimer( a);
       this. initialize(url, rb);
       
    }
   
    @FXML
   public void clear(ActionEvent ev){
       tfdest.clear();
       tfdepart.clear();
       tfnum.clear();
       tfid.clear();
       tfprix.clear();
       tfnbr.clear();
   }
   Connection c ;
    @FXML
  public void print(){
       c = ConnexionBd.getInstance().getConncetion();
        try{
        JasperDesign jDesign =JRXmlLoader.load("C:\\Users\\anice\\Documents\\NetBeansProjects\\PiDev\\src\\Test\\report.jrxml");
        JasperReport jReport =JasperCompileManager.compileReport(jDesign);    
        JasperPrint jPrint = JasperFillManager.fillReport(jReport, null, c);
        JasperViewer viewer = new JasperViewer(jPrint,false);
        viewer.setTitle("Esprit_Connect");
        viewer.show();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }
    
}
