package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  TalonSRX motor1;
  TalonSRX motor2;
  Joystick joy = new Joystick(0);
  //SmoothAcceleration loopObj = new SmoothAcceleration(.01);
  Acceleration accelerate = new Acceleration();
  double speed;
  //long pastTime = System.currentTimeMillis();
  Encoder encoder= new Encoder(3, 4);
  PI_D pid = new PI_D();

  @Override
  public void robotInit() {
    motor1 = new TalonSRX(1);
    motor2 = new TalonSRX(2);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    pid.init(encoder.get());
  }

  @Override
  public void teleopPeriodic() {
    if (joy.getRawButton(3))
    {
      motor1.set(ControlMode.PercentOutput, pid.move(45, encoder.get()));
    }
    else
    {
      motor1.set(ControlMode.PercentOutput, pid.move(0, encoder.get()));
    }

    if (joy.getRawButton(1))
    {
      speed = accelerate.getAccel(0.7);
      System.out.println(speed);
    }
    else
    {
      speed = accelerate.getAccel(0);
    }
    motor2.set(ControlMode.PercentOutput, speed); 
  }

  @Override
  public void testPeriodic() {
  }

}
