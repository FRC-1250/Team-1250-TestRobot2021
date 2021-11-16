// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveAllGo extends CommandBase {

  private final Drivetrain m_drivetrain;
  private final Joystick s_joystick;
  boolean tankDrive = true;

  /** Creates a new DriveTankGo. */
  public DriveAllGo(Drivetrain drivetrain, Joystick joystick) {
    m_drivetrain = drivetrain;
    s_joystick = joystick;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_drivetrain.dioCheck()) {
      //the button to toggle the half speed drive is A button but it might get changed later
      boolean toggleLatch = false;
      boolean aButtonStatus = s_joystick.getRawButton(2);




      if(s_joystick.getRawButton(2) == true){
        m_drivetrain.driveTank(-s_joystick.getRawAxis(1)*.5, -s_joystick.getRawAxis(3)*.5);
      }
      else{
        m_drivetrain.driveTank(-s_joystick.getRawAxis(1), -s_joystick.getRawAxis(3));
      }
    } else {
      m_drivetrain.driveArcade(-s_joystick.getY(), -s_joystick.getZ() * 0.8);
    }
  }

  // Called once the command ends or is interrupted
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
