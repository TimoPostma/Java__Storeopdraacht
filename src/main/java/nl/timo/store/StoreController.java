package nl.timo.store;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ResourceBundle;


public class StoreController implements Initializable {

    @FXML private TableView<Product> tableView;
    @FXML public Button addProductButton;
    @FXML public static Text loginText;
    private ObservableList<Product> products;
    private StoreDataAccessObject storeDOA;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Login();
        createColumns();
//        addProductButton.setVisible(false);
        storeDOA = new StoreDataAccessObject("noorderpoort", "toets");
     //   addProductButton.setVisible(false);
        getInitialTableData();
    }


    private void createColumns(){
        TableColumn<Product, Integer> columnProductId = new TableColumn<>("Product ID");
        columnProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        columnProductId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<Product, String> columnBrand = new TableColumn<>("Brand");
        columnBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        columnBrand.setCellFactory(TextFieldTableCell.<Product>forTableColumn());

        TableColumn<Product, String> columnType = new TableColumn<>("Type");
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnType.setCellFactory(TextFieldTableCell.<Product>forTableColumn());

        TableColumn<Product, Double> columnPrice = new TableColumn<>("Price");
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnPrice.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        tableView.getColumns().addAll(columnProductId, columnBrand, columnType, columnPrice);
        tableView.setEditable(false);
    }

    private void getInitialTableData() {
        products = FXCollections.observableList(storeDOA.getProducts());
        tableView.setItems(products);
    }
    public void delete(){


    }
    public void Edit(){


    }
    public void addData(){
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Add.fxml"));
        try {
            Parent AddParent = loader.load();
            Stage AddStage = new Stage();
            AddStage.initModality(Modality.APPLICATION_MODAL);

            AddStage.setTitle("Add product");
            Scene AddScene = new Scene(AddParent);

            AddStage.setScene(AddScene);
            AddStage.show();
        }
        catch (Exception e){

        }

    }
    public void Login(){
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Login.fxml"));
        try {
            Parent LoginParent = loader.load();


            Stage LoginStage = new Stage();
            LoginStage.initModality(Modality.APPLICATION_MODAL);

            LoginStage.setTitle("login");
            Scene LoginScene = new Scene(LoginParent);

            LoginStage.setScene(LoginScene);
            LoginStage.show();
        }
        catch (Exception e){
                e.getMessage();
        }

    }


}
