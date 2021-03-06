package juegoAdivinanzas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.Collator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static juegoAdivinanzas.Main.hr;

class PalabraEncadenada {
Herramientas hr = new Herramientas();
JuegoPalabras jp = new JuegoPalabras();	
Collator comparador = Collator.getInstance();

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
                Color nuevoColor = new Color(167, 220, 231);
                
                principal.getContentPane().setBackground(nuevoColor);
		
		JLabel tituloPrincipal = new JLabel ("Palabra Encadenada");
                
                //Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=tituloPrincipal.getFont();

		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
                
		final JButton numeroPartidas = new JButton ("Introduce el numero de partidas");
			final JTextField numeroPartidasIn = new JTextField();	
			
			
			final JButton palabra = new JButton ("Introduce una palabra");
			final JTextField palabraIn = new JTextField();	

			final JButton palabra2 = new JButton ("Palabra que comienze por la ultima letra de la anterior");
			final JTextField palabra2In = new JTextField();	

			final JButton nomJug = new JButton ("Introduce los datos del jugador");
			final JTextField nomJugIn = new JTextField("Introduce tu nombre");	
			
			final JTextField edadIn = new JTextField("Introduce tu edad");	

	
			final JButton salir = new JButton ("Salir");
			final JLabel fecha = new JLabel (hr.fechaInterfaz());

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Asignamos al JFrame el Layout que usaremos, GridBagLayout
		
		principal.setLayout (gridbag);
		
		//a�adir botones al layout
		
