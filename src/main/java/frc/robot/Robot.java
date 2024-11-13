// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //Creating gyro member variable.
  AHRS ahrs = new AHRS(SPI.Port.kMXP); // TODO: Find actual port

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    //Initializing Shuffleboard
    initShuffleboard();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }

  private void initShuffleboard(){
    // Creating Shuffleboard tab
    ShuffleboardTab navXTab = Shuffleboard.getTab("NavX");
    // Creating Shuffleboard layouts
    ShuffleboardLayout angleLayout = navXTab.getLayout("Angles", BuiltInLayouts.kGrid).withSize(1, 3).withPosition(0, 0);
    ShuffleboardLayout accelLayout = navXTab.getLayout("Accelerations", BuiltInLayouts.kGrid).withSize(3, 3).withPosition(1, 0);

    //Adding Doubles to angle layout
    angleLayout.addDouble("Pitch", () -> ahrs.getPitch());
    angleLayout.addDouble("Yaw", () -> ahrs.getYaw());
    angleLayout.addDouble("Roll", () -> ahrs.getRoll());

    //Adding Doubles to accelerations layout
    accelLayout.addDouble("Acceleration", () -> ahrs.getAccelFullScaleRangeG());
    accelLayout.addDouble("X", () -> ahrs.getWorldLinearAccelX());
    accelLayout.addDouble("Y", () -> ahrs.getWorldLinearAccelY());
    accelLayout.addDouble("Z", () -> ahrs.getWorldLinearAccelZ());
  }
}
