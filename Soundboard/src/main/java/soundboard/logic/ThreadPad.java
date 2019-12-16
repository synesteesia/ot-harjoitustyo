package soundboard.logic;

import java.io.File;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;

/**
 * Class responsible of playing specific sound files and closing them after.
 */
public class ThreadPad implements Runnable {

    private static final String SOUND_PLAY_ERROR = "Error playing file: ";
    private static final String AUDIO_PATH = "./audioFiles/";
    private String fileName;

    public ThreadPad(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Attempts to use this ThreadPads fileName and play the corresponding file.
     */
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
            System.out.println(SOUND_PLAY_ERROR + this.fileName);
        }
    }

}
