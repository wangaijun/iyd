package util;

import javax.sound.sampled.*;
import java.net.URL;
public class AudioPlayer {

	private Clip clip;

	public void play(String word){
		try{
			String urlStr = "http://dict.youdao.com/speech?audio="+word;
			URL url = new URL(urlStr);
			AudioInputStream in=AudioSystem.getAudioInputStream(url);
			AudioFormat fm=getOutFormat(in.getFormat());
			DataLine.Info info=new DataLine.Info(Clip.class,fm);
			clip = (Clip) AudioSystem.getLine(info);
			if(clip !=null){
				clip.open(AudioSystem.getAudioInputStream(fm,in));
//				clip.loop(2);
				clip.start();
				clip.drain();
				clip.stop();
			}
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}

	private AudioFormat getOutFormat(AudioFormat inFormat){
		final int ch=inFormat.getChannels();
		final float rate=inFormat.getSampleRate();
		return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,rate,16,ch,ch*2,rate,false);
	}

	public static void main(String[] args){
		AudioPlayer d=new AudioPlayer();
//		d.play("http://openapi.youdao.com/ttsapi?q=word&langType=en&sign=14070FA9EB17A96E6AA41B8E01349AF2&salt=1527159826480&voice=0&format=mp3&appKey=6fe6f4309122ff9c");
		d.play("http://dict.youdao.com/speech?audio=emit");
	}
}
