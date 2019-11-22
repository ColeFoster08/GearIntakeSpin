
package frc.robot;
import edu.wpi.first.wpilibj.*;

public class PI_D extends TimedRobot {

  private double rotationsTraveled;
  private double startPosition = 0;
  private double integralValue = 0;
  private long pastTime = 0;
  private double pastPosition = 0;

  public PI_D()
  {}  

  public void init(double startPosition_)
  {
    startPosition = startPosition_;
    integralValue = 0;
    pastTime = System.currentTimeMillis();
    pastPosition = 0;
  }

    public double move(double angle, double rotationsTraveled_) 
    {
        double rotationsNeeded = 8192 * (angle / 360);
        rotationsTraveled = rotationsTraveled_ - startPosition;
        long currentTime = System.currentTimeMillis();
        double deltaTime = currentTime - pastTime;
        double deltaPosition = rotationsTraveled - pastPosition;
        double error =  rotationsTraveled - rotationsNeeded;
        double pFactor = .0006;
        double iFactor = .00002;
        double dFactor = 0.06;
        double velocity = deltaPosition / deltaTime;
        integralValue += error;
        System.out.println("clicks traveled: " + rotationsTraveled);
        System.out.println("rotations needed: " + rotationsNeeded);
        System.out.println("integral Value: " + integralValue);
        System.out.println("Velocity: " + velocity);
        double power = error * pFactor + integralValue * iFactor + velocity * dFactor;
        pastTime = currentTime;
        pastPosition = rotationsTraveled;
        return power;
    }
}