package comm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Phone extends Application {
    Scanner s = new Scanner(System.in);
    private HashMap<Long,String> contactList = new HashMap<>();
    private boolean isSpeakerOn = false;
    public Phone(String appName, double initialAppSize) {
        super(appName, initialAppSize);
    }

    private void call(long phoneNumber,String contactName)
    {
        kernel.mic.turnOnMic();
        kernel.antenna.receiveSignal("Signal");
        kernel.speaker.playSound("Phone call sound");
        kernel.mic.getVoiceInput();
        kernel.mic.processVoice();
        kernel.antenna.sendSignal("Input Voice Signal");
        callingScreen(contactName,phoneNumber);
    }

    private long findContact(String contactName)
    {
        long phoneNumber = 0;
        for(Map.Entry<Long,String> entry : contactList.entrySet())
        {
            if(entry.getValue().equals(contactName))
            {
                phoneNumber = entry.getKey();
            }
        }
        if(phoneNumber == 0)
            System.out.println("Search Not found");
        return phoneNumber;
    }

    private void message(long phoneNumber,String contactName,String message)
    {
        kernel.antenna.sendSignal(message);
        System.out.println("Message has been sent to "+contactName+" - +91"+phoneNumber);
    }

    private void createContact(long phoneNumber, String name)
    {
        contactList.put(phoneNumber,name);
    }

    private void viewContacts()
    {
        if(contactList.size() == 0)
            System.out.println("Nothing to show");
        else
        {
            int i = 1;
            for (Map.Entry<Long, String> entry : contactList.entrySet()) {
                System.out.println(i + "." + entry.getValue() +" "+ entry.getKey());
            }
        }
        System.out.println("______________________");
    }

    @Override
    protected void display()
    {
        boolean loopBreaker = true;
        String contact;
        String contactName = "Unknown Number";
        while(loopBreaker) {
            System.out.print("1.Call\n2.Message\n3.Contacts\n4.Create new contact\n0.Quit\nEnter your choice:");
            String choice = s.next();
            switch (choice) {
                case "1":
                    System.out.print("Enter number or contactName:");
                    contact = s.next();
                    if (Character.isLetter(contact.charAt(0)))
                    {
                        contactName = contact;
                        if(findContact(contact)!=0)
                            call(findContact(contact),contactName);
                    }
                    else
                        call(Long.parseLong(contact),contactName);
                    break;
                case "2":
                    System.out.print("Enter number or contactName:");
                    contact = s.next();
                    System.out.print("Enter the message:");
                    String message = s.next();
                    if (Character.isLetter(contact.charAt(0)))
                    {
                        contactName = contact;
                        if(findContact(contact)!=0)
                            message(findContact(contact),contactName,message);
                    }
                    else
                        message(Long.parseLong(contact),contactName,message);
                    break;
                case "3":
                    viewContacts();
                    break;
                case "4":
                    System.out.print("Enter the phone number:");
                    long phoneNumber = s.nextLong();
                    System.out.print("Enter the contact name:");
                    contactName = s.next();
                    createContact(phoneNumber, contactName);
                    break;
                case "0":
                    loopBreaker = false;
                    break;
                default:
            }
        }
    }

    private void callingScreen(String contactName,long phoneNumber)
    {
        boolean loopBreaker = true;
        System.out.println("Ringing..........\n"+contactName+"\n"+phoneNumber);
        while(loopBreaker) {
            System.out.print("1.Speaker\n2.Mute\n3.End Call\n4.Press Volume Up Button\n5.Press Volume Down Button\nEnter your choice:");
            switch (s.next()) {
                case "1":
                    if(!isSpeakerOn)
                    {
                        isSpeakerOn = true;
                        kernel.speaker.playSound("Call sound in speaker");
                        System.out.println("Speaker On");
                    }
                    else
                    {
                        isSpeakerOn =false;
                        kernel.earPiece.playSound("Call sound in earpiece");
                        System.out.println("Speaker Off");
                    }
                    break;
                case "2":
                    if(processor.mic.isMicOn())
                    {
                        kernel.mic.turnOnMic();
                        System.out.println("Mic muted");
                    }
                    else
                    {
                        kernel.mic.turnOffMic();
                        System.out.println("Mic unmuted");
                    }
                    break;
                case "3":
                    kernel.mic.turnOffMic();
                    System.out.println("Call ended");
                    System.out.println();
                    loopBreaker = false;
                    display();
                    break;
                case "4":
                    volumeUpButton.setSpeakerCondition(isSpeakerOn);
                    volumeUpButton.press();
                    if(isSpeakerOn)
                        System.out.println("Volume is "+kernel.speaker.getMediaVolumeLevel());
                    else
                        System.out.println("Volume is "+kernel.earPiece.getMediaVolumeLevel());
                    break;
                case "5":
                    volumeDownButton.setSpeakerCondition(isSpeakerOn);
                    volumeDownButton.press();
                    if(isSpeakerOn)
                        System.out.println("Volume is "+kernel.speaker.getMediaVolumeLevel());
                    else
                        System.out.println("Volume is "+kernel.earPiece.getMediaVolumeLevel());
                    break;
                default:
                    System.out.println("ERROR! NOT FOUND");
            }
        }
    }
}
