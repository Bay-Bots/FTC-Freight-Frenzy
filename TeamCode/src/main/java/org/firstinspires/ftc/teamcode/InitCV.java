package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

public class InitCV {
    private OpenCvInternalCamera phoneCam;

    public void init(DuckDetector detector, int id) {
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, id);
        phoneCam.setPipeline(detector);
//        check this next line when debugging
        phoneCam.setFlashlightEnabled(true);
        phoneCam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                phoneCam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

           @Override
           public void onError(int errorCode) {

           }
        });

//        telemetry.addData("Camera ", "Initialized");
    }

    public void stopStream() {
        phoneCam.stopStreaming();
    }
}
