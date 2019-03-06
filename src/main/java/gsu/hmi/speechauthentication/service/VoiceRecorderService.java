package gsu.hmi.speechauthentication.service;

import javax.sound.sampled.*;

import java.io.*;
import java.time.ZonedDateTime;

public class VoiceRecorderService {
	
	static final long RECORD_TIME = 5000;
	static final String RECORDING_PATH = "C:/Users/GLB90062128/Documents/Fax/xd.wav";
	
	File wavFile = new File(RECORDING_PATH);
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    TargetDataLine line;
	
	public void recordVoiceForMicrosoftAzure() throws IOException {
		System.out.println("When you are ready, please enter to start record your voice.");
		
		BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
		String waitForAnswer = ob.readLine();
		
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    System.out.println("ERROR: Error at voice recording (" + ex.getLocalizedMessage() + ")");
                }
                finishRecording();
            }
        });
 
        stopper.start();
 
        startRecording();
	}
	
	private AudioFormat getAudioFormat() {
    	float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
	
	private void startRecording() {
        try {	
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("ERROR: Line not supported");
                System.exit(0);
            }
            
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
 
            System.out.println("INFO: Voice capturing started at " + ZonedDateTime.now());
 
            AudioInputStream audioInputStream = new AudioInputStream(line);
            
            System.out.println("INFO: Voice recording started at " + ZonedDateTime.now());

            AudioSystem.write(audioInputStream, fileType, wavFile);  
 
        } catch (LineUnavailableException ex) {
            System.out.println("ERROR: Error at voice recording (" + ex.getLocalizedMessage() + ")");
        } catch (IOException ioe) {
            System.out.println("ERROR: Error at voice recording (" + ioe.getLocalizedMessage() + ")");
        }
    }
	
	private void finishRecording() {
        line.stop();
        line.close();
        System.out.println("INFO: Voice recording finished at " + ZonedDateTime.now() + " wav file saved to " + RECORDING_PATH);
    }

}
