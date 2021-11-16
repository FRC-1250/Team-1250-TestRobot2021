// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class elevator extends SubsystemBase {
  CANSparkMax driveMotor = new CANSparkMax(1, MotorType.kBrushless);
  /** Creates a new elevator. */
  public elevator() {
    driveMotor.setIdleMode(IdleMode.kCoast);
  }
public void Up() {
  driveMotor.set(-0.1);
}
public void Down() {
  driveMotor.set(0.1);
}
public void Stop() {
  driveMotor.set(0);
}
public double GetTicks() {
  return driveMotor.getEncoder().getPosition();
}
  @Override
  public void periodic() {
    SmartDashboard.setDefaultNumber("Ticks", GetTicks());
    // This method will be called once per scheduler run
  }
}
