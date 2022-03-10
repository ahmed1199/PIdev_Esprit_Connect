/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entites.LostandFound;
import Services.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author anice
 */
public class ItemController  {

    @FXML
    private Label nameLabel;
    private LostandFound laf;
    private MyListener myListener;
    @FXML
    private ImageView imgv;
    @FXML
    
    
    private void click(MouseEvent event) {
         myListener.onClickListener(laf);
    }
     public void setData(LostandFound laf, MyListener myListener) {
        this.laf = laf;
        this.myListener = myListener;
        nameLabel.setText(laf.getTitre());
        
        String photo = "file:" + laf.getPhoto();

        Image image = new Image(photo, 110, 110, false, true);

        imgv.setImage(image);

        String path =  laf.getPhoto();
        
      //  priceLable.setText(laf.getTitre());
        //Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        //img.setImage(image);
    }
}
