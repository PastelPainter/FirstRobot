package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Gripper;

import java.util.function.Supplier;

public class GripperRelease extends CommandBase {
    private Gripper gripper;
    private double motorSpeed;

    public GripperRelease(Gripper gripper, Supplier<Double> motorSpeed) {
        this.gripper = gripper;
        addRequirements(gripper);
    }

    @Override
    public void execute() {
        gripper.moveMotor(-motorSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        gripper.stop();
    }

    @Override
    public boolean isFinished() {
        return gripper.getLimitSwitch();
    }
}
