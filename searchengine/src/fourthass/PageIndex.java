package fourthass;

import java.io.IOException;
import java.util.LinkedList;
public class PageIndex {
InvertedPageIndex iv1=new InvertedPageIndex();
	
	LinkedList<WordEntry> lwe=new LinkedList<WordEntry>();
	
	public void addPositionForWord(String str, Position p) {//throws IOException{
		for(int i=0;i<iv1.lpe.size();i++){
			for(int j=0;j<iv1.lpe.get(i).lwp.size();j++){
				if(iv1.lpe.get(i).lwp.get(j).w.equals(str) && iv1.lpe.get(i).web.equals(p.sr)){
					
					lwe.add(iv1.lpe.get(i).lwp.get(j));
				}
			}
		}
		
	}
public LinkedList<WordEntry> getWordEntries(){
	return lwe;
}
}
