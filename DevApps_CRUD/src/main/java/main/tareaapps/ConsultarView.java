package main.tareaapps;

import POJO.Estudiante;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultarView implements Initializable {
    public Label lb_primerNombre;
    public Label lb_segundoNombre;
    public Label lb_primerApellido;
    public Label lb_segundoApellido;

    private Estudiante estudiante;

    public ConsultarView(Estudiante estudiante) {
        this.estudiante = estudiante;
    }


    public void clicRegresar(ActionEvent actionEvent) {
        Stage regresar = (Stage)lb_primerApellido.getScene().getWindow();
        regresar.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lb_primerNombre.setText(estudiante.getPrimerNombre());
        lb_segundoNombre.setText(estudiante.getSegundoNombre());
        lb_primerApellido.setText(estudiante.getPrimerApellido());
        lb_segundoApellido.setText(estudiante.getSegundoApellido());
    }
}
