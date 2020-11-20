/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.GripperMove;
import frc.robot.commands.GripperRelease;
import frc.robot.subsystems.Gripper;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class OI {
    private Joystick leftJoystick = new Joystick(0);
    private Joystick rightJoystick = new Joystick(1);
    private JoystickButton gripperIn = new JoystickButton(leftJoystick, 0);
    private JoystickButton gripperOut = new JoystickButton(leftJoystick, 1);

    public double getLeftJoystickX() {
        return leftJoystick.getX();
    }
    public double getLeftJoystickY() {
        return -leftJoystick.getY();
    }
    public double getRightJoystickX() {
        return rightJoystick.getX();
    }
    public double getRightJoystickY() {
        return -rightJoystick.getY();
    }

    public OI() {
        gripperIn.whileHeld(new GripperMove(Robot.gripper, Gripper.IN_SPEED));
        gripperOut.whileHeld(new GripperRelease(Robot.gripper, Gripper.IN_SPEED));
    }
}
