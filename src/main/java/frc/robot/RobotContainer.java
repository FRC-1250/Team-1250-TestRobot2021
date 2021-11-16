// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ClawCatch;
import frc.robot.commands.ClawClose;
import frc.robot.commands.ClawOpen;
import frc.robot.commands.ClawRelease;
import frc.robot.commands.ClawStop;
import frc.robot.commands.DriveAllGo;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Claw m_claw = new Claw();
  private Joystick driverJoystick = new Joystick(0);
  JoystickButton driverXButton = new JoystickButton(driverJoystick, Constants.X_BUTTON);
  JoystickButton driverYButton = new JoystickButton(driverJoystick, Constants.Y_BUTTON);
  JoystickButton driverAButton = new JoystickButton(driverJoystick, Constants.A_BUTTON);
  JoystickButton driverBButton = new JoystickButton(driverJoystick, Constants.B_BUTTON);
  JoystickButton driverBackButton = new JoystickButton(driverJoystick, Constants.BACK_BUTTON);
  JoystickButton driverStartButton = new JoystickButton(driverJoystick, Constants.START_BUTTON);
  JoystickButton driverLeftBumper = new JoystickButton(driverJoystick, Constants.LEFT_BUMPER);
  JoystickButton driverRightBumper = new JoystickButton(driverJoystick, Constants.RIGHT_BUMPER);
  JoystickButton driverLeftTrigger = new JoystickButton(driverJoystick, Constants.LEFT_TRIGEER);
  JoystickButton driverRightTrigger = new JoystickButton(driverJoystick, Constants.RIGHT_TRIGGER);
  JoystickButton driverLeftStickClick = new JoystickButton(driverJoystick, Constants.LEFT_STICK_CLICK);
  JoystickButton driverRightStickClick = new JoystickButton(driverJoystick, Constants.RIGHT_STICK_CLICK);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_drivetrain.setDefaultCommand(new DriveAllGo(m_drivetrain, driverJoystick));
    driverRightTrigger.whileActiveOnce(new ClawStop(m_claw));
    driverYButton.whileActiveOnce(new ClawCatch(m_claw));
    driverAButton.whileActiveOnce(new ClawRelease(m_claw));
    driverXButton.whileActiveOnce(new ClawOpen(m_claw));
    driverBButton.whileActiveOnce(new ClawClose(m_claw));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
