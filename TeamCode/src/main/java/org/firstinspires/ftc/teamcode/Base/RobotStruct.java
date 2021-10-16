package org.firstinspires.ftc.teamcode.Base;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class RobotStruct extends OpMode {
    DcMotor motorFrontRight;
    DcMotor motorFrontLeft;
    DcMotor motorBackRight;
    DcMotor motorBackLeft;
    DcMotor motorDuckDropper;
    DcMotorEx motorArm;
    DcMotorEx motorArmDuo;
    Servo servoClaw;

    @Override
    public void init() {
        motorFrontRight = hardwareMap.get(DcMotor.class, "motor front right");
        motorFrontLeft = hardwareMap.get(DcMotor.class, "motor front left");
        motorBackLeft = hardwareMap.get(DcMotor.class, "motor back left");
        motorBackRight = hardwareMap.get(DcMotor.class, "motor back right");
        motorDuckDropper = hardwareMap.get(DcMotor.class, "motor duck dropper");
        motorArm = hardwareMap.get(DcMotorEx.class, "motor arm");
        motorArmDuo = hardwareMap.get(DcMotorEx.class, "motor arm duo");
        servoClaw = hardwareMap.get(Servo.class, "servo claw");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {}

    public void setDriverMotorPower(double FRightPower, double FLeftPower, double BRightPower, double BLeftPower) {
        motorFrontRight.setPower(FRightPower);
        motorFrontLeft.setPower(FLeftPower);
        motorBackLeft.setPower(BLeftPower);
        motorBackRight.setPower(BRightPower);
    }

    public void setDuckDropperSpeed(double speed){ motorDuckDropper.setPower(speed); }

    public void setArmSpeed(double speed) {
        motorArm.setPower(speed);
        motorArmDuo.setPower(speed);
    }

    public void sendAmpReading() {
        telemetry.addData("Arm Current: ", motorArm.getCurrent(CurrentUnit.AMPS));
        telemetry.update();
    }

    public void setClawPos(double pos) {
        servoClaw.setPosition(pos);
    }
}
