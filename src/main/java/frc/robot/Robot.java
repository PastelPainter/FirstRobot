/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DrivetrainMove;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gripper;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private Drivetrain drivetrain;
  public static Gripper gripper;
  public static Elevator elevator;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    SpeedControllerGroup leftController = new SpeedControllerGroup(new WPI_VictorSPX(RobotMap.CAN.LEFT_TALON_1),
            new WPI_VictorSPX(RobotMap.CAN.LEFT_VICTOR_2));
    SpeedControllerGroup rightController = new SpeedControllerGroup(new WPI_VictorSPX (RobotMap.CAN.RIGHT_TALON_3),
            new WPI_VictorSPX(RobotMap.CAN.RIGHT_VICTOR_4));

    drivetrain = new Drivetrain(leftController, rightController);
    gripper = new Gripper(new WPI_VictorSPX(RobotMap.CAN.GRIPPER_LEFT_5), new WPI_VictorSPX(RobotMap.CAN.GRIPPER_RIGHT_6), new DigitalInput(RobotMap.DIO.GRIPPER_LIMIT_1));
    elevator = new Elevator(new WPI_VictorSPX(RobotMap.CAN.ELEVATOR_1), new WPI_VictorSPX(RobotMap.CAN.ELEVATOR_2),
            new WPI_TalonSRX(RobotMap.CAN.ELEVATOR_3), new DigitalInput(RobotMap.DIO.ELEVATOR_BOTTOM), new DigitalInput(RobotMap.DIO.ELEVATOR_UP));

    OI oi = new OI();
    drivetrain.setDefaultCommand(new DrivetrainMove(oi::getLeftJoystickY, oi::getLeftJoystickY, drivetrain));
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
