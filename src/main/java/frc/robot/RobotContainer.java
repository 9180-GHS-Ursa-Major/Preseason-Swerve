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
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ArmSubsystem;


public class RobotContainer {

  public RobotBase<SwerveDrivetrain> robotBase = Constants.robotBase.create().shuffleboard();

  private final EnhancedXboxController driverController = new EnhancedXboxController(0)
                                                              .setLeftInverted(false)
                                                              .setRightInverted(false)
                                                              .setLeftSlewrate(1.5)
                                                              .setSticksDeadzone(0.05);
  public RobotContainer() {

    robotBase.getDrivetrain().shuffleboard("DriveTrain"); 
    robotBase.getDrivetrain().setDriveCommand(driverController);
    configureBindings();
  }

  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final ArmSubsystem arm = new ArmSubsystem();

// CONTROLLER BINDINGS
  private void configureBindings() {
    
    driverController.start.onTrue(() -> robotBase.getDrivetrain().getIMU().setYaw(0));

  //BINDINGS FOR INTAKE SUBSYSTEM
    driverController.a.whileTrue(intake.run(() -> intake.setSpeed(0.25))).onFalse(intake.runOnce(intake::stop));
    driverController.b.whileTrue(intake.run(() -> intake.setSpeed(-0.25))).onFalse(intake.runOnce(intake::stop));

  //BINDINGS FOR ARM SUBSYSTEM
    driverController.pov.right.whileTrue(arm.run(() -> arm.setSpeed(0.25))).onFalse(arm.runOnce(arm::stop));
    driverController.pov.left.whileTrue(arm.run(() -> arm.setSpeed(-0.25))).onFalse(arm.runOnce(arm::stop));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
