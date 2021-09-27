package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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

    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        DuckDetector duckVision = new DuckDetector();
        AutoCVCMD = new InitCV();
        AutoCVCMD.init(duckVision, cameraMonitorViewId);
        waitForStart();

//        telemetry.addData("Position: ", duckVision.getLoc());

        switch (duckVision.getLoc()) {
            case LEFT:
//                ...
                break;

            case RIGHT:
//                ...
                break;

            case NF:
//                ...
                break;
        }

        AutoCVCMD.stopStream();


//        Auto.setDriverMotorPower(-5, 0, 0, 5);
//        sleep(500);
    }
}
