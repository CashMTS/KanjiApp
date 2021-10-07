package test;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Translate {
	
	public static void main(String args[]) throws IOException {
		
		ArrayList<String> liste = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entrez le chemin d'accès du fichier à analyser");
		String path = scan.next();
		
		addToList(liste, path);
				
		ArrayList<String> meaning = new ArrayList<String>();
		ArrayList<String> pronounciation = new ArrayList<String>();
		
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
		
		ArrayList<Kanji> listeKanji=new ArrayList<Kanji>();
		for(int i = 0;i<pronounciation.size();i++) {
			Kanji kan = new Kanji(liste.get(i), pronounciation.get(i), meaning.get(i));
			listeKanji.add(kan);
		}
		
		String combine = "\n";
		for(Kanji kani : listeKanji) {
			combine+=kani.getName()+","+'"'+kani.getPronounciation()+'"'+","+'"'+kani.getMeaning()+'"'+"\n";
		}
		
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Entrez le chemin d'accès du fichier à modifier/créer");
		String filePath = scan3.next();
		File f = new File(filePath);

		Files.write(Paths.get(filePath), combine.getBytes());
				
		System.out.println("Terminé !");

	}
	
	public static void addToList(ArrayList<String> list, String filePath) {
		try {
			
			File test = new File(filePath);
			Scanner scan = new Scanner(test);
			String s = "";
			
			while(scan.hasNext()) {
				String line = scan.nextLine();
				list.add(line);
				s+=line+"\n";
			}
			
			System.out.println(list.size());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
}

