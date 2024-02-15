import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/* Miguel Herrera
 * abril 2023
 * Clase para hacer la vista del torneo de futbol
 */
public class VistaTorneoDeFutbol extends JFrame {
	protected JButton botonAgregarEquipo, botonBajaEquipo, botonAgregarJugador, botonDarDeBajaJugador, botonCambiarEstadisticaEquipo, botonCambiarEstadisticaJugador, botonGoleador, botonMejorPortero, botonMejorPromedioDeGoles, botonMasAsistencias, botonEquipoMasCampeonatos, botonJugadorMasViejo, botonJugadorMasJoven, botonMasMinutos, botonCualesEquiposSeQuedaronEn, botonCampeon, botonMejorDefensiva, botonMejorOfensiva, botonGoleadorPorEquipo, botonMejorPorteroPorEquipo, botonInformacionGeneral, botonCuantosJugadoresJugaron, botonCuantosJugadoresPorPosicion, botonJugadorBuscado;
	private JLabel tituloPanel, nombreTorneo, equipoLb, directorTecnicoLb, campeonatosLb, rendimientoLb, tituloPanel2, espacioEnBlanco, nombreEquipoLb, nombreJugadorLb, ahoNacLb, posicionLb, partidosLb, golesLb, asistenciasLb, minutosLb, golesRecibidosLb, tituloPanel3, tituloPanel4, espacioBlanco2, espacioBlanco3, espacioBlanco4, palabraPartidoLb, grupoLb, espacioBlanco5, jugadorBuscadoLb;
	protected JTextField directorTecnicoTxt, campeonatosTxt, nombreJugadorTxt, ahoNacTxt, partidosTxt, golesTxt, asistenciasTxt, minutosTxt, golesRecibidosTxt, cantidadPartidosTxt, respuestaAltaEquipoTxt, respuestaAltaJugadorTxt, jugadorBuscadoTxt;
	protected JTextArea respuestaTorneoTxt, respuestaEquipoTxt;
	private final String[]RENDIMIENTO= {"Fase de grupos", "Octavos de final", "Cuartos de final", "Semifinal", "Final", "Campeón"};
	private final String[]EQUIPOS= {"Alemania", "Arabia Saudita", "Argentina", "Australia", "Bélgica", "Brasil", "Camerún", "Canadá", "Costa Rica", "Croacia",   "Corea del Sur", "Dinamarca", "Ecuador", "España", "Estados Unidos", "Francia", "Gales",  "Ghana", "Inglaterra", "Irán", "Japón", "Marruecos", "México", "Países Bajos", "Polonia", "Portugal", "Qatar", "Senegal", "Serbia", "Suiza", "Túnez", "Uruguay"};
	private final String[]GRUPOS= {"A", "B", "C", "D", "E", "F", "G" ,"H"};
	private final String[]POSICION= {"Portero", "Defensa", "Mediocampista", "Delantero"};
	protected JComboBox<String> boxRendimiento, boxRendimiento2, equipo, equipo1, equipo2, boxGrupos, boxPosicion, boxPosicion2;
	private JScrollPane barraEquipos, barraInfo;

