package Test;


import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;
import pe.edu.ulima.endurance.*;

public class EnduranceTest {
	
	@Test
	public void testComprobarArmadoNave() {
		ZonaA zonaA = new ZonaA();
		zonaA.agregar(new MotorPrincipal());
		zonaA.agregar(new ModuloComando());
		
		ZonaB zonaB = new ZonaB();
		zonaB.agregar(new ModuloHabitable());
		zonaB.agregar(new ModuloHabitable());
		
		ZonaC zonaC = new ZonaC();
		zonaC.agregar(new ModuloHibernacion());
		zonaC.agregar(new ModuloHibernacion());
		zonaC.agregar(new ModuloHibernacion());
		
		EnduranceSpaceship ship = new EnduranceSpaceship();
		ship.agregar(zonaA);
		ship.agregar(zonaB);
		ship.agregar(zonaC);
		
		assertTrue("Error", ship.calcularEnergiaUtilizada() == 8400);
	}

	@Test
	public void testNoDesperfectos() {
		// Se crea el robot1 que siempre va a decir que todo esta Ok
		Robot robot1 = mock(Robot.class);
		when(robot1.analizarDesperfecto()).thenReturn(0);
		
		ZonaA zonaA = new ZonaA();
		zonaA.agregar(new MotorPrincipal(robot1));
		zonaA.agregar(new ModuloComando(robot1));
		
		ZonaB zonaB = new ZonaB();
		zonaB.agregar(new ModuloHabitable(robot1));
		zonaB.agregar(new ModuloHabitable(robot1));
		
		ZonaC zonaC = new ZonaC();
		zonaC.agregar(new ModuloHibernacion(robot1));
		zonaC.agregar(new ModuloHibernacion(robot1));
		zonaC.agregar(new ModuloHibernacion(robot1));
		
		EnduranceSpaceship ship = new EnduranceSpaceship();
		ship.agregar(zonaA);
		ship.agregar(zonaB);
		ship.agregar(zonaC);
		
		assertTrue("Error", ship.verificarFuncionamiento() == 0);
	}
	
	@Test
	public void testDesperfectoModuloHabitable() {
		// Se crea el robot1 que siempre va a decir que todo esta Ok
		Robot robot1 = mock(Robot.class);
		when(robot1.analizarDesperfecto()).thenReturn(0);
		
		// Se crea el robot2 que siempre va a decir que hay un desperfecto y que va a
		// tardar 10 min en corregirlo.
		Robot robot2 = mock(Robot.class);
		when(robot2.analizarDesperfecto()).thenReturn(10);

		ZonaA zonaA = new ZonaA();
		zonaA.agregar(new MotorPrincipal(robot1));
		zonaA.agregar(new ModuloComando(robot1));

		ZonaB zonaB = new ZonaB();
		zonaB.agregar(new ModuloHabitable(robot2));
		zonaB.agregar(new ModuloHabitable(robot1));

		ZonaC zonaC = new ZonaC();
		zonaC.agregar(new ModuloHibernacion(robot1));
		zonaC.agregar(new ModuloHibernacion(robot1));
		zonaC.agregar(new ModuloHibernacion(robot1));

		EnduranceSpaceship ship = new EnduranceSpaceship();
		ship.agregar(zonaA);
		ship.agregar(zonaB);
		ship.agregar(zonaC);
		
		assertTrue("Error", ship.verificarFuncionamiento() == 10);
	}
	
	@Test
	public void testDesperfectoModulosHabitableComandoHibernacion() {
		// Se crea el robot1 que siempre va a decir que todo esta Ok
		Robot robot1 = mock(Robot.class);
		when(robot1.analizarDesperfecto()).thenReturn(0);

		// Se crea el robot2 que siempre va a decir que hay un desperfecto y que va a
		// tardar 10 min en corregirlo.
		Robot robot2 = mock(Robot.class);
		when(robot2.analizarDesperfecto()).thenReturn(10);

		ZonaA zonaA = new ZonaA();
		zonaA.agregar(new MotorPrincipal(robot1));
		zonaA.agregar(new ModuloComando(robot2));

		ZonaB zonaB = new ZonaB();
		zonaB.agregar(new ModuloHabitable(robot2));
		zonaB.agregar(new ModuloHabitable(robot1));

		ZonaC zonaC = new ZonaC();
		zonaC.agregar(new ModuloHibernacion(robot2));
		zonaC.agregar(new ModuloHibernacion(robot1));
		zonaC.agregar(new ModuloHibernacion(robot1));

		EnduranceSpaceship ship = new EnduranceSpaceship();
		ship.agregar(zonaA);
		ship.agregar(zonaB);
		ship.agregar(zonaC);
		
		assertTrue("Error", ship.verificarFuncionamiento() == 30);
		
		
	}

}