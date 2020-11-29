package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

import java.util.function.Supplier;

public class Elevator extends SubsystemBase {

    private Elevator elevator;
    public DigitalInput limitSwitchUp;
    public DigitalInput limitSwitchBottom;

    private boolean wasUpLimitPressed;
    private boolean wasBottomLimitPressed;

    private int ballsAmount;
    private static final int MAXIMUM_BALLS_AMOUNT = 3;

    private WPI_TalonSRX talonSRX;
    private WPI_VictorSPX victorSPX1;
    private WPI_VictorSPX victorSPX2;

    public static final Supplier<Double> IN_SPEED = () -> 0.5;

    public Elevator(WPI_VictorSPX victorSPX1, WPI_VictorSPX victorSPX2, WPI_TalonSRX talonSRX, DigitalInput limitSwitchUp, DigitalInput limitSwitchBottom) {
        this.victorSPX1 = victorSPX1;
        this.victorSPX2 = victorSPX2;
        this.talonSRX = talonSRX;
        this.limitSwitchBottom = limitSwitchBottom;
        this.limitSwitchUp = limitSwitchUp;
    }
    public void elevate(double motorSpeed) {
        if (motorSpeed >= 0 && Robot.elevator.getBallsAmount() < Elevator.MAXIMUM_BALLS_AMOUNT) {
            talonSRX.set(motorSpeed);
            victorSPX1.set(motorSpeed);
            victorSPX2.set(motorSpeed);
        }
    }
    public void stop() {
        talonSRX.stopMotor();
        victorSPX1.stopMotor();
        victorSPX2.stopMotor();
    }

    public boolean getLimitSwitchUp() {
        return limitSwitchUp.get();
    }

    public boolean getLimitSwitchBottom() {
        return limitSwitchBottom.get();
    }

    public int getBallsAmount() {
        return ballsAmount;
    }

    @Override
    public void periodic() {
        if (limitSwitchBottom.get()) {
            if (!getLimitSwitchBottom()) {
                ballsAmount--;
            }
            wasUpLimitPressed = true;
        } else {
            wasUpLimitPressed = false;
        }
        if (getLimitSwitchUp()) {
            if (!wasBottomLimitPressed) {
                ballsAmount++;
            }
            wasBottomLimitPressed = true;
        } else {
            wasBottomLimitPressed = false;
        }
    }
}

