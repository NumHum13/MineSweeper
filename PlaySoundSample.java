package minePackage;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*; // For sound handling
import javax.sound.sampled.LineEvent.Type.*; // For LineEvent types used in listener

public class PlaySoundSample extends JFrame implements ActionListener, LineListener {
	JButton play;
	
	// Audio variables
	File soundFile;
	Clip clip;
	AudioInputStream soundIn;
	AudioFormat format;
	DataLine.Info info;

	public PlaySoundSample() {
		setTitle("PlaySound Example");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		play = new JButton("Play");
		play.addActionListener(this);
		
		// Add play button to the bottom portion of the frame (so we could possibly put visualizer or something in the top half???)
		add(play,BorderLayout.SOUTH);
		
		
		// Configure our variables for playing
		format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, AudioSystem.NOT_SPECIFIED, 16, 2, 4, AudioSystem.NOT_SPECIFIED, true);
		info = new DataLine.Info(Clip.class, format);

		// Our test file, be sure to change this to your own sounds or load it dynamically
		soundFile = new File("C:\\Users\\Panizza\\Videos\\MineSweeper Sounds\\digging.wav");
	
	}
	
	
	public static void main(String[] args) {
		PlaySoundSample playSound = new PlaySoundSample();
		
		playSound.setVisible(true);
	}

	
	// Listens for when the play button is pressed (Part of the ActionListener)
	public void actionPerformed(ActionEvent e) {
		try {
			// Play the sound if it is currently not set to playing a clip or that clip is not ACTIVELY PLAYING the sound.
			if ((clip == null) || (!clip.isActive())) {
				soundIn = AudioSystem.getAudioInputStream(soundFile);
				
				// Get the Data line for our clip, open it using the audio input stream from the actual sound file (loading the sound file into the clip)
				// Then start it
				clip = (Clip)AudioSystem.getLine(info);
				clip.open(soundIn);
				clip.start();
				
				// Attach line listener to the clip
				clip.addLineListener(this);
			}
		}
		catch (Exception ex) {
			System.out.println("There was an error!");
		}

	}
	
	// Listens for when the clip has stopped playing and closes it. (Part of the LineListener)
	public void update(LineEvent event) {
		if (event.getType().equals(LineEvent.Type.STOP)) { 
			clip.close();
		}
	}
}
