package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;

public class Robot {
    private DcMotor motorFrontRight;
    private DcMotor motorFrontLeft;
    private DcMotor motorBackRight;
    private DcMotor motorBackLeft;

    public Robot() {
        motorFrontRight = hardwareMap.dcMotor.get("motor front right");
        motorFrontLeft = hardwareMap.dcMotor.get("motor front left");
        motorBackLeft = hardwareMap.dcMotor.get("motor back left");
        motorBackRight = hardwareMap.dcMotor.get("motor back right");
        // initialization is complete
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    // adjust the motor power for driving on controller
    public void setDriverMotorPower(float FRightPower, float FLeftPower, float BRightPower, float BLeftPower) {
        this.motorFrontRight.setPower(FRightPower);
        this.motorFrontLeft.setPower(FLeftPower);
        this.motorBackLeft.setPower(BLeftPower);
        this.motorBackRight.setPower(BRightPower);
    }
}
