package fourthass;

import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;

public class MyHashTable {
	InvertedPageIndex ii1=new InvertedPageIndex();
WordEntry wo; 
LinkedList<String> ls=new LinkedList<String>();
 Hashtable<String,LinkedList<Position>> h=new Hashtable<String,LinkedList<Position>>() ;

	public void addPositionsForWord(String str){ 
		LinkedList<Position> lps=new LinkedList<Position>();
if(!str.equals("a") && !str.equals("an") && !str.equals("the") && !str.equals("the") && !str.equals("they") && !str.equals("these") && !str.equals("for") && !str.equals("is") && !str.equals("are") && !str.equals("of") && !str.equals("was") && !str.equals("or") && !str.equals("and") && !str.equals("does") && !str.equals("will")&& !str.equals("whose"))
		{
	h.put(str, lps);
		
		for(int i=0;i<ii1.lpe.size();i++){
			
			for(int j=0;j<ii1.lpe.get(i).st.size();j++){
				if(ii1.lpe.get(i).st.get(j).equals(str)){
					
					
					for(int k=0;k<ii1.lpe.get(i).swe.size();k++){
						if(ii1.lpe.get(i).swe.get(k).sr.equals(ii1.lpe.get(i).web) && ii1.lpe.get(i).swe.get(k).wi==j){
							
							h.get(str).add(ii1.lpe.get(i).swe.get(k));
						}
					}
				}
			}
		}
	}
}
	
}
