package pe.edu.ulima.endurance;

public class ControlEndurance {

	public static void main(String[] args) {
		/*
		 * Se debe armar la nave segun la especificacion dada. Aca lo que podríamos
		 * hacer es que los muchachos creen la nave segun la siguiente configuracion:
		 * - EnduranceSpaceship
		 *   - Zona A
		 *     - Motor Principal
		 *     - ModuloComando
		 *   - Zona B
		 *     - 2 Modulos de Habitables
		 *   - Zona C 
		 *     - 3 Modulos de Hibernacion
		 *     
		 *   Para que comprueben que su configuracion es la correcta, tienen que 
		 *   armar el EnduranceSpaceship y llamar al metodo calcularEnergiaUtilizada.
		 *   Les debería salir el valor 8400
		 */
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
		
		long cantidadEnergiaUtilizada = ship.calcularEnergiaUtilizada();
		System.out.println("Cantidad Energia Utilizada: " + cantidadEnergiaUtilizada);
		
		/*
		 * La segunda pregunta pregunta es utilizando mockito y hacer casos de prueba para 
		 * que si es que falla un componente, se nos diga una cantidad de tiempo 
		 */
	}

}
