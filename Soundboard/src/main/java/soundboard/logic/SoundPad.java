package soundboard.logic;

import java.io.File;
import java.io.Serializable;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;

/**
 * Class responsible of playing specific sound files and storing names and filepaths.
 */
public class SoundPad extends Thread implements Serializable {

    private static final String SOUND_PLAY_ERROR = "Error playing file: ";
    private static final String EMPTY_STRING = "EMPTY";
    private static final String AUDIO_PATH = "./audioFiles/";
    private String fileName;
    private String soundPadName;
    private int soundPadNumber;

    public SoundPad(String filename, int padNumber) {
        this.fileName = filename;
        this.soundPadName = filename;
        this.soundPadNumber = padNumber;
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

    /**
     * Attempts to use this SoundPads fileName and play the corresponding file.
     *
     * @return Boolean according to success of the attempt.
     *
     */
    public boolean playSound() {

        if (this.fileName.equals(EMPTY_STRING)) {
            return true;
        }

        try {
            File testForExceptionFile = new File(AUDIO_PATH + this.fileName);
            Player testForExceptionPlayer = Manager.createRealizedPlayer(testForExceptionFile.toURI().toURL());

            Thread threadPad = new Thread(new ThreadPad(this.fileName));
            threadPad.start();
            return true;

        } catch (Exception e) {
            System.out.println(SOUND_PLAY_ERROR + this.fileName);
            return false;
        }
    }

    @Override
    public String toString() {
        return "fileName=" + fileName + ", soundPadName=" + soundPadName + ", soundPadNumber=" + soundPadNumber + "\n";
    }

}
