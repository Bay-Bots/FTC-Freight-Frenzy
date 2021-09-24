package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

// Game pad routing docs for reference: https://ftctechnh.github.io/ftc_app/doc/javadoc/com/qualcomm/robotcore/hardware/Gamepad.html

@TeleOp(name="DriverControl")
public class DriverControl extends OpMode {
    Robot Driver;

    @Override
    public void init() {
        Driver = new Robot();
    }

    @Override
    public void loop() {
        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;

        float FrontRight = -gamepad1LeftY + gamepad1LeftX + gamepad1RightX;
        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackRight = -gamepad1LeftY - gamepad1LeftX + gamepad1RightX;

        FrontRight = Range.clip(FrontRight, -1, 1);
        FrontLeft = Range.clip(FrontLeft, -1, 1);
        BackRight = Range.clip(BackRight, -1, 1);
        BackLeft = Range.clip(BackLeft, -1, 1);

        Driver.setDriverMotorPower(FrontRight, FrontLeft, BackRight, BackLeft);
    }
}