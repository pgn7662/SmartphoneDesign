package comm;

import java.util.Scanner;

class Music extends Application {
    Scanner s  = new Scanner(System.in);



    public Music(String appName, double appSize) {
        super(appName, appSize);
    }

    @Override
    protected void display()
    {
        boolean loopBreaker = true;
        while (loopBreaker)
        {
            System.out.println("1.Play/Pause\n2.Next song\n3.Previous song\n4.Volume up(To press Volume Up Button)\n5.Volume down(To press Volume Down Button)\n0.Quit\nEnter your choice:");
            String choice = s.next();
            switch(choice)
            {
                case "1":
                    playOrPause();
                    break;
                case "2" :
                    nextSong();
                    break;
                case "3" :
                    previousSong();
                    break;
                case "4" :
                    volumeUpButton.press();
                    System.out.println("Volume is  "+processor.speaker.getMediaVolumeLevel());
                    break;
                case "5" :
                    volumeDownButton.press();
                    System.out.println("Volume is  "+processor.speaker.getMediaVolumeLevel());
                    break;
                case "0" :
                    loopBreaker = false;
                    break;
                default:
                    System.out.println("ERROR! NOT FOUND");
            }
        }
    }

    private void playOrPause()
    {
        processor.speaker.playSound("Music/Song");
    }

    private void nextSong()
    {

    }

    private void previousSong()
    {

    }

}
