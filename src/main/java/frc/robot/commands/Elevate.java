package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

import java.util.function.Supplier;

public class Elevate extends CommandBase {
    private Elevator elevator;

    private Supplier<Double> setpoint;
    private PIDController pidController;
    private Supplier<Double> kP, kI, kD;
    private Supplier<Double> tolerance;
    private Supplier<Double> source;


    public Elevate(Elevator elevator, Supplier<Double> setpoint, Supplier<Double> kP, Supplier<Double> kI, Supplier<Double> kD, Supplier<Double> tolerance, Supplier<Double> source) {
        this.elevator = elevator;
        addRequirements(elevator);

        this.setpoint = setpoint;
        this.pidController = new PIDController(kP.get(), kI.get(), kD.get());
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.tolerance = tolerance;
        this.source = source;
    }

    @Override
    public void execute() {
        pidController.setPID(kP.get(), kI.get(), kD.get());
        pidController.setTolerance(tolerance.get());
        double pidOut = pidController.calculate(source.get(), setpoint.get());
        elevator.elevate(pidOut);
    }

    @Override
    public void end(boolean interrupted) {
        elevator.stop();
    }
}
