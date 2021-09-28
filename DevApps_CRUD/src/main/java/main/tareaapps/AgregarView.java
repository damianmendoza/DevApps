package main.tareaapps;

import DBConnection.Estudiante_DAO;
import POJO.Estudiante;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AgregarView {
    public TextField tf_primerNombre;
    public TextField tf_segundoNombre;
    public TextField tf_primerApellido;
    public TextField tf_segundoApellido;

    public HelloController helloController;

    public AgregarView(HelloController helloController) {
        this.helloController = helloController;
    }

    public void clicCancelar(ActionEvent actionEvent) {
        Stage cancelar = (Stage)tf_primerApellido.getScene().getWindow();
        cancelar.close();
    }

    public void clicRegistrar(ActionEvent actionEvent) {
        if (validar()){
            Estudiante estudiante = new Estudiante();
            estudiante.setPrimerNombre(tf_primerNombre.getText());
            estudiante.setSegundoNombre(tf_segundoNombre.getText());
            estudiante.setPrimerApellido(tf_primerApellido.getText());
            estudiante.setSegundoApellido(tf_segundoApellido.getText());
            estudiante.setActivation(true);

            Estudiante_DAO.guardar(estudiante);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Registro realizado");
            alert.show();

            helloController.llenarTabla();

            Stage cancelar = (Stage)tf_primerApellido.getScene().getWindow();
            cancelar.close();
        }
    }

    public boolean validar(){
        return !tf_primerNombre.getText().isEmpty() &&
                !tf_segundoNombre.getText().isEmpty() &&
                !tf_primerApellido.getText().isEmpty() &&
                !tf_segundoApellido.getText().isEmpty();
    }
}
