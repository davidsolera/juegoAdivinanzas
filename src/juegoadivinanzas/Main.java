package juegoAdivinanzas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;






public class Main {
	
static int eleccion1;
static Herramientas hr = new Herramientas();
static Jugadores jg = new Jugadores(null, eleccion1, eleccion1, eleccion1);

static JuegoPalabras jp = new JuegoPalabras();
static JuegoNumeros jn = new JuegoNumeros();
static PalabraEncadenada pe = new PalabraEncadenada();
	public static void main(String[] args) {
		
            hr.reproductor();
            try{
                    
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                
                //UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");// -------------estilo papel
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");//------------------estilo metal
                //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//-------estilo windows
               //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//--------------estilo morado
            
            }
            catch (Exception e){
                e.printStackTrace();
            }
                
		//************************INICIO****INTERFAZ**************************************************************************
            
		
		JFrame principal = new JFrame ("Juego Adivinanzas");
                //Colores
 
              
                Color nuevoColor = new Color(167, 220, 231);
                
                principal.getContentPane().setBackground(nuevoColor);


		JLabel tituloPrincipal = new JLabel ("Juego Adivinanzas");
		//Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=tituloPrincipal.getFont();

		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		tituloPrincipal.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		
		JButton adJug = new JButton ("Agregar Jugadores");
		JButton adivinaPalabra = new JButton ("Adivina la Palabra");
		JButton adivinaNum = new JButton ("Adivina el Numero");
		JButton palabraEncadenada = new JButton ("Palabra Encadenada");
		JButton salir = new JButton ("Salir");
		JLabel fecha = new JLabel (hr.fechaInterfaz());

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Asignamos la constante EXIT_ON_CLOSE, cierra la ventana al pulsar la X.
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
                
                
		gbc.gridx = 0;
		gbc.gridy = 1;gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
                principal.add (adJug,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (adivinaPalabra,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (adivinaNum,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (palabraEncadenada,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (salir,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.CENTER ;
		principal.add (fecha,gbc);

		//Hace visible el panel
		principal.setVisible(true);
		principal.setSize(650, 350);
		principal.setLocationRelativeTo(null); 
		principal.setResizable(false);
		//principal.pack();
		
                        
                
		try{
			adJug.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					 jg.interfazJugadores();
					
				}

			});
			}
			
			catch(Exception e){}
		try{
			adivinaPalabra.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					jp.interfazJuegoPalabras();
					
				}

			});
			}
			
			catch(Exception e){}
	
		
		try{
			adivinaNum.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					jn.interfazJuegoNumeros();
					
				}

			});
			}
			
			catch(Exception e){}
		try{
			palabraEncadenada.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					pe.interfazPalEnc();
					
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
			
	/*ejecucion en terminal		
		do{	
			hr.transicion();
			hr.mostrarFecha();
			hr.menuPrincipal();
			
			try{
				eleccion1 = Integer.valueOf(hr.pregunta("*       Elige una opcion:                            *"+"\n"+"*                                                    *" +"\n"+"******************************************************"));
			}
			catch(Exception o){
				
				hr.muestra("Debes introducir un numero. " + o);
			}
			
		}while(eleccion1>5 || eleccion1<1);
		
		
				switch(eleccion1){
				
					case 1:
						//anyadir jugadores
						hr.transicion();
						hr.mostrarFecha();
						hr.anyadirJugadores();
						break;
						
					case 2:
						//Adivinar palabras
						hr.transicion();
						hr.mostrarFecha();
						jp.partida();
						
						
					break;
					
					
					case 3:
						//Adivinar Numeros
						hr.transicion();
						hr.mostrarFecha();
						jn.juegoNum();
						
					break;
					
					
					case 4:
						//Jugar a palabra encadenada
						hr.transicion();
						hr.mostrarFecha();
						pe.encadenada();
						
					break;
					
					case 5:
						
						hr.transicion();
						hr.transicion();
						hr.mostrarFecha();
						hr.muestra("Adios, que pases un buen dia.");
						
						System.exit(0);
						
				}
			
		*/
	}

}
