package monstres;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadModeleMonstre {
	public static void main (){
		String name;
		Integer pv;
		Integer vitesse;
		String image;
		Integer attaque;
		Integer recompense;
		Integer cout;
		Boolean invisible;
		Boolean volant;
		
		String fichier=".\\monstres.txt";
		
		try {
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			Scanner scanner = new Scanner(ipsr);
			scanner.useDelimiter(Pattern.compile("/"));
			while(scanner.hasNext()){
				
			}
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
}