package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import sample.Interface.Calculations;
import sample.Transport.Wrapper;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Controller implements Initializable{
    @FXML
    private RadioButton truckrb;
    @FXML
    private RadioButton busrb;
    @FXML
    private TextField powertb;
    @FXML
    private TextField marktb;
    @FXML
    private TextField capacitytb;
    @FXML
    private TextField passcounttb;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnShowAll;
    @FXML
    private TableView<Wrapper.Autotransport> table;
    @FXML
    private TableColumn<Wrapper.Autotransport, Integer> number;
    @FXML
    private TableColumn<Wrapper.Autotransport, Integer> mass;
    @FXML
    private TableColumn<Wrapper.Autotransport, String> mark;
    @FXML
    private TableColumn<Wrapper.Autotransport, Integer> power;
    @FXML
    private TableColumn<Wrapper.Autotransport, Double> weightpower;

    List<Wrapper.Autotransport> list=new ArrayList<>();

    public void loadDefaultCollections() {
        list.add(new Wrapper.Bus(150, "Zil", 5, 375));
        list.add(new Wrapper.Bus(110, "Big Rock", 8, 600));
        list.add(new Wrapper.Truck(420, "Huge bug", 10000));
        list.add(new Wrapper.Truck(350, "Hulk" , 7500));
    }

    // Show a Information Alert with header Text
    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Уведомление");
        alert.setHeaderText("Results:");
        alert.setContentText("Ошибка ввода!");

        alert.showAndWait();
    }

    public void truckRbtnChecked() {
        //В зависимости от выбора вида транпорта закрываем поля
           passcounttb.setVisible(false);
           capacitytb.setVisible(true);

    }

    public void busRbtnChecked() {
        //В зависимости от выбора вида транпорта закрываем поля
            capacitytb.setVisible(false);
            passcounttb.setVisible(true);
    }



    public void onClickMethod(){
        if (truckrb.isSelected()) {
            if (powertb.getText().trim().isEmpty() || marktb.getText().trim().isEmpty() || capacitytb.getText().trim().isEmpty()) {
                showAlertWithHeaderText();
            } else {
                Wrapper.Truck truckobj = new Wrapper.Truck(parseInt(powertb.getText()), marktb.getText(), parseDouble(capacitytb.getText()));
                list.add(truckobj);
            }
        }

        if (busrb.isSelected()) {
            if (powertb.getText().trim().isEmpty() || marktb.getText().trim().isEmpty() || passcounttb.getText().trim().isEmpty()) {
                showAlertWithHeaderText();
            } else {
                int busmass = 75 * parseInt(passcounttb.getText());
                Wrapper.Bus busobj = new Wrapper.Bus(parseInt(powertb.getText()), marktb.getText(), parseInt(passcounttb.getText()), busmass);
                list.add(busobj);
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDefaultCollections();
        ObservableList<Wrapper.Autotransport> tablelist = FXCollections.observableArrayList(list);
        number.setCellValueFactory(new PropertyValueFactory<Wrapper.Autotransport, Integer>("ID"));
        mass.setCellValueFactory(new PropertyValueFactory<Wrapper.Autotransport, Integer>("Mass"));
        mark.setCellValueFactory(new PropertyValueFactory<Wrapper.Autotransport, String>("Mark"));
        power.setCellValueFactory(new PropertyValueFactory<Wrapper.Autotransport, Integer>("Power"));
        //weightpower.setCellValueFactory(new PropertyValueFactory<Wrapper.Bus, Double>("Weight/Power"));
        table.setItems(tablelist);

    }

}
