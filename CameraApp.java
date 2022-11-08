package comm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



class CameraApp extends Application
{
    Scanner s = new Scanner(System.in);
    public CameraApp(String appName, double initialAppSize) {
        super(appName, initialAppSize);
    }
    private CameraSide cameraSide = CameraSide.REAR;
    private Camera currentCamera;

    private void captureImage()
    {
        System.out.print("Focus on the area where you want to capture the picture.\n Enter 0 to capture the picture:");
        if(s.nextInt()==0) {
            currentCamera.shutterPhoto();
            processor.processData("Process Photo");
            kernel.saveFile((double) (Math.round(Math.random() * 100)) / 10);
            System.out.println("Image has been saved");
        }
    }

    private void captureVideo()
    {
        System.out.println("Enter 0 to start capturing the video");
        System.out.println("Enter X to stop capturing the video");


        if(s.nextInt() == 0) {
            System.out.println("Recording started");
            currentCamera.startVideoRecording();
            kernel.mic.turnOnMic();
            LocalDateTime startTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String[] startTimeFormatted = formatter.format(startTime).split(":");
            while(true)
            {
                if(s.hasNext() && s.next().equals("X"))
                {
                    currentCamera.stopVideoRecording();
                    kernel.mic.turnOffMic();
                    LocalDateTime endTime = LocalDateTime.now();
                    String[] endTimeFormatted = formatter.format(endTime).split(":");
                    processor.processData("Process Video");
                    int timeTaken = ((Integer.parseInt(endTimeFormatted[0])-Integer.parseInt(startTimeFormatted[0]))*3600)+((Integer.parseInt(endTimeFormatted[1])-Integer.parseInt(startTimeFormatted[1]))*60)+(Integer.parseInt(endTimeFormatted[2])-Integer.parseInt(startTimeFormatted[2]));
                    kernel.saveFile(((double) (Math.round(Math.random() * 100))/10)*timeTaken*0.2);

                    System.out.println("File has been saved successfully with recorded time "+timeTaken/3600+":"+(timeTaken%3600)/60+":"+(timeTaken%3600)%60);
                    break;
                }
            }
        }
    }

    @Override
    protected void display()
    {
        boolean loopBreaker = true;
        kernel.primaryCamera.cameraOn();
        currentCamera = kernel.primaryCamera;
        do {
            System.out.println(cameraSide+" camera is turned on");
            System.out.print("1.Capture Photos\n2.Capture video\n3.Change Camera\n0.Quit\nEnter your choice:");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    captureImage();
                    break;
                case 2:
                    captureVideo();
                    break;
                case 3:
                    if(cameraSide.equals(CameraSide.REAR))
                    {
                        kernel.secondaryCamera.cameraOn();
                        kernel.primaryCamera.cameraOff();
                        cameraSide = CameraSide.FRONT;
                        currentCamera = kernel.secondaryCamera;
                        System.out.println("Camera is changed to Front");
                    }
                    else {
                        kernel.secondaryCamera.cameraOff();
                        kernel.primaryCamera.cameraOn();
                        cameraSide = CameraSide.REAR;
                        currentCamera = kernel.primaryCamera;
                        System.out.println("Camera is changed to Rear");
                    }
                    break;

                case 0:
                    currentCamera.cameraOff();
                    loopBreaker = false;
                    break;
                default:
                    System.out.println("ERROR! NOT FOUND");
            }
        }while (loopBreaker);
    }
    public enum CameraSide
    {
        REAR,
        FRONT;
    }
}