/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;
import Gui.Gmail;
import Entites.LostandFound;
import Services.MyListener;
import Services.ServiceLostandfound;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.ConnexionBd;

/**
 * FXML Controller class
 *
 * @author anice
 */
public class LostandfounddController implements Initializable {

    private TextField titre;
    @FXML
    private TextArea description;
    @FXML
    private ImageView imgview;
    @FXML
    private Button btnimg;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private MyListener myListener;
    private List<LostandFound> lostfound = new ArrayList<>();
    @FXML
    private Label titrelabel;
    @FXML
    private Label num_tellabel;    
    ServiceLostandfound sl = new ServiceLostandfound();
    @FXML
    private Button btnadd;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfnum;
    @FXML
    private Label file_path;
    @FXML
    private AnchorPane left_main;
    @FXML
    private VBox vv;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Label m;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button covoiturage;
    URL url; 
    ResourceBundle rb;
    @FXML
    private TextField tfid;
    /**
     * Initializes the controller class.
     */
    private List<LostandFound> getLostandFound() {
         List<LostandFound> lst = sl.afficher();
         return lst;
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
       
        private void setChosen(LostandFound lst) {
           titrelabel.setText(lst.getTitre());
           tfnum.setText(String.valueOf(lst.getNum_tel()));
            System.out.println("rrrrrrrrrrrrrrrrrrr"+lst.getDescription());
           description.setText(lst.getDescription());
           tftitre.setText(lst.getTitre());
           file_path.setText(lst.getPhoto());
           tfid.setText(String.valueOf(lst.getId())); String codeColor = "bbb1b1";
           vv.setStyle("-fx-background-color: #" + codeColor + ";\n"
           + "    -fx-background-radius: 30;");
           // num_tellabel.setText(Integer.parseInt((lst.getNum_tel())));      
           // description.setText(lst.getDescription());       
           // Label setText = num_tellabel.setText(Integer.parseInt(lst.getNum_tel()));
           // fruitPriceLabel.setText(livre.getTitre());
           // String codeColor = "A8FF33";
           //  image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
           //  fruitImg.setImage(image);
           /*  chosenFruitCard.setStyle("-fx-background-color: #" + codeColor + ";\n"
           + "    -fx-background-radius: 30;");*/
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dropshadowEffect();
        // TODO
          lostfound = getLostandFound();
        if (lostfound.size() > 0) {
            System.out.println("sizessss" + lostfound.size());
            setChosen(lostfound.get(lostfound.size() - 1));
            myListener = new MyListener() {
                
                @Override
                public void onClickListener(LostandFound laf) {
                  setChosen(laf);
                }
            };
        }

        int column = 0;
        int row = 1;
        try {
            System.out.println("colonne1111" + column);
            System.out.println("row" + row);
            for (int i = 0; i <  lostfound.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData( lostfound.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
            System.out.println("colonne" + column);
            System.out.println("row" + row);
        } catch (IOException e) {
            e.printStackTrace();
        }

    } 
    @FXML
     public void switchTocovoiturage(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("/Gui/Covoiturage.fxml"));
         stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
 }
    private void ajouter(){
      try{
           if(tftitre.getText().isEmpty()
           | description.getText().isEmpty()  
           | tfnum.getText().isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Esprit-Connect :: Error Message");
           alert.setHeaderText(null);
           alert.setContentText("Verifier Tous Les Champs !!");
           alert.showAndWait();
            }
          else{
               System.out.println("fileeeeee"+file_path.getText());
       LostandFound lostAndFounf1=new LostandFound();
       lostAndFounf1.setDescription(description.getText());
       lostAndFounf1.setNum_tel(Integer.parseInt(tfnum.getText()));
       lostAndFounf1.setPhoto(file_path.getText());
       lostAndFounf1.setTitre(tftitre.getText());
       lostAndFounf1.setId_utilisateur(5);
        sl.ajouter(lostAndFounf1);
        Gmail.sendMail("anis.noussari@esprit.tn");
        initialize(url, rb);
          }
          
      } catch (Exception ex) {
                System.out.println(ex.getMessage());   
        }
      
        
        
    }
    private void modifier(){
      /* LostandFound lostAndFounf1=new LostandFound();
       lostAndFounf1.setDescription(description.getText());
       lostAndFounf1.setNum_tel(Integer.parseInt(tfnum.getText()));
       lostAndFounf1.setPhoto(file_path.getText());
       lostAndFounf1.setTitre(titrelabel.getText());
       lostAndFounf1.setNum_tel(Integer.parseInt(tfid.getText()));
       lostAndFounf1.setId_utilisateur(5);*/
        
      sl.modifier((Integer.parseInt(tfnum.getText())),description.getText(),file_path.getText(),Integer.parseInt(tfid.getText()),tftitre.getText());
      // sl.modifier(lostAndFounf1);
      initialize(url, rb);
    }
    private void delete(){
        // LostandFound lostAndFounf1=new LostandFound();
       // lostAndFounf1.setId(Integer.parseInt(tfid.getText()));
         sl.supprimer((Integer.parseInt(tfid.getText())));
         initialize(url, rb);
    }
    @FXML
     public void InsertImage(){
         FileChooser open = new FileChooser();
        Stage stage =(Stage)left_main.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if(file != null){
            String path = file.getAbsolutePath();
            
            file_path.setText(path);
            Image image = new Image(file.toURI().toString(), 110,110,false,true);
            imgview.setImage(image);
        }else{
            System.out.println("No FILE EXIST");
            }
        }
            
    @FXML
    public void handler(ActionEvent event){
         if (event.getSource() == btnadd){
            ajouter();}
         else if (event.getSource()==btndelete){       
             delete();
         }
         else if (event.getSource()==btnupdate){       
             modifier();
         }                       
    }
    @FXML
    public void clear (ActionEvent ev){
        tftitre.clear();
        tfnum.clear();
        description.clear();
        tfid.clear();
    }
   /* Connection c;
    public void refresh(){
       List<LostandFound> s = getLostandFound();
        c = ConnexionBd.getInstance().getConncetion();
        lostfound = getLostandFound();
        if (lostfound.size() > 0) {
            System.out.println("sizessss" + lostfound.size());
            setChosen(lostfound.get(lostfound.size() - 1));
            myListener = new MyListener() {
                
                @Override
                public void onClickListener(LostandFound laf) {
                  setChosen(laf);
                }
            };
        }

        int column = 0;
        int row = 1;
        try {
            System.out.println("colonne1111" + column);
            System.out.println("row" + row);
            for (int i = 0; i <  lostfound.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData( lostfound.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
            System.out.println("colonne" + column);
            System.out.println("row" + row);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    
}
