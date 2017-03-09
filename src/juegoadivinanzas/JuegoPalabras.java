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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


                








public class JuegoPalabras {
	Herramientas hr = new Herramientas();
	//con System.nanotime() se utiliza la hora del sistema en nanosegundos, para que el numero sea lo mas aleatorio posible.
	Random  rnd = new Random(System.nanoTime());
	
	private String palabraElegida=("");
	private String letrasMuestra=("");
	private String palabraRecibida=("");
	private int contador=0;
	private int numeroPartidas=0;
	private String nombre="";
	private int edad=0;
        private int partidasElegidas=0;
	private int partidasGanadas=0;
	private int partidasPerdidas=0;
	private int partidasJugadas=0;
	//comienzo juego
        
        public void interfazJuegoPalabras(){
            //************************INICIO****INTERFAZ**************************************************************************
		
		JFrame principal = new JFrame ("Juego Adivinanzas");
                Color nuevoColor = new Color(167, 220, 231);
                
                principal.getContentPane().setBackground(nuevoColor);
		
		JLabel tituloPrincipal = new JLabel ("Adivina la palabra");
		//Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=tituloPrincipal.getFont();

		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		
		final JButton numeroPartidas = new JButton ("Introduce el numero de partidas");
                final JTextField numeroPartidasIn = new JTextField("");	
		
                final JButton pista = new JButton();
			
		final JTextField palabraIn = new JTextField();	

                

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
		principal.add (pista,gbc);
                gbc.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

		
		
                
		gbc.gridx = 2;
		gbc.gridy = 2;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
		principal.add (palabraIn,gbc);
                
                
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

        //creacion de un array con las palabras preestablecidas
		
			final String palabra[] = new String[25];
			
			palabra[0] = ("procesador");
			palabra[1] = ("almacenamiento");
			palabra[2] = ("aplicaciones");
			palabra[3] = ("monitor");
			palabra[4] = ("variables");
			palabra[5] = ("constantes");
			palabra[6] = ("metodos");
			palabra[7] = ("constructores");
			palabra[8] = ("clases");
			palabra[9] = ("bucles");
			palabra[10] = ("rombo");
			palabra[11] = ("teclado");
			palabra[12] = ("corchetes");
			palabra[13] = ("parentesis");
			palabra[14] = ("asteriscos");
			palabra[15] = ("codigo fuente");
			palabra[16] = ("compilar");
			palabra[17] = ("ejecutar");
			palabra[18] = ("comillas");
			palabra[19] = ("string");
			palabra[20] = ("entero");
			palabra[21] = ("proceso");
			palabra[22] = ("instancia");
			palabra[23] = ("propiedad");
			palabra[24] = ("programador");
			
			
		
        pista.setEnabled(false);
        nomJug.setEnabled(false);
                             try{
				numeroPartidas.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						partidasElegidas=Integer.valueOf(numeroPartidasIn.getText());
                                                numeroPartidas.setEnabled(false);
                                                numeroPartidasIn.setEnabled(false);
                                                pista.setEnabled(true);
                                                nomJug.setEnabled(true);  
                                                
                                                
                                                
                                                 //seleccionar una posicion aleatoria del array que sera la palabra a adivinar
                                               palabraElegida = palabra[rnd.nextInt(25)];
					
                                            //selecciono las dos primeras letras de la palabra
                                            letrasMuestra = palabraElegida.substring(0,2);
					
                                                //se muestran las dos primeras letras de la palabra+las dos ultimas usando (palabraElegida.substring(palabraElegida.length()-2)) 
                                                //y por ultimo el numero de letras de las que se compone la misma.

                                        	String muestraPista=("La palabra comienza por las letra: "+letrasMuestra+" y la letra final es "+palabraElegida.substring(palabraElegida.length()-2)+" y tiene una longitud de " + palabraElegida.length()+" caracteres.");
                                                pista.setText(String.valueOf(muestraPista));

					}

				});
				}
				
                            catch(Exception e){}
		
		
                            try{
				pista.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
                                           
                                           
                                               //se lee la palabra por teclado y se compara con la elegida aleatoriamente sumando a partidasGanadas o perdidas.
                                               try{
                                                       palabraRecibida =  palabraIn.getText();
                                               }
                                               catch(Exception s){}

                                               if(palabraRecibida.equals(palabraElegida)){

                                                       palabraIn.setBackground(Color.green);
                                                       //seleccionar una posicion aleatoria del array que sera la palabra a adivinar
                                                       palabraElegida = palabra[rnd.nextInt(25)];

                                                       //selecciono las dos primeras letras de la palabra
                                                       letrasMuestra = palabraElegida.substring(0,2);

                                                       //se muestran las dos primeras letras de la palabra+las dos ultimas usando (palabraElegida.substring(palabraElegida.length()-2)) 
                                                       //y por ultimo el numero de letras de las que se compone la misma.

                                                       String muestraPista=("La palabra comienza por las letra: "+letrasMuestra+" y la letra final es "+palabraElegida.substring(palabraElegida.length()-2)+" y tiene una longitud de " + palabraElegida.length()+" caracteres.");
                                                       pista.setText(String.valueOf(muestraPista));
                                                       partidasJugadas++;
                                                       partidasGanadas++;

                                               }

                                               else{
                                                       palabraIn.setBackground(Color.red);
                                                       partidasJugadas++;
                                                       partidasPerdidas++;
                                               }

                                           if(partidasElegidas==partidasJugadas){
                                                
                                                pista.setEnabled(false);
                                                palabraIn.setEnabled(false);
                                                
                                           }
					}

				});
				}
				
                            catch(Exception e){}
			
		
				
				
                        
                        
                        
                            try{
				nomJug.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
                                                    nombre=nomJugIn.getText();
                                                    edad=Integer.valueOf(edadIn.getText());
                                                    try{
                                                            File juegoencAdivinaLaPalabra = new File("juegoencAdivinaLaPalabra.txt");
                                                            if(juegoencAdivinaLaPalabra.exists()){	
                                                                    FileWriter fw = new FileWriter (juegoencAdivinaLaPalabra, true);
                                                                    BufferedWriter br = new BufferedWriter(fw);

                                                                    br.newLine();    
                                                                    br.write(nombre+";"+edad+";"+partidasGanadas+";"+partidasPerdidas);
                                                                    br.close();
                                                            }
                                                            else{
                                                                    FileWriter fw = new FileWriter (juegoencAdivinaLaPalabra, true);
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

                                                System.exit(0);

                                        }

                                });
                                }

                                catch(Exception e){}

        
        
        
        
        
        
}  
        
        

	public void partida(){
	
			//creacion de un array con las palabras preestablecidas
		
			String palabra[] = new String[25];
			
			palabra[0] = ("procesador");
			palabra[1] = ("almacenamiento");
			palabra[2] = ("aplicaciones");
			palabra[3] = ("monitor");
			palabra[4] = ("variables");
			palabra[5] = ("constantes");
			palabra[6] = ("metodos");
			palabra[7] = ("constructores");
			palabra[8] = ("clases");
			palabra[9] = ("bucles");
			palabra[10] = ("rombo");
			palabra[11] = ("teclado");
			palabra[12] = ("corchetes");
			palabra[13] = ("parentesis");
			palabra[14] = ("asteriscos");
			palabra[15] = ("codigo fuente");
			palabra[16] = ("compilar");
			palabra[17] = ("ejecutar");
			palabra[18] = ("comillas");
			palabra[19] = ("string");
			palabra[20] = ("entero");
			palabra[21] = ("proceso");
			palabra[22] = ("instancia");
			palabra[23] = ("propiedad");
			palabra[24] = ("programador");
			
			
		
			try{
				hr.muestra("");
				hr.muestra("*****************************************************");				
				hr.muestra("*************!ADIVINA LA PALABRA!********************");
				hr.muestra("*****************************************************");
				hr.muestra("*Las palabras estan relacionadas con la informatica.*");
				hr.muestra("*****************************************************");
				hr.muestra("");
				hr.muestra("");

				//pide el numero de partidas  a jugar
				numeroPartidas=Integer.valueOf(hr.pregunta("Cuantas partidas vas a jugar? "));
			}
			
			catch(Exception r){
				hr.muestra("Debes introducir un numero"+r);
			}
		
			
			for(contador=0;contador<numeroPartidas; contador++){
				
					//seleccionar una posicion aleatoria del array que sera la palabra a adivinar
					palabraElegida = palabra[rnd.nextInt(25)];
					
					//selecciono las dos primeras letras de la palabra
					letrasMuestra = palabraElegida.substring(0,2);
					
					//se muestran las dos primeras letras de la palabra+las dos ultimas usando (palabraElegida.substring(palabraElegida.length()-2)) 
					//y por ultimo el numero de letras de las que se compone la misma.

					hr.muestra("La palabra comienza por las letra: "+letrasMuestra+" y la letra final es "+palabraElegida.substring(palabraElegida.length()-2)+" y tiene una longitud de " + palabraElegida.length()+" caracteres.");
					
					//se lee la palabra por teclado y se compara con la elegida aleatoriamente sumando a partidasGanadas o perdidas.
					try{
						palabraRecibida =  hr.pregunta("Cual es la palabra?" );
					}
					catch(Exception s){}
					
					if(palabraRecibida.equals(palabraElegida)){
						
						hr.muestra("Has acertado!! eres un maestro de las palabras!!");
						partidasGanadas++;
						
					}
					
					else{
						hr.muestra("La palabra es incorrecta, vuelve a intentarlo con otra palabra.");
						partidasPerdidas++;
					}
					
				
				
			}
		
	nombre=hr.pregunta("Introduce tu nombre: ");
	edad=Integer.valueOf(hr.pregunta("introduce tu edad: "));
	
	try{
		File juegoPalabras = new File("juegoPalabras.txt");
		if(juegoPalabras.exists()){	
			FileWriter fw = new FileWriter (juegoPalabras, true);
			BufferedWriter br = new BufferedWriter(fw);
			
			
			br.newLine();
			br.write("Jugador: "+nombre+" Edad: "+edad+" Partidas ganadas: "+partidasGanadas+" Partidas perdidas: "+partidasPerdidas);
			br.close();
		}
		else{
			FileWriter fw = new FileWriter (juegoPalabras, true);
			BufferedWriter br = new BufferedWriter(fw);
			
			br.write("Jugador: "+nombre+" Edad: "+edad+" Partidas ganadas: "+partidasGanadas+" Partidas perdidas: "+partidasPerdidas);
			br.newLine();
		
			br.close();
			
			
		}
	}catch(Exception ex){}
	
	
	//vuelve a ejecutarse el metodo principal de la aplicacion

	Main.main(null);
	


	}
	
	

	

	
}
