package test;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
	
	public static void main(String args[]) throws IOException {
		
		ArrayList<String> liste = new ArrayList<String>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		/*System.out.println("Entrez le chemin d'accès du fichier à analyser");
		String path = scan.next();
		
		ArrayList<Kanji> kanlist = new ArrayList<Kanji>();
		ArrayList<ArrayList<String>> returnedValues = new ArrayList<ArrayList<String>>();
		
		addToList(liste, path);
		returnedValues = addMeaning(liste, kanlist, false);*/
		ArrayList<String> sig = new ArrayList<String>();
		ArrayList<String> pro = new ArrayList<String>();
		ArrayList<String> kan = new ArrayList<String>();
		
		ArrayList<String> sig2 = new ArrayList<String>();
		ArrayList<String> pro2 = new ArrayList<String>();
		ArrayList<String> kan2 = new ArrayList<String>();
		
		ListUtils.convertFileToLists("C:\\Users\\Mathis\\eclipse-workspace\\cut2.txt",kan,pro,sig);
		ListUtils.convertFileToLists("C:\\Users\\Mathis\\eclipse-workspace\\cut3.txt",kan2,pro2,sig2);
		
		ArrayList<Kanji> kaniList = new ArrayList<Kanji>();
		
		for(Kanji k : kaniList) {
			k.describe();
		}
		
		ArrayList<Integer> listeInd = ListUtils.checkSameInList(kan, kan2);
		for(int i = 0 ; i<listeInd.size() ; i++) {
			sig.set(listeInd.get(i), sig2.get(listeInd.get(i)));
		}
		
		for(int i = 0 ; i<sig.size() ; i++) {
			Kanji ka = new Kanji(kan.get(i),pro.get(i),sig.get(i));
			kaniList.add(ka);
		}
		
		Kanji.kanjiToFile(kaniList, "C:\\Users\\Mathis\\eclipse-workspace\\cut4.txt");
		
	}
	
	
	
	
	
	
	
	
	
}

