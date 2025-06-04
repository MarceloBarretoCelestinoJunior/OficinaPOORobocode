package garagem;
import robocode.*;
import java.awt.Color;

/**
 * Cshapa - a robot by (Marcelo, João e Pedro)
 */
public class Cshapa extends AdvancedRobot
{

	public void run() {

		setColors(Color.yellow,Color.yellow,Color.yellow); // body,gun,radar
		
		double margemArena = 150;
		
		setAdjustRadarForGunTurn(true);
		setAdjustGunForRobotTurn(true);
		while(true) {
			//Estrategia de evitar as paredes, para não perder pontuação e vida.
			if(getX() < margemArena){
				setTurnRight(90);
				setAhead(100);
			} else if(getX() > getBattleFieldWidth() - margemArena){
				setTurnRight(270);
				setAhead(100);
			} else if(getY() < margemArena){
				setTurnRight(90);
				setAhead(100);
			} else	if (getY() > getBattleFieldHeight() - margemArena){
				setTurnRight(180);
				setAhead(100);
			} else{
			
				//Movimentação aleatória, impossivel de prever.
				double anguloAleatorio = Math.random() * 180 - 90;
				double dInimigoAleatoria = 20 + Math.random() * 150;
				setTurnRight(anguloAleatorio);
				setAhead(dInimigoAleatoria);  
			}
			
			setTurnRadarRight(360);
			execute();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
   		double cshapaX = getX();
    	double cshapaY = getY();

    	// Angulo do inimigo.
    	double anguloAbsoluto = Math.toRadians(getHeading() + e.getBearing());

    	// Posição do inimigo.
    	double iX = cshapaX + e.getDistance() * Math.sin(anguloAbsoluto);
    	double iY = cshapaY + e.getDistance() * Math.cos(anguloAbsoluto);

    	double vInimigo = e.getVelocity();
    	double dirInimigo = Math.toRadians(e.getHeading());
    	double dInimigo = e.getDistance();

    	// Força do tiro.
    	double potenciaTiro = Math.max(1.0, Math.min(3.0, 400 / dInimigo));
    	double vBala = 20 - 3 * potenciaTiro;

    	double tempo = dInimigo / vBala;
		
    	// Tenta prever a posição futura do meliante com base na direção e velocidade, usando seno e cosseno para prever X e Y.
    	double iFX = iX + Math.sin(dirInimigo) * vInimigo * tempo; 
    	double iFY = iY + Math.cos(dirInimigo) * vInimigo * tempo;

    	// Calcular ângulo.
    	double deltaX = iFX - cshapaX;
   		double deltaY = iFY - cshapaY;
    	double anguloFuturo = Math.toDegrees(Math.atan2(deltaX, deltaY));

    	double ajusteArma = normalizarAngulo(anguloFuturo - getGunHeading());
    	setTurnGunRight(ajusteArma);
    	if (Math.abs(getGunTurnRemaining()) < 5) {
        	setFire(potenciaTiro);
    	}
    	double ajusteRadar = normalizarAngulo(getHeading() + e.getBearing() - getRadarHeading());
    	setTurnRadarRight(ajusteRadar);

    	execute();
	}

	
	//Faz o ângulo percorrer o caminho mais curto.
	private double normalizarAngulo(double angulo) {
        while (angulo > 180) angulo -= 360;
        while (angulo < -180) angulo += 360;
        return angulo;
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
   		double direcao = Math.random() > 0.5 ? 90 : -90;
    	setTurnRight(direcao);
    	setAhead(150);
		  double direcao2 = Math.random() > 0.5 ? 35 : 60;
	  	setBack(direcao2);
	}

	public void onHitWall(HitWallEvent e) {
	  	setBack(100);
    	setTurnRight(90);
    	setAhead(100);
	}	
}
