package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private SpeedController left;
    private SpeedController right;

    public Drivetrain(SpeedController left, SpeedController right) {
        this.left = left;
        this.right = right;
        this.left.setInverted(true);
    }
    public void moveTank (double leftSpeed, double rightSpeed) {
        left.set(leftSpeed);
        right.set(rightSpeed);
    }
    public void stop() {
        left.stopMotor();
        right.stopMoTor();
    }
}
