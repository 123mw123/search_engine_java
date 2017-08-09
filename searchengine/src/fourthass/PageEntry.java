package fourthass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedList;
public class PageEntry {
String web;
InvertedPageIndex ipp =new InvertedPageIndex();

LinkedList<String> st;
LinkedList<String> st1;

LinkedList<WordEntry> lwp;
static LinkedList<Position> swe=new LinkedList<Position>();

PageIndex pi;
	public  PageEntry(String pageName) throws IOException{
		int e=0;
		pi=new PageIndex();
		int n;
		
		st=new LinkedList<String>();
		st1=new LinkedList<String>();
	
		lwp=new LinkedList<WordEntry>();
		
		web=pageName;
		
		try{
		 FileReader fr = new FileReader (web); 
		
		  BufferedReader br = new BufferedReader (fr);     
	       String line = br.readLine();
	       int count = 0;
	       while (line != null) {
	    	 
	    	  if(!line.isEmpty()){
	    		  line=line.toLowerCase();
	    		  
	    		 line=line.trim();
	    		  line=line.replace('"',' ');
	    		
	          String []parts = line.split("[- { } [ ] < > = ( ) . , ; '  ? # !  :]+");
	          for(int i=0;i<parts.length;i++){
	        	  if(parts[i].equals("stack") ||parts[i].equals("structure")||parts[i].equals("application") ){
	        		  parts[i]=parts[i]+"s";
	        	  }
	          }
	     
	          for(int i=0;i<parts.length;i++)
	          {
	        	
	        	  st.add(parts[i]);
if(!parts[i].equals("a") && !parts[i].equals("an") && !parts[i].equals("the") && !parts[i].equals("the") && !parts[i].equals("they") && !parts[i].equals("these") && !parts[i].equals("for") && !parts[i].equals("is") && !parts[i].equals("are") && !parts[i].equals("of") && !parts[i].equals("was") && !parts[i].equals("or") && !parts[i].equals("and") && !parts[i].equals("does") && !parts[i].equals("will")&& !parts[i].equals("whose")){
st1.add(parts[i]);	        		  
	        	  }

	        	
	      	 WordEntry wr=new WordEntry(parts[i]);
	        	 lwp.add(wr);
	        	
	        	 Position pos=new Position(web,e);
	        	 swe.add(pos);
	        	 pi.addPositionForWord(parts[i], pos);
	        	 e++;
	        
	          }
	    	  }
				line = br.readLine();
			
	       }   
	     
		}
		catch (java.io.FileNotFoundException en){
			System.out.println("file doesn't exists");
		}

		}
	

public PageIndex getPageIndex(){	
	return pi;
}

public float getRelevanceOfPage(String[] str, boolean doTheseWordsRepresentAPhrase) throws IOException{
	float rel=0;
LinkedList li=new LinkedList();
LinkedList<String> cw=new LinkedList<String>();
	
	int j=0;
	
		float r=0;
		cw.add("a");
		cw.add("an");
		cw.add("the");
		cw.add("they");
		cw.add("these");
		cw.add("this"); cw.add("for"); cw.add("is");cw.add("are");
		cw.add("was");cw.add("of");cw.add("or");cw.add("and");cw.add("does");cw.add("will");cw.add("whose");
		
	
		
	if(doTheseWordsRepresentAPhrase==false){
		while(j<str.length){
			
			for(int i=0;i<st.size();i++){
	if(st.get(i).equals(str[j])){
	
		
	r=(i+1)*(i+1);
	
	rel=rel+(1/r);
	
	}
			}
	j=j+1;
	
		}
}
	
	if(doTheseWordsRepresentAPhrase==true){
		LinkedList<Integer> lip=new LinkedList<Integer>();
		WordEntry wt=new WordEntry(str[0]); 
		wt.getAllPositionsForThisWord();
		wt.avl.preorder();

		for(int i=0;i<wt.avl.li.size();i++){
			if(wt.avl.li.get(i).sr.equals(this.web)){
				
				lip.add(wt.avl.li.get(i).wi);
			}
		}
		for(int i=0;i<lip.size();i++){
			
		int	x=lip.get(i)+1;
		
		int z=1;
		for(int y=1;y<str.length;y++){
			
			
		
		
		
			while(cw.contains(st.get(x))){
		
		
				x=x+1;
				
			}
	
		WordEntry wr=new WordEntry(str[y]); 
		wr.getAllPositionsForThisWord();
		wr.avl.preorder();
		Position ps=new Position(this.web,x);
		if(wr.avl.search(ps)){
			
			z=z+1;
			x=x+1;
			
		}
			if(z==str.length){
				
				r=(lip.get(i)+1)*(lip.get(i)+1);
				rel=rel+(1/r);
				
			}
	
			
		}
	}
	}
		
		return rel;
	
}
		
}
