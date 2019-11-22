package frc.robot;

public class Acceleration {
    public int ticks = 0;

    public double accelerateMethod(double desired)
    {
        ticks++;
        return desired*ticks*0.0001;
    }
}