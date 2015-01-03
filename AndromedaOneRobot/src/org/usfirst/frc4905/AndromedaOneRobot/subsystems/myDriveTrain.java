// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4905.AndromedaOneRobot.subsystems;

import org.usfirst.frc4905.AndromedaOneRobot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4905.AndromedaOneRobot.commands.*;

/**
 *
 */
public class myDriveTrain extends Subsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	SpeedController rightMotor_Controller = RobotMap.myDriveTrainRightMotor_Controller;
	SpeedController leftMotor_Controller = RobotMap.myDriveTrainLeftMotor_Controller;
	RobotDrive myRobotDrive = RobotMap.myDriveTrainmyRobotDrive;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		setDefaultCommand(new myArcadeDrive());
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void driveRobot(Joystick gamePad)
	{
		double leftStick_speed = gamePad.getRawAxis(2);
		double rightStick_speed = gamePad.getRawAxis(4);

		if (Math.abs(leftStick_speed) < 0.1)
			leftStick_speed = 0.0;
		if (Math.abs(rightStick_speed) < 0.1)
			rightStick_speed = 0.0;

		// myRobotDrive.arcadeDrive(gamePad);
		// myRobotDrive.arcadeDrive(gamePad,2,gamePad,4);
		// myRobotDrive.arcadeDrive(-1.0*leftStick_speed,-1.0*rightStick_speed);
		myRobotDrive.arcadeDrive(leftStick_speed, rightStick_speed);
	}

	public void driveStraight(double speed)
	{
		myRobotDrive.tankDrive(speed, speed);
	}

	public void turnAround()
	{
		myRobotDrive.arcadeDrive(0.0, 0.8);
		Timer.delay(1.3);
		driveStraight(0.0);
	}

	public void rotate()
	{
		myRobotDrive.tankDrive(-1.0, 1.0);
		Timer.delay(0.1);
		driveStraight(0.0);
	}
}
