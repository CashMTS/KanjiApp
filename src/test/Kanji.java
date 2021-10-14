package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void describe() {
		System.out.println("Le kanji "+name+" se prononce : "+pronounciation+" et veut dire : "+meaning);
	}
	
	/**
	 * Analyse une liste de String contenant des kanji et demande leur prononciation(s) et signification(s).
	 * Convertit alors les données en l'objet Kanji et l'ajoute dans une liste.
	 * @param liste
	 * La liste à analyser
	 * @param listeKanji
	 * La liste à remplir
	 * @param writing
	 * Si true : écrit le résultat dans un fichier
	 * @return 
	 * retourne une List<String> contenant prononciation et signification des Kanjis
	 */
	
	public static ArrayList<ArrayList<String>> addMeaning(ArrayList<String> liste, ArrayList<Kanji> listeKanji) {
		
		//création des listes contenant prononciations et significations
		ArrayList<String> meaning = new ArrayList<String>();
		ArrayList<String> pronounciation = new ArrayList<String>();
		ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
		
		@SuppressWarnings("resource")
		Scanner scan2 = new Scanner(System.in);
		
		for(int i=0 ; i< liste.size() ; i++) {
			
			System.out.println("donnez la prononciation de ce kanji : "+liste.get(i));
			String pron = scan2.nextLine();
			pronounciation.add(pron);
			
		}
		
		System.out.println("Prononciations terminées, passons aux significations !");
		
		for(int i=0 ; i< liste.size() ; i++) {
			System.out.println("donnez la signification de ce kanji : "+liste.get(i));
			String mean = scan2.nextLine();
			meaning.add(mean);
		}
		
		for(int i = 0;i<liste.size();i++) {
			Kanji kan = new Kanji(liste.get(i), pronounciation.get(i), meaning.get(i));
			listeKanji.add(kan);
		}
		
				
		System.out.println("Terminé !");
		
		resultList.add(meaning);
		resultList.add(pronounciation);
		
		return resultList;
	}
	public static void kanjiToString(ArrayList<Kanji> listeKanji) {
		//convertion de la liste de Kanji en String pour pouvoir exporter le résultat dans un fichier
		String combine = "\n";
		for(Kanji kani : listeKanji) {
			if(kani.getPronounciation().contains(",") || kani.getMeaning().contains(",")) {
				combine+=kani.getName()+","+'"'+kani.getPronounciation()+'"'+","+'"'+kani.getMeaning()+'"'+"\n";
			}else {
				combine+=kani.getName()+","+kani.getPronounciation()+","+kani.getMeaning()+"\n";
			}
			
		}
		
	}
	
	public static void kanjiToFile(ArrayList<Kanji> listeKanji, String path) {
		//convertion de la liste de Kanji en String pour pouvoir exporter le résultat dans un fichier
		String combine = "\n";
		for(Kanji kani : listeKanji) {
			if(kani.getPronounciation().contains(",") || kani.getMeaning().contains(",")) {
				combine+=kani.getName()+","+'"'+kani.getPronounciation()+'"'+","+'"'+kani.getMeaning()+'"'+"\n";
			}else {
				combine+=kani.getName()+","+kani.getPronounciation()+","+kani.getMeaning()+"\n";
			}
			
		}
		
		@SuppressWarnings("resource")
		File f = new File(path);

		try {
			Files.write(Paths.get(path), combine.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
