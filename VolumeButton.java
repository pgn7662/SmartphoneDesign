package comm;

abstract class VolumeButton implements Button {
   boolean isSpeakerOn = true;

   protected void setSpeakerCondition(boolean isSpeakerOn)
   {
      this.isSpeakerOn = isSpeakerOn;
   }

}