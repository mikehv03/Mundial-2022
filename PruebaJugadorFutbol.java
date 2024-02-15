/* Miguel Herrera
 * abril 2023
 * Clase para probar el jugador de fubtol
 */
public class PruebaJugadorFutbol {

	public static void main(String[] args) {
		JugadorDeFutbol j1, j2, j3;
		
		j1= new JugadorDeFutbol("Lionel Messi", 1987, "Delantero",6,5,2,789, 0);
		System.out.println(j1.toString());
		j1.agregarGoles(2);
		j1.agregarPartidos(1);
		j1.agregarAsistencias(1);
		System.out.println(j1.toString());
		System.out.println("El promedio de goles por partidos es: "+j1.promedioGolesPorPartido());
		System.out.println("El promedio de goles recibidos por partido es: "+j1.promedioGolesRecibidosPorPartido());
		j2=new JugadorDeFutbol("Emiliano Martines", 1992, "Portero", 7, 0, 0, 680, 8);
		j2.agregarMinutos(10);
		System.out.println(j2.toString());
		System.out.println("El promedio de goles recibidos por partido es: "+j2.promedioGolesRecibidosPorPartido());
		j3=new JugadorDeFutbol("Franco Armani", 1986, "Portero",0,0,0,0,0);
		System.out.println("El promedio de goles recibidos por partido es: "+j3.promedioGolesRecibidosPorPartido());
		System.out.println("El promedio de goles por partido es: "+j3.promedioGolesPorPartido());
	}
}
