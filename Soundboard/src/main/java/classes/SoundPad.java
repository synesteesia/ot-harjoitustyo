package classes;


import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class SoundPad {

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
        
        if(this.fileName.equals("")){
            
            return true;
        }

        try {
            File audioFile = new File(this.fileName);
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(audioFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
            return true;
        } catch (Exception e) {
            System.out.println("Error playing file.");
            e.printStackTrace();
            return false;
        }
    }

}
