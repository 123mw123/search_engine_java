package fourthass;

import java.io.IOException;
import java.util.LinkedList;
public class Position {
	
	InvertedPageIndex iv2=new InvertedPageIndex();
	String sr;

	int wi;
	
	public Position(String p, int wordIndex) {
		sr=p;
	
		
	wi=wordIndex;
	}
	public PageEntry getPageEntry(){
		int j=0;
	for(int i=0;i<iv2.lpe.size();i++){
		if(iv2.lpe.get(i).web.equals(sr))
			j=i;
	}
	return iv2.lpe.get(j);
	}
	public int getWordIndex(){
		return wi;
	}
}
