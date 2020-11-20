package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import java.util.function.Supplier;

public class DrivetrainMove  extends CommandBase {

    private Supplier<Double> leftSpeed;
    private Supplier<Double> rightSpeed;
    private Drivetrain drivetrain;

    public DrivetrainMove (Supplier<Double> leftSpeed, Supplier<Double> rightSpeed, Drivetrain drivetrain) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.moveTank(leftSpeed.get(), rightSpeed.get());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
