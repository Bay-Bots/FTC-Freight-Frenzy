package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/*******************************************************************
 *     ___   __  ____________  _   ______  __  _______  __  _______ *
 *    /   | / / / /_  __/ __ \/ | / / __ \/  |/  / __ \/ / / / ___/ *
 *   / /| |/ / / / / / / / / /  |/ / / / / /|_/ / / / / / / /\__ \  *
 *  / ___ / /_/ / / / / /_/ / /|  / /_/ / /  / / /_/ / /_/ /___/ /  *
 * /_/  |_\____/ /_/  \____/_/ |_/\____/_/  /_/\____/\____//____/   *
 *******************************************************************/

@Autonomous(name="AutoBot")
public class AutoBot extends AutoRobotStruct {
    InitCV AutoCVCMD;
    DuckDetector duckVision = new DuckDetector();
    String position;

    @Override
    public void runOpMode() throws InterruptedException {
        initRunner();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        AutoCVCMD = new InitCV();
        AutoCVCMD.init(duckVision, cameraMonitorViewId);

        while(!isStarted()){
            detect();
            position = duckVision.getLoc();
        }

        waitForStart();
        AutoCVCMD.stopStream();

//        Auto.setDriverMotorPower(-5, 0, 0, 5);
//        sleep(500);
    }

    public void detect(){
        if (position.equals("LEFT")) {
            telemetry.addData("Position: ", "LEFT");
            telemetry.update();
        } else if (position.equals("RIGHT")) {
            telemetry.addData("Position: ", "RIGHT");
            telemetry.update();
        } else if (position.equals("MIDDLE")) {
            telemetry.addData("Position: ", "MIDDlE");
            telemetry.update();
        } else {
            telemetry.addData("Position: ", "NOT FOUND");
            telemetry.update();
        }
    }
}
