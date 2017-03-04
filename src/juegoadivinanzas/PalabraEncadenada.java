package juegoAdivinanzas;

import java.awt.Color;
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

class PalabraEncadenada {
Herramientas hr = new Herramientas();
JuegoPalabras jp = new JuegoPalabras();	

private String palabra1="";
private String parabraIn="";
private String letraFinal="";
private String letraInicial="";
private int longitudPalabra=0;	
private int contador=0;
private int numeroPartidas=0;
private String nombre="";
private int edad=0;
private int partidasGanadas=0;
private int partidasPerdidas=0;
private int partidasElegidas=0;

private int partidasJugadas=0;

public void interfazPalEnc(){
	
	//************************INICIO****INTERFAZ**************************************************************************
	
			JFrame principal = new JFrame ("Juego Adivinanzas");

			
			JLabel titulo = new JLabel ("AÒadir Jugadores");
			//Recojo la fuente que se esta utilizando actualmente.
			Font auxFont=titulo.getFont();

			//Aplico la fuente actual, y al final le doy el tama√±o del texto...
			titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
			JLabel hueco = new JLabel ("                 ");
			final JButton numeroPartidas = new JButton ("Introduce el numero de partidas");
			final JTextField numeroPartidasIn = new JTextField();	
			
			
			final JButton palabra = new JButton ("Introduce una palabra");
			final JTextField palabraIn = new JTextField();	

			JButton palabra2 = new JButton ("Palabra que comienze por la ultima letra de la anterior");
			final JTextField palabra2In = new JTextField();	

			JButton nomJug = new JButton ("Introduce el nombre del jugador");
			final JTextField nomJugIn = new JTextField();	
			
			JButton edadJugador = new JButton ("Introduce su edad");
			final JTextField edadIn = new JTextField();	

	
			JButton salir = new JButton ("Salir");
			JLabel fecha = new JLabel ("hora actual");
			
			
			JPanel panel1 = new JPanel (new GridLayout(7,2));
			
			panel1.add(numeroPartidas);
			panel1.add(numeroPartidasIn);	
			
			panel1.add(palabra);
			panel1.add(palabraIn);	

			panel1.add(palabra2);
			panel1.add(palabra2In);	
			
			panel1.add(edadJugador);
			panel1.add(edadIn);	
			
			panel1.add(nomJug);
			panel1.add(nomJugIn);	
			
			panel1.add(edadJugador);
			panel1.add(edadIn);	
			
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

			
			
			try{
				numeroPartidas.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						partidasElegidas=Integer.valueOf(numeroPartidasIn.getText());
					}

				});
				}
				
				catch(Exception e){}
		
		
			try{
				palabra.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						palabra1=palabraIn.getText();
						palabra.setEnabled(false);
					}

				});
				}
				
				catch(Exception e){}
			
			try{
				palabra2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						//se lee la palabra a comparar con palabraIn 
						parabraIn=palabra2In.getText();
						
						//se determina la longitud de la palabra 
						longitudPalabra = palabra1.length();
						
						//se selecciona la letra final de la palabra
						letraFinal=palabra1.substring(longitudPalabra-1);
						
						//se selecciona la letra inicial de la palabra
						letraInicial= parabraIn.substring(0, 1);
						
						//se comparan las palabras, si son iguales se suma a partidasGanadas y palabra1 toma el valor de palabraIn para  que se siga jugando y no se pierda la cadena
						if(letraInicial.equals(letraFinal)&&partidasElegidas!=partidasJugadas){
							
							palabraIn.setText(String.valueOf(palabraIn));
							palabra2In.setBackground(new Color(255,255,255));
							hr.muestra("la palabra es valida, introduce otra palabra.");
							partidasGanadas++;
							palabra1=parabraIn;
							partidasJugadas++;
						}
						//si no son iguales se suma i a partidasPerdidas
						else{
							
							palabra2In.setBackground(new Color(255,0,0)); //("la palabra NO comienza por la misma letra que la final de " + palabra1);
							partidasPerdidas++;
							partidasJugadas--;
						}
						
						
						
						
						
					}

				});
				}
				
				catch(Exception e){}
	}
//Comienza el juego
	public void encadenada(){
		
		hr.muestra("");
		hr.muestra("*****************************************************");				
		hr.muestra("*************!PALABRAS ENCADENADAS!******************");
		hr.muestra("*****************************************************");
		hr.muestra("*   Consiste en escribir una palabra que comience   *");
		hr.muestra("*     por la letra de la palabra anterior           *");
		hr.muestra("*     y algunas con el modulo de programacion       *");
		hr.muestra("*****************************************************");
		hr.muestra("");
		hr.muestra("");

		//se lee el numero de partidas
		numeroPartidas=Integer.valueOf(hr.pregunta("Cuantas partidas vas a jugar? "));
	
		
		//se lee la palabra con la que omenzara el juego (despues tomara el valor de la segunda que introduzcamos y asi con las sucesivas
		palabra1=hr.pregunta("introduce una palabra");
			
		
		for(contador=0;contador<numeroPartidas; contador++){
			
			//se lee la palabra a comparar con palabraIn 
			parabraIn=hr.pregunta("introduce una palabra que comience por la misma letra que termina "+palabra1);
			
			//se determina la longitud de la palabra 
			longitudPalabra = palabra1.length();
			
			//se selecciona la letra final de la palabra
			letraFinal=palabra1.substring(longitudPalabra-1);
			
			//se selecciona la letra inicial de la palabra
			letraInicial= parabraIn.substring(0, 1);
			
			//se comparan las palabras, si son iguales se suma a partidasGanadas y palabra1 toma el valor de palabraIn para  que se siga jugando y no se pierda la cadena
			if(letraInicial.equals(letraFinal)){
				
				hr.muestra("la palabra es valida, introduce otra palabra.");
				partidasGanadas++;
				palabra1=parabraIn;
			}
			//si no son iguales se suma i a partidasPerdidas
			else{
				
				hr.muestra("la palabra NO comienza por la misma letra que la final de " + palabra1);
				partidasPerdidas++;
			}
			
		}	
		//se toman los datos del jugador y se guardan en un fichero
		nombre=hr.pregunta("Introduce tu nombre: ");
		edad=Integer.valueOf(hr.pregunta("introduce tu edad: "));
		try{
			File juegoencPalabrasEdenadas = new File("juegoencPalabrasEdenadas.txt");
			if(juegoencPalabrasEdenadas.exists()){	
				FileWriter fw = new FileWriter (juegoencPalabrasEdenadas, true);
				BufferedWriter br = new BufferedWriter(fw);
				
				
				br.newLine();
				br.write("Jugador: "+nombre+" Edad: "+edad+" Partidas ganadas: "+partidasGanadas+" Partidas perdidas: "+partidasPerdidas);
				br.close();
			}
			else{
				FileWriter fw = new FileWriter (juegoencPalabrasEdenadas, true);
				BufferedWriter br = new BufferedWriter(fw);
				
				br.write("Jugador: "+nombre+" Edad: "+edad+" Partidas ganadas: "+partidasGanadas+" Partidas perdidas: "+partidasPerdidas);
				br.newLine();
			
				br.close();
				
				
			}
		}catch(Exception ex){}
		
		//retorna al menu principal para que la aplicacion no se cierre hasta que el usuario lo haga manualmente desde el menu principal
		Main.main(null);
	}
	
	

}
