package juegoAdivinanzas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

 
class Herramientas{
    

        public  void reproductorFondo(){
            
            try {
                //
               // Se obtiene un Clip de sonido
               Clip sonido = AudioSystem.getClip();

               // Se carga con un fichero wav
               sonido.open(AudioSystem.getAudioInputStream(new File("musicaFondo.wav")));

            
                // Comienza la reproducción
                sonido.loop(Clip.LOOP_CONTINUOUSLY);
                
              

               // Espera mientras se esté reproduciendo.
               while (sonido.isRunning())
                   Thread.sleep(1000);

               
           } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
               System.out.println("" + e);
           }
    
        }
    public void reproductorFallo(){
           try {
                //
               // Se obtiene un Clip de sonido
               Clip sonido = AudioSystem.getClip();

               // Se carga con un fichero wav
               sonido.open(AudioSystem.getAudioInputStream(new File("fallo.wav")));

               // Comienza la reproducción
               sonido.start();
              

               // Espera mientras se esté reproduciendo.
               while (sonido.isRunning())
                   Thread.sleep(1000);

               
           } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
               System.out.println("" + e);
           }
    
        }
    public void reproductorAcierto(){
            try {
                //
               // Se obtiene un Clip de sonido
               Clip sonido = AudioSystem.getClip();

               // Se carga con un fichero wav
               sonido.open(AudioSystem.getAudioInputStream(new File("acierto.wav")));

               // Comienza la reproducción
               sonido.start();
              

               // Espera mientras se esté reproduciendo.
               while (sonido.isRunning())
                   Thread.sleep(1000);

               
           } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
               System.out.println("" + e);
           }
    
        }
    
    public void reproductorDespedida(){
           try {
                //
               // Se obtiene un Clip de sonido
               Clip sonido = AudioSystem.getClip();

               // Se carga con un fichero wav
               sonido.open(AudioSystem.getAudioInputStream(new File("bye.wav")));

               // Comienza la reproducción
               sonido.start();
              

               // Espera mientras se esté reproduciendo.
               while (sonido.isRunning())
                   Thread.sleep(1000);

               
           } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
               System.out.println("" + e);
           }
    
        }
    public void reproducirBoton(){
           try {
                //
               // Se obtiene un Clip de sonido
               Clip sonido = AudioSystem.getClip();

               // Se carga con un fichero wav
               sonido.open(AudioSystem.getAudioInputStream(new File("clic.wav")));

               // Comienza la reproducción
               sonido.start();
              

               // Espera mientras se esté reproduciendo.
               while (sonido.isRunning())
                   Thread.sleep(1000);

               
           } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
               System.out.println("" + e);
           }
    
        }
    public void reproducirBotonJuego(){
           try {
                //
               // Se obtiene un Clip de sonido
               Clip sonido = AudioSystem.getClip();

               // Se carga con un fichero wav
               sonido.open(AudioSystem.getAudioInputStream(new File("clicJuego.wav")));

               // Comienza la reproducción
               sonido.start();
              

               // Espera mientras se esté reproduciendo.
               while (sonido.isRunning())
                   Thread.sleep(1000);

               
           } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
               System.out.println("" + e);
           }
    
        }
    public void reproducirBienvenida(){
           try {
                //
               // Se obtiene un Clip de sonido
               Clip sonido = AudioSystem.getClip();

               // Se carga con un fichero wav
               sonido.open(AudioSystem.getAudioInputStream(new File("bienvenida.wav")));

               // Comienza la reproducción
               sonido.start();
              

               // Espera mientras se esté reproduciendo.
               while (sonido.isRunning())
                   Thread.sleep(1000);

               
           } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
               System.out.println("" + e);
           }
    
        }
    
    
    
    
    
	//introducir datos

	public String pregunta(String preg){
	
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		System.out.print(preg);
		String leer= teclado.nextLine();
		
	    return (leer);
	
	  }	
	
	//mostrar datos
	public void muestra (String texto){
		
		System.out.println (texto);
	
	}

	//mostrar datos enteros
		public void muestraInt (int numero){
			
			System.out.print (numero);
		
		}

	//Limpiar pantalla
	public void cls (String texto){
		
	System.out.flush();
	
	}

	//menu principal
	
	public void menuPrincipal(){

		muestra("");
		muestra("******************************************************");				
		muestra("*************!JUEGOS DE ADIVINANZAS!******************");
		muestra("******************************************************");
		muestra("*       Pulsa 1 para introducir los jugadores.       *");
		muestra("*       Pulsa 2 para jugar a adivinar palabra.       *");
		muestra("*       Pulsa 3 para jugar a adivinar el numero.     *");
		muestra("*       Pulsa 4 para jugar a palabras encadenadas.   *");
		muestra("*       Pulsa 5  para salir.                         *");
		muestra("******************************************************");				
		muestra("*                                                    *");
	}
	
	  
	//transicion	
	public void transicion(){
		for(int a=0; a<=10;a++){
			byte altura = 12;
		    
		    muestra("");
	
		    int i,j;
		    int mitad=altura/2;
		   
		    for (i=0;i<=altura;i++){
		      
			//Primera mitad del rombo
			if (i<mitad) {
				//Espacios hasta primer *
				for (j=mitad;j>i;j--){
					System.out.print(" ");
				}
				System.out.print("*");
				
				//Espacios hasta segundo *
				for (j=1;j<(i*2);j++){
					System.out.print(" ");
				}
				if (i>0) System.out.print("*");
	
			}
	
			//Segunda mitad del rombo
			else{
				//Espacios hasta primer *
				for (j=mitad;j<i;j++){
					System.out.print(" ");
				}
				System.out.print("*");
	
				//Espacios hasta segundo *
				for (j=1;j<((altura-i)*2);j++){
					System.out.print(" ");
				}
				if (i<altura) System.out.print("*");
			}
	
			System.out.println();
	
		    }
		}
	   
	}
	
	//introducir jugadores
	public void anyadirJugadores(){
			
			int numeroJugadores=0;
			String nombre="";
			int edad=0;
			int partidasGanadas=0;
			int partidasPerdidas=0;
			int i;
			
			try{
			numeroJugadores=Integer.valueOf(pregunta("Cuantos jugadores sois?"));
			}
			catch(Exception y){
				
			}
			Jugadores jugador[] = new Jugadores[numeroJugadores];
			
				for(i=0;i<jugador.length;i++){
					
					nombre = pregunta("introduce tu nombre");
					edad=Integer.valueOf(pregunta("introduce tu edad"));
					partidasGanadas=0;
					partidasPerdidas=0;

					jugador[i] = new Jugadores(nombre, edad, partidasGanadas, partidasPerdidas);
					
					
				}
				try{
					File ficheroJugadores = new File("jugadores.txt");
					if(ficheroJugadores.exists()){	
						FileWriter fw = new FileWriter (ficheroJugadores, true);
						BufferedWriter br = new BufferedWriter(fw);
						
						for(i=0; i<numeroJugadores;i++){
							br.newLine();
							br.write("El nombre del jugador es: "+jugador[i].getNombre()+". Su edad es: "+ jugador[i].getEdad());
						}
						br.close();
					}
					else{
						FileWriter fw = new FileWriter (ficheroJugadores, true);
						BufferedWriter br = new BufferedWriter(fw);
						
						for(i=0; i<numeroJugadores;i++){
							br.write("El nombre del jugador es: "+jugador[i].getNombre()+". Su edad es: "+ jugador[i].getEdad());
							br.newLine();
						}
						br.close();
						
						
					}
				}catch(Exception ex){}
				
				Main.main(null);
	}	
	
	
	//mostrar jugadores
	public void mostrarJugadores(String jugador[]){
		
		for(int i=0; i>jugador.length;i++){
			
			muestra(jugador[i]);
			
		}
		
	}
	
	public void mostrarFecha(){
		
		Date fecha = new Date();
		SimpleDateFormat formateador;
		SimpleDateFormat formateador2;
		
		formateador = new SimpleDateFormat ("dd/MM/yy");
		formateador2 = new SimpleDateFormat ("HH:mm:ss");
		
		muestra("La fecha actual es: "+formateador.format(fecha));
		muestra("La hora actual es: "+formateador2.format(fecha));

		
		
		
		
	}
        public String fechaInterfaz(){
		String fechaFinal=("");
                
                    Date fecha = new Date();
                    SimpleDateFormat formateador;
                    SimpleDateFormat formateador2;

                    formateador = new SimpleDateFormat ("dd/MM/yy");
                    formateador2 = new SimpleDateFormat ("HH:mm:ss");

                   
                   
                fechaFinal = formateador.format(fecha)+"\n";
		fechaFinal = fechaFinal+formateador2.format(fecha);

		return fechaFinal;
		
		
	}
	public void ventanaPrincipal(){
		//-------------------------------------------------------------------------------------------------------------
				//creo la ventana
				final JFrame ventana = new JFrame ("JUEGO ADIVINANZAS");
				//creo la barra menu principal
				JMenuBar barra = new JMenuBar();
				
				//**********************************************
				//creo boton en barra del menu
				JMenu inicio = new JMenu("Inicio");
				
				//creo otro menu para poder añadir submenus
				JMenu adJugador = new JMenu("Añadir jugador");
				
				
				
				//creo listado de los elementos del menu que no tendran submenus
				JMenuItem adivinaPal = new JMenuItem("Adivina la palabra");
				JMenuItem adivinaNum = new JMenuItem("Adivina el numero");
				JMenuItem palabraEnc = new JMenuItem("Juego palabras encadenadas");
				JMenuItem salir = new JMenuItem("Salir");

				//añado el menu añadir jugador a la barra principal
				inicio.add(adJugador);
				
				
				//creo los submenus para el menu añadir jugador
				JMenuItem add = new JMenuItem("Añadir jugadores");	
				
				add.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						
						JPanel panelPrincipal = new JPanel(new GridLayout(5,2));
						JPanel panelTitulo = new JPanel (new GridLayout(1,3));

						JPanel panel1 = new JPanel (new GridLayout(2,1));
						JPanel panel11 = new JPanel (new GridLayout(1,2));
						JPanel panel12 = new JPanel (new GridLayout(1,2));
						

						JPanel panel2 = new JPanel (new GridLayout(2,1));
						JPanel panel21 = new JPanel (new GridLayout(1,2));
						JPanel panel22 = new JPanel (new GridLayout(1,2));
						

						JPanel panelEnviar = new JPanel(new GridLayout(5,2));				
						JButton textoEnviar = new JButton("ENVIAR");
						
						JLabel vacioTitulo = new JLabel(""); 
						JLabel vacioTitulo2 = new JLabel(""); 

				
						JLabel textTitulo = new JLabel("Añadir Jugadores"); 
						
						JLabel textoNombre = new JLabel ("Nombre");
						JTextField textAreaNombre = new JTextField(); 
					
						JLabel textoEdad = new JLabel ("Edad");
						JTextField textAreaEdad = new JTextField(); 

						JLabel textoPartidasG = new JLabel ("Partidas Ganadas");
						JTextField textPartidasG = new JTextField(); 
					
						JLabel textoPartidasP = new JLabel ("Partidas Perdidas");
						JTextField textPartidasP= new JTextField(); 
						
						panelTitulo.add(vacioTitulo);
						panelTitulo.add(textTitulo);
						panelTitulo.add(vacioTitulo2);

						panel1.add(panel11);
						panel1.add(panel12);
						
						panel11.add(textoNombre);
						panel11.add(textAreaNombre);
						
						panel12.add(textoEdad);
						panel12.add(textAreaEdad);

						panel2.add(panel21);
						panel2.add(panel22);
						
						panel21.add(textoPartidasG);
						panel21.add(textPartidasG);
						
						panel22.add(textoPartidasP);
						panel22.add(textPartidasP);
						
						panelEnviar.add(textoEnviar);
						
						
						panelPrincipal.add(panelTitulo);
						panelPrincipal.add(panel1);
						panelPrincipal.add(panel2);
						panelPrincipal.add(panelEnviar);
						
						ventana.add(panelPrincipal);
						ventana.setVisible(true);
					}

				});		
				
				
				
				JMenuItem borrar = new JMenuItem("Borrar jugadores");
				JMenuItem ver = new JMenuItem("Ver jugadores");

				//añado los submenus al menu añadir jugador
				adJugador.add(add);
				adJugador.add(borrar);
				adJugador.add(ver);
				
				//añado los elementos al menu inicio
				inicio.add(adivinaPal);
				inicio.add(adivinaNum);
				inicio.add(palabraEnc);
				inicio.add(salir);
				
				//añado el menu inicio con todo el contenido a la barra principal
				barra.add(inicio);
				
				//**********************************************
				ventana.setJMenuBar(barra);
				ventana.setVisible(true);
				ventana.setSize(500, 500);
				ventana.setLocationRelativeTo(null);
		//-----------------------------------------------------------------------------------------------------------
				

		
	}

        
        
}
