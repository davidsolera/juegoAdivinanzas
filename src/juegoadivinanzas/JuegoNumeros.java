package juegoAdivinanzas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class JuegoNumeros {
	Herramientas hr = new Herramientas();	
	//con System.nanotime() se utiliza la hora del sistema en nanosegundos, para que el numero sea lo mas aleatorio posible.
	Random  rnd = new Random(System.nanoTime());
	
	private int numeroElegido = 0;
	private int numeroIntroducido = 0;
	private int i = 0;
	private int numeroPartidas;
	private int contador;
	private String nombre="";
	private int edad=0;
	private int partidasGanadas=0;
	private int partidasPerdidas=0;
	private int numeroAleatorio=0;
	
	
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
	
	
}
