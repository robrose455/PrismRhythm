package ge.core;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AudioManager {

    public AudioManager() {

    }

    public void PlaySong(String filePath) throws FileNotFoundException {

        File Song = new File(filePath);

        try{

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Song));

            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-15.f);

            clip.start();



        }catch(Exception e) {

        }
    }
}
