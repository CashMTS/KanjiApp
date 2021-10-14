package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListUtils {
	
	public static void afficList(String pre ,ArrayList<String> list) {
		for(int i = 0 ; i<list.size() ; i++) {
			System.out.println(pre+list.get(i));
		}
	}
	
	public static ArrayList<Integer> checkSameInList(ArrayList<String> a, ArrayList<String> b) {
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		if(a.size()>b.size()) {
			for(int i =0 ; i<a.size() ; i++) {
				if(b.contains(a.get(i))) {
					System.out.println("élément similaire : "+a.get(i));
					intlist.add(i);
				}
			}
		}else {
			for(int i =0;i<b.size();i++) {
				if(a.contains(b.get(i))) {
					System.out.println("élément similaire : "+b.get(i));
					intlist.add(i);
				}
			}
		}
		return intlist;
	}
	

	public static ArrayList<ArrayList<String>> convertFileToLists(String filePath, ArrayList<String> alist, ArrayList<String> blist, ArrayList<String> clist) {
		
		ArrayList<ArrayList<String>> completeList = new ArrayList<ArrayList<String>>();
		
		try {
			
			File file = new File(filePath);
			Scanner scan = new Scanner(file);
			int cpt = 0;
			
			while(scan.hasNext()) {
				String temp = "";
				String line = scan.nextLine();
				
				for(int i = 0 ; i<line.length() ; i++) {
					char c = line.charAt(i);
					int cptw = i;
					
					if(c=='"') {
						temp+=String.valueOf(line.charAt(cptw));
						cptw++;
						i++;
							while(line.charAt(cptw)!='"') {
								temp+=String.valueOf(line.charAt(cptw));
								cptw++;
								i++;
							}
					}
					
					if(c==',') {
						
						if(cpt==0) {
							
							alist.add(temp);
							cpt++;
							
						}else if(cpt==1) {
							blist.add(temp);
							cpt++;
						}
						temp="";
					}else {
						temp+=String.valueOf(c);
					}
					
					if(i==line.length()-1) {
						clist.add(temp);
						temp="";
						cpt=0;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		completeList.add(alist);
		completeList.add(blist);
		completeList.add(clist);
		
		return completeList;
		
	}
	
	/**
	 * Transforme un fichier contenant une liste de mots en une Liste de String java
	 * @param list
	 * la liste à remplir
	 * @param filePath
	 * chemin du fichier à analyser
	 */
	
	public static void addToList(ArrayList<String> list, String filePath) {
		try {
			
			File test = new File(filePath);
			@SuppressWarnings("resource")
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
