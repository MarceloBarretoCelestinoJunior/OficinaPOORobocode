package garagem;
import robocode.*;
public class ShooterTest extends Robot
{
	public void run() {
		while(true) {
			turnGunRight(3);
		}
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
		double anguloinimigo = e.getBearing();
		turnGunRight(1 - anguloinimigo);
		
	}
}
