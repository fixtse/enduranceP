package pe.edu.ulima.endurance;

import java.util.ArrayList;

/*
 * Solamente tiene espacio para 2 compartimentos
 */
public class ZonaC extends ShipComponent{

	@Override
	public void agregar(ShipComponent component) {
		if (super.mChilds == null){
			super.mChilds = new ArrayList<ShipComponent>();
		}
		if (super.mChilds.size() < 2){
			super.mChilds.add(component);
		}
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

}
