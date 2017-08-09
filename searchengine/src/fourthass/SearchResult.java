package fourthass;

public class SearchResult{ //implements Comparable<SearchResult>{
	PageEntry pn;
	float f;
	public SearchResult(PageEntry p, float r){
		
		
		pn=p;
		f=r;
	}
	public PageEntry getPageEntry(){
		return pn;
	}
	public float getRelevance(){
		return f;
	}
	
	public int compareTo(float f2) {
		if(f==f2)
		return 0;
		else if(f>f2)
			return -1;
		else 
			return 1;
	}
	

}
