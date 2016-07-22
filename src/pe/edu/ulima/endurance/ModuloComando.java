package pe.edu.ulima.endurance;


public class ModuloComando extends ShipComponent{
	public static int CANTIDAD_ENERGIA = 1000;
	private Robot mRobot;
	
	public ModuloComando(){}
	
	public  ModuloComando(Robot robot) {
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
