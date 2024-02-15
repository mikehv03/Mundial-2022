import java.util.ArrayList;

/* Miguel Herrera
 * abril 2023
 * Clase que sirve para crear un equipo de fútbol. Esta clase va a contener a todos los jugadores.
 */
public class Equipo {
	private String nombre;
	private String directorTecnico;
	private int campeonatos;
	private String rendimiento;
	private JugadorDeFutbol[] jugadores; //Esta clase contiene un arreglo de jugadorDeFutbol.
	private int cantJugadores; //Este atributo va a servir para las búsquedas.
	private final int MAX_JUGADORES=23; //Hay máximo 23 jugadores por equipo.
	
	//Este constructor se puso para crear el arreglo.
	public Equipo() {
		jugadores=new JugadorDeFutbol[MAX_JUGADORES];
		cantJugadores=0;
	}
	
	//Se pone un constructor con solo el nombre como parámetro, para las búsquedas que se hagan más adelante.
	public Equipo(String nombre) {
		this.nombre=nombre;
	}
	
	public Equipo(String nombre, String directorTecnico, int campeonatos, String rendimiento) {
		this();
		this.nombre=nombre;
		this.directorTecnico=directorTecnico;
		this.campeonatos=campeonatos;
		this.rendimiento=rendimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDirectorTecnico() {
		return directorTecnico;
	}

	public int getCampeonatos() {
		return campeonatos;
	}

	public String getRendimiento() {
		return rendimiento;
	}
	
	public int getCantJugadores() {
		return cantJugadores;
	}

	//Función para obtener la información de cualquier jugador, que este inscrito en el equipo.
	public String getUnJugador(String nombre) {
		String jugador="El jugador no existe en este equipo.";
		int posicion;
		JugadorDeFutbol jugadorBus;
		
		jugadorBus=new JugadorDeFutbol(nombre);
		posicion=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugadorBus);
		if(posicion>=0) //Se pone esta condición porque si el Manejador de arreglos no encuentra lo que busca, arroja -1, por lo cual el jugador no existiría.
			jugador=jugadores[posicion].toString();
		return jugador;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDirectorTecnico(String directorTecnico) {
		this.directorTecnico = directorTecnico;
	}

	public void setRendimiento(String rendimiento) {
		this.rendimiento = rendimiento;
	}
	
	//Suma los campeonatos conseguidos en vez de solo cambiarlos. Esto sirve por si acabo el torneo que solo sumen uno al campeón.
	public void agregarCampeonatos(int campeonatos) {
		this.campeonatos += campeonatos;
	}

	//Dar de alta un jugador en el equipo.
	public boolean darDeAltaJugador(String nombre, int ahoNac, String posicion, int partidos, int goles, int asistencias, int minutos, int golesRecibidos) {
		boolean res;
		int posicionExistente, n;
		JugadorDeFutbol jugador;
		
		//No se van a permitir repetidos, por eso primero se busca si el jugador existe
		jugador=new JugadorDeFutbol(nombre, ahoNac, posicion, partidos, goles, asistencias, minutos, golesRecibidos);
		posicionExistente=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugador);
		n=cantJugadores;
		if(posicionExistente<0) //Esto significa que el jugador no existe.
			cantJugadores=ManejadorArregloGenerico.insertaAlFinal(jugadores, cantJugadores, jugador);
		if(n<cantJugadores) //Debido a que insertaAlFinal solo arroja si la cantidad de jugadores aumento o se mantuvo igual, se puso esta condición.
			res=true;
		else
			res=false;
		return res;
	}
	
	//Dar de baja un jugador.
	public boolean darDeBajaJugador(String nombre) {
		boolean res;
		int n;
		JugadorDeFutbol jugador;
		
		jugador= new JugadorDeFutbol(nombre);
		n=cantJugadores;
		cantJugadores=ManejadorArregloGenerico.eliminaEnDes(jugadores, cantJugadores, jugador); //Primero se busca y por la misma razón que la función anterior se pone esa la siguiente condición.
		if(n>cantJugadores)
			res=true;
		else
			res=false;
		return res;
	}
	
