// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */

  CANSparkMax ClawLeft = new CANSparkMax(11, MotorType.kBrushless);
  CANSparkMax ClawRight = new CANSparkMax(10, MotorType.kBrushless);
  Solenoid ClawSolenoid = new Solenoid(0);
  public Claw() {
  }

  public void Catch() {
    ClawLeft.set(-.5);
    ClawRight.set(.5);
  }

  public void Release() {
    ClawRight.set(-.5);
    ClawLeft.set(.5);
  }

  public void Stop() {
    ClawLeft.set(0);
    ClawRight.set(0);
  }
 public void Open(){
   ClawSolenoid.set(true);
 }
 public void Close(){
   ClawSolenoid.set(false);
 }
  @Override 
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
