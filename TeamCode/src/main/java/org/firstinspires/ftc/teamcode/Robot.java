package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Robot {
//    private DcMotorEx motorFrontRight;
//    private DcMotorEx motorFrontLeft;
//    private DcMotorEx motorBackRight;
//    private DcMotorEx motorBackLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorFrontLeft;
    private DcMotor motorBackRight;
    private DcMotor motorBackLeft;
//    private DcMotor arm;

    public Robot() {
//        Extended dcmotor
//        motorFrontRight = (DcMotorEx) hardwareMap.dcMotor.get("motor front right");
//        motorFrontLeft = (DcMotorEx) hardwareMap.dcMotor.get("motor front left");
//        motorBackLeft = (DcMotorEx) hardwareMap.dcMotor.get("motor back left");
//        motorBackRight = (DcMotorEx) hardwareMap.dcMotor.get("motor back right");
        motorFrontRight = hardwareMap.dcMotor.get("motor front right");
        motorFrontLeft = hardwareMap.dcMotor.get("motor front left");
        motorBackLeft = hardwareMap.dcMotor.get("motor back left");
        motorBackRight = hardwareMap.dcMotor.get("motor back right");
//        arm = hardwareMap.dcMotor.get("arm motor");
        // initialization is complete
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    // adjust the motor power for driving on controller
    public void setDriverMotorPower(double FRightPower, double FLeftPower, double BRightPower, double BLeftPower) {
        motorFrontRight.setPower(FRightPower);
        motorFrontLeft.setPower(FLeftPower);
        motorBackLeft.setPower(BLeftPower);
        motorBackRight.setPower(BRightPower);
    }

//    public void setArmSpeed(double speed) {
//        arm.setPower(speed);
//    }
}
