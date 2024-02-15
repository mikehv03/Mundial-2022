import java.util.ArrayList;

/* Miguel Herrera
 * abril 2023
 * Clase para crear un torneo de fútbol con equipos. El torneo tiene que tener 8 grupos, si no no funciona
 */
public class TorneoDeFutbol{
	private String nombre;
	private int aho;
	private String sede;
	private Equipo[][]equipos; //Es una matriz que tiene todos los equipos.
	private final int MAX_EQUIPOS_EN_GRUPO=4; //Se va a aceptar un máximo de 4 equipos por grupo.
	private final int MAX_GRUPOS=16; //Se va a aceptar que se haga un torneo de máximo 16 grupos. Es importante mencionar que el usuario va a tener que dar como parámetro para todas las funciones la cantidad de grupos en su torneo.
	//Lo anterior se hizo para que este programa pueda ser utilizado en más torneos y no solo en uno de 8 grupos (los que tiene el mundial).
	private final Character[] GRUPOS= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'};//Este es un arreglo paralelo a la matriz. La cual va a indicar el grupo de los equipos.
	private final int[] LUGAR_DEL_GRUPO= {1,2,3,4};
	private int []cantEquipos; //Es necesario poner la cantidad de equipos por si un usuario quiere hacer un torneo con menos de 4 equipos.
	
	public TorneoDeFutbol(String nombre, int aho, String sede) {
		this.nombre=nombre;
		this.aho=aho;
		this.sede=sede;
		cantEquipos=new int[MAX_GRUPOS]; //Es necesario instanciar la cantidad de equipos con 0 en todos los lugares.
		for(int i=0; i<MAX_GRUPOS; i++) {
			cantEquipos[i]=0;
		}
		equipos=new Equipo[MAX_GRUPOS][MAX_EQUIPOS_EN_GRUPO];
	}

	public String getNombre() {
		return nombre;
	}

	public int getAho() {
		return aho;
	}

	public String getSede() {
		return sede;
	}
	
	//Conseguir la información de un equipo.
	//Como se logra observar en la siguiente función, va a ser imposible hacer una búsqueda con el Manejador de matrices porque cada grupo puede tener una cantidad de equipos diferentes, y la cantidad disponible de grupos no está completa, es decir, se pueden utilizar 8 grupos en vez de 16. Por lo cual no se le podría entregar una matriz completa al manejador de matrices y esto arrojaría un error. 
	//Además, de esta forma también se va a lograr que el usuario no tenga que poner muchos parámetros. Es importante recalcar que por esto, no se va a utilizar busqueda de matrices en ninguna función.
	public String getUnEquipo(String nombreEquipo, int cantGrupos) {
		String res="No existe este equipo";
		Equipo equipoBuscado;
		int j=0, pos;
		boolean encontrado=false;
		
		
		while(j<cantGrupos && !encontrado) {
			equipoBuscado=new Equipo(nombreEquipo);
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0) {
				res=equipos[j][pos].toString();
				encontrado=true;
			}
			else
				j++;
		}
		return res;
	}
	
	//Conseguir la información del jugador de un equipo
	//Se va a usar una bandera de equipo encontrado para que no se tengan que poner dos condiciones dentro el if.
	//De esta forma va a ser más fácil leer el programa. 
	//Aun así con la bandera ya se está obligando a que se cumplan ambas condiciones, es decir, que la fila y la columna de la matriz existan y que se pueda trabajar con ellas.
	//Esto se va a repetir en otras funciones.
	public String getUnJugadorDeEquipo(String nombreEquipo, String nombreJugador, int cantGrupos) {
		String res;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		boolean encontradoEquipo=false;

		equipoBuscado= new Equipo(nombreEquipo);
		while(j<cantGrupos && !encontradoEquipo) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				encontradoEquipo=true;
			else
				j++;
		}
		if(encontradoEquipo)
			res=equipos[j][pos].getUnJugador(nombreJugador);
		else
			res="Equipo no registrado. Por lo tanto el jugador no existe.";
		return res;
	}

	//Conseguir los campeonatos de un equipo.
	public int getCampeonatosEquipo(String nombreEquipo, int cantGrupos){
		int res;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado)
			res=equipos[j][pos].getCampeonatos();
		else
			res=-1;
		return res;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAho(int aho) {
		this.aho = aho;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	
	//Primero se va a buscar el grupo escogido, por eso se puso un arreglo paralelo
	//Si el grupo existe, se va a dar de alta el equipo en ese grupo (si cabe y no se repite).
	public boolean altaEquipo(String nombre, String directorTecnico, int campeonatos, String rendimiento, char grupo, int cantGrupos) {
		boolean res=false, encontrado=false;
		int grupoEscogido, posicionEquipoExistente, n, j=0;
		Equipo equipoAgregado;
		
		
		grupoEscogido=ManejadorArregloGenerico.busSecOrd(GRUPOS, MAX_GRUPOS, grupo);
		equipoAgregado=new Equipo(nombre, directorTecnico, campeonatos, rendimiento);
		//No se van a permitir altas de equipos repetidos.
		while(j<cantGrupos &&!encontrado) {
			posicionEquipoExistente=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoAgregado);
			if(posicionEquipoExistente>=0)
				encontrado=true;
			else 
				j++;
		}
		if (grupoEscogido>=0 && !encontrado) {
			n=cantEquipos[grupoEscogido];
			cantEquipos[grupoEscogido]=ManejadorArregloGenerico.insertaAlFinal(equipos[grupoEscogido], cantEquipos[grupoEscogido], equipoAgregado);
			if(cantEquipos[grupoEscogido]>n) //El manejador de arreglos no regresa un boolean, por eso se pone la condición al final y se observa si en realidad si aumento el número de equipos.
				res=true;
		}
		return res;	
	}
	
	//Dar de baja un equipo.
	public boolean bajaEquipo(String nombre, int cantGrupos) {
		Equipo equipo;
		boolean encontrado=false;
		int j=0, n;
		
		equipo=new Equipo(nombre);
		while(j<cantGrupos &&!encontrado) {
			n=cantEquipos[j];
			cantEquipos[j]=ManejadorArregloGenerico.eliminaEnDes(equipos[j], cantEquipos[j], equipo);
			if(cantEquipos[j]<n)
				encontrado=true;
			else 
				j++;
		}
		return encontrado;
	}
	
	//Dar de alta un jugador en un equipo en específico.
	public boolean altaJugadorEnEquipo(String nombreEquipo, String nombre, int ahoNac, String posicion, int partidos, int goles, int asistencias, int minutos, int golesRecibidos, int cantGrupos) {
		boolean res=false;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado) {
			res=equipos[j][pos].darDeAltaJugador(nombre, ahoNac, posicion, partidos, goles, asistencias, minutos, golesRecibidos);
		}
		return res;
	}
	
	public boolean darDeBajaJugadorEnEquipo(String nombreEquipo, String nombre, int cantGrupos) {
		boolean res=false;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado)
			res=equipos[j][pos].darDeBajaJugador(nombre);
		return res;
	}
	
	//Para agregar campeonatos a un equipo se usa la misma lógica que se utilizó para cambiar las estadísticas de un jugador.
	public boolean agregarCampeonatosAEquipo(String nombreEquipo, int campeonatos, int cantGrupos) {
		boolean res=false;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1, campeonatosAnteriores;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado) {
			campeonatosAnteriores=equipos[j][pos].getCampeonatos();
			equipos[j][pos].agregarCampeonatos(campeonatos);
			if(campeonatosAnteriores!=equipos[j][pos].getCampeonatos())
				res=true;
		}
		return res;
	}
	
	//Permitir modificar ciertas estadísticas de los jugadores en un equipo determinado.
	public boolean agregarPartidosAJugadorEnEquipo(String nombreEquipo, int partidos, String nombreJugador, int cantGrupos) {
		boolean res=false;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado)
			res=equipos[j][pos].agregarPartidosAJugador(partidos, nombreJugador);
		return res;
	}
	
	public boolean agregarGolesAJugadorEnEquipo(String nombreEquipo, int goles, String nombreJugador, int cantGrupos) {
		boolean res=false;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado)
			res=equipos[j][pos].agregarGolesAJugador(goles, nombreJugador);
		return res;
	}
	
	public boolean agregarAsistenciasAJugadorEnEquipo(String nombreEquipo, int asistencias, String nombreJugador, int cantGrupos) {
		boolean res=false;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado)
			res=equipos[j][pos].agregarAsistenciasAJugador(asistencias, nombreJugador);
		return res;
	}
	
	public boolean agregarMinutosAJugadorEnEquipo(String nombreEquipo, int minutos, String nombreJugador, int cantGrupos) {
		boolean res=false;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado)
			res=equipos[j][pos].agregarMinutosAJugador(minutos, nombreJugador);
		return res;
	}
	
	public boolean agregarGolesRecibidosAJugadorEnEquipo(String nombreEquipo, int golesRecibidos, String nombreJugador, int cantGrupos) {
		boolean res=false;
		boolean equipoEncontrado=false;
		Equipo equipoBuscado;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado) 
			res=equipos[j][pos].agregarGolesRecibidosAJugador(golesRecibidos, nombreJugador);
		return res;
	}
	
	//El jugador que anoto más goles en el torneo.
	//Se puso como un arreglo en vez de un StringBuilder para que se vea más ordenado, pero es una función que podría funcionar de las dos formas.
	//Además, ya que sirven de la misma forma a mi me gusta trabajar más con arreglos.
	//Es importante observar que en las siguientes funciones se observa que gracias a que se puede obtener las estadísticas de un jugador, se pueden comparar entre los jugadores. Si no se pusiera esa función no se podrían comparar
	public String[] goleadorDelTorneo(int cantGrupos) {
		int posRenglonMax, posColumnaMax;
		String goleadorEquipo, goleadorTorneo;
		String[] estadisticasGoleador= new String[2]; //En todos las funciones se puso que el arreglo tenga máximo 2 celdas porque solo se van a utilizar esas dos.
		
		posRenglonMax=0;
		posColumnaMax=0;
		goleadorTorneo=equipos[posRenglonMax][posColumnaMax].jugadorConMasGoles();
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				goleadorEquipo=equipos[j][i].jugadorConMasGoles();
				//Se comparan los mejores jugadores de cada equipo, debido a que como ya tenemos a los mejores jugadores de cada equipo, si estos se comparan se obtiene el mejor jugador del torneo.
				if(equipos[j][i].golesDeUnJugador(goleadorEquipo)>equipos[posRenglonMax][posColumnaMax].golesDeUnJugador(goleadorTorneo)) {
					posRenglonMax=j;
					posColumnaMax=i;
					goleadorTorneo=goleadorEquipo; //Es necesario ir cambiando el nombre porque las funciones de obtener ciertos goles piden como parámetro el nombre del jugador.
				}	
			}
		}
		estadisticasGoleador[0]=goleadorTorneo;
		estadisticasGoleador[1]=", anotó "+equipos[posRenglonMax][posColumnaMax].golesDeUnJugador(goleadorTorneo)+" goles";
		return estadisticasGoleador;
	}
	
	//Mejor portero, es el que tuvo mejor promedio de goles recibidos.
	public String[] mejorPortero(int cantGrupos) {
		int posRenglonMax, posColumnaMax;
		String mejorPorteroEquipo, mejorPorteroTorneo;
		String[] estadisticasPorteroDelTorneo= new String[2];
		
		posRenglonMax=0;
		posColumnaMax=0;
		mejorPorteroTorneo=equipos[posRenglonMax][posColumnaMax].jugadorConMenorPromedioDeGolesRecibidos();
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				mejorPorteroEquipo=equipos[j][i].jugadorConMenorPromedioDeGolesRecibidos();
				if(equipos[j][i].promedioGolesRecibidosPorPartidoDeUnJugador(mejorPorteroEquipo)<equipos[posRenglonMax][posColumnaMax].promedioGolesRecibidosPorPartidoDeUnJugador(mejorPorteroTorneo)) {
					posRenglonMax=j;
					posColumnaMax=i;
					mejorPorteroTorneo=mejorPorteroEquipo;
				}	
			}
		}
		estadisticasPorteroDelTorneo[0]=mejorPorteroTorneo;
		estadisticasPorteroDelTorneo[1]=", recibió en promedio "+equipos[posRenglonMax][posColumnaMax].promedioGolesRecibidosPorPartidoDeUnJugador(mejorPorteroTorneo)+" goles por partido";
		return estadisticasPorteroDelTorneo;
	}
	
	public String[]jugadorConMejorPromedioDeGoles(int cantGrupos){
		int posRenglonMax, posColumnaMax;
		String mejorPromedioGolesEquipo, mejorPromedioGolesTorneo;
		String[] estadisticasGoleadorPromedio= new String[2];
		
		posRenglonMax=0;
		posColumnaMax=0;
		mejorPromedioGolesTorneo=equipos[posRenglonMax][posColumnaMax].jugadorConMejorPromedioGolesPorPartido();
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				mejorPromedioGolesEquipo=equipos[j][i].jugadorConMejorPromedioGolesPorPartido();
				if(equipos[j][i].promedioGolesPorPartidoDeUnJugador(mejorPromedioGolesEquipo)>equipos[posRenglonMax][posColumnaMax].promedioGolesPorPartidoDeUnJugador(mejorPromedioGolesTorneo)) {
					posRenglonMax=j;
					posColumnaMax=i;
					mejorPromedioGolesTorneo=mejorPromedioGolesEquipo;
				}	
			}
		}
		estadisticasGoleadorPromedio[0]=mejorPromedioGolesTorneo;
		estadisticasGoleadorPromedio[1]=", anotó en promedio "+equipos[posRenglonMax][posColumnaMax].promedioGolesPorPartidoDeUnJugador(mejorPromedioGolesTorneo)+" goles por partido";
		return estadisticasGoleadorPromedio;
	}
	
	public String[]jugadorConMasAsistencias(int cantGrupos){
		int posRenglonMax, posColumnaMax;
		String jugadorMasAsistenciasEquipo, jugadorMasAsistenciasTorneo;
		String[] estadisticasAsistencias= new String[2];
		
		posRenglonMax=0;
		posColumnaMax=0;
		jugadorMasAsistenciasTorneo=equipos[posRenglonMax][posColumnaMax].jugadorConMasAsistencias();
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				jugadorMasAsistenciasEquipo=equipos[j][i].jugadorConMasAsistencias();
				if(equipos[j][i].asistenciasDeUnJugador(jugadorMasAsistenciasEquipo)>equipos[posRenglonMax][posColumnaMax].asistenciasDeUnJugador(jugadorMasAsistenciasTorneo)) {
					posRenglonMax=j;
					posColumnaMax=i;
					jugadorMasAsistenciasTorneo=jugadorMasAsistenciasEquipo;
				}	
			}
		}
		estadisticasAsistencias[0]=jugadorMasAsistenciasTorneo;
		estadisticasAsistencias[1]=", asistió en "+equipos[posRenglonMax][posColumnaMax].asistenciasDeUnJugador(jugadorMasAsistenciasTorneo)+" goles";
		return estadisticasAsistencias;
	}
	
	public String equipoConMasCampeonatos(int cantGrupos) {
		String equipoMasCampeonatos;
		int renglonMax, columnaMax;
		
		renglonMax=0;
		columnaMax=0;
		for(int j=0; j<cantGrupos; j++) {
			for(int i=0; i<cantEquipos[j]; i++) {
				if(equipos[j][i].getCampeonatos()>equipos[renglonMax][columnaMax].getCampeonatos()) {
					renglonMax=j;
					columnaMax=i;
				}
			}
		}
		equipoMasCampeonatos=equipos[renglonMax][columnaMax].getNombre();
		return equipoMasCampeonatos;
	}
	
	public String jugadorMasViejoDelTorneo(int cantGrupos) {
		int posRenglonMax, posColumnaMax;
		String jugadorMasViejoTorneo, jugadorMasViejoEquipo;
		
		posRenglonMax=0;
		posColumnaMax=0;
		jugadorMasViejoTorneo=equipos[posRenglonMax][posColumnaMax].jugadorMasViejo(aho);
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				jugadorMasViejoEquipo=equipos[j][i].jugadorMasViejo(aho); //Se toma el atributo aho, porque es importante el año en el cual se realizó el torneo.
				if(equipos[j][i].edadJugador(jugadorMasViejoEquipo, aho)>equipos[posRenglonMax][posColumnaMax].edadJugador(jugadorMasViejoTorneo, aho)) {
					posRenglonMax=j;
					posColumnaMax=i;
					jugadorMasViejoTorneo=jugadorMasViejoEquipo;
				}	
			}
		}
		return jugadorMasViejoTorneo;
	}
	
	public String jugadorMasJovenDelTorneo(int cantGrupos) {
		int posRenglonMax, posColumnaMax;
		String jugadorMasJovenTorneo, jugadorMasJovenEquipo;
		
		posRenglonMax=0;
		posColumnaMax=0;
		jugadorMasJovenTorneo=equipos[posRenglonMax][posColumnaMax].jugadorMasJoven(aho);
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				jugadorMasJovenEquipo=equipos[j][i].jugadorConMasAsistencias();
				if(equipos[j][i].edadJugador(jugadorMasJovenEquipo, aho)<equipos[posRenglonMax][posColumnaMax].edadJugador(jugadorMasJovenTorneo, aho)) {
					posRenglonMax=j;
					posColumnaMax=i;
					jugadorMasJovenTorneo=jugadorMasJovenEquipo;
				}	
			}
		}
		return jugadorMasJovenTorneo;
	}
	
	public String[] jugadorConMasMinutos(int cantGrupos) {
		int posRenglonMax, posColumnaMax;
		String jugadorMasMinutosEquipo, jugadorMasMinutosTorneo;
		String[] estadisticasGoleador= new String[2];
		
		posRenglonMax=0;
		posColumnaMax=0;
		jugadorMasMinutosTorneo=equipos[posRenglonMax][posColumnaMax].jugadorConMasMinutos();
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				jugadorMasMinutosEquipo=equipos[j][i].jugadorConMasAsistencias();
				if(equipos[j][i].minutosDeUnJugador(jugadorMasMinutosEquipo)>equipos[posRenglonMax][posColumnaMax].minutosDeUnJugador(jugadorMasMinutosTorneo)) {
					posRenglonMax=j;
					posColumnaMax=i;
					jugadorMasMinutosTorneo=jugadorMasMinutosEquipo;
				}	
			}
		}
		estadisticasGoleador[0]=jugadorMasMinutosTorneo;
		estadisticasGoleador[1]=", jugó un total de "+equipos[posRenglonMax][posColumnaMax].minutosDeUnJugador(jugadorMasMinutosTorneo)+" minutos.";
		return estadisticasGoleador;
	}
	
	//Esta función arroja los nombres de los equipos que se quedaron en una instancia del torneo, es decir, fase de grupos, octavos, ...
	public ArrayList<String> cualesEquiposSeQuedaronEn(String rendimiento, int cantGrupos){
		ArrayList<String> resp= new ArrayList<String>();
		
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				if(equipos[j][i].getRendimiento().equals(rendimiento))
					resp.add(equipos[j][i].getNombre());
			}
		}
		return resp;
	}
	
	//Es una función que va a buscar al equipo que quedó campeón
	public String equipoCampeon(int cantGrupos) {
		String campeon="Todavía no hay un equipo campeón";
		int j, i;
		boolean encontrado=false;
		
		j=0;
		while (j<cantGrupos && !encontrado) {
			i=0;
			while(i<cantEquipos[j] && !encontrado) {
				if(equipos[j][i].getRendimiento().equals("Campeón")) {
					encontrado=true;
					campeon=equipos[j][i].getNombre();
				}
				else
					i++;
			}
			j++;
		}
		return campeon;
	}
	
	//Las siguientes son funciones que sirven para observar que equipo tuvo un mejor rendimiento independientemente de que equipo es campeón.
	public String[] equipoConMejorDefensiva(int cantGrupos) {
		int posRenglonMin, posColumnaMin;
		String[]mejorDefensiva=new String[2];
		
		posRenglonMin=0;
		posColumnaMin=0;
		for(int j=0; j<cantGrupos; j++) {
			for(int i=0; i<cantEquipos[j]; i++) {
				if(equipos[j][i].totalGolesRecibidos()<equipos[posRenglonMin][posColumnaMin].totalGolesRecibidos()) {
					posRenglonMin=j;
					posColumnaMin=i;
				}
			}
		}
		mejorDefensiva[0]=equipos[posRenglonMin][posColumnaMin].getNombre();
		mejorDefensiva[1]=", concedieron "+equipos[posRenglonMin][posColumnaMin].totalGolesRecibidos()+" goles.";
		return mejorDefensiva;
	}
	
	public String[] equipoConMejorOfensiva(int cantGrupos) {
		int posRenglonMax, posColumnaMax;
		String[]mejorOfensiva=new String[2];
		
		posRenglonMax=0;
		posColumnaMax=0;
		for(int j=0; j<cantGrupos; j++) {
			for(int i=0; i<cantEquipos[j]; i++) {
				if(equipos[j][i].totalGoles()>equipos[posRenglonMax][posColumnaMax].totalGoles()) {
					posRenglonMax=j;
					posColumnaMax=i;
				}
			}
		}
		mejorOfensiva[0]=equipos[posRenglonMax][posColumnaMax].getNombre();
		mejorOfensiva[1]=", anotaron "+equipos[posRenglonMax][posColumnaMax].totalGoles()+" goles.";
		return mejorOfensiva;
	}
	
	//Función que sirve para obtener las estadísticas por equipo.
	public String[] goleadorPorEquipo(String nombreEquipo, int cantGrupos) {
		String[] goleador= new String[2];
		String nombreGoleador;
		Equipo equipoBuscado;
		boolean equipoEncontrado=false;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado) {
			nombreGoleador=equipos[j][pos].jugadorConMasGoles();
			goleador[0]=nombreGoleador;
			goleador[1]=", anotó "+equipos[j][pos].golesDeUnJugador(nombreGoleador)+" goles";
		}
		return goleador;
	}
	
	public String[] mejorPorteroPorEquipo(String nombreEquipo, int cantGrupos) {
		String[] portero= new String[2];
		String nombrePortero;
		Equipo equipoBuscado;
		boolean equipoEncontrado=false;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado) {
			nombrePortero=equipos[j][pos].jugadorConMenorPromedioDeGolesRecibidos();
			portero[0]=nombrePortero;
			portero[1]=", recibió "+equipos[j][pos].promedioGolesRecibidosPorPartidoDeUnJugador(nombrePortero)+" goles.";
		}
		return portero;
	}
	
	//Función que te da la cantidad de jugadores que fueron registrados por posición por equipo.
	public String cantidadDeJugadoresPorPosicionPorEquipo(String nombreEquipo, String posicion, int cantGrupos) {
		String cantidadJugadores= "No existe el equipo";
		Equipo equipoBuscado;
		boolean equipoEncontrado=false;
		int j=0, pos=-1;
		
		equipoBuscado=new Equipo(nombreEquipo);
		while(j<cantGrupos && !equipoEncontrado) {
			pos=ManejadorArregloGenerico.busSecDes(equipos[j], cantEquipos[j], equipoBuscado);
			if(pos>=0)
				equipoEncontrado=true;
			else
				j++;
		}
		if(equipoEncontrado) {
			cantidadJugadores="Convocaron un total de "+equipos[j][pos].cuantosJugadoresPorPosicion(posicion)+" "+posicion;
		}
		return cantidadJugadores;
	}
	
	//Regresa los nombres de todos los jugadores que jugaron cierta cantidad de partidos.
	public ArrayList<String> cualesJugadoresJugaronAlMenosXPartidosEnElTorneo(int partidos, int cantGrupos){
		ArrayList<String> jugadores= new ArrayList<String>();
		
		for(int j=0; j<cantGrupos; j++) {
			for (int i=0; i<cantEquipos[j]; i++) {
				//El addAll es una fucnión del ArrayList para agregar toda una lista a otra lista.
				jugadores.addAll(equipos[j][i].cualesJugadoresJugaronAlMenosXPartidos(partidos));
			}
		}
		return jugadores;
	}
	
	public String toString() {
		StringBuilder cad= new StringBuilder();
		
		cad.append("\nLa información del torneo es: ");
		cad.append("\n                      nombre: "+nombre);
		cad.append("\n                         año: "+aho);
		cad.append("\n                        sede: "+sede);
		cad.append("\nLos equipos son: ");
		for(int z=0; z<MAX_EQUIPOS_EN_GRUPO; z++) {
			cad.append(LUGAR_DEL_GRUPO[z]+"\t\t");
		}
		for(int j=0; j<MAX_GRUPOS; j++) {
			cad.append("\nGrupo "+GRUPOS[j]+"\t\t");
			for(int i=0; i<cantEquipos[j]; i++) {
				cad.append(equipos[j][i].toString()+"\t\t");
			}
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
		TorneoDeFutbol other = (TorneoDeFutbol) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public int compareTo(TorneoDeFutbol otro) {
		return this.nombre.compareTo(otro.nombre);
	}
}
