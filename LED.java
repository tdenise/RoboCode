package LED;
import robocode.*;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.HitRobotEvent;
import java.awt.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import robocode.HitByBulletEvent;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * LED - a robot by Denise Tran & Lei Pei
 */
public class LED extends Robot
{
	double moveAmount;
	boolean check;
	/**
	 * run: LED's default behavior
	 */
	public void run() {
	
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		setBodyColor(Color.blue);
		setGunColor(Color.black);
		setRadarColor(Color.yellow);
		setBulletColor(Color.cyan);
		setScanColor(Color.cyan);
		
		// Initialization of the robot should be put here
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		check = false;
		
		//divorce gun movement from body
		setAdjustGunForRobotTurn(true);
		
		// turnLeft to face a wall
		turnLeft(getHeading() % 90);
		ahead(moveAmount);
		// Turn the gun to turn right 90 degrees.
		check = true;
		turnGunRight(90);
		
		
		while (true) {
			// Look before we turn when ahead() completes.
			check = true;			
			// Turn to the next wall
			ahead(moveAmount);
			turnRight(90);
			ahead(moveAmount); // Move ahead 100
			turnRadarRight(360);
			turnGunRight(360); // Spin gun around
			back(moveAmount); // Move back 100
			turnGunRight(360); // Spin gun around
			// Don't look now
			check = false;
		}

	}		

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double absoluteBearing = getHeading() + e.getBearing();
		double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
				
				if (Math.abs(bearingFromGun) <= 3) {
					turnGunRight(bearingFromGun);
					// We check gun heat in order to not lose robot
					if (getGunHeat() == 0) {
						fire(Math.min(3 - Math.abs(bearingFromGun), getEnergy() - .1));
					}
				} // otherwise just set the gun to turn.
				else {
					turnGunRight(bearingFromGun);
				}
				
				if(bearingFromGun == 0) { 
					scan();
				}
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		turnRight(90 - e.getBearing());
		ahead(100);
	}
	
/*	public onHitWall(){
		
	}*/

	//move back a bit if robo in front of us
	public void onHitRobot(HitRobotEvent e) {
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		if(e.getBearing() > -90 && e.getBearing() < 90) {
			back(moveAmount);
		}
		else{
			ahead(moveAmount);
		}
	}
		
}
