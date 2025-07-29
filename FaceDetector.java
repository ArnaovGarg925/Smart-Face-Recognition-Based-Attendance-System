import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetector {
    public static void startCamera() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera = new VideoCapture(0);
        CascadeClassifier faceDetector = new CascadeClassifier("resources/haarcascade_frontalface.xml");

        Mat frame = new Mat();
        while (camera.read(frame)) {
            MatOfRect faces = new MatOfRect();
            faceDetector.detectMultiScale(frame, faces);
            for (Rect rect : faces.toArray()) {
                System.out.println("Face detected at: " + rect.toString());
                AttendanceLogger.log("Student123"); // Simulated ID
            }
        }
        camera.release();
    }
}
