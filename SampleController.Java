package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;


public class Controller {

    @FXML Button thebutton;
    @FXML TextField field1;
    @FXML TextField field2;
    @FXML TextField field3;
    @FXML TableView firstTable;
    ObservableList theListing;
    Map<String,String> thisMap = new HashMap<>();
    ObservableMap theMaps;
    
//    Using an observablemap to filter the contents entered into the observablearray.

    public void initialize() {

        theMaps = FXCollections.observableMap(thisMap);
        theListing = FXCollections.observableArrayList();
    }

    public void addAPerson(ActionEvent actionEvent) {

        Person a = new Person(field1.getText(),field2.getText(),Integer.parseInt(field3.getText()));

        int mapContents = theMaps.size();
        theMaps.put(field1.getText(),a);

        if (mapContents != theMaps.size()) {
            theListing.add(a);
        }

        firstTable.setItems(theListing); //tableview
        System.out.println("the listing size: " + theListing.size());
        System.out.println(theMaps.size());
    }
}
