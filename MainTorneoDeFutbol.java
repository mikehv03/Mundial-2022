import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Miguel Herrera
 * abril 2023
 * Main para probar la clase torneo de futbol.
 */
public class MainTorneoDeFutbol {
	
	public static void main(String[] args) {
		TorneoDeFutbol mundial;
		String[]arr= new String[2];
		final int CANTIDAD_GRUPOS=8;
		String nombreEquipo, nombreEntrenador, rendimiento, nombreJugador, posicion, aux; //EL auxiliar sirve para leer Strings con dos palabras y enteros.
		char grupo;
		int campeonatos, cantEquipos, cantJugadores, ahoNac, partidos, goles, asistencias, minutos, golesRecibidos;
		File ent= new File("Mundial2022.txt");
	
		try(Scanner lec= new Scanner(ent)){
			mundial= new TorneoDeFutbol("Mundial", 2022, "Qatar");
			cantEquipos=lec.nextInt();
			aux=lec.nextLine();
			for(int i=0; i<cantEquipos; i++) {
				nombreEquipo=lec.nextLine();
				nombreEntrenador=lec.nextLine();
				campeonatos=lec.nextInt();
				aux=lec.nextLine();
				rendimiento=lec.nextLine();
				grupo=lec.nextLine().charAt(0);
				cantJugadores=lec.nextInt();
				aux=lec.nextLine();
				System.out.println(mundial.altaEquipo(nombreEquipo, nombreEntrenador, campeonatos, rendimiento, grupo, CANTIDAD_GRUPOS));
				for(int j=0; j<cantJugadores; j++) {
					nombreJugador=lec.nextLine();
					ahoNac=lec.nextInt();
					aux=lec.nextLine();
					posicion=lec.nextLine();
					partidos=lec.nextInt();
					aux=lec.nextLine();
					goles=lec.nextInt();
					asistencias=lec.nextInt();
					minutos=lec.nextInt();
					golesRecibidos=lec.nextInt();
					System.out.println(mundial.altaJugadorEnEquipo(nombreEquipo, nombreJugador, ahoNac, posicion, partidos, goles, asistencias, minutos, golesRecibidos, CANTIDAD_GRUPOS));
					aux=lec.nextLine();
				}
			}
			nombreEquipo=lec.nextLine();
			System.out.println(nombreEquipo);
			campeonatos=lec.nextInt();
			System.out.println(campeonatos);
			System.out.println(mundial.getUnEquipo(nombreEquipo, CANTIDAD_GRUPOS));
			System.out.println(mundial.agregarCampeonatosAEquipo(nombreEquipo, campeonatos, CANTIDAD_GRUPOS));
			System.out.println(mundial.getUnEquipo(nombreEquipo, CANTIDAD_GRUPOS));
			aux=lec.nextLine();
			nombreEquipo=lec.nextLine();
			System.out.println(nombreEquipo);
			nombreJugador=lec.nextLine();
			System.out.println(nombreJugador);
			System.out.println(mundial.getUnJugadorDeEquipo(nombreEquipo, nombreJugador, CANTIDAD_GRUPOS));
			partidos=lec.nextInt();
			goles=lec.nextInt();
			asistencias=lec.nextInt();
			minutos=lec.nextInt();
			lec.close();
			System.out.println(mundial.agregarPartidosAJugadorEnEquipo(nombreEquipo, partidos, nombreJugador, CANTIDAD_GRUPOS));
			System.out.println(mundial.agregarGolesAJugadorEnEquipo(nombreEquipo, goles, nombreJugador, CANTIDAD_GRUPOS));
			System.out.println(mundial.agregarAsistenciasAJugadorEnEquipo(nombreEquipo, asistencias, nombreJugador, CANTIDAD_GRUPOS));
			System.out.println(mundial.agregarMinutosAJugadorEnEquipo(nombreEquipo, minutos, nombreJugador, CANTIDAD_GRUPOS));
			System.out.println(mundial.getUnJugadorDeEquipo(nombreEquipo, nombreJugador, CANTIDAD_GRUPOS));
			arr=mundial.goleadorPorEquipo("Argentina", CANTIDAD_GRUPOS);
			System.out.println("El goleador es: ");
			for(int i=0; i<2; i++) {
				System.out.println(arr[i]);
			}
			arr=mundial.mejorPorteroPorEquipo("Argentina", CANTIDAD_GRUPOS);
			System.out.println("El mejor portero es: ");
			for(int i=0; i<2; i++) {
				System.out.println(arr[i]);
			}
			System.out.println("El equipo con más campeonatos es: "+mundial.equipoConMasCampeonatos(CANTIDAD_GRUPOS));
			System.out.println("El goleador del torneo fue: ");
			arr=mundial.goleadorDelTorneo(CANTIDAD_GRUPOS);
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			System.out.println("El portero del torneo fue: ");
			arr=mundial.mejorPortero(CANTIDAD_GRUPOS);
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			System.out.println("Equipo campeón: "+mundial.equipoCampeon(CANTIDAD_GRUPOS));
			arr=mundial.goleadorPorEquipo("Argentina", CANTIDAD_GRUPOS);
			System.out.println("El goleador es: ");
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			arr=mundial.mejorPorteroPorEquipo("Ghana", CANTIDAD_GRUPOS);
			System.out.println("El mejor portero es: ");
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			System.out.println("Quedaron en cuartos de final: "+mundial.cualesEquiposSeQuedaronEn("Cuartos de final", CANTIDAD_GRUPOS).toString());
			System.out.println("El jugador con mejor promedio de goles fue: ");
			arr=mundial.jugadorConMejorPromedioDeGoles(CANTIDAD_GRUPOS);
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			System.out.println("El jugador con más asistencias del torneo fue: ");
			arr=mundial.jugadorConMasAsistencias(CANTIDAD_GRUPOS);
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			System.out.println("El jugador con más minutos del torneo fue: ");
			arr=mundial.jugadorConMasMinutos(CANTIDAD_GRUPOS);
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			System.out.println("El equipo con mejor defensiva del torneo fue: ");
			arr=mundial.equipoConMejorDefensiva(CANTIDAD_GRUPOS);
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			System.out.println("El equipo con mejor ofensiva del torneo fue: ");
			arr=mundial.equipoConMejorOfensiva(CANTIDAD_GRUPOS);
			for(int i=0; i<2; i++) {
				System.out.print("\t\t"+arr[i]);
			}
			System.out.println("");
			System.out.println("Jugaron 5 partidos los siguientes jugadores: "+mundial.cualesJugadoresJugaronAlMenosXPartidosEnElTorneo(5, CANTIDAD_GRUPOS));
			System.out.println("El jugador más viejo del torneo es: "+mundial.jugadorMasViejoDelTorneo(CANTIDAD_GRUPOS));
			System.out.println("El jugador más jovén del torneo es: "+mundial.jugadorMasJovenDelTorneo(CANTIDAD_GRUPOS));
			System.out.println(mundial.toString());
			System.out.println(mundial.bajaEquipo("México", CANTIDAD_GRUPOS));
			System.out.println(mundial.toString());
		}
	
		catch(FileNotFoundException fnfe) {
			System.err.println("ERROR        "+fnfe);
			System.exit(-1);
		}
	}
}
