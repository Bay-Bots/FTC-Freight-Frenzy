package org.firstinspires.ftc.teamcode;
import org.opencv.core.Core;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Mat;

public class DuckDetector extends OpenCvPipeline{
    double LEFT_value;
    double RIGHT_value;
    double MID_value;

    Mat mat = new Mat();

    public enum LOCATION {
        LEFT,
        RIGHT,
        MIDDLE,
        NF
    }

    private LOCATION location;

//  320, 240
    static final Rect LEFT_MAT = new Rect(
            new Point(60, 35),
            new Point(100, 75)
    );

    static final Rect MID_MAT = new Rect(
            new Point(120, 35),
            new Point(180, 75)
    );

    static final Rect RIGHT_MAT = new Rect(
            new Point(190, 35),
            new Point(220, 75)
    );

    final static double PCT = 0.40;

    Mat LEFT;
    Mat RIGHT;
    Mat MID;

    public DuckDetector() {}

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);

        final Scalar LOW_BOUND = new Scalar(23, 50, 70);
        final Scalar UPPER_BOUND = new Scalar(32, 255, 255);

        Core.inRange(mat, LOW_BOUND, UPPER_BOUND, mat);

        LEFT = mat.submat(LEFT_MAT);
        RIGHT = mat.submat(RIGHT_MAT);
        MID = mat.submat(MID_MAT);

        LEFT_value = Core.sumElems(LEFT).val[0] / LEFT_MAT.area() / 255;
        MID_value = Core.sumElems(MID).val[0] / MID_MAT.area() / 255;
        RIGHT_value = Core.sumElems(RIGHT).val[0] / RIGHT_MAT.area() / 255;

        LEFT.release();
        MID.release();
        RIGHT.release();

//        telemetry.addData("LEFT", (int) Core.sumElems(LEFT).val[0]);
//        telemetry.addData("RIGHT", (int) Core.sumElems(RIGHT).val[0]);
//
//        telemetry.addData("Percent conf. LEFT", Math.round(LEFT_value * 100) + "%");
//        telemetry.addData("Percent conf. RIGHT", Math.round(RIGHT_value * 100) + "%");

        boolean dl = LEFT_value > PCT;
        boolean dm = MID_value > PCT;
        boolean dr = RIGHT_value > PCT;

//        need to double check these conditions and what they find on the field
//        need to see if all of the locations can be found in this image

        if (dl) {
            location = LOCATION.LEFT;
        } else if (dr) {
            location = LOCATION.RIGHT;
        } else if (dm) {
            location = LOCATION.MIDDLE;
        } else {
            location = LOCATION.NF;
        }

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        Scalar duckLocationFound = new Scalar(0, 255, 0);
        Scalar duckNotFound = new Scalar(255, 0, 0);

        Imgproc.rectangle(mat, LEFT_MAT, location == LOCATION.LEFT ? duckLocationFound:duckNotFound);
        Imgproc.rectangle(mat, MID_MAT, location == LOCATION.MIDDLE ? duckLocationFound:duckNotFound);
        Imgproc.rectangle(mat, RIGHT_MAT, location == LOCATION.RIGHT ? duckLocationFound:duckNotFound);

        return mat;
    }

    public LOCATION getLoc() { return this.location; }

    public double[] getLR() {
        return new double[]{Core.sumElems(LEFT).val[0], Core.sumElems(MID).val[0], Core.sumElems(RIGHT).val[0]};
    }

    public Long[] getConf() {
        return new Long[]{Math.round(LEFT_value * 100), Math.round(MID_value * 100), Math.round(RIGHT_value * 100)};
    }
}