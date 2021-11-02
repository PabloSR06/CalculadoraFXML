package dad.CalculadoraFXML;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

	// model

	private StringProperty screen = new SimpleStringProperty();

	// view

	@FXML
	private GridPane view;

	@FXML
	private TextField screenText;

	@FXML
	private Button borrarTodoButton;

	@FXML
	private Button igualButton;

	@FXML
	private Button borrarButton;

	@FXML
	private Button sumaButton;

	@FXML
	private Button multiplicarButton;

	@FXML
	private Button restaButton;

	@FXML
	private Button divisionButton;

	@FXML
	private Button comaButton;

	@FXML
	private Button unoButton;
	
	@FXML
	private Button dosButton;
	
	@FXML
	private Button tresButton;
	
	@FXML
	private Button cuatroButton;
	
	@FXML
	private Button cincoButton;
	
	@FXML
	private Button seisButton;
	
	@FXML
	private Button sieteButton;
	
	@FXML
	private Button ochoButton;
	
	@FXML
	private Button nueveButton;

	//Calculadora
	private Calculadora calc = new Calculadora();

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/view.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		//pantalla
		screenText.textProperty().bind(screen);

		borrarTodoButton.setOnAction(e -> onOperatorAction(borrarTodoButton.getText()));
		borrarButton.setOnAction(e -> onOperatorAction(borrarButton.getText()));
		restaButton.setOnAction(e -> onOperatorAction(restaButton.getText()));
		sumaButton.setOnAction(e -> onOperatorAction(sumaButton.getText()));
		multiplicarButton.setOnAction(e -> onOperatorAction(multiplicarButton.getText()));
		divisionButton.setOnAction(e -> onOperatorAction(divisionButton.getText()));
		comaButton.setOnAction(e -> onOperatorAction(comaButton.getText()));
		igualButton.setOnAction(e -> onOperatorAction(igualButton.getText()));

	}

	@FXML
	private void onNumeroClick(ActionEvent e) {
		System.out.println(e.getSource().toString().charAt(e.getSource().toString().length()-2));
		char salida = e.getSource().toString().charAt(e.getSource().toString().length()-2);
		calc.insertar(salida);
		screen.set(calc.getPantalla());
	}

	private void onOperatorAction(String ButtomText) {

		char operador = ButtomText.charAt(0);

		switch (ButtomText) {
		case "CE":
			calc.borrarTodo();
			break;
		case "C":
			calc.borrar();
			break;
		case "-":
			calc.operar(operador);
			break;
		case "+":
			calc.operar(operador);
			break;
		case "*":
			calc.operar(operador);
			break;
		case "/":
			calc.operar(operador);
			break;
		case ".":
			calc.insertarComa();
			break;
		case "=":
			calc.operar(operador);
			break;
		}
		screen.set(calc.getPantalla());
	}

	public GridPane getView() {
		return view;
	}

//	public String getPantalla() {
//		return screen.getValue();
//	}

}
