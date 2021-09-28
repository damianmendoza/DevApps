package main.tareaapps;

import DBConnection.DataBaseConnection;
import DBConnection.Estudiante_DAO;
import POJO.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    public TableView <Estudiante> tb_Estudiantes;
    @FXML
    public TableColumn <Estudiante, String> clmn_primerNom;
    @FXML
    public  TableColumn <Estudiante, String> clmn_segundoNom;
    @FXML
    public TableColumn <Estudiante, String> clmn_apellidoPat;
    @FXML
    public TableColumn <Estudiante, String> clmn_apellidoMat;
    @FXML
    public Button btn_Agregar;
    @FXML
    public Button btn_Visualizar;
    @FXML
    public Button btn_Borrar;


    private Estudiante estudiante;

    ObservableList <Estudiante> observableEstudiante;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        llenarTabla();
    }

    public void llenarTabla (){
        clmn_primerNom.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("primerNombre"));
        clmn_segundoNom.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("segundoNombre"));
        clmn_apellidoPat.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("primerApellido"));
        clmn_apellidoMat.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("segundoApellido"));


        List<Estudiante> listaEstudiante = Estudiante_DAO.getEstudiantesActivos();

        observableEstudiante = FXCollections.observableArrayList(listaEstudiante);
        tb_Estudiantes.setItems(observableEstudiante);
    }


    public void clicAgregar(ActionEvent actionEvent) {
        AgregarView agregarView = new AgregarView(this);
        Ventana.iniciarVentana(btn_Agregar, agregarView, "Agregar_view.fxml", false);

    }

    public void clicVisualizar(ActionEvent actionEvent) {
        if(estudiante == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Seleccione un estudiante.");
            alert.show();
        }else {
            ConsultarView consultarView = new ConsultarView(estudiante);
            Ventana.iniciarVentana(btn_Visualizar, consultarView, "Consultar_view.fxml", false);
        }
    }

    public void clicBorrar(ActionEvent actionEvent) {
        if(estudiante == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Seleccione un estudiante.");
            alert.show();
        }else {
            Estudiante_DAO.borrar(estudiante);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Usuario borrado");
            alert.show();

            llenarTabla();
        }
    }

    public void clicEstudiante(MouseEvent mouseEvent) {

        estudiante = this.tb_Estudiantes.getSelectionModel().getSelectedItem();
    }
}