// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import ca.frc6390.athena.controllers.EnhancedXboxController;
import ca.frc6390.athena.core.RobotBase;
import ca.frc6390.athena.core.RobotSendableSystem.SendableLevel;
import ca.frc6390.athena.drivetrains.swerve.SwerveDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {

  public RobotBase<SwerveDrivetrain> robotBase = Constants.robotBase.create();

  private final EnhancedXboxController driverController = new EnhancedXboxController(0)
                                                              .setLeftInverted(false)
                                                              .setRightInverted(false)
                                                              .setLeftSlewrate(0.8)
                                                              .setSticksDeadzone(0.05);
  public RobotContainer() {

    robotBase.getDrivetrain().shuffleboard("DriveTrain"); 
    robotBase.getDrivetrain().setDriveCommand(driverController);
    configureBindings();
  }

  private void configureBindings() {
    
    driverController.start.onTrue(() -> robotBase.getDrivetrain().getIMU().setYaw(0));


  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
