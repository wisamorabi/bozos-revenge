package project;

import java.io.*;
import javax.sound.sampled.*;

//Being static allows us to use this class ANYWHERE throughout the program with no hassle.

//This enumerator encapsulates all the sound effects of a game, so as to separate the sound playing
//1. Define all your sound effect names and the associated wave file.
//2. To play a specific sound, simply invoke SoundEffect.SOUND_NAME.play().
public enum AudioPlayer {
	//All the audio files used in the game.
	SCORE("Score.wav"),
	LOSE("Lose.wav"),
	INTRO("Intro.wav"),
	EASY("Easy.wav"),
	MEDIUM("Med.wav"),
	HARD("Hard.wav"),
	PREPARE("Prepare.wav"),
	EVIL("Evil.wav"),
	SONG("Megalovania.wav"),
	ATTACK("Attack.wav");


	// Nested class for specifying volume
	public static enum Volume {
		MUTE, LOW, MEDIUM, HIGH
	}

	public static Volume volume = Volume.HIGH;

	// Each sound effect has its own "clip", loaded with its own sound file.
	private Clip clip;

	// Constructor to construct each element of the enum with its own sound file.
	AudioPlayer(String soundFileName) {
		try {
			File soundFile = new File(soundFileName);

			// Set up an audio input stream piped from the sound file.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			// Get a clip resource.

			clip = AudioSystem.getClip();


			// Open audio clip and load samples from the audio input stream.
			clip.open(audioInputStream);
		}
		catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	//To loop the background music. Only called when the SONG enum is used.
	public void playbackgroundsong() {
		if (clip.isRunning()) {clip.stop();} 
		clip.setFramePosition(0);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	// Play or Re-play the sound effect from the beginning, by rewinding.
	public void play() {
		if (clip.isRunning()) { clip.stop(); } // Stop the player if it is still running
		clip.setFramePosition(0); // rewind to the beginning
		clip.start(); // Start playing
	}
	// To stop the background music when the player loses.
	public void stop() {
		if (clip.isRunning())
			clip.stop(); // Stop the player if it is still running
	}
	//Pre-load all the sound files to prevent delays due to loading mid-game.
	static void init() {
		values(); //Called once in game.java once the program starts.
	}
}

