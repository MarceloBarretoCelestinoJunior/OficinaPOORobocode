package garagem;
import robocode.*;

public class VBot extends Robot
{
	public void run() {
		while(true) {
		//Robozinho que anda em V de vitória, cshapa vem ai
			turnLeft(45);
			ahead(150);
			turnRight(90);
			ahead(150);
			turnLeft(45);
		}
	}	
}
