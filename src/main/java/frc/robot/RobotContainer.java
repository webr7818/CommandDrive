/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.DriveSubsystem;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem roboDrive = new DriveSubsystem();

  // A chooser for autonomous commands
  //SendableChooser<Command> m_chooser = new SendableChooser<>();

  // The driver's controller
  Joystick ps4 = new Joystick(OIConstants.ps4port);

  // Move variable
  DoubleSupplier move = () -> ps4.getRawAxis(OIConstants.kRightTriggerAxis) - ps4.getRawAxis(OIConstants.kLeftTriggerAxis);

  // Rotate variable
  DoubleSupplier rotate = () -> ps4.getX(Hand.kLeft);

  // Setting up DefaultDrive
  DefaultDrive defaultDrive = new DefaultDrive(roboDrive, move, rotate);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    roboDrive.setDefaultCommand(defaultDrive);

    // Add commands to the autonomous command chooser
    //m_chooser.addOption("@AutonomousCommandName", @AutonomousCommand);

    // Put the chooser on the dashboard
    //Shuffleboard.getTab("Autonomous").add(m_chooser);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //new JoystickButton(ps4, OIConstants.kSquareButton).whenHeld(command);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   *
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */

}
