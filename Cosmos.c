#pragma config(Hubs,  S1, HTMotor,  none,     none,     none)
#pragma config(Hubs,  S2, HTMotor,  none,     none,     none)
#pragma config(Sensor, S1,     ,               sensorI2CMuxController)
#pragma config(Sensor, S2,     ,               sensorI2CMuxController)
#pragma config(Motor,  mtr_S1_C1_1,     FLMotor,       tmotorTetrix, openLoop, reversed)
#pragma config(Motor,  mtr_S1_C1_2,     FRMotor,       tmotorTetrix, openLoop)
#pragma config(Motor,  mtr_S2_C1_1,     BLMotor,       tmotorTetrix, openLoop, reversed)
#pragma config(Motor,  mtr_S2_C1_2,     BRMotor,       tmotorTetrix, openLoop)

#include "JoystickDriver.c"
#pragma DebuggerWindows("joystickSimple")

task main()
{
	while(1 == 1)
	{
		getJoystickSettings(joystick);
		motor[FLMotor] = joystick.joy1_y1;
		motor[BLMotor] = joystick.joy1_y1;
		motor[FRMotor] = joystick.joy1_y2;
		motor[BRMotor] = joystick.joy1_y2;
	}
}
