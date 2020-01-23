/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class DefaultDrive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveSubsystem m_drive;
  private final DoubleSupplier m_move;
  private final DoubleSupplier m_rotate;

  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The subsystem used by this command.
   * @param move The control input for driving forwards/backwards
   * @param rotate The control input for turning
   */
  public DefaultDrive(DriveSubsystem subsystem, DoubleSupplier move, DoubleSupplier rotate) {
    m_drive = subsystem;
    m_move = move;
    m_rotate = rotate;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
  }

  /*
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  */

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_move.getAsDouble(), m_rotate.getAsDouble());
  }

  /*
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  */

}
