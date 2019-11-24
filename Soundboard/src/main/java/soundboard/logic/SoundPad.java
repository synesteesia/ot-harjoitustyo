package soundboard.logic;


import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class SoundPad {

    private static final String SOUND_PLAY_ERROR = "Error playing file.";
    private String fileName;
    private String soundPadName;
    private int soundPadNumber;

    public SoundPad(String filename, int buttonNumber) {
        this.fileName = filename;
        this.soundPadName = filename;
        this.soundPadNumber = buttonNumber;
    }

    public String getFilename() {
        return fileName;
    }

    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public String getSoundPadName() {
        return soundPadName;
    }

    public void setSoundPadName(String soundPadName) {
        this.soundPadName = soundPadName;
    }

    public int getSoundPadNumber() {
        return soundPadNumber;
    }

    public void setSoundPadNumber(int soundPadNumber) {
        this.soundPadNumber = soundPadNumber;
    }
    
    

    public boolean playSound() {
        //use this buttons fileName and play it
        
        if (this.fileName.equals("")) {
            
            return true;
        }

        try {
            File audioFile = new File(this.fileName);
            AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = stream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);

            clip.open(stream);
            clip.start();
            return true;
        } catch (Exception e) {
            System.out.println(SOUND_PLAY_ERROR);
            e.printStackTrace();
            return false;
        }
    }

}
