/* Miguel Herrera
 * abril 2023
 * Prueba para la clase equipo.
 */
public class PruebaEquipoDeFutbol {

	public static void main(String[] args) {
		Equipo e1;
		
		e1=new Equipo("Argentina", "Scaloni", 2, "Campeón");
		e1.agregarCampeonatos(1);
		System.out.println(e1.toString());
		System.out.println(e1.darDeAltaJugador("Franco Armani", 1986, "Portero",0,0,0,0,0));
		System.out.println(e1.darDeAltaJugador("Geronimo Rullo", 1992, "Portero",0,0,0,0,0));
		System.out.println(e1.darDeAltaJugador("Emiliano Martínez", 1992, "Portero",7,0,0,690,8));
		System.out.println(e1.darDeAltaJugador("Juan Foyth", 1998, "Defensa",1,0,0,4,0));
		System.out.println(e1.darDeAltaJugador("Nicolás Tagliafico", 1992, "Defensa",6,0,0,371,0));
		System.out.println(e1.darDeAltaJugador("Gonzalo Montiel", 1996, "Defensa",4,0,0,118,0));
		System.out.println(e1.darDeAltaJugador("Germán Pezzella", 1991, "Defensa",3,0,0,57,0));
		System.out.println(e1.darDeAltaJugador("Marcos Acuña", 1991, "Defensa",6,0,0,374,0));
		System.out.println(e1.darDeAltaJugador("Cristian Romero", 1998, "Defensa",7,0,0,548,0));
		System.out.println(e1.darDeAltaJugador("Nicolás Otamendi", 1988, "Defensa",7,0,1,690,0));
		System.out.println(e1.darDeAltaJugador("Lisandro Martinez", 1998, "Defensa",5,0,0,301,0));
		System.out.println(e1.darDeAltaJugador("Nahuel Molina", 1998, "Defensa",7,1,1,568,0));
		System.out.println(e1.darDeAltaJugador("Leandro Paredes", 1994, "Mediocampista",5,0,0,224,0));
		System.out.println(e1.darDeAltaJugador("Rodrigo de Paul", 1994, "Mediocampista",7,0,0,602,0));
		System.out.println(e1.darDeAltaJugador("Exequiel Palacios", 1998, "Mediocampista",3,0,0,47,0));
		System.out.println(e1.darDeAltaJugador("Thiago Almada", 2001, "Mediocampista",1,0,0,6,0));
		System.out.println(e1.darDeAltaJugador("Guido Rodriguez", 1994, "Mediocampista",1,0,0,57,0));
		System.out.println(e1.darDeAltaJugador("Alexis MacAllister", 1998, "Mediocampista",6,1,1,555,0));
		System.out.println(e1.darDeAltaJugador("Enzo Fernández", 2001, "Mediocampista",7,1,1,563,0));
		System.out.println(e1.darDeAltaJugador("Ángel Di María", 1988, "Mediocampista",5,1,1,290,0));
		System.out.println(e1.darDeAltaJugador("Julián Alvárez", 2000, "Delantero",7,4,0,602,0));
		System.out.println(e1.darDeAltaJugador("Lionel Messi", 1987, "Delantero",6,5,2,689, 0));
		System.out.println(e1.darDeAltaJugador("Ángel Correa", 1995, "Delantero",1,0,0,4,0));
		System.out.println(e1.darDeAltaJugador("Paulo Dybala", 1993, "Delantero",2,0,0,17,0));
		System.out.println(e1.darDeAltaJugador("Lautaro Martínez", 1994, "Delantero",6,0,0,238,0));
		System.out.println("BAJAAAAAAAAAAAAAAA");
		System.out.println(e1.darDeBajaJugador("Ángel Correa"));
		System.out.println(e1.darDeBajaJugador("Lautaro Martínez"));
		System.out.println("ALTAAAAAAAAAAAAAAA");
		System.out.println(e1.darDeAltaJugador("Lionel Messi", 1987, "Delantero",6,5,2,689, 0));
		System.out.println(e1.darDeAltaJugador("Lautaro Martínez", 1994, "Delantero",6,0,0,238,0));
		System.out.println(e1.getUnJugador("Lionel Messi"));
		System.out.println(e1.getUnJugador("Paulo Dybala"));
		System.out.println(e1.agregarGolesAJugador(2, "Lionel Messi"));
		System.out.println(e1.agregarPartidosAJugador(1, "Lionel Messi"));
		System.out.println(e1.agregarAsistenciasAJugador(1, "Lionel Messi"));
		System.out.println(e1.agregarMinutosAJugador(100, "Lionel Messi"));
		System.out.println(e1.agregarGolesAJugador(2, "Miguel"));
		System.out.println(e1.getUnJugador("Lionel Messi"));
		System.out.println("----------------------------------------------");
		System.out.println("Hay defensas: "+e1.cuantosJugadoresPorPosicion("Defensa"));
		System.out.println("El jugador con más goles es: "+e1.jugadorConMasGoles());
		System.out.println("");
		System.out.println("El jugador con más asistencias es: "+e1.jugadorConMasAsistencias());
		System.out.println("");
		System.out.println("El jugador con más minutos es: "+e1.jugadorConMasMinutos());
		System.out.println("");
		System.out.println("El jugador con mejor promedio de goles es: "+e1.jugadorConMejorPromedioGolesPorPartido());
		System.out.println("");
		System.out.println("El jugador con menor promedio de goles recibidos es: "+e1.jugadorConMenorPromedioDeGolesRecibidos());
		System.out.println("");
		System.out.println("El jugador más joven es: "+e1.jugadorMasJoven(2022));
		System.out.println("El jugador más viejo es: "+e1.jugadorMasViejo(2022));
		System.out.println("El total de goles anotados fue de: "+e1.totalGoles());
		System.out.println("El total de goles recibidos fue de: "+e1.totalGolesRecibidos());
		System.out.println(e1.cualesJugadoresJugaronAlMenosXPartidos(7).toString());
	}
}
