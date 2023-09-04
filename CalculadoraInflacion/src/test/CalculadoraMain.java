package test;

import javax.swing.SwingUtilities;

import calculadoraInflacion.CalculadoraInflacion;

public class CalculadoraMain{
	 
	public static void main(String[] args) {
	    
	
		   SwingUtilities.invokeLater(() -> {
	            new CalculadoraInflacion();
	        });
}
}

   
   