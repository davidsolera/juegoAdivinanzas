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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JuegoNumeros {
	Herramientas hr = new Herramientas();	
	//con System.nanotime() se utiliza la hora del sistema en nanosegundos, para que el numero sea lo mas aleatorio posible.
	Random  rnd = new Random(System.nanoTime());
	
	private int numeroElegido = 0;
	private int numeroIntroducido = 0;
	private int i = 0;
	private int numeroPartidas=0;
	private int contador;
	private String nombre="";
	private int edad=0;
	private int partidasGanadas=0;
	private int partidasPerdidas=0;
	private int numeroAleatorio=0;
	private int partidasElegidas;
        private int partidasJugadas=0;
public void interfazJuegoNumeros(){
            //************************INICIO****INTERFAZ**************************************************************************
		
		JFrame principal = new JFrame ("Juego Adivinanzas");
                Color nuevoColor = new Color(167, 220, 231);
                
                principal.getContentPane().setBackground(nuevoColor);
		
		JLabel tituloPrincipal = new JLabel ("Adivina El numero");
		//Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=tituloPrincipal.getFont();

		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		
		final JButton numeroPartidas = new JButton ("Introduce el numero de partidas");
                final JTextField numeroPartidasIn = new JTextField("");	
		
                final JButton pista = new JButton();
			
		final JTextField numeroIn = new JTextField();	

                

		final JButton nomJug = new JButton ("Introduce los datos del jugador");
		final JTextField nomJugIn = new JTextField("Nombre");	
			
		final JTextField edadIn = new JTextField("edad");	

	
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
		principal.add (pista,gbc);
                gbc.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

		
		
                
		gbc.gridx = 2;
		gbc.gridy = 2;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
		principal.add (numeroIn,gbc);
                
                
		gbc.gridx = 0;
		gbc.gridy = 3;
                gbc.gridwidth = 1;
                gbc.gridheight = 2;
		principal.add (nomJug,gbc);
                
                gbc.gridx = 1;
		gbc.gridy = 3;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 1.0; // La fila 0 debe estirarse, le ponemos un 1.0
              //  gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (nomJugIn,gbc);
                
             
                gbc.gridx = 1;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 1.0; // La fila 0 debe estirarse, le ponemos un 1.0
            //    gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (edadIn,gbc);
                
		gbc.gridx = 2;
		gbc.gridy = 3;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
		principal.add (salir,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
		principal.add (fecha,gbc);

		//Hace visible el panel
		principal.setVisible(true);
		principal.setSize(650, 350);
		principal.setLocationRelativeTo(null); 
		principal.setResizable(false);
                
                
                
                    pista.setEnabled(false);
                    nomJug.setEnabled(false);
                
                //creacion de array de enteros con 50 posiciones
		final int numero[] = new int [50];
			
			
			
			
		//se da un valor aleatorio y se asigna a cada posicion del array

		for(i=0; i<numero.length;i++){
				
				
                    numeroAleatorio= rnd.nextInt(500);
				
                    numero[i]=numeroAleatorio;
		}
		
        
                //captar el numero de partidas
                try{
				numeroPartidas.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						partidasElegidas=Integer.valueOf(numeroPartidasIn.getText());
                                                numeroPartidas.setEnabled(false);
                                                numeroPartidasIn.setEnabled(false);
                                                pista.setEnabled(true);
                                                nomJug.setEnabled(true);
                                                //se elige una posicion aleatoria del array
                                                numeroElegido=numero[rnd.nextInt(49)];
			
                                               pista.setText(String.valueOf("El resultado del numero multiplicado por dos es: "+numeroElegido*2+" adivina que numero es."));
					}

				});
				}
				
				catch(Exception e){}
                
                
                 try{
				pista.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
					
                                           
                                                //se lee el numero 
                                                numeroIntroducido= Integer.valueOf(numeroIn.getText());
                                                //comprobar si numerointroducido es igual a numeroElegido sumando a la variable partidaGanada o perdida en cada caso

                                                    if(numeroIntroducido==numeroElegido){
                                                            
                                                            numeroIn.setBackground(Color.green);
                                                            numeroElegido=numero[rnd.nextInt(49)];
			
                                                            pista.setText(String.valueOf("El resultado del numero multiplicado por dos es: "+numeroElegido*2+" adivina que numero es."));
                                                            partidasJugadas++;
                                                            partidasGanadas++;
                                                            hr.reproductorAcierto();

                                                    }

                                                    else{
                                                            numeroIn.setBackground(Color.red);
                                                            hr.reproductorFallo();
                                                            
                                                            partidasJugadas++;
                                                            partidasPerdidas++;
                                                    }
                                            if(partidasElegidas==partidasJugadas){
                                                pista.setEnabled(false);
                                                numeroIn.setEnabled(false);
                                                nomJug.setEnabled(true);
                                                nomJugIn.setEditable(true);
                                                edadIn.setEnabled(true);
                                            }   
					}

				});
				}
				
				catch(Exception e){}
                
                
                //Añadir jugadores al fichero del juego formateado con ; entre nombre edad y partidas ganadas/perdidas
                
                try{
				nomJug.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
                                                    nombre=nomJugIn.getText();
                                                    edad=Integer.valueOf(edadIn.getText());
                                                    try{
                                                            File juegoeAdivinaNumero = new File("juegoeAdivinaNumero.txt");
                                                            if(juegoeAdivinaNumero.exists()){	
                                                                    FileWriter fw = new FileWriter (juegoeAdivinaNumero, true);
                                                                    BufferedWriter br = new BufferedWriter(fw);

                                                                    br.newLine();    
                                                                    br.write(nombre+";"+edad+";"+partidasGanadas+";"+partidasPerdidas);
                                                                    br.close();
                                                            }
                                                            else{
                                                                    FileWriter fw = new FileWriter (juegoeAdivinaNumero, true);
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
	//comienza el juego
	public void juegoNum(){
		
			//creacion de array de enteros con 50 posiciones
			int numero[] = new int [50];
			
			//se da un valor aleatorio y se asigna a cada posicion del array

			for(i=0; i<numero.length;i++){
				
				
				numeroAleatorio= rnd.nextInt(500);
				
				numero[i]=numeroAleatorio;
			}
		
		hr.muestra("");
		hr.muestra("*****************************************************");				
		hr.muestra("*************!ADIVINA EL NUMERO!*********************");
		hr.muestra("*****************************************************");
		hr.muestra("*     Se mostrara el resultado del numero por 2     *");
		hr.muestra("*****************************************************");
		hr.muestra("");
		hr.muestra("");
		
		//pregunta el numero de partidas a jugar
		numeroPartidas=Integer.valueOf(hr.pregunta("Cuantas partidas vas a jugar? "));

		System.out.print("Adivina el numero apartir del resultado de multiplicarlo por 2: ");
		
		
		for(contador = 0;contador<numeroPartidas; contador++){
			
				//se elige una posicion aleatoria del array
				numeroElegido=numero[rnd.nextInt(49)];
			
				//se muestra el resultado de multiplicar el contenido de la posicion elegida por dos
				hr.muestraInt(numeroElegido*2);
				hr.muestra("");
				
				try{
					//se lee el numero por teclado
					numeroIntroducido=Integer.valueOf(hr.pregunta("Que numero es? "));
				}
				catch(Exception o){
					
				}
				
				//comprobar si numerointroducido es igual a numeroElegido sumando a la variable partidaGanada o perdida en cada caso
				if(numeroIntroducido==numeroElegido){
					hr.muestra("has acertado!! Eres el maestro de los numeros!!");
					partidasGanadas++;
					
				}
				
				else{
					hr.muestra("no has acertado");
					partidasPerdidas++;
				}
			
		}
		
		//escritura de los datos del jugador en un fichero (incluyendo el resultado de la partida
		try{
		nombre=hr.pregunta("Introduce tu nombre: ");
		edad=Integer.valueOf(hr.pregunta("introduce tu edad: "));
		}
		catch(Exception u){}
		try{
			File juegoNumeros = new File("juegoNumeros.txt");
			if(juegoNumeros.exists()){	
				FileWriter fw = new FileWriter (juegoNumeros, true);
				BufferedWriter br = new BufferedWriter(fw);
				
				br.newLine();
				br.write("Jugador: "+nombre+" Edad: "+edad+" Partidas ganadas: "+partidasGanadas+" Partidas perdidas: "+partidasPerdidas);
				br.close();
			}
			else{
				FileWriter fw = new FileWriter (juegoNumeros, true);
				BufferedWriter br = new BufferedWriter(fw);
				
				br.write("Jugador: "+nombre+" Edad: "+edad+" Partidas ganadas: "+partidasGanadas+" Partidas perdidas: "+partidasPerdidas);
				br.newLine();
			
				br.close();
				
				
			}
		}catch(Exception ex){}
		
		//vuelve a ejecutarse el metodo principal de la aplicacion
		Main.main(null);

	}
	
	*/
}
