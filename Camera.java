package comm;

public class Camera {
    private final int megapixelSize;
    private final int zoomSize;
    private final float aperture;
    private final float focalLength;
    private final boolean isOISPresent;


    public Camera(int megapixelSize, int zoomSize, float aperture, float focalLength, boolean isOISPresent) {
        this.megapixelSize = megapixelSize;
        this.zoomSize = zoomSize;
        this.aperture = aperture;
        this.focalLength = focalLength;
        this.isOISPresent = isOISPresent;
    }

    protected void cameraOn()
    {

    }

    protected void cameraOff()
    {

    }

    protected void shutterPhoto()
    {

    }

    protected void startVideoRecording()
    {

    }

    protected void stopVideoRecording()
    {

    }
}