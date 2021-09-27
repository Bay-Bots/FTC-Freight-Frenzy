package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// Game pad routing docs for reference: https://ftctechnh.github.io/ftc_app/doc/javadoc/com/qualcomm/robotcore/hardware/Gamepad.html

@TeleOp(name="DriverControl")
public class DriverControl extends RobotStruct {
    @Override
    public void loop() {
        double speed = gamepad1.right_trigger - gamepad1.left_trigger;
        double turn = gamepad1.left_stick_x;
        double armSpeed = gamepad1.right_stick_x;

        setDriverMotorPower(speed - turn, speed + turn, speed - turn, speed + turn);
//        Driver.setArmSpeed(armSpeed);

    }
}