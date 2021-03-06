/***********************************************************
* Developer: Minhas Kamal (minhaskamal024@gmail.com)       *
* Date: 04-Aug-2016                                        *
* License: MIT License                                     *
* Website: github.com/MinhasKamal/BengaliDictionary        *
***********************************************************/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Dictionary {
	private HashMap<String, String> map;
	
	public Dictionary(String filePath) throws Exception{
		map = new HashMap<String, String>();
		BufferedReader mainBR = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
		
		String line = mainBR.readLine();
		while(line != null){
			int seperator = line.indexOf('|', 1);
			map.put(line.substring(1, seperator), line.substring(seperator+1));
			line = mainBR.readLine();
		}

		mainBR.close();
	}
	
	public String search(String word){
		return map.get(word);
	}
	
	public static void main(String[] args) {
		try {
			Dictionary dictionary = new Dictionary("BengaliDictionary_17.txt");
			System.out.println(dictionary.search("heart"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
