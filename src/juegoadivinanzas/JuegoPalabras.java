package juegoAdivinanzas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

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
	private int partidasGanadas=0;
	private int partidasPerdidas=0;
	
	//comienzo juego
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
