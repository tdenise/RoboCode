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
		
		// turnLeft to face a wall.
		// getHeading() % 90 means the remainder of
		// getHeading() divided by 90.
		turnLeft(getHeading() % 90);
		ahead(moveAmount);
		// Turn the gun to turn right 90 degrees.
		check = true;
		turnGunRight(90);
		turnRight(90);
		
		while (true) {
			// Look before we turn when ahead() completes.
			check = true;			
			// Turn to the next wall
			turnRight(90);
			ahead(moveAmount);
			// Don't look now
			check = false;
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}	
		
/*		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}*/
	}
	

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double absoluteBearing = getHeading() + e.getBearing();
		double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
		
		if (Math.abs(bearingFromGun) <= 3) {
			turnGunRight(bearingFromGun);
			// We check gun heat here, because calling fire()
			// uses a turn, which could cause us to lose track
			// of the other robot.
			if (getGunHeat() == 0) {
				fire(Math.min(3 - Math.abs(bearingFromGun), getEnergy() - .1));
			}
		} // otherwise just set the gun to turn.
		// Note:  This will have no effect until we call scan()
		else {
			turnGunRight(bearingFromGun);
		}
		
			fire(10);
			if(check){
				scan();
			}
	}
	


	public void onGotHit(HitByBulletEvent e) {
		if(e.getBearing() > -90 && e.getBearing() < 90) {
			turnRight(90);
			ahead(100);
			back(30);
		}
	}	

	//move back a bit if robo in front of us
	public void onHitRobot(HitRobotEvent e) {
		if(e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		}
		else{
			ahead(100);
		}
	}
		
}
