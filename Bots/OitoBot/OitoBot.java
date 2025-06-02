package garagem;
import robocode.*;

public class OitoBot extends Robot
{
    public void run() {
        while (true) {
		 //parte de cima do ocho(oito em espanhol pra quem n é fluente)
          ahead(100);
          turnLeft(90);
          ahead(100);
	      turnLeft(90);
          ahead(100);
          turnLeft(90);
          ahead(100);
          turnLeft(90);
		   
		 //parte de baixo
          ahead(100);
          turnRight(90);
          ahead(100);
          turnRight(90);
          ahead(100);
          turnRight(90);
          ahead(100);
		   turnRight(90);
        }
    }
}
