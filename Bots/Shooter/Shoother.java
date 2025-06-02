package garagem;
import robocode.*;
import robocode.util.Utils;

public class ShooterTest extends AdvancedRobot {
    public void run() {
      // Robo SBP, famoso por matar barata
        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);
        setAdjustRadarForRobotTurn(true);

        while (true) {
            turnRadarRight(360);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        double poderTiro = 3;
        double velocidadeTiro = 20 - 3 * poderTiro;

        double X = getX();
        double Y = getY();
        double distancia = e.getDistance();
        double anguloAbsoluto = Math.toRadians(getHeading() + e.getBearing());
        double inimigoX = X + Math.sin(anguloAbsoluto) * distancia;
        double inimigoY = Y + Math.cos(anguloAbsoluto) * distancia;

        double direcaoInimigo = Math.toRadians(e.getHeading());
        double velocidadeInimigo = e.getVelocity();

        double tempoEstimado = (distancia / velocidadeTiro) * 0.8;

        double futuroX = inimigoX + Math.sin(direcaoInimigo) * velocidadeInimigo * tempoEstimado;
        double futuroY = inimigoY + Math.cos(direcaoInimigo) * velocidadeInimigo * tempoEstimado;

        double deltaX = futuroX - X;
        double deltaY = futuroY - Y;
        double anguloMira = Math.toDegrees(Math.atan2(deltaX, deltaY));
        double ajustarCanhao = Utils.normalRelativeAngleDegrees(anguloMira - getGunHeading());

        setTurnGunRight(ajustarCanhao);
        execute();

        if (getGunHeat() == 0 && Math.abs(ajustarCanhao) < 2) {
            fire(poderTiro);
        }

        double ajusteRadar = Utils.normalRelativeAngleDegrees((getHeading() + e.getBearing()) - getRadarHeading());
        setTurnRadarRight(ajusteRadar);
    }
}
