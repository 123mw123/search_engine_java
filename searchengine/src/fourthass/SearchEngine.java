package fourthass;

import java.util.LinkedList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class SearchEngine {
	InvertedPageIndex ii;
	LinkedList<String> s=new LinkedList<String>();
	public SearchEngine(){
		ii=new InvertedPageIndex();
	}
	public void addPage(PageEntry y){
		
		int j=0;
		if(s.size()==0){
			ii.addPage(y);
			j=1;
			s.add(y.web);
		}
		else
			for(int i=0;i<s.size();i++){
				if(s.get(i).equals(y.web)){
					System.out.println("page already exists");
					j=2;
				}
			
				
			}
		if(j==0){
			
		s.add(y.web);
			ii.addPage(y);
		}
	}
	
	public void queryFindPagesWhichContainWord(String x){
		x=x.toLowerCase();
		LinkedList<String> lls=new LinkedList<String>();
		if(!x.equals("stack") && !x.equals("stacks") && !x.equals("structure") && !x.equals("structures") && !x.equals("application") && !x.equals("applications"))
		for(int i=0;i<ii.getPagesWhichContainWord(x).x.size();i++){
		lls.add(ii.getPagesWhichContainWord(x).x.get(i).web);
	}
		if(x.equals("stack") || x.equals("stacks")){
			for(int i=0;i<ii.getPagesWhichContainWord("stack").x.size();i++){
				
				lls.add(ii.getPagesWhichContainWord("stack").x.get(i).web);
			}
			for(int i=0;i<ii.getPagesWhichContainWord("stacks").x.size();i++){
				
				if(!lls.contains(ii.getPagesWhichContainWord("stacks").x.get(i).web))
				lls.add(ii.getPagesWhichContainWord("stacks").x.get(i).web);
			}
		}
		if(x.equals("structure") || x.equals("structures")){
			for(int i=0;i<ii.getPagesWhichContainWord("structure").x.size();i++){
				lls.add(ii.getPagesWhichContainWord("structure").x.get(i).web);
			}
			for(int i=0;i<ii.getPagesWhichContainWord("structures").x.size();i++){
				lls.add(ii.getPagesWhichContainWord("structures").x.get(i).web);
			}
		}
		if(x.equals("application") || x.equals("applications")){
			for(int i=0;i<ii.getPagesWhichContainWord("application").x.size();i++){
				lls.add(ii.getPagesWhichContainWord("application").x.get(i).web);
			}
			for(int i=0;i<ii.getPagesWhichContainWord("applications").x.size();i++){
				lls.add(ii.getPagesWhichContainWord("applications").x.get(i).web);
			}
		}
		if(!lls.isEmpty())
		System.out.println(lls);
		else
			System.out.println(x+" is not found in any of the web pages");
		
		
	}
	public void queryFindPositionsOfWordInAPage(String u1,String u2) {
		u1=u1.toLowerCase();
		
		LinkedList<Integer> lp=new LinkedList<Integer>();
		
		MyHashTable mh=new MyHashTable();
if(!u1.equals("stack") && !u1.equals("stacks") && !u1.equals("structure") && !u1.equals("structures") && !u1.equals("application") && !u1.equals("applications")){	
		mh.addPositionsForWord(u1);
		if(mh.h.get(u1)!=null){
			
	for(int i=0;i<mh.h.get(u1).size();i++){
		if(mh.h.get(u1).get(i).sr.equals(u2)){
			lp.add(mh.h.get(u1).get(i).wi+1);
		}
	}
		}
}
if(u1.equals("stack") || u1.equals("stacks")){
	mh.addPositionsForWord("stack");
	if(mh.h.get("stack")!=null){
		
for(int i=0;i<mh.h.get("stack").size();i++){
	if(mh.h.get("stack").get(i).sr.equals(u2)){
		lp.add(mh.h.get("stack").get(i).wi+1);
	}
}
	}
	mh.addPositionsForWord("stacks");
	if(mh.h.get("stacks")!=null){
		
for(int i=0;i<mh.h.get("stacks").size();i++){
	if(mh.h.get("stacks").get(i).sr.equals(u2)){
		lp.add(mh.h.get("stacks").get(i).wi+1);
	}
}
	}
}
if(u1.equals("structure") || u1.equals("structures")){
	mh.addPositionsForWord("structure");
	if(mh.h.get("structure")!=null){
		
for(int i=0;i<mh.h.get("structure").size();i++){
	if(mh.h.get("structure").get(i).sr.equals(u2)){
		lp.add(mh.h.get("structure").get(i).wi+1);
	}
}
	}
	mh.addPositionsForWord("structures");
	if(mh.h.get("structures")!=null){
		
for(int i=0;i<mh.h.get("structures").size();i++){
	if(mh.h.get("structures").get(i).sr.equals(u2)){
		lp.add(mh.h.get("structures").get(i).wi+1);
	}
}
	}
}
if(u1.equals("application") || u1.equals("applications")){
	mh.addPositionsForWord("application");
	if(mh.h.get("application")!=null){
		
for(int i=0;i<mh.h.get("application").size();i++){
	if(mh.h.get("application").get(i).sr.equals(u2)){
		lp.add(mh.h.get("application").get(i).wi+1);
	}
}
	}
	mh.addPositionsForWord("applications");
	if(mh.h.get("applications")!=null){
		
for(int i=0;i<mh.h.get("applications").size();i++){
	if(mh.h.get("applications").get(i).sr.equals(u2)){
		lp.add(mh.h.get("applications").get(i).wi+1);
	}
}
	}
}


if(!lp.isEmpty())
		System.out.println(lp);
if(lp.isEmpty()){
int j=0;
	for(int i=0;i<ii.lpe.size();i++){
		if(ii.lpe.get(i).web.equals(u2)){
			j=1;
		}
	}
	if(j==0){
		System.out.println(u2 +" page not found");
	}
	if(j==1){
		System.out.println(u1 +" is not there in " +u2 + " page");
	}
	}
	}
public void queryFindPagesWhichContainPhrase(String[] str) throws IOException{
	MySet<SearchResult> msr=new MySet<SearchResult>();
	MySort mso=new MySort();
		ArrayList<SearchResult>  A=new ArrayList<SearchResult>();
		LinkedList<String> ls=new LinkedList<String>();
		for(int i=0;i<ii.lpe.size();i++){
			boolean b=true;
		SearchResult se=new SearchResult(ii.lpe.get(i),ii.lpe.get(i).getRelevanceOfPage(str,b));
		
		if(ii.lpe.get(i).getRelevanceOfPage(str,b)!=0)
		msr.addElement(se);
		}
		A.addAll(mso.sortThisList(msr));
		for(int i=0;i<A.size();i++){
			ls.add(A.get(i).pn.web);
		}
		if(!ls.isEmpty())
		System.out.println(ls);
		else
			System.out.println("No page exists which  contains this phrase ");
		//System.out.println( System.currentTimeMillis());
		
}

public void queryFindPagesWhichContainAllWords(String[] str) throws  IOException{
	
	MySet<SearchResult> msr=new MySet<SearchResult>();
MySort mso=new MySort();
	ArrayList<SearchResult>  A=new ArrayList<SearchResult>();
	LinkedList<String> ls=new LinkedList<String>();
		for(int i=0;i<ii.lpe.size();i++){
			LinkedList<Integer> lb=new LinkedList<Integer>();
			int j=0;
			while(j<str.length){
				
		for(int k=0;k<ii.lpe.get(i).st1.size();k++)	{
			
		if(ii.lpe.get(i).st1.get(k).equals(str[j]))	{
			
			if(!lb.contains(j)){
			lb.add(j);
			}
		}
		
		}
		j=j+1;
		
		
			}
			
			if(lb.size()==str.length){
				
				boolean b = false;
				SearchResult se=new SearchResult(ii.lpe.get(i),ii.lpe.get(i).getRelevanceOfPage(str,b));
				
				if(ii.lpe.get(i).getRelevanceOfPage(str,b)!=0)
				msr.addElement(se);
			}
			
		}
	
		A.addAll(mso.sortThisList(msr));
		for(int i=0;i<A.size();i++){
			ls.add(A.get(i).pn.web);
		}
		if(!ls.isEmpty())
		System.out.println(ls);
		else
			System.out.println("No page exists which contains all these words");
	
	
}
public void queryFindPagesWhichContainAnyOfTheseWords(String[] str) throws IOException{
	MySet<SearchResult> msr=new MySet<SearchResult>();
	MySort mso=new MySort();
		ArrayList<SearchResult>  A=new ArrayList<SearchResult>();
		LinkedList<String> ls=new LinkedList<String>();
		for(int i=0;i<ii.lpe.size();i++){
			boolean b=false;
		SearchResult se=new SearchResult(ii.lpe.get(i),ii.lpe.get(i).getRelevanceOfPage(str,b));
		
		if(ii.lpe.get(i).getRelevanceOfPage(str,b)!=0)
		msr.addElement(se);
		}
		A.addAll(mso.sortThisList(msr));
		for(int i=0;i<A.size();i++){
			ls.add(A.get(i).pn.web);
		}
		if(!ls.isEmpty())
		System.out.println(ls);
		else
			System.out.println("No page exists which contains any of these words");
		
}

public void performAction(String actionMessage) throws IOException{
	String A[]=actionMessage.split(" ");
	
	if(A[0].equals("addPage")){
	
		PageEntry Po=new PageEntry(A[1]);
		
		addPage(Po);
	}
	/*if(A[0].equals("queryFindPagesWhichContainWord")){
		
		queryFindPagesWhichContainWord(A[1]);
	}*/
	if(A[0].equals("queryFindPositionsOfWordInAPage")){
		String q1=A[1];
		String q2= A[2];
		queryFindPositionsOfWordInAPage(q1,q2);
	}
	if(A[0].equals("queryFindPagesWhichContainPhrase")){
		
		
		String[] ph=new String[A.length-1];
		  for(int i=1;i<A.length;i++){
			A[i]= A[i].toLowerCase();
			// System.out.println(A[i]);
        	  if(A[i].equals("stack") ||A[i].equals("structure")||A[i].equals("application") ){
        		  A[i]=A[i]+"s";
        	  }
          }
		for(int i=0;i<ph.length;i++){
			ph[i]=A[i+1];
		}
		queryFindPagesWhichContainPhrase(ph);
	}
	if(A[0].equals("queryFindPagesWhichContainAllWords")){
		String[] ph=new String[A.length-1];
		for(int i=1;i<A.length;i++){
			A[i]= A[i].toLowerCase();
      	  if(A[i].equals("stack") ||A[i].equals("structure")||A[i].equals("application") ){
      		  A[i]=A[i]+"s";
      	  }
        }
		
		for(int i=0;i<ph.length;i++){
			
			ph[i]=A[i+1];
		}
		
		queryFindPagesWhichContainAllWords(ph);
		
	}
	if(A[0].equals("queryFindPagesWhichContainAnyOfTheseWords") ||  A[0].equals("queryFindPagesWhichContainWord")){
		for(int i=1;i<A.length;i++){
			A[i]= A[i].toLowerCase();
      	  if(A[i].equals("stack") ||A[i].equals("structure")||A[i].equals("application") ){
      		  A[i]=A[i]+"s";
      	  }
        }
		String[] ph=new String[A.length-1];
		for(int i=0;i<ph.length;i++){
			ph[i]=A[i+1];
		}
		queryFindPagesWhichContainAnyOfTheseWords(ph);
	}
}
}