	//Los siguientes métodos son para agregar estadísticas
	//Se va a regresar un boolean para que el usuario sepa si se logró.
	public boolean agregarPartidosAJugador(int partidos, String nombre) {
		boolean res=false;
		int posicion, partidosAnteriores;
		JugadorDeFutbol jugador;
	
		jugador=new JugadorDeFutbol(nombre);
		posicion=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugador);
		if(posicion>=0) {
			partidosAnteriores=jugadores[posicion].getGoles();
			jugadores[posicion].agregarPartidos(partidos);
			if(partidosAnteriores!=jugadores[posicion].getPartidos()) //Se pone esta condición para ver si sí cambiaron las estadísticas. Se usa diferente porque si ponen -1 los partidos disminuyen, por lo que no se sabe bien si el usuario va a aumentar o disminuir una estadística.
				res=true;
		}
		return res;
	}
	
	public boolean agregarGolesAJugador(int goles, String nombre) {
		boolean res=false;
		int posicion, golesAnteriores;
		JugadorDeFutbol jugador;
		
		jugador=new JugadorDeFutbol(nombre);
		posicion=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugador);
		if(posicion>=0) {
			golesAnteriores=jugadores[posicion].getGoles();
			jugadores[posicion].agregarGoles(goles);
			if(golesAnteriores!=jugadores[posicion].getGoles())
				res=true;
		}
		return res;
	}

	public boolean agregarAsistenciasAJugador(int asistencias, String nombre) {
		boolean res=false;
		int posicion, asistenciasAnteriores;
		JugadorDeFutbol jugador;
		
		jugador=new JugadorDeFutbol(nombre);
		posicion=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugador);
		if(posicion>=0) {
			asistenciasAnteriores=jugadores[posicion].getAsistencias();
			jugadores[posicion].agregarAsistencias(asistencias);
			if(asistenciasAnteriores!=jugadores[posicion].getAsistencias())
				res=true;
		}
		return res;
	}

	public boolean agregarMinutosAJugador(int minutos, String nombre) {
		boolean res=false;
		int posicion, minutosAnteriores;
		JugadorDeFutbol jugador;
	
		jugador=new JugadorDeFutbol(nombre);
		posicion=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugador);
		if(posicion>=0) {
			minutosAnteriores=jugadores[posicion].getMinutos();
			jugadores[posicion].agregarMinutos(minutos);
			if(minutosAnteriores!=jugadores[posicion].getMinutos())
				res=true;
		}
		return res;
	}
	
	public boolean agregarGolesRecibidosAJugador(int golesRecibidos, String nombre) {
		boolean res=false;
		int posicion, golesRecibidosAnteriores;
		JugadorDeFutbol jugador;
		
		jugador=new JugadorDeFutbol(nombre);
		posicion=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugador);
		if(posicion>=0) {
			golesRecibidosAnteriores=jugadores[posicion].getGolesRecibidos();
			jugadores[posicion].agregarGolesRecibidos(golesRecibidos);
			if(golesRecibidosAnteriores!=jugadores[posicion].getGolesRecibidos())
				res=true;
		}
		return res;
	}
	
	//Sirve para saber la cantidad de jugadores que llevó un equipo por posición.
	public int cuantosJugadoresPorPosicion(String posicion) {
		int contador=0;
		
		for(int i=0; i<cantJugadores; i++) {
			if(jugadores[i].getPosicion().equals(posicion))
				contador++;
		}
		return contador;
	}
	
	//Se va a crear una lista de los jugadores que jugaron cierta cantidad de partidos.
	public ArrayList<String> cualesJugadoresJugaronAlMenosXPartidos(int partidos) {
		ArrayList<String> jugadoresPartidos= new ArrayList<String>();
		String jugador;
		
		for(int i=0; i<cantJugadores; i++) {
			if(jugadores[i].getPartidos()>=partidos) {
				jugador=jugadores[i].getNombre();
				jugadoresPartidos.add(jugador);
			}
		}
		return jugadoresPartidos;
	} 
	
	//Sirve para saber quien fue el jugador que tuvo las mejores estadísticas. (Cabe recalcar que no es en general sino por estadísticas).
	public String jugadorConMasGoles() {
		int posMax=0;
		String goleador;
		
		for(int i=1; i<cantJugadores; i++) { //El ciclo empieza desde 1, porque se asigno el máximo desde el principio.
			if(jugadores[i].getGoles()>jugadores[posMax].getGoles())
				posMax=i;
		}
		goleador=jugadores[posMax].getNombre();
		return goleador;
	}
	
	//Esto va a servir para que en un futuro se puedan comparar la cantidad de goles anotados entre todos los jugadores. 
	//Esto va a suceder con todas las estadísticas.
	public int golesDeUnJugador(String nombre) {
		JugadorDeFutbol jugadorBuscado;
		int goles=-1, pos; //Se pone una respuesta negativa para indicar que el jugador no existe.
		
		jugadorBuscado=new JugadorDeFutbol(nombre);
		pos=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugadorBuscado);
		if(pos>=0)
			goles=jugadores[pos].getGoles();
		return goles;
	}
	
	public String jugadorConMasAsistencias() {
		int posMax=0;
		String jugadorConMasAsistencias;
		
		for(int i=1; i<cantJugadores; i++) {
			if(jugadores[i].getAsistencias()>jugadores[posMax].getAsistencias())
				posMax=i;
		}
		jugadorConMasAsistencias=jugadores[posMax].getNombre();
		return jugadorConMasAsistencias;
	}
	
	public int asistenciasDeUnJugador(String nombre) {
		JugadorDeFutbol jugadorBuscado;
		int asistencias=-1, pos;
		
		jugadorBuscado=new JugadorDeFutbol(nombre);
		pos=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugadorBuscado);
		if(pos>=0)
			asistencias=jugadores[pos].getAsistencias();
		return asistencias;
	}
	
	public String jugadorConMasMinutos() {
		int posMax=0;
		String jugadorMasMinutos;
		
		for(int i=1; i<cantJugadores; i++) {
			if(jugadores[i].getMinutos()>jugadores[posMax].getMinutos()) 
				posMax=i;
		}
		jugadorMasMinutos=jugadores[posMax].getNombre();
		return jugadorMasMinutos;
	}
	
	public int minutosDeUnJugador(String nombre) {
		JugadorDeFutbol jugadorBuscado;
		int minutos=-1, pos;
		
		jugadorBuscado=new JugadorDeFutbol(nombre);
		pos=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugadorBuscado);
		if(pos>=0)
			minutos=jugadores[pos].getMinutos();
		return minutos;
	}
	
	public String jugadorConMejorPromedioGolesPorPartido() {
		int posMax=0;
		String jugadorMejorPromGoles;
		
		for(int i=1; i<cantJugadores; i++) {
			if(jugadores[i].promedioGolesPorPartido()>jugadores[posMax].promedioGolesPorPartido())
				posMax=i;
		}
		jugadorMejorPromGoles=jugadores[posMax].getNombre();
		return jugadorMejorPromGoles;
	}
	
	public double promedioGolesPorPartidoDeUnJugador(String nombre) {
		JugadorDeFutbol jugadorBuscado;
		int pos;
		double golesPorPartido=-1;
		
		jugadorBuscado=new JugadorDeFutbol(nombre);
		pos=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugadorBuscado);
		if(pos>=0)
			golesPorPartido=jugadores[pos].promedioGolesPorPartido();
		return golesPorPartido;
	}
	
	//Como se mencionó en la clase JugadorDeFutbol, solo van a poder participar porteros y jugadores que jugaron al menos un partido. Por eso la condición es >=0, ya que si no jugaron o no son porteros la función arrojan un "-1.
	public String jugadorConMenorPromedioDeGolesRecibidos(){
		int posMin=-1; //Se instanció posMin en "-1", debido a que como no todos son porteros no se puede empezar desde 0.
		boolean primerPortero=true; //Se puso una bandera porque los jugadores pueden estar desordenados por posición. Por eso cuando se encuentre al primer portero ese va a ser el que tenga las mejores estadísticas. 
		String mejorPortero;
		
		for(int i=0; i<cantJugadores; i++) {
			if(jugadores[i].promedioGolesRecibidosPorPartido()>=0) { //Esta condición sirve para que se cumplan todas las condiciones necesarias para participar, es decir, que sea portero y que tengan más de 1 partido.
				if(primerPortero) {
					posMin=i;
					primerPortero=false;
				}
				else {
					if(jugadores[i].promedioGolesRecibidosPorPartido()<jugadores[posMin].promedioGolesRecibidosPorPartido())
						posMin=i;
				}
			}
		}
		if(posMin>=0) //Como la posición mínima empieza en "-1", si no hubieron jugadores con las condiciones necesarias, no se va a entrar a esta condición.
			mejorPortero=jugadores[posMin].getNombre();
		else 
			mejorPortero="No hay porteros";
		return mejorPortero;
	}
	
	public double promedioGolesRecibidosPorPartidoDeUnJugador(String nombre) {
		JugadorDeFutbol jugadorBuscado;
		int pos;
		double golesRecibidosPorPartido=-1;
		
		jugadorBuscado=new JugadorDeFutbol(nombre);
		pos=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugadorBuscado);
		if(pos>=0)
			golesRecibidosPorPartido=jugadores[pos].promedioGolesRecibidosPorPartido();
		return golesRecibidosPorPartido;
	}
	
	//Jugador que jugó el torneo siendo el que tenía menor edad.
	public String jugadorMasJoven(int aho) {
		String jugador;
		int posMin=0;
		
		for(int i=1; i<cantJugadores; i++) {
			if(jugadores[i].getEdad(aho)<jugadores[posMin].getEdad(aho))
				posMin=i;
		}
		jugador=jugadores[posMin].getNombre();
		return jugador;
	}
	
	//Jugador que jugó el torneo siendo el que tenía mayor edad.
	public String jugadorMasViejo(int aho) {
		String jugador;
		int posMax=0;
		
		for(int i=1; i<cantJugadores; i++) {
			if(jugadores[i].getEdad(aho)>jugadores[posMax].getEdad(aho))
				posMax=i;
		}
		jugador=jugadores[posMax].getNombre();
		return jugador;
	}
	
	//Se necesita esta función para que en un futuro se puedan comparar las edades de los jugadores
	public int edadJugador(String nombre, int aho) {
		JugadorDeFutbol jugadorBuscado;
		int pos, edad=-1;
		
		jugadorBuscado=new JugadorDeFutbol(nombre);
		pos=ManejadorArregloGenerico.busSecDes(jugadores, cantJugadores, jugadorBuscado);
		if(pos>=0) {
			edad=jugadores[pos].getEdad(aho);
		}
		return edad;
	}
	
	//Función que sirve para sumar todos los goles anotados y recibidos de todos los jugadores del equipo. Ayuda a saber cuál fue el rendimiento en general del equipo.
	public int totalGoles() {
		int goles=0;
		
		for(int i=0; i<cantJugadores; i++){
			goles+=jugadores[i].getGoles();
		}
		return goles;
	}
	
	public int totalGolesRecibidos() {
		int golesRec=0;
		
		for(int i=0; i<cantJugadores; i++) {
			golesRec+=jugadores[i].getGolesRecibidos();
		}
		return golesRec;
	}
	
	public String toString() {
		StringBuilder cad= new StringBuilder();
		
		cad.append("La información del equipo es: ");
		cad.append("\n                      nombre: "+nombre);
		cad.append("\n            director técnico: "+directorTecnico);
		cad.append("\n       número de campeonatos: "+campeonatos);
		cad.append("\n              llegaron hasta: "+rendimiento);
		cad.append("\n           los jugadores son: ");
		for(int i=0; i<cantJugadores; i++) {
			cad.append("\n"+jugadores[i].toString());
			cad.append("\n");
		}
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
		Equipo other = (Equipo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public int compareTo(Equipo otro) {
		return this.nombre.compareTo(otro.nombre);
	}
}
