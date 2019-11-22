package frc.robot;

public class Acceleration {
    public double accelFactor = 0.06;
    public double currentAccel = 0;
    public double startValue = 0.05;

    //accelerates wheel based off of desired value and designated acceleration factors
    public double getAccel(double desired) {
        //will immediately set to valid startValue, set to overcome friction
        if(currentAccel<startValue && currentAccel>-startValue && desired>startValue) {
            currentAccel = startValue;
        }
        else if(currentAccel>-startValue && currentAccel<startValue && desired<-startValue) {
            currentAccel = -startValue;
        } 
        else if(currentAccel < desired) {
            currentAccel += accelFactor;
        }
        else if(currentAccel > desired) {
            currentAccel -= accelFactor;
        }

        return currentAccel;
    }
}