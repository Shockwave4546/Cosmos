package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Will Marchesi on 10/22/2015.
 */
public class TankOpMode extends OpMode{

    DcMotor motorFrontLeft;
    DcMotor motorFrontRight;
    DcMotor motorBackLeft;
    DcMotor motorBackRight;

    public TankOpMode() {

    }

    @Override
    public void init() {

        motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get("motorFrontLeft");
        motorBackLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        motorBackRight = hardwareMap.dcMotor.get("motorFrontLeft");

    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float leftX = gamepad1.left_stick_x;
        float rightY = -gamepad1.right_stick_y;
        float rightX = gamepad1.right_stick_x;

        leftY = Range.clip(leftY, -1, 1);
        leftX = Range.clip(leftX, -1, 1);
        rightY = Range.clip(rightY, -1, 1);
        rightX = Range.clip(rightX, -1, 1);

        leftY = (float)scaleInput(leftY);
        leftX = (float)scaleInput(leftX);
        rightY =  (float)scaleInput(rightY);
        rightX =  (float)scaleInput(rightX);

        telemetry.addData("Text", "*** Robot Data ***");
        telemetry.addData("leftX", "LeftX" + leftX);
        telemetry.addData("leftY", "LeftY" + leftY);
        telemetry.addData("rightX", "RightX" + rightX);
        telemetry.addData("rightY", "RightY" + rightY);
    }

    @Override
    public void stop() {

    }

    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }

}
