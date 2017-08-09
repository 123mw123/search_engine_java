package fourthass;

import java.util.LinkedList;

public class MySet<X> {
	LinkedList<X> x=new LinkedList<X>();
	
	public void addElement(X element){
		x.add(element);
	}
	
	public MySet<X> union(MySet<X> otherSet){
	MySet<X> a=new MySet<X>();
	MySet<X> b=new MySet<X>();
	a.x=this.x;
	b.x.addAll(a.x);
	
		for(int i=0;i<otherSet.x.size();i++)
		if(!a.x.contains(otherSet.x.get(i))){
			b.x.add(otherSet.x.get(i));
			
		}
		
	return b;	
	}
	public  MySet<X> intersection(MySet<X> otherSet){
		MySet<X> a=new MySet<X>();
		MySet<X> b=new MySet<X>();
		LinkedList<X> L=new LinkedList<X>();
		a.x=this.x;
		
		for(int i=0;i<otherSet.x.size();i++)
			if(a.x.contains(otherSet.x.get(i))){
				b.x.add(otherSet.x.get(i));
				
			}
		
		return b;
	}
	

	
}


