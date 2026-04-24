package org.example.practica2;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.time.LocalDate;

public class HelloController {

    static Connection conexion;

    @FXML
    private TableView<Estudiante> estudiantesTableView;

    @FXML
    private TableColumn<Estudiante, Integer> niaTableColumn;

    @FXML
    private TableColumn<Estudiante, String> nombreTableColumn;

    @FXML
    private TableColumn<Estudiante, LocalDate> fechaTableColumn;

    @FXML
    private Button eliminarButton;

    @FXML
    private Button editarButton;

    @FXML
    private Label mensajeOkLabel;

    @FXML
    private TextField niaTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private DatePicker nacimientoDatePicker;

    @FXML
    private Button insertarButton;

    @FXML
    private Button guardarButton;

    @FXML
    private Label welcomeText;

    @FXML
    public void initialize() {

        conexion = Datos.conexion();

        niaTableColumn.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getNia()).asObject());
        nombreTableColumn.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        fechaTableColumn.setCellValueFactory(datos -> new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_de_nacimiento()));

        estudiantesTableView.setItems(Datos.consulta(conexion));
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void insertarClickButton() {

        Integer nia = Integer.parseInt(niaTextField.getText());
        String nombre = nombreTextField.getText();
        LocalDate fecha = nacimientoDatePicker.getValue();

        Datos.insertar(conexion, new Estudiante(nia, nombre, fecha));

        niaTextField.clear();
        nombreTextField.clear();
        nacimientoDatePicker.setValue(null);
        mensajeOkLabel.setText("Estudiante insertado.");

        estudiantesTableView.setItems(Datos.consulta(conexion));

    }

    public void guardarClickButton() {

        Integer nia = Integer.parseInt(niaTextField.getText());
        niaTextField.setDisable(true);
        String nombre = nombreTextField.getText();
        LocalDate fecha = nacimientoDatePicker.getValue();

        Datos.modificar(conexion, new Estudiante(nia, nombre, fecha));

        insertarButton.setDisable(false);
        guardarButton.setDisable(true);
        niaTextField.clear();
        nombreTextField.clear();
        nacimientoDatePicker.setValue(null);

        estudiantesTableView.setItems(Datos.consulta(conexion));
        niaTextField.setDisable(false);

    }

    public void eliminarClickButton() {

        Estudiante seleccionado = estudiantesTableView.getSelectionModel().getSelectedItem();

        if(seleccionado == null) {
           mensajeOkLabel.setText("No hay nada seleccionado.");
        }else{

            Datos.eliminar(conexion, seleccionado);
            mensajeOkLabel.setText("Estudiante borrado.");
        }

        estudiantesTableView.setItems(Datos.consulta(conexion));

    }

    public void editarClickButton() {

        Estudiante seleccionado = estudiantesTableView.getSelectionModel().getSelectedItem();

        if(seleccionado == null) {
            mensajeOkLabel.setText("No hay nada seleccionado.");
        }else{

            insertarButton.setDisable(true);
            guardarButton.setDisable(false);
            niaTextField.setText(seleccionado.getNia().toString());
            niaTextField.setDisable(true);
            nombreTextField.setText(seleccionado.getNombre());
            nacimientoDatePicker.setValue(seleccionado.getFecha_de_nacimiento());
            mensajeOkLabel.setText("Estudiante modificado.");
        }

        estudiantesTableView.setItems(Datos.consulta(conexion));

    }
}
