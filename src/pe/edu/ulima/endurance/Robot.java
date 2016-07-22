package pe.edu.ulima.endurance;

public interface Robot {
	/*
	 * Metodo que devuelve la cantidad de horas que se demora en reparar
	 * el desperfecto el robot. Si devuelve 0 significa que no hay desperfecto por lo 
	 * tanto no hara nada.
	 */
	public int analizarDesperfecto();
}
