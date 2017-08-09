package fourthass;

import java.io.IOException;
import java.util.LinkedList;

public class WordEntry {
String w;

InvertedPageIndex iv=new InvertedPageIndex();

PageEntry pt;
int a;
MyLinkedList<Position> mpo;
LinkedList<Integer> iw;
AVLTree avl;

	public WordEntry(String word) throws IOException{
		
		w=word;
		avl=new AVLTree();
		 mpo=new MyLinkedList<Position>();
		 iw=new LinkedList<Integer>();
	}

public MyLinkedList<Position> getAllPositionsForThisWord(){
	
	
	 for(int i=0;i<iv.lpe.size();i++){
		
	for(int j=0;j<iv.lpe.get(i).lwp.size();j++)	 {
		if(iv.lpe.get(i).lwp.get(j).w.equals(this.w)){
			for(int k=0;k<iv.lpe.get(i).swe.size();k++){
				if(iv.lpe.get(i).swe.get(k).sr.equals(iv.lpe.get(i).web) && iv.lpe.get(i).swe.get(k).wi==j){
					
					avl.insert(iv.lpe.get(i).swe.get(k));
					mpo.add(iv.lpe.get(i).swe.get(k));
				}
			}
			
		}
	}
	 }
	
	return mpo;
}
}

 class AVLNode
{    
    AVLNode left, right;
    Position data;
    int height;


    public AVLNode(Position n)
    {
        left = null;
        right = null;
        data = n;
        height = 0;
    }     
}
 class AVLTree{
	 public AVLNode root;
	 LinkedList<Position> li;
	
	
	 public AVLTree(){
	 li=new LinkedList<Position>();	 

		 root=null;
	 }
	 public void insert(Position data){
		 root=insert(data,root);
	 }
	public int height(AVLNode t )
     {
       if( t == null)
    	   return -1 ;
       else	   return t.height;
     }
	private int max(int lhs, int rhs)
    {
		if(lhs > rhs)
        return   lhs ;
        else
        	return rhs;
    }
  
    private AVLNode insert(Position x, AVLNode t)
    {
        if (t == null)
            t = new AVLNode(x);
        else if (x.wi<=t.data.wi)
        {
            t.left = insert( x, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if( x .wi<=t.left.data.wi )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( x.wi > t.data.wi )
        {
            t.right = insert( x, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( x.wi > t.right.data.wi)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
          
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
   
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

   
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
  
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
       
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }  
    public boolean search(Position val)
    {
        return search(root, val);
    }
    private boolean search(AVLNode r, Position val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
        	Position rval = r.data;
            if (val.wi < rval.wi)
                r = r.left;
            else if (val.wi > rval.wi)
                r = r.right;
           
            else if(val.wi==rval.wi && !val.sr.equals(rval.sr)){
            	 r = r.left;
            }
            else if(val.wi==rval.wi && val.sr.equals(rval.sr))
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    public void preorder()
    {
        preorder(root);
      
    }
    private void preorder(AVLNode r)
    {
    	
    	if(r==null){
    		
    	}
    	
        if (r != null)
        {
            li.add(r.data );
           
            preorder(r.left);             
            preorder(r.right);
        }
     
    }
	 
 }
