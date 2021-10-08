package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// Game pad routing docs for reference: https://ftctechnh.github.io/ftc_app/doc/javadoc/com/qualcomm/robotcore/hardware/Gamepad.html

@TeleOp(name="DriverControl")
public class DriverControl extends RobotStruct {
    @Override
    public void loop() {
        double speed = gamepad1.right_trigger - gamepad1.left_trigger;
        double turn = gamepad1.left_stick_x;
        double armSpeed = gamepad1.right_stick_y;

        setDriverMotorPower(speed - turn, speed + turn, speed - turn, speed + turn);
        setArmSpeed(armSpeed);

        if(gamepad1.x){
            // get the current (in amps) from the arm motor
            sendAmpReading();
        }
    }
}