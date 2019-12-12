package soundboard.logic;

import java.io.File;
import java.io.Serializable;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;

/**
 * Class responsible of playing specific sound files.
 */
public class SoundPad implements Serializable, Runnable {

    private static final String SOUND_PLAY_ERROR = "Error playing file.";
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

            Thread threadPad = new Thread(new SoundPad(this.fileName, 0));
            threadPad.start();
            return true;

        } catch (Exception e) {
            System.out.println(SOUND_PLAY_ERROR);
            return false;
        }
    }

    @Override
    public void run() {
        try {
            File audioFile = new File(AUDIO_PATH + this.fileName);
            Player threadPlayer = Manager.createRealizedPlayer(audioFile.toURI().toURL());
            threadPlayer.start();
            Time timer = threadPlayer.getDuration();
            Thread.sleep(timer.getNanoseconds() / 1000000);
            threadPlayer.stop();
            threadPlayer.close();

        } catch (Exception threadEx) {
            System.out.println(SOUND_PLAY_ERROR);
        }

    }

    @Override
    public String toString() {
        return "fileName=" + fileName + ", soundPadName=" + soundPadName + ", soundPadNumber=" + soundPadNumber + "\n";
    }

}
