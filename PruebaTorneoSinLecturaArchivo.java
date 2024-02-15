import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Miguel Herrera
 * abril 2023
 * Prueba del torneo sin lectura
 */
public class PruebaTorneoSinLecturaArchivo {

	public static void main(String[] args) {
		TorneoDeFutbol mundial;
		final int CANTIDAD_GRUPOS=8;
		String nombreEquipo, nombreEntrenador, rendimiento, nombreJugador, posicion;
		char grupo;
		int campeonatos, cantEquipos, cantJugadores, ahoNac, partidos, goles, asistencias, minutos, golesRecibidos;
		File ent= new File("Mundial2022.txt");
		System.out.println("Dentro");
		
		try(Scanner lec= new Scanner(ent)){
			mundial= new TorneoDeFutbol("Mundial", 2022, "Qatar");
			cantEquipos=Integer.parseInt(lec.nextLine());
			System.out.println(cantEquipos);
			cantJugadores=Integer.parseInt(lec.nextLine());
			System.out.println(cantJugadores);
			for(int i=0; i<cantEquipos; i++) {
				nombreEquipo=lec.nextLine();
				System.out.println(nombreEquipo);
				nombreEntrenador=lec.nextLine();
				System.out.println(nombreEntrenador);
				campeonatos=Integer.parseInt(lec.nextLine());
				rendimiento=lec.nextLine();
				grupo=lec.nextLine().charAt(0);
				System.out.println(mundial.altaEquipo(nombreEquipo, nombreEntrenador, campeonatos, rendimiento, grupo, CANTIDAD_GRUPOS));
				for(int j=0; j<cantJugadores; j++) {
					nombreJugador=lec.nextLine();
					ahoNac=Integer.parseInt(lec.nextLine());
					posicion=lec.nextLine();
					partidos=Integer.parseInt(lec.nextLine());
					goles=Integer.parseInt(lec.nextLine());
					asistencias=Integer.parseInt(lec.nextLine());
					minutos=Integer.parseInt(lec.nextLine());
					golesRecibidos=Integer.parseInt(lec.nextLine());
					System.out.println(mundial.altaJugadorEnEquipo(nombreEquipo, nombreJugador, ahoNac, posicion, partidos, goles, asistencias, minutos, golesRecibidos, CANTIDAD_GRUPOS));
				}
			}
			lec.close();
		}
		
		catch(FileNotFoundException fnfe) {
			System.err.println("ERROR        "+fnfe);
			System.exit(-1);
		}
	}
}
