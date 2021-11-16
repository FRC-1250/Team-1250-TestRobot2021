// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  WPI_TalonFX driveMotorLeft = new WPI_TalonFX(2);
  WPI_TalonFX driveMotorRight = new WPI_TalonFX(1);
  DifferentialDrive differentialDrive = new DifferentialDrive(driveMotorLeft, driveMotorRight);
  DigitalInput dioToggle = new DigitalInput(0);

  public Drivetrain() {

  }

  public boolean dioCheck() {
    return dioToggle.get();
  }

  public void driveTank(double left, double right) {
    differentialDrive.tankDrive(left, right);
  }

  public void driveArcade(double xSpeed, double zRotation) {
    differentialDrive.arcadeDrive(xSpeed, zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
