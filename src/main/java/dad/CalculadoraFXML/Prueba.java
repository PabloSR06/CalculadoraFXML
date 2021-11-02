package dad.CalculadoraFXML;

public class Prueba {

	public static void main(String[] args) {

		// instancio la calculadora
		Calculadora calc = new Calculadora();

		// queremos sumar 15 + 8,5 
		        
		// insertamos el 15
		calc.insertar('1');
		calc.insertar('5');

		// pulsamos el botón "+"
		calc.operar(Calculadora.SUMAR);
		        
		// insertamos 8,5
		calc.insertar('8');
		calc.insertarComa();
		calc.insertar('5');
		        
		// pulsamos el botón "="
		calc.operar(Calculadora.IGUAL);
		        
		// muestra el contenido de la pantalla de la calculadora (23.5)
		System.out.println(calc.getPantalla());
	}

}
