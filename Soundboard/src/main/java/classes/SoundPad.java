package classes;


import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class SoundPad {

    private String fileName;
    private String buttonName;
    private int buttonNumber;

    public SoundPad(String filename, int buttonNumber) {
        this.fileName = filename;
        this.buttonName = filename;
        this.buttonNumber = buttonNumber;
    }

    public String getFilename() {
        return fileName;
    }

    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public int getButtonNumber() {
        return buttonNumber;
    }

    public void setButtonNumber(int buttonNumber) {
        this.buttonNumber = buttonNumber;
    }
    
    

    public boolean playSound() {
        //use this buttons fileName and play it

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