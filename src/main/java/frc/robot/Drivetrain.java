package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drivetrain
{
    TalonSRX leftMotor1 = new TalonSRX(4);

    public void tankDrive ()
    {
        leftMotor1.set(ControlMode.PercentOutput, 0.5);
    }
}