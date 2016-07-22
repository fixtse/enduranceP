package pe.edu.ulima.endurance;


public class ModuloHibernacion extends ShipComponent{
	public static int CANTIDAD_ENERGIA = 200;
	private Robot mRobot;
	
	public ModuloHibernacion() {}
	
	public ModuloHibernacion(Robot robot) {
		mRobot = robot;
	}
	@Override
	public void agregar(ShipComponent component) {}

	@Override
	public long calcularEnergiaUtilizada() {
		
		return CANTIDAD_ENERGIA;
	}

	@Override
	public int verificarFuncionamiento() {
		
		if (mRobot != null){
			return mRobot.analizarDesperfecto();
		}
		return 0;
	}

}
