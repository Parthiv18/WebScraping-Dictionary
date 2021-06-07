package findWord;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class sWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print ("Enter Word ");
		Scanner scan = new Scanner (System.in);
		String word = scan.nextLine ();
		gWords (word);
	}
		
	public static void gWords (String word)
		{
		    try
		    { 
		    	//System.out.print(word);
		        Document doc = Jsoup.connect ("https://www.merriam-webster.com/dictionary/"+word).timeout (6000).get ();
		        Elements temp = doc.select ("div.vg"); //for dictionay - default-content - lister-item-content - css-1avshm7 e16867sm0 - css-1ghs5zt e1q3nk1v2   
		        
		        int i = 0;
		        for (Element element:temp)
		        {
		            i++;
		            System.out.print (i+" "+element.select("span.dt").first().text()+ "\n"); //first() //if (i==3) { //break;   //}
		        }
		    }
		    catch (IOException e)
		    {
		        e.printStackTrace ();		      
		        System.out.print("Word not found, checking for spelling mistakes");		     
		    }
		}
}
