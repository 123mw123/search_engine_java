package fourthass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class MySort{ 
MySet<SearchResult> mss=new MySet<SearchResult>();

ArrayList<SearchResult> al=new ArrayList<SearchResult>();

	public ArrayList<SearchResult> sortThisList(MySet<SearchResult> list) {
		
		for(int i=0;i<list.x.size();i++){
			al.add(list.x.get(i));
			
		}
		Collections.sort(al,new Comparator<SearchResult>(){
			
			
			public int compare(SearchResult s1, SearchResult s2) {
				
				return s1.compareTo(s2.f);
			}	
		});
		
		return al;
	}



	
	
	
	
	
	




	
	

			
}
