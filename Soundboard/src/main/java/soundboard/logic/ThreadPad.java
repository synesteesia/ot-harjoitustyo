/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundboard.logic;

import java.io.File;
import javax.media.Manager;
import javax.media.Player;
import javax.media.Time;

public class ThreadPad implements Runnable {

    private static final String SOUND_PLAY_ERROR = "Error playing file: ";
    private static final String AUDIO_PATH = "./audioFiles/";
    private String fileName;

    public ThreadPad(String fileName) {
        this.fileName = fileName;
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
            System.out.println(SOUND_PLAY_ERROR + this.fileName);
        }
    }

}
