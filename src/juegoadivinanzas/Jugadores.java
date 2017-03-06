package juegoAdivinanzas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Jugadores {
    

	
	public void interfazJugadores(){
		
		//************************INICIO****INTERFAZ**************************************************************************

		JFrame principal = new JFrame ("Juego Adivinanzas");

		
		JLabel titulo = new JLabel ("A�adir Jugadores");
		//Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=titulo.getFont();

		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		JLabel hueco = new JLabel ("                 ");

		final JButton numJugadores = new JButton ("Introduce el numero de jugadores");
		final JTextField nJugadoresIn = new JTextField();	

		final JButton nomJugador = new JButton ("Introduce el nombre del jugador");
		final JTextField nomJugadorIn = new JTextField();	

		final JButton edadJugador = new JButton ("Introduce su edad");
		final JTextField edadIn = new JTextField();	

		final JButton partPerdidas = new JButton ("Introduce el numero de partidas que ha perdido");
		final JTextField partPerdidasIn = new JTextField();	

		final JButton partGanadas = new JButton ("Introduce el numero de partidas que ha ganado");
		final JTextField partGanadasIn = new JTextField();	

		final JButton salir = new JButton ("Salir");
		final JLabel fecha = new JLabel ("hora actual");
		
		
		JPanel panel1 = new JPanel (new GridLayout(7,2));

		
                panel1.add(numJugadores);
		panel1.add(nJugadoresIn);	

		panel1.add(nomJugador);
		panel1.add(nomJugadorIn);	
		
		panel1.add(edadJugador);
		panel1.add(edadIn);	
		
		panel1.add(partPerdidas);
		panel1.add(partPerdidasIn);	
		
		panel1.add(partGanadas);
		panel1.add(partGanadasIn);	
		
		panel1.add(salir);
		panel1.add(fecha);	
		
	
		
		//panel1.add(panel11);
		//panel11.add(texto1);
	//	panel12.add(textArea);
		
		principal.add(panel1);
		
		
		

		//Hace visible el panel
		principal.setVisible(true);
		principal.setSize(650, 350);
		principal.setLocationRelativeTo(null); 
		principal.setResizable(false);
		//principal.pack();

		
		
		
Jugadores jugador[] = new Jugadores[ Integer.valueOf(nJugadoresIn.getText())];

	
		try{
			numJugadores.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					final int numeroJug = Integer.valueOf(nJugadoresIn.getText());
                                        numJugadores.setEnabled(false);
                                        nJugadoresIn.setEnabled(false);
				}

			});
			}
			
			catch(Exception e){}
                
                
                try{
			nomJugador.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){

                                        nombre = nomJugadorIn.getText();
					edad=Integer.valueOf(edadIn.getText());
					partidasGanadas=Integer.valueOf(partGanadasIn.getText());
					partidasPerdidas=Integer.valueOf(partPerdidasIn.getText());
					
                                        
                                         
                                        jugador[i] = new Jugadores(nombre, edad, partidasGanadas, partidasPerdidas);    
                                          
                                       
                                   
                                    
                                    
				}

			});
			}
			
			catch(Exception e){}
                
                
//************************FIN****INTERFAZ**************************************************************************

                
		
}
	
	
	
	
	
	Herramientas hr = new Herramientas();
	private String nombre="";
	private int edad=0;
	private int partidasGanadas=0;
	private int partidasPerdidas=0;
	
	
	
	
	public Jugadores(String nombre, int partidasGanadas,int edad, int partidasPerdidas) {
		this.nombre = nombre;
		this.edad = edad;
		this.partidasGanadas = partidasGanadas;
		this.partidasPerdidas= partidasPerdidas;
	
	}
	
	public String jugador(){
		
		return nombre + " " + edad + " " + partidasGanadas + " " + partidasPerdidas;
	}

	
	
	///gets sets
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getPartidasGanadas() {
		return partidasGanadas;
	}
	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}
	public int getPartidasPerdidas() {
		return partidasPerdidas;
	}
	public void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas = partidasPerdidas;
	}

			
			
			
}