		gbc.gridx = 1;
		gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
                principal.add (tituloPrincipal,gbc);
                gbc.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

		
		gbc.gridx = 1;
		gbc.gridy = 1;
                gbc.gridheight = 1;     
                gbc.weighty = 2.0; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.NONE ;
		principal.add (numeroPartidas,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;     
                gbc.weighty = 2.0; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (numeroPartidasIn,gbc);
                gbc.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

		
                
                gbc.gridx = 0;
		gbc.gridy = 2;
                gbc.gridwidth = 2;
                gbc.weighty = 2.2; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.BOTH;
		principal.add (palabra,gbc);
                gbc.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

                 
		gbc.gridx = 2;
		gbc.gridy = 2;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
		principal.add (palabraIn,gbc);
                
                
                
		gbc.gridx = 0;
		gbc.gridy = 3;
                gbc.gridwidth = 2;
                gbc.weighty = 2.2; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.BOTH;
		principal.add (palabra2,gbc);
                gbc.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

		
		
                
		gbc.gridx = 2;
		gbc.gridy = 3;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
		principal.add (palabra2In,gbc);
                
                
		gbc.gridx = 2;
		gbc.gridy = 3;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
		principal.add (palabra2In,gbc);
                
		gbc.gridx = 0;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 2;
		principal.add (nomJug,gbc);
                
                gbc.gridx = 1;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 1.0; // La fila 0 debe estirarse, le ponemos un 1.0
              //  gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (nomJugIn,gbc);
                
             
                gbc.gridx = 1;
		gbc.gridy = 5;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 1.0; // La fila 0 debe estirarse, le ponemos un 1.0
            //    gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (edadIn,gbc);
                
		gbc.gridx = 2;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
		principal.add (salir,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 5;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                
		principal.add (fecha,gbc);

		//Hace visible el panel
		principal.setVisible(true);
		principal.setSize(650, 350);
		principal.setLocationRelativeTo(null); 
		principal.setResizable(false);
		//principal.pack(); 
    palabra.setEnabled(false);
    palabra2.setEnabled(false);
    nomJug.setEnabled(false);
    comparador.setStrength(Collator.PRIMARY);
			try{
				numeroPartidas.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
                                                hr.reproducirBotonJuego();
						partidasElegidas=Integer.valueOf(numeroPartidasIn.getText());
                                                numeroPartidasIn.setEnabled(false);
                                                numeroPartidas.setEnabled(false);
                                                palabra.setEnabled(true);
                                                palabra2.setEnabled(true);
                                                nomJug.setEnabled(true);

					}

				});
				}
				
				catch(Exception e){}
		
		
			try{
				palabra.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
                                                hr.reproducirBotonJuego();
						palabra1=palabraIn.getText();
						palabra.setEnabled(false);
                                                palabraIn.setEnabled(false);
					}

				});
				}
				
				catch(Exception e){}
			
			try{
				palabra2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
                                        hr.reproducirBotonJuego();
						//se lee la palabra a comparar 
						parabraIn=palabra2In.getText();
						
						//se determina la longitud de la palabra 
						longitudPalabra = palabra1.length();
						
						//se selecciona la letra final de la palabra
						letraFinal=palabra1.substring(longitudPalabra-1);
						
						//se selecciona la letra inicial de la palabra
						letraInicial= parabraIn.substring(0, 1);
                                                
						if(comparador.equals(parabraIn, palabra1)){
                                                   palabra2In.setText("ES IGUAL!!!");
						
						 }
                                                else{
                                                      //se comparan las palabras, si son iguales se suma a partidasGanadas y palabra1 toma el valor de palabraIn para  que se siga jugando y no se pierda la cadena
                                                    if(letraInicial.equals(letraFinal)&&partidasElegidas!=partidasJugadas){

                                                            palabraIn.setText(String.valueOf(palabraIn));
                                                            palabra2In.setBackground(Color.green);
                                                            partidasGanadas++;
                                                            palabra1=parabraIn;
                                                            palabraIn.setText(palabra1);                                             
                                                            partidasJugadas++;
                                                            hr.reproductorAcierto();
                                                    }

                                                    //si no son iguales se suma 1 a partidasPerdidas
                                                    else{

                                                            palabra2In.setBackground(new Color(255,0,0)); //("la palabra NO comienza por la misma letra que la final de " + palabra1);

                                                            partidasPerdidas++;
                                                            hr.reproductorFallo();
                                                    }


                                                    if(partidasElegidas==partidasJugadas){
                                                        numeroPartidas.setEnabled(false);
                                                        numeroPartidasIn.setEnabled(false);
                                                        palabra.setEnabled(false);
                                                        palabraIn.setEnabled(false);
                                                        palabra2.setEnabled(false);
                                                        palabra2In.setEditable(false);
                                                        nomJug.setEnabled(true);
                                                        nomJugIn.setEnabled(true);
                                                        edadIn.setEnabled(true);
                                                    }
                                                  
                                                   
                                                }
                                                    
						
					}

				});
				}
				
				catch(Exception e){}
                        
                                try{
				nomJug.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
                                                    hr.reproducirBotonJuego();
                                                    nombre=nomJugIn.getText();
                                                    edad=Integer.valueOf(edadIn.getText());
                                                    try{
                                                            File juegoencPalabrasEdenadas = new File("juegoencPalabrasEdenadas.txt");
                                                            if(juegoencPalabrasEdenadas.exists()){	
                                                                    FileWriter fw = new FileWriter (juegoencPalabrasEdenadas, true);
                                                                    BufferedWriter br = new BufferedWriter(fw);

                                                                    br.newLine();    
                                                                    br.write(nombre+";"+edad+";"+partidasGanadas+";"+partidasPerdidas);
                                                                    br.close();
                                                            }
                                                            else{
                                                                    FileWriter fw = new FileWriter (juegoencPalabrasEdenadas, true);
                                                                    BufferedWriter br = new BufferedWriter(fw);
                                                                    
                                                                    br.write(nombre+";"+edad+";"+partidasGanadas+";"+partidasPerdidas);
                                                                    br.newLine();

                                                                    br.close();
                                                                                

                                                            }
                                                            
                                                            
                                                    }catch(Exception ex){}
                                            
                                                    nomJug.setEnabled(false);
                                                    nomJugIn.setEnabled(false);
                                                    edadIn.setEnabled(false);
					}

				});
				}
				
				catch(Exception e){}
                        
                        
                        try{
			salir.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					hr.reproductorDespedida();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                    }
					System.exit(0);
                                    
                                    
                                    
					System.exit(0);
					
				}

			});
			}
			
			catch(Exception e){}
	}

                

/*Ejecucion en terminal
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
	
	
        */
}
