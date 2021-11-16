// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

  WPI_TalonFX driveMotorLeft = new WPI_TalonFX(0);
  CANSparkMax ClawLeft = new CANSparkMax(0, MotorType.kBrushless);


  public void publicVoidMethodWithNoParameters() {
    // I am accessible anywhere but do not return any values
  }

  private void privateVoidMethidWithNoParameters() {
    // I am only accessible within the class I am written in
  }


  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