	public VistaTorneoDeFutbol(String titulo) {
		super(titulo);
		
		botonAgregarEquipo= new JButton("Alta");
		botonBajaEquipo= new JButton("Baja");
		botonCambiarEstadisticaEquipo= new JButton("Cambiar estadística");
		tituloPanel= new JLabel ("Equipos");
		tituloPanel.setForeground(Color.GRAY);
		nombreTorneo= new JLabel("Mundial 2022");
		equipoLb= new JLabel ("Equipo :");
		equipoLb.setForeground(Color.GRAY);
		directorTecnicoLb= new JLabel("Director Técnico: ");
		directorTecnicoLb.setForeground(Color.GRAY);
		campeonatosLb= new JLabel("Campeonatos: ");
		campeonatosLb.setForeground(Color.GRAY);
		rendimientoLb= new JLabel("Rendimiento: ");
		rendimientoLb.setForeground(Color.GRAY);
		grupoLb= new JLabel("Grupo: ");
		grupoLb.setForeground(Color.GRAY);
		boxRendimiento= new JComboBox<>(RENDIMIENTO);
		equipo= new JComboBox<>(EQUIPOS);
		directorTecnicoTxt= new JTextField(14);
		campeonatosTxt= new JTextField(4);
		boxGrupos= new JComboBox<>(GRUPOS);
		respuestaAltaEquipoTxt= new JTextField(20);
		
		tituloPanel2= new JLabel("Jugadores");
		tituloPanel2.setForeground(Color.RED);
		espacioEnBlanco=new JLabel("                ");
		botonAgregarJugador= new JButton("Alta");
		botonDarDeBajaJugador= new JButton("Baja");
		botonCambiarEstadisticaJugador= new JButton("Cambiar estadística");
		nombreEquipoLb= new JLabel("Equipo: ");
		nombreEquipoLb.setForeground(Color.RED);
		nombreJugadorLb= new JLabel ("Nombre: ");
		nombreJugadorLb.setForeground(Color.RED);
		ahoNacLb= new JLabel("Año de nacimiento: ");
		ahoNacLb.setForeground(Color.RED);
		posicionLb= new JLabel("Posición: ");
		posicionLb.setForeground(Color.RED);
		partidosLb= new JLabel("Partidos: ");
		partidosLb.setForeground(Color.RED);
		golesLb=new JLabel("Goles: ");
		golesLb.setForeground(Color.RED);
		asistenciasLb= new JLabel("Asistencias: ");
		asistenciasLb.setForeground(Color.RED);
		minutosLb= new JLabel("Minutos: ");
		minutosLb.setForeground(Color.RED);
		golesRecibidosLb= new JLabel("Goles recibidos: ");
		golesRecibidosLb.setForeground(Color.RED);
		equipo1= new JComboBox<>(EQUIPOS);
		nombreJugadorTxt= new JTextField(12);
		ahoNacTxt= new JTextField(4);
		boxPosicion= new JComboBox<>(POSICION);
		partidosTxt= new JTextField(4);
		golesTxt= new JTextField(3);
		asistenciasTxt= new JTextField(3);
		minutosTxt= new JTextField(5);
		golesRecibidosTxt= new JTextField(5);
		respuestaAltaJugadorTxt= new JTextField(20);
		
		tituloPanel3= new JLabel("Estadísticas del torneo");
		tituloPanel3.setForeground(Color.GREEN);
		espacioBlanco2= new JLabel("          ");
		espacioBlanco3= new JLabel("          ");
		espacioBlanco4= new JLabel("          ");
		respuestaTorneoTxt= new JTextArea(10000,10000);
		barraInfo= new JScrollPane(respuestaTorneoTxt);
		barraInfo.setViewportView(respuestaTorneoTxt);
		botonGoleador= new JButton("Goleador"); 
		botonMejorPortero= new JButton("Mejor portero");
		botonMejorPromedioDeGoles= new JButton ("Mejor promedio de goles");
		botonMasAsistencias= new JButton("Más asistencias");
		botonEquipoMasCampeonatos= new JButton("Más campeonatos"); 
		botonJugadorMasViejo= new JButton("Más viejo");
		botonJugadorMasJoven= new JButton("Más jovén");
		botonMasMinutos= new JButton("Más minutos");
		botonCualesEquiposSeQuedaronEn= new JButton("Quedaron en: ");
		botonCuantosJugadoresJugaron= new JButton("Jugadores que jugaron: ");
		cantidadPartidosTxt= new JTextField(4);
		palabraPartidoLb= new JLabel("partidos.");
		boxRendimiento2= new JComboBox<>(RENDIMIENTO);
		botonCampeon= new JButton("Campéon");
		botonMejorDefensiva= new JButton("Mejor defensiva");
		botonMejorOfensiva= new JButton("Mejor ofensiva");
		
		tituloPanel4= new JLabel("Información por equipo");
		tituloPanel4.setForeground(Color.ORANGE);
		respuestaEquipoTxt= new JTextArea(10000, 1000);
		barraEquipos= new JScrollPane(respuestaEquipoTxt);
		barraEquipos.setViewportView(respuestaEquipoTxt);
		equipo2= new JComboBox<>(EQUIPOS);
		botonInformacionGeneral= new JButton("Información general");
		botonGoleadorPorEquipo= new JButton("Goleador");
		botonMejorPorteroPorEquipo= new JButton("Mejor portero");
		botonCuantosJugadoresPorPosicion= new JButton("Jugadores por posición");
		boxPosicion2= new JComboBox<>(POSICION);
		espacioBlanco5= new JLabel("");
		jugadorBuscadoTxt= new JTextField(12);
		botonJugadorBuscado= new JButton("Información jugador");
		jugadorBuscadoLb= new JLabel("Nombre jugador: ");
		
		JPanel altaYBajaEquipo=new JPanel();
		altaYBajaEquipo.setLayout(new GridLayout(12,2));
		Border gap=BorderFactory.createEmptyBorder(2,2,2,2);
		altaYBajaEquipo.setBorder(gap);
		altaYBajaEquipo.add(tituloPanel);
		altaYBajaEquipo.add(nombreTorneo);
		altaYBajaEquipo.add(equipoLb);
		altaYBajaEquipo.add(equipo);
		altaYBajaEquipo.add(directorTecnicoLb);
		altaYBajaEquipo.add(directorTecnicoTxt);
		altaYBajaEquipo.add(campeonatosLb);
		altaYBajaEquipo.add(campeonatosTxt);
		altaYBajaEquipo.add(rendimientoLb);
		altaYBajaEquipo.add(boxRendimiento);
		altaYBajaEquipo.add(grupoLb);
		altaYBajaEquipo.add(boxGrupos);
		altaYBajaEquipo.add(botonAgregarEquipo);
		altaYBajaEquipo.add(botonBajaEquipo);
		altaYBajaEquipo.add(botonCambiarEstadisticaEquipo);
		altaYBajaEquipo.add(respuestaAltaEquipoTxt);
		
		JPanel altaYBajaJugador= new JPanel();
		altaYBajaJugador.setLayout(new GridLayout(12,2));
		altaYBajaJugador.setBorder(gap);
		altaYBajaJugador.add(tituloPanel2);
		altaYBajaJugador.add(espacioEnBlanco);
		altaYBajaJugador.add(nombreEquipoLb);
		altaYBajaJugador.add(equipo1);
		altaYBajaJugador.add(nombreJugadorLb);
		altaYBajaJugador.add(nombreJugadorTxt);
		altaYBajaJugador.add(ahoNacLb);
		altaYBajaJugador.add(ahoNacTxt);
		altaYBajaJugador.add(posicionLb);
		altaYBajaJugador.add(boxPosicion);
		altaYBajaJugador.add(partidosLb);
		altaYBajaJugador.add(partidosTxt);
		altaYBajaJugador.add(golesLb);
		altaYBajaJugador.add(golesTxt);
		altaYBajaJugador.add(asistenciasLb);
		altaYBajaJugador.add(asistenciasTxt);
		altaYBajaJugador.add(minutosLb);
		altaYBajaJugador.add(minutosTxt);
		altaYBajaJugador.add(golesRecibidosLb);
		altaYBajaJugador.add(golesRecibidosTxt);
		altaYBajaJugador.add(botonAgregarJugador);
		altaYBajaJugador.add(botonDarDeBajaJugador);
		altaYBajaJugador.add(botonCambiarEstadisticaJugador);
		altaYBajaJugador.add(respuestaAltaJugadorTxt);
		
		JPanel informacionTorneo= new JPanel();
		informacionTorneo.setLayout(new GridLayout(7,3));
		informacionTorneo.setBorder(gap);
		informacionTorneo.add(tituloPanel3);
		informacionTorneo.add(barraInfo);
		informacionTorneo.add(espacioBlanco2);
		informacionTorneo.add(botonGoleador);
		informacionTorneo.add(botonMejorPortero);
		informacionTorneo.add(botonMejorPromedioDeGoles);
		informacionTorneo.add(botonMasAsistencias);
		informacionTorneo.add(botonMasMinutos);
		informacionTorneo.add(botonJugadorMasViejo);
		informacionTorneo.add(botonJugadorMasJoven);
		informacionTorneo.add(botonEquipoMasCampeonatos);
		informacionTorneo.add(botonCampeon);
		informacionTorneo.add(botonMejorDefensiva);
		informacionTorneo.add(botonMejorOfensiva);
		informacionTorneo.add(espacioBlanco3);
		informacionTorneo.add(botonCualesEquiposSeQuedaronEn);
		informacionTorneo.add(boxRendimiento2);
		informacionTorneo.add(espacioBlanco4);
		informacionTorneo.add(botonCuantosJugadoresJugaron);
		informacionTorneo.add(cantidadPartidosTxt);
		informacionTorneo.add(palabraPartidoLb);
		
		JPanel informacionEquipo= new JPanel();
		informacionEquipo.setLayout(new GridLayout(4,3));
		informacionEquipo.setBorder(gap);
		informacionEquipo.add(tituloPanel4);
		informacionEquipo.add(barraEquipos);
		informacionEquipo.add(equipo2);
		informacionEquipo.add(botonGoleadorPorEquipo);
		informacionEquipo.add(botonMejorPorteroPorEquipo);
		informacionEquipo.add(botonInformacionGeneral);
		informacionEquipo.add(botonCuantosJugadoresPorPosicion);
		informacionEquipo.add(boxPosicion2);
		informacionEquipo.add(espacioBlanco5);
		informacionEquipo.add(botonJugadorBuscado);
		informacionEquipo.add(jugadorBuscadoLb);
		informacionEquipo.add(jugadorBuscadoTxt);
		
		JPanel panelGeneral= new JPanel();
		panelGeneral.setLayout(new GridLayout(2,3));
		panelGeneral.setBorder(gap);
		panelGeneral.add(altaYBajaEquipo);
		panelGeneral.add(altaYBajaJugador);
		panelGeneral.add(informacionTorneo);
		panelGeneral.add(informacionEquipo);
		
		this.add(panelGeneral);
		this.setVisible(true);
		this.setBounds(950,600,950,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//public static void main(String[] args) {
		//VistaTorneoDeFutbol prov= new VistaTorneoDeFutbol("PROVISIONAL");
	//}
}
