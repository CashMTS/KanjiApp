package test;

public class Kanji {
	
	String name;
	String pronounciation;
	String meaning;
	
	public Kanji(String nam, String pron, String mean) {
		this.name=nam;
		this.pronounciation=pron;
		this.meaning=mean;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPronounciation() {
		return pronounciation;
	}
	
	public String getMeaning() {
		return meaning;
	}
	
}
