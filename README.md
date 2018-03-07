# RoboCode
Actual Features:
  After trying to implement many of the abilities that we had planned the code started to conflict with each other, so we tried to keep the code as simple as possible in order to avoid conflict between the code. We wanted to implement something similar to the sample Walls robot, a robot that is simple and effective.

-Divorces gun movement from body.
&emsp; We wanted to create a robot that has gun movements that was independent from its body because we started to differentiate from the plan to make the robot hug the wall. Since the robot is no longer hugging the walls it now has the chance to jump into the middle of the battlefield which will increase its chances of being surrounded by robots from all sides so if the robot has independent gun movements from its body it will be able to shoot the closest robot from all around. The idea to not make the robot hug the wall was made in order to not make our robot identical to the Walls robot, we wanted to retain some originality.
-Every time it gets hit moves away to avoid another bullet by turning and moving ahead by a specified amount. 
  &emsp; This ability is used in the hopes of avoiding the path of the enemy robot’s bullets.
-If a robot is in front of us then move back otherwise move ahead to avoid it.
  &emsp;This ability will make it less likely to hit the enemy robot again. Points are taken off for ramming an opponent. 
-Tracks opponent and tries to kill it off before moving. Check gunheat in order to not lose robot because every shot takes up a turn.
 &emsp; The only problem with this ability is that the robot has to stand still in order to implement this ability. Especially since the robot is more than likely to be in the middle of the battlefield it has the chance to be hit more often and be killed before it can kill off another robot. The robot also checks its gunheat before shooting in order to not lose track of its enemy so that it doesn’t lose it.
-Rapid Fire
 &emsp; The robot shoots rapidly. However the issue with this is that it shoots and misses if the robot is constantly moving. This could be improved by implementing a predictive shooting ability in an advanced robot. Since multiple abilities can be implemented per turn for an advanced robot it would have been to have started with that. 

Desired Features:
-Hugs the wall.
<p> &emsp; After checking the sample robots we noticed that the walls robot had a tendency to win due to its simplicity and design. The Walls robot hugs the wall while shooting a few bullets every time it scans a robot. It is constantly moving and only pauses to move away from a robot it has crashed into or in order to turn on corners. </p>
-Shoots several bullets at the same time. 
 <p>&emsp; Initially we were thinking that the best way to win was to kill other robots, but the main focus is to hit your opponents more than they have hit you. After trying to create our own robot we found it difficult, or even impossible, to implement a gun that shoots several bullets per turn. We also thought that if we could implement this the spray of bullets could act as a force field for our robot. </p>
-Shoots at robots close to it.
<p>  &emsp;Shooting ultimately takes up energy and turns, this is something we want to avoid. In order to avoid this we were thinking of creating a robot that constantly scans its surroundings and shoots the nearest robot in order to avoid premature shooting. 
-Avoids getting too close to other robots/Turns right or left if it hits the wall</p>
 <p> &emsp;An issue that can cause our robot to die prematurely is if it constantly rams into a robot or wall. We were thinking of implementing predictive dodging which would mean extending from the AdvancedRobot. We have already started with a robot that extends from the Robot class so instead we thought that it would be better for the robot to back away or move ahead if an enemy robot hits it.</p>
-Shoots as it moves (rapid fire)
<p> &emsp; We want to gain as many points as possible so we thought that the best way to do this is to implement a gun that moves independently from the tank and shoots rapidly. The issue with this ability is that it is hard to shoot a robot that is constantly moving because our robot will not be able to predict its movement and instead shoots prematurely wasting energy after not hitting its target.</p>
-If there is a robot in the way destroy it first then continue on the way.
<p> &emsp; One of the abilities that we admired about the Walls Robot was its ability to focus on a target in its way and annihilate it so that it can continue on its path. The only thing about this ability is that it only works if the robot has a preplanned track of where it will go. If the robot is in the middle of the battleground and it does this ability it will become a sitting duck naked from the bullets of other passing robots because it has to stop to perform this ability. </p>

APIs Used:
  ScannedRobotEvent
  HitByBullet
  HitRobotEvent
  normalRelativeAngleDegrees
