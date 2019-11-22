package frc.robot;

public class SmoothAcceleration
{
    private double goalVel = 0;
    private double newSpeed = 0;
    private double rateOfIncrease; //System.currentTimeMillis();

    public SmoothAcceleration(double rateOfIncrease_)
    {
        rateOfIncrease = rateOfIncrease_;
    }
    public double loop(double desiredSpeed)
    {
        goalVel = desiredSpeed;
        
        if ((newSpeed + rateOfIncrease) <= goalVel)
        {
            newSpeed += rateOfIncrease;
        } 
        else if ((newSpeed + rateOfIncrease) >= goalVel)
        {
            newSpeed -= rateOfIncrease;
        }

        return newSpeed;
    }
}
