import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Miguel Herrera
 * abril 2023
 * Controlador del torneo
 */

public class ControladorTorneoDeFutbol extends VistaTorneoDeFutbol{

	private static TorneoDeFutbol mundial= new TorneoDeFutbol("Mundial", 2022, "Qatar");
	private final int CANT_GRUPOS=8; //Se puso este atributo porque es necesario para utilizar todas las funciones. Y se puso esta cifra porque el mundial tiene máximo 8 grupos.
	
	public ControladorTorneoDeFutbol(String titulo) {
		super(titulo);
		
		botonAgregarEquipo.addActionListener(new EscuchadorAltaEquipo());
		botonBajaEquipo.addActionListener(new EscuchadorBajaEquipo());
		botonCambiarEstadisticaEquipo.addActionListener(new EscuchadorCambiarEstadisticaEquipo());
		botonAgregarJugador.addActionListener(new EscuchadorAltaJugador());
		botonDarDeBajaJugador.addActionListener(new EscuchadorBajaJugador());
		botonCambiarEstadisticaJugador.addActionListener(new EscuchadorEstadisticasJugador());
		botonGoleador.addActionListener(new EscuchadorGoleadorTorneo());
		botonMejorPortero.addActionListener(new EscuchadorPorteroTorneo());
		botonMejorPromedioDeGoles.addActionListener(new EscuchadorPromedioGolesTorneo());
		botonMasAsistencias.addActionListener(new EscuchadorAsistenciasTorneo());
		botonMasMinutos.addActionListener(new EscuchadorMinutosTorneo());
		botonMejorDefensiva.addActionListener(new EscuchadorDefensivaTorneo());
		botonMejorOfensiva.addActionListener(new EscuchadorOfensivaTorneo());
		botonEquipoMasCampeonatos.addActionListener(new EscuchadorCampeonatosTorneo());
		botonJugadorMasViejo.addActionListener(new EscuchadorJugadorViejoTorneo());
		botonJugadorMasJoven.addActionListener(new EscuchadorJugadorJovenTorneo());
		botonCampeon.addActionListener(new EscuchadorCampeonTorneo());
		botonCualesEquiposSeQuedaronEn.addActionListener(new EscuchadorEquiposEnRendimiento());
		botonCuantosJugadoresJugaron.addActionListener(new EscuchadorPartidosJugadoresEnTorneo());
		botonGoleadorPorEquipo.addActionListener(new EscuchadorGoleadorEquipo());
		botonMejorPorteroPorEquipo.addActionListener(new EscuchadorMejorPorteroEquipo());
		botonInformacionGeneral.addActionListener(new EscuchadorInformacionEquipo());
		botonCuantosJugadoresPorPosicion.addActionListener(new EscuchadorJugadoresPorPosicion());
		botonJugadorBuscado.addActionListener(new EscuchadorBuscarJugador());
	}
	
	private class EscuchadorAltaEquipo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String equipoCreado, directorTecnico, rendimientoCreado, respuesta, grupoCreado;
			int campeonatos;
			char grupo;
			
			equipoCreado=(String) equipo.getSelectedItem();
			directorTecnico= directorTecnicoTxt.getText();
			campeonatos= Integer.parseInt(campeonatosTxt.getText());
			rendimientoCreado= (String) boxRendimiento.getSelectedItem();
			grupoCreado = (String) boxGrupos.getSelectedItem();
			grupo= grupoCreado.charAt(0);
			if(mundial.altaEquipo(equipoCreado, directorTecnico, campeonatos, rendimientoCreado, grupo, CANT_GRUPOS))
				respuesta = "Sí se dio de alta al equipo.";
			else
				respuesta = "No se dio de alta al equipo.";
			respuestaAltaEquipoTxt.setText(respuesta);
		}
	}
	
	private class EscuchadorBajaEquipo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombreEquipo, respuesta;
			
			nombreEquipo=(String) equipo.getSelectedItem();
			if(mundial.bajaEquipo(nombreEquipo, CANT_GRUPOS))
				respuesta = "Sí se dio de baja al equipo.";
			else
				respuesta = "No se dio de baja al equipo.";
			respuestaAltaEquipoTxt.setText(respuesta);
		}
	}
	
	private class EscuchadorCambiarEstadisticaEquipo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombreEquipo, respuesta;
			int campeonatosParaAgregar;
			
			nombreEquipo = (String) equipo.getSelectedItem();
			campeonatosParaAgregar =Integer.parseInt(campeonatosTxt.getText());
			System.out.println(nombreEquipo);
			System.out.println(campeonatosParaAgregar);
			if(mundial.agregarCampeonatosAEquipo(nombreEquipo, campeonatosParaAgregar, CANT_GRUPOS))
				respuesta="Sí se cambió la estadística.";
			else
				respuesta="No se cambió la estadística.";
			respuestaAltaEquipoTxt.setText(respuesta);
		}
	}
	
	private class EscuchadorAltaJugador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombreEquipo, nombreJugador, posicionJugador, respuesta;
			int ahoNac, partidos, goles, asistencias, minutos, golesRecibidos;
			
			nombreEquipo= (String) equipo1.getSelectedItem();
			nombreJugador=nombreJugadorTxt.getText();
			ahoNac=Integer.parseInt(ahoNacTxt.getText());
			posicionJugador= (String) boxPosicion.getSelectedItem();
			partidos=Integer.parseInt(partidosTxt.getText());
			goles=Integer.parseInt(golesTxt.getText());
			asistencias=Integer.parseInt(asistenciasTxt.getText());
			minutos=Integer.parseInt(minutosTxt.getText());
			golesRecibidos=Integer.parseInt(golesRecibidosTxt.getText());
			if(mundial.altaJugadorEnEquipo(nombreEquipo, nombreJugador, ahoNac, posicionJugador, partidos, goles, asistencias, minutos, golesRecibidos, CANT_GRUPOS))
				respuesta="Sí se dio de alta al jugador.";
			else
				respuesta="No se dio de alta al jugador.";
			respuestaAltaJugadorTxt.setText(respuesta);
		}
	}
	
	private class EscuchadorBajaJugador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombreEquipo, nombreJugador, respuesta;
			
			nombreEquipo= (String) equipo1.getSelectedItem();
			nombreJugador=nombreJugadorTxt.getText();
			if(mundial.darDeBajaJugadorEnEquipo(nombreEquipo, nombreJugador, CANT_GRUPOS))
				respuesta="Sí se dio de baja al jugador.";
			else
				respuesta="No se dio de baja al jugador.";
			respuestaAltaJugadorTxt.setText(respuesta);
		}
	}
	
	//Se van a cambiar todas las estadísticas al mismo tiempo.
	//Hay un StringBuilder el cual va a guardar todos los cambios que fallaron para arrojarselos al usuario.
	private class EscuchadorEstadisticasJugador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String nombreJugador, nombreEquipo, respuesta;
			int partidos, goles, asistencias, minutos, golesRecibidos;
			//Se usaron estos auxiliares y el StringBuilder para que salga en la pantalla los errores que existieron.
			boolean partidosAux=true, golesAux=true, asistenciasAux=true, minutosAux=true, golesRecibidosAux=true;
			StringBuilder errores= new StringBuilder();
			
			nombreEquipo= (String) equipo1.getSelectedItem();
			nombreJugador=nombreJugadorTxt.getText();
			partidos=Integer.parseInt(partidosTxt.getText());
			goles=Integer.parseInt(golesTxt.getText());
			asistencias=Integer.parseInt(asistenciasTxt.getText());
			minutos=Integer.parseInt(minutosTxt.getText());
			golesRecibidos=Integer.parseInt(golesRecibidosTxt.getText());
			partidosAux=mundial.agregarPartidosAJugadorEnEquipo(nombreEquipo, partidos, nombreJugador, CANT_GRUPOS);
			golesAux=mundial.agregarGolesAJugadorEnEquipo(nombreEquipo, goles, nombreJugador, CANT_GRUPOS);
			asistenciasAux=mundial.agregarAsistenciasAJugadorEnEquipo(nombreEquipo, asistencias, nombreJugador, CANT_GRUPOS);
			minutosAux=mundial.agregarMinutosAJugadorEnEquipo(nombreEquipo, minutos, nombreJugador, CANT_GRUPOS);
			golesRecibidosAux=mundial.agregarGolesRecibidosAJugadorEnEquipo(nombreEquipo, golesRecibidos, nombreJugador, CANT_GRUPOS);
			if(partidosAux && golesAux && asistenciasAux && minutosAux && golesRecibidosAux)
				respuesta="Todo se cambió.";
			else {
				errores.append("No se cambiaron los: "); //Se va a decir que cuales estadísticas no cambiaron. 
				if(!partidosAux)
					errores.append("partidos, ");
				if(!golesAux)
					errores.append("goles, ");
				if(!asistenciasAux)
					errores.append("asistencias, ");
				if(!minutosAux)
					errores.append("minutos, ");
				if(!golesRecibidosAux)
					errores.append("goles recibidos ");
				respuesta=errores.toString();
			}
			respuestaAltaJugadorTxt.setText(respuesta);
		}
	}
	
	//Se pone 0 y 1, para que sea más eficiente utilizar el arreglo sin entrar a un ciclo para imprimirlo (un for).
	//Además, se sabe por el código que el arreglo que regresa es de dos celdas.
	private class EscuchadorGoleadorTorneo implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
			
			arrEstadistica=mundial.goleadorDelTorneo(CANT_GRUPOS);
			respuestaTorneoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorPorteroTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
			
			arrEstadistica=mundial.mejorPortero(CANT_GRUPOS);
			respuestaTorneoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorPromedioGolesTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
			
			arrEstadistica=mundial.jugadorConMejorPromedioDeGoles(CANT_GRUPOS);
			respuestaTorneoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorAsistenciasTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
			
			arrEstadistica=mundial.jugadorConMasAsistencias(CANT_GRUPOS);
			respuestaTorneoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorMinutosTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
				
			arrEstadistica=mundial.jugadorConMasMinutos(CANT_GRUPOS);
			respuestaTorneoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorDefensivaTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
			
			arrEstadistica=mundial.equipoConMejorDefensiva(CANT_GRUPOS);
			respuestaTorneoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorOfensivaTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
			
			arrEstadistica=mundial.equipoConMejorOfensiva(CANT_GRUPOS);
			respuestaTorneoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorCampeonatosTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			respuestaTorneoTxt.setText(mundial.equipoConMasCampeonatos(CANT_GRUPOS));
		}
	}
	
	private class EscuchadorJugadorViejoTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			respuestaTorneoTxt.setText(mundial.jugadorMasViejoDelTorneo(CANT_GRUPOS));
		}
	}
	
	private class EscuchadorJugadorJovenTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			respuestaTorneoTxt.setText(mundial.jugadorMasJovenDelTorneo(CANT_GRUPOS));
		}
	}
	
	private class EscuchadorCampeonTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			respuestaTorneoTxt.setText(mundial.equipoCampeon(CANT_GRUPOS));
		}
	}
	
	private class EscuchadorEquiposEnRendimiento implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String rendimientoParaBuscar;
			
			rendimientoParaBuscar= (String) boxRendimiento2.getSelectedItem();
			respuestaTorneoTxt.setText(mundial.cualesEquiposSeQuedaronEn(rendimientoParaBuscar, CANT_GRUPOS).toString());
		}
	}
	
	private class EscuchadorPartidosJugadoresEnTorneo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int cantPartidosBus;
			
			cantPartidosBus=Integer.parseInt(cantidadPartidosTxt.getText());
			respuestaTorneoTxt.setText(mundial.cualesJugadoresJugaronAlMenosXPartidosEnElTorneo(cantPartidosBus, CANT_GRUPOS).toString());
		}
	}
	
	private class EscuchadorGoleadorEquipo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
			String equipoBuscadoParaSusEstadisticas;
			
			equipoBuscadoParaSusEstadisticas= (String) equipo2.getSelectedItem();
			arrEstadistica=mundial.goleadorPorEquipo(equipoBuscadoParaSusEstadisticas, CANT_GRUPOS);
			respuestaEquipoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorMejorPorteroEquipo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String []arrEstadistica= new String[2];
			String equipoBuscadoParaSusEstadisticas;
			
			equipoBuscadoParaSusEstadisticas= (String) equipo2.getSelectedItem();
			arrEstadistica=mundial.mejorPorteroPorEquipo(equipoBuscadoParaSusEstadisticas, CANT_GRUPOS);
			respuestaEquipoTxt.setText(arrEstadistica[0]+" "+arrEstadistica[1]);
		}
	}
	
	private class EscuchadorInformacionEquipo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String equipoBuscadoParaSusEstadisticas;
			
			equipoBuscadoParaSusEstadisticas= (String) equipo2.getSelectedItem();
			respuestaEquipoTxt.setText(mundial.getUnEquipo(equipoBuscadoParaSusEstadisticas, CANT_GRUPOS));
		}
	}
	
	private class EscuchadorJugadoresPorPosicion implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String equipoBuscadoParaSusEstadisticas, posicionBuscada;
			
			equipoBuscadoParaSusEstadisticas= (String) equipo2.getSelectedItem();
			posicionBuscada=(String) boxPosicion2.getSelectedItem();
			respuestaEquipoTxt.setText(mundial.cantidadDeJugadoresPorPosicionPorEquipo(equipoBuscadoParaSusEstadisticas, posicionBuscada, CANT_GRUPOS));
		}
	}
	
	private class EscuchadorBuscarJugador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String equipo, jugador;
			
			equipo= (String) equipo2.getSelectedItem();
			jugador= jugadorBuscadoTxt.getText();
			respuestaEquipoTxt.setText(mundial.getUnJugadorDeEquipo(equipo, jugador, CANT_GRUPOS));
		}
	}

	public static void leeArchivo(TorneoDeFutbol mundial){
		final int CANTIDAD_GRUPOS=8;
		String nombreEquipo, nombreEntrenador, rendimiento, nombreJugador, posicion, aux;//La explicación de este aux esta en el main;
		char grupo;
		int campeonatos, cantEquipos, cantJugadores, ahoNac, partidos, goles, asistencias, minutos, golesRecibidos;
		File ent= new File("Mundial2022.txt");
		
		try(Scanner lec= new Scanner(ent)){
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
			lec.close();
		}
	
		catch(FileNotFoundException fnfe) {
			System.err.println("ERROR        "+fnfe);
			System.exit(-1);
		}
	}
	
	public static void main(String[] args) {
		ControladorTorneoDeFutbol yo= new ControladorTorneoDeFutbol("Mundial 2022");
		leeArchivo(mundial);
	}

}
