import java.io.IOException;  
import java.util.Scanner;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class similarFBLikes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//SCANNER CREATED
		Scanner s = new Scanner(System.in);
		
		//TAKE INPUT FROM USER
		System.out.println("Enter first person's Facebook Username");
		String firstlink = s.next();
		
		System.out.println("Enter second person's Facebook Username");
		String secondlink = s.next();
		
		//FIND INTERESTS OF FIRST PERSON

		//fetching html from first profile using jsoup
		Document doc = Jsoup.connect("https://www.facebook.com/"+firstlink).get();
		Elements links = doc.select("a[href]");
		String[] strs = new String[links.size()];
		int i=0;
		boolean flag = false;
		for (Element link : links) {
			if (link.attr("href").equals("#"))
				break;
			if (link.text().isEmpty())
				flag = true;
			if (flag && !link.text().isEmpty()) {
				strs[i]=link.text();
				i++;
			}
		} 
		
		//FIND INTERESTS OF SECOND PERSON

		//fetching html from second profile using jsoup
		Document doc2 = Jsoup.connect("https://www.facebook.com/"+secondlink).get();
		Elements links2 = doc2.select("a[href]");
		String[] strs2 = new String[links2.size()];
		int i2=0;
		boolean flag2 = false;
		for (Element link : links2) {
			if (link.attr("href").equals("#"))
				break;
			if (link.text().isEmpty())
				flag2 = true;
			if (flag2 && !link.text().isEmpty()) {
				strs2[i2]=link.text();
				i2++;
			}
		} 
		
		for (int j=0;strs[j]!=null;j++)
		{
			for (int k=0;strs2[k]!=null;k++)
			{
				if (strs[j].equals(strs2[k]) || strs[j].contains(strs2[k]) || strs2[k].contains(strs[j]))
				{
					System.out.println(strs[j]);
				}
			}
		}
		
	}

}
