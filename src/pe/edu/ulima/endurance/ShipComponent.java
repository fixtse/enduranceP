package pe.edu.ulima.endurance;

import java.util.List;

public abstract class ShipComponent {
	protected List<ShipComponent> mChilds;
	
	public List<ShipComponent> listarComponentes(){
		if (mChilds != null){
			return mChilds;
		}return null;
	}
	
	public abstract void agregar(ShipComponent component);
	public abstract long calcularEnergiaUtilizada();
	
	/*
	 * Metodo que verifica si el componente esta funcionando. 
	 * Para ciertos componentes se necesita un Robot. El robot analiza si es que hay 
	 * algun desperfecto y deberia enviar el tiempo que se demoraria en corregir 
	 * el desperfecto.
	 */
	public abstract int verificarFuncionamiento();
}
