package com.amazon.asksdk.helloworld;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class GetNews {
	
	String news = "default1"; 
	String html = "default2";
	String titel = "default3";
	
	public GetNews() {} 
	
 
	
	public String getHomepageContent(){
		try {URL philHome= new URL("https://www.uni-tuebingen.de/fakultaeten/philosophische-fakultaet/fachbereiche/altertums-und-kunstwissenschaften/philologisches-seminar/institut.html");
		news = new Scanner((philHome).openStream(), "UTF-8").useDelimiter("\\A").next(); 
		}
		catch(Exception e) {};
		
		
		return news;
	}
	
	public Map<String,String> getVeranstaltungenHeader() {
		Map<String,String> events = new HashMap<String,String>();
		String news=getHomepageContent(); 
		String[] parts = news.split("<hr>");
		
		int index = 0;
		for (String part : parts) {
			System.out.println(index);
			if (index > 1 && part.contains("<h2>")){
				if (part.contains("<h1>Nachrichten</h1>")) {
					part = part.substring(0,part.indexOf("<h1>Nachrichten</h1>"));
				}
				part = part.replaceAll("\\<[^>]*>","");
				part = part.replaceAll("&quot;","");
				String text = "";
				String title = "";
				for (String line : part.split("\n")) {
					if (line.length() > 2) {
						if(title.equals("")) {
							title = line;
						}
						text += line;
					}
				}
				events.put(title, text);
				System.out.println("Titel: "+title);
				System.out.println("Text: "+text);
				
				
			}	
		index++;
		}
	    
		return events;
		
	}
	
	

}
