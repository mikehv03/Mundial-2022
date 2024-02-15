/*Miguel Herrera
 * abril 2023
 * Clase para crear un jugador de fútbol que haya jugado en cualquier mundial. Esta clase va a tener todas las estadísticas del jugador.
 */
public class JugadorDeFutbol {
	private String nombre;
	private int ahoNac;
	private String posicion;
	private int partidos;
	private int goles;
	private int asistencias;
	private int minutos;
	private int golesRecibidos;
	
	//Se pone un constructor con solo el nombre como parámetro, para las búsquedas que se hagan más adelante.
	public JugadorDeFutbol(String nombre) {
		this.nombre=nombre;
	}
	
	public JugadorDeFutbol(String nombre, int ahoNac, String posicion, int partidos, int goles, int asistencias, int minutos, int golesRecibidos) {
		this.nombre = nombre;
		this.ahoNac = ahoNac;
		this.posicion = posicion;
		this.partidos = partidos;
		this.goles = goles;
		this.asistencias = asistencias;
		this.minutos = minutos;
		this.golesRecibidos = golesRecibidos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAhoNac() {
		return ahoNac;
	}
	
	//Función para calcular la edad de un jugador. Se pide como parámetro el año en el que es el torneo.
	public int getEdad(int aho) {
		int edad;
		
		edad=aho-ahoNac;
		return edad;
	}

	public String getPosicion() {
		return posicion;
	}

	public int getPartidos() {
		return partidos;
	}

	public int getGoles() {
		return goles;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getGolesRecibidos() {
		return golesRecibidos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	//En vez de que el usuario tenga que cambiar todas las estadísticas (si el torneo se está jugando en ese momento).
	//Se decidió que en vez de cambiar se agreguen para que el usuario no tenga que hacer las cuentas por fuera.
	//No va a arrojar nada porque se quería hacer parecido a un set.
	public void agregarPartidos(int partidos) {
		this.partidos += partidos;
	}

	public void agregarGoles(int goles) {
		this.goles += goles;
	}

	public void agregarAsistencias(int asistencias) {
		this.asistencias += asistencias;
	}

	public void agregarMinutos(int minutos) {
		this.minutos += minutos;
	}

	public void agregarGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos += golesRecibidos;
	}
	
	//Esta función calcula el promedio de los goles anotados en el torneo y lo divide entre los partidos jugados.
	public double promedioGolesPorPartido() {
		double promedio=0; //Se inicializó el promedio en 0 porque no era necesario poner una bandera de error, debido a que aun así va a haber un jugador con mayores goles que 0.
		
		//La condición se puso para que no salga un error en las clases futuras si el jugador jugo 0 partidos.
		if(partidos>0)
			promedio=(double) goles/partidos;
		return promedio;
	}
	
	//Esta es una función que calcula el promedio de goles recibidos para los porteros.
	public double promedioGolesRecibidosPorPartido() {
		double promedio=-1; //Los porteros son los únicos que van a poder competir por este reconocimiento, por eso si no son porteros se va a poner -1. Esta condición va a servir más adelante. Además, como en un futuro esto va a ser utilizada para comparar a los jugadores con un menor valor de esta función, es necesario poner -1 para que los porteros que no jugaron ningún partido no participen.
		
		if(posicion.equals("Portero")) //Es importante observar que se le va a tener que decir al usuario como escribir portero.
			if(partidos>0)
				promedio=(double)golesRecibidos/partidos;
		return promedio;
	}
	
	public String toString() {
		StringBuilder cad= new StringBuilder();
		
		cad.append("La información del jugador de fútbol es: ");
		cad.append("\n                                 nombre: "+nombre);
		cad.append("\n                      año de nacimiento: "+ahoNac);
		cad.append("\n                         la posición es: "+posicion);
		cad.append("\n                   cantidad de partidos: "+partidos);
		cad.append("\n                      cantidad de goles: "+goles);
		cad.append("\n                cantidad de asistencias: "+asistencias);
		cad.append("\n                    cantidad de minutos: "+minutos);
		cad.append("\n            cantidad de goles recibidos: "+golesRecibidos);
		return cad.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JugadorDeFutbol other = (JugadorDeFutbol) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public int compareTo(JugadorDeFutbol otro) {
		return this.nombre.compareTo(otro.nombre);
	}
}
