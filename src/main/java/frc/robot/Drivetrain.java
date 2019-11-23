package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drivetrain
{
    TalonSRX leftMotor1 = new TalonSRX(4);
    TalonSRX leftMotor2 = new TalonSRX(5);
    TalonSRX RightMotor1 = new TalonSRX(6);
    TalonSRX RightMotor2 = new TalonSRX(7);

    public void tankDrive (double leftPower, double rightPower)
    {
        leftMotor1.set(ControlMode.PercentOutput, leftPower);
        RightMotor1.set(ControlMode.PercentOutput, -rightPower);
        leftMotor2.set(ControlMode.PercentOutput, leftPower);
        RightMotor2.set(ControlMode.PercentOutput, -rightPower);
    }

    public void arcadeDrive (double drivePower, double turnPower)
    {

        tankDrive(drivePower*turnPower, drivePower*(1-turnPower));
    }
}