package nl.timo.store;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * @author Timo Postma
 * @version 1.0
 * @since feb 2020
 * MIT License
 * Copyright 2020 Voornaam Achternaam
 */
public class AddController {
    @FXML
    private TextField brand;
    @FXML
    private TextField type;
    @FXML
    private TextField price;
    public void submit(){
            String brandmerk = brand.getText();
            String typetype = type.getText();
            String priceprijs = price.getText();
        StoreDataAccessObject ldao = new StoreDataAccessObject("noorderpoort","toets");
        ldao.addProduct(brandmerk,typetype,priceprijs);


    }


}
