package fourthass;

import java.util.LinkedList;
public class InvertedPageIndex {
static LinkedList<PageEntry>  lpe=new LinkedList<PageEntry>();
MySet<PageEntry> mpe;
 MySet<PageEntry> ms1;

	public void addPage(PageEntry p){
		
	if(!lpe.contains(p))
		lpe.add(p);
	
	
	}
		
	public MySet<PageEntry> getPagesWhichContainWord(String str){
	mpe=new MySet<PageEntry>();
if(!str.equals("a") && !str.equals("an") && !str.equals("the") && !str.equals("the") && !str.equals("they") && !str.equals("these") && !str.equals("for") && !str.equals("is") && !str.equals("are") && !str.equals("of") && !str.equals("was") && !str.equals("or") && !str.equals("and") && !str.equals("does") && !str.equals("will")&& !str.equals("whose"))
	{
	for(int i=0;i<lpe.size();i++){
		
		
	for(int j=0;j<lpe.get(i).swe.size();j++){
		if(lpe.get(i).st.contains(str)){
			
		if(lpe.get(i).swe.get(j).sr.equals(lpe.get(i).web) && lpe.get(i).st.get(lpe.get(i).swe.get(j).wi).equals(str)){
			
			if(!mpe.x.contains(lpe.get(i)))
			mpe.addElement(lpe.get(i));
	
			}
		}
	}
		
		
		
	}
	}
	return mpe;
	}
	public MySet<PageEntry>getPagesWhichContainPhrase(String[] str){
	ms1=new MySet<PageEntry>();
	
	for(int i=0;i<lpe.size();i++){
	
		for(int j=0;j<lpe.get(i).st1.size();j++){
		
			if(lpe.get(i).st1.get(j).equals(str[0])){
				
				int k=j;
				int n=0;
			int l=0;
				while( l<str.length && k<lpe.get(i).st1.size()&& lpe.get(i).st1.get(k).equals(str[l]) ){
					
					if(k<lpe.get(i).st1.size())
					k=k+1;
					n=n+1;
					if(l<str.length)
						l=l+1;
					
				}
				if(n==str.length)
					if(!ms1.x.contains(lpe.get(i)))
					ms1.addElement(lpe.get(i));
				
			
			}
		}
		
	}
	return ms1;
	}
}
