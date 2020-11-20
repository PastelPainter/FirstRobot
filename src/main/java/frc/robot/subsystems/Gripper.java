package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class Gripper extends SubsystemBase {

    private SpeedController motor2;
    private SpeedController motor1;
    private DigitalInput limitSwitch;
    public static final Supplier<Double> IN_SPEED = () -> 0.5;

    public Gripper(SpeedController motor1, SpeedController motor2, DigitalInput limitSwitch) {
        this.motor1 = motor1;
        this.motor2 = motor2;
        this.motor2.setInverted(true);
        this.limitSwitch = limitSwitch;
    }

    public boolean getLimitSwitch() {
        return limitSwitch.get();
    }

    public void moveMotor(double motorSpeed) {
        if (motorSpeed >= 0 && !getLimitSwitch()) {
            motor1.set(motorSpeed);
            motor2.set(motorSpeed);
            motor2.setInverted(true);
        } else {
            stop();
        }
    }

    public void stop() {
        motor1.stopMotor();
        motor2.stopMotor();
    }
}
