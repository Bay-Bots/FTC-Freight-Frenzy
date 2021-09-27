package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TestRunner")
public class TestRun extends OpMode
{
    // Declare OpMode members.
    DcMotor motorFrontRight;
    DcMotor motorFrontLeft;
    DcMotor motorBackRight;
    DcMotor motorBackLeft;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        motorFrontRight = hardwareMap.dcMotor.get("motor front right");
        motorFrontLeft = hardwareMap.dcMotor.get("motor front left");
        motorBackLeft = hardwareMap.dcMotor.get("motor back left");
        motorBackRight = hardwareMap.dcMotor.get("motor back right");
        // Leo's reversal
        motorBackRight.setDirection(DcMotor.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotor.Direction.REVERSE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {

        // left stick controls direction
        // right stick X controls rotation

        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;
        float gamepad2RightY = gamepad2.right_stick_y;
        float gamepad2LeftY = gamepad2.left_stick_y;




        // holonomic formulas
        /*
        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        */
        //Leo's mecanum formulas
        float FrontRight = -gamepad1LeftY + gamepad1LeftX + gamepad1RightX;
        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackRight = -gamepad1LeftY - gamepad1LeftX + gamepad1RightX;


        float FrontLift = -gamepad2RightY;
        float LeftDrag =  gamepad2LeftY;
        float RightDrag = gamepad2LeftY;

        // clip the right/left values so that the values never exceed +/- 1
        FrontRight = Range.clip(FrontRight, -1, 1);
        FrontLeft = Range.clip(FrontLeft, -1, 1);
        BackLeft = Range.clip(BackLeft, -1, 1);
        BackRight = Range.clip(BackRight, -1, 1);


        // write the values to the motors
        motorFrontRight.setPower(FrontRight);
        motorFrontLeft.setPower(FrontLeft);
        motorBackLeft.setPower(BackLeft);
        motorBackRight.setPower(BackRight);


        /*
        if (gamepad2.x) {               //open doors
            servoDoor1.setPosition(.65);
            servoDoor2.setPosition(.12);
        }
        //capstone is b
        if(gamepad2.b) {                    //close doors longways
            servoDoor1.setPosition(.65);
            servoDoor2.setPosition(.15);
        }
        if(gamepad2.a) {                    //close doors smaller
            servoDoor1.setPosition(.25);
            servoDoor2.setPosition(.55);
        }
        if(gamepad1.x) {                //lower fork
            servoDoor3.setPosition(.7);
        }
        if(gamepad1.y) {
            servoDoor3.setPosition(.1);     //raise fork
        */

    }
}