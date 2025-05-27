package garagem;
import robocode.*;

public class FilhoteDeBarata extends Robot{
	public void run() {
	
		while(true){
			ahead(800);
		}
	}
	public void onHitWall(HitWallEvent event){
		setDebugProperty("angulo da colisao: ", String.valueOf(event.getBearing()));
		
		double anguloParede = event.getBearing();
		turnLeft(90 - anguloParede);
	}
}
