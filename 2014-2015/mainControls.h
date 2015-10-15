void allForward()
{
	motor[backLeft] = 100;
	motor[backRight] = 100;
}

void turnRight()
{
	motor[backLeft] = 100;
	motor[backRight] = -100;
}

void turnLeft()
{
	motor[backLeft] = -100;
	motor[backRight] = 100;
}

void allBackwards()
{
	motor[backLeft] = -100;
	motor[backRight] = -100;
}
