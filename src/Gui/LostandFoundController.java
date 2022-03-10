/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.LostandFound;
import Services.MyListener;
import Services.ServiceLostandfound;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


/*import Services.MyListener;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;*/


/**
 * FXML Controller class
 *
 * @author anice
 */
public class LostandFoundController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    private Label fruitNameLable;
    @FXML
    private ImageView fruitImg;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfnom;
    @FXML
    private Button btnadd;
    @FXML
    private Button btndelete;
    @FXML
    private Button btnupdate;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private MyListener myListener;
    private List<LostandFound> lostfound = new ArrayList<>();
    @FXML
    private Label titre;
    @FXML
    private Label num_tel;
     private List<LostandFound> getLostandFound() {
         List<LostandFound> lst = sl.afficher();
         return lst;
     }
     ServiceLostandfound sl = new ServiceLostandfound();
        private void setChosen(LostandFound lst) {
        fruitNameLable.setText(lst.getDescription());
       // fruitPriceLabel.setText(livre.getTitre());
        String codeColor = "A8FF33";
        //  image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        //  fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + codeColor + ";\n"
                + "    -fx-background-radius: 30;");
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void ajouter(){
       // sl.ajouter(new LostandFound(tfid.getText(), tftitre.getText(), tfnom.getText(), , 0));
    }
        // TODO
        

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
}
