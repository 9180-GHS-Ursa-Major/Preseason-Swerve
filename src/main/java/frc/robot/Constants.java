package frc.robot;

import ca.frc6390.athena.core.RobotBase;
import ca.frc6390.athena.core.RobotBase.RobotBaseConfig;
import ca.frc6390.athena.devices.EncoderConfig.EncoderType;
import ca.frc6390.athena.devices.IMU.IMUType;
import ca.frc6390.athena.devices.MotorController.Motor;
import ca.frc6390.athena.drivetrains.swerve.SwerveDrivetrain;
import ca.frc6390.athena.drivetrains.swerve.SwerveDrivetrainConfig;
import ca.frc6390.athena.drivetrains.swerve.modules.SwerveVendorSDS;
import edu.wpi.first.math.util.Units;

public class Constants {


        public static double[] ENCODER_OFFSETS = {0.8618,0.03125,0.2199,0.9601};

        public static SwerveDrivetrainConfig DRIVETRAIN_CONFIG = SwerveDrivetrainConfig.defualt(Units.inchesToMeters(19))
                                                    .setIMU(IMUType.CTREPigeon2, false)
                                                    .setIMUId(13)
                                                    .setDriveIds(new int[]{4,5,1,7}) //FL FR BL BR
                                                    .setSteerIds(new int[]{6,3,2,8})
                                                    .setEncoderIds(new int[]{12,9,11,10})
                                                    .modules(
                                                        SwerveVendorSDS.MK3.STANDARD.config(Motor.FALCON_500,EncoderType.CTRECANcoder).setP(0.45),
                                                        SwerveVendorSDS.MK3.STANDARD.config(Motor.FALCON_500,EncoderType.CTRECANcoder).setP(0.45),
                                                        SwerveVendorSDS.MK3.STANDARD.config(Motor.FALCON_500,EncoderType.CTRECANcoder).setP(0.45),
                                                        SwerveVendorSDS.MK3.STANDARD.config(Motor.FALCON_500,EncoderType.CTRECANcoder).setP(0.45)
                                                        ) 
                                                    .setSteerInverted(false)  
                                                    .setEncoderOffset(ENCODER_OFFSETS)                                                    
                                                    .setCurrentLimit(60);

        public static RobotBaseConfig<SwerveDrivetrain> robotBase = RobotBaseConfig.swerve(DRIVETRAIN_CONFIG);
}


