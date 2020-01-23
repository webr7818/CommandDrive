/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  // The motors on the left side of the drive.
  SpeedController kLeftMotor1 = new PWMVictorSPX(DriveConstants.kLeftMotor1port);
  SpeedController kLeftMotor2 = new PWMVictorSPX(DriveConstants.kLeftMotor2port);
  SpeedControllerGroup kLeft = new SpeedControllerGroup(kLeftMotor1, kLeftMotor2);
  
  // The motors on the right side of the drive.
  SpeedController kRightMotor1 = new PWMVictorSPX(DriveConstants.kRightMotor1port);
  SpeedController kRightMotor2 = new PWMVictorSPX(DriveConstants.kRightMortor2port);
  SpeedControllerGroup kRight = new SpeedControllerGroup(kRightMotor1, kRightMotor2);
  
  // The robot's drive
  DifferentialDrive kDrive = new DifferentialDrive(kLeft, kRight); 
  
  //public DriveSubsystem() {}

  public void arcadeDrive(double move, double rotate){
    kDrive.arcadeDrive(move, rotate);
  }

  //@Override
  //public void periodic() {}
}
