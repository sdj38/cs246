import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundTest  {
	public static final AudioClip BITE = Applet.newAudioClip(SoundTest.class.getResource("Splat.wav"));
	public static final AudioClip MUSIC = Applet.newAudioClip(SoundTest.class.getResource("HellsBells.wav"));
}
