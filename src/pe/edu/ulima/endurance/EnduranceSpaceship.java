package pe.edu.ulima.endurance;

import java.util.ArrayList;

public class EnduranceSpaceship extends ShipComponent{

	@Override
	public void agregar(ShipComponent component) {
		if (super.mChilds == null){
			super.mChilds = new ArrayList<ShipComponent>();
		}
		super.mChilds.add(component);
	}

	@Override
	public long calcularEnergiaUtilizada() {
		long energiaUtilizada = 0;
		if (super.mChilds != null){
			for (ShipComponent component : super.mChilds){
				energiaUtilizada += component.calcularEnergiaUtilizada();
			}
		}
		
		return energiaUtilizada;
	}

	@Override
	public int verificarFuncionamiento() {
		int tiempoTotal = 0;
		for (ShipComponent component : super.mChilds){
			tiempoTotal += component.verificarFuncionamiento();
		}
		return tiempoTotal;
	}
	
	/*
	 * Se les hara que terminen de implementar el patron Composite
	 * Se tendra una clase HandicapableRobotTARS que sera el encargado de realizar
	 * las operaciones de verificacion de errores.
	 * 
	 * http://www.space.com/27694-interstellar-movie-spaceships-infographic.html
	 * http://interstellarfilm.wikia.com/
	 * 
	 * 
	 */

}
