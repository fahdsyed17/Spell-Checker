
package project2;
import java.io.*;

public class BinarySearchTree implements SpChecker{
    protected TNode root; // root of the tree
    
    public BinarySearchTree(String filename)throws Exception {//Constructor
        set(filename); //additional function to make the tree
    }
    
    public void set(String filename) throws Exception{
        String i;
        int j=0;
        
        BufferedReader in=new BufferedReader(new FileReader(filename));
        String Array[] = new String[24988];
        while((i = in.readLine()) != null){//reading the dictionary file and storing the elements into a string array
            Array[j] = i;
            j++;
        }
        
        int left = -1;
        int right = Array.length;
        int mid = (left+right)/2;
        add(Array[mid]); //making the root of the tree
        
        right = mid;
        while(left+1 != right){ //Adding the middles of the left part of the array
            mid = (left+right)/2;
            add(Array[mid]);
            right = mid;
        }
        
        left = -1;
        right = Array.length;
        mid = (left+right)/2;
        left = mid;
        
        while(left+1 != right){ //Adding the middle of the right parts of the array
            mid = (left+right)/2;
            add(Array[mid]);
            left = mid;
        }
        for(int k=0;k<Array.length;k++){
            add(Array[k]); //Adding the remaining elements (except the middles which are already added) of the array
        }
    }
    public Result add(String s){//This function adds an element into the binary tree 
        Result r1 = new Result();
        if(root == null){
            root = new TNode(s,null,null);//Creating the root
            r1.numbProbes = 0;
        }
        else{
            r1.numbProbes = 0;
            insertTree(s, root, r1);//Function to add the elements at their appropriate place 
        }
        return r1;
    }
    public void insertTree (String s, TNode t, Result r){
        r.numbProbes++;  //counting the no. of probes traversed
        if(s.compareTo(t.element)<0){
            if(t.left == null)
                t.left = new TNode(s,null,null);//if the element is smaller, it will be added to the left
            else 
                insertTree(s,t.left,r);
        }
        else if(s.compareTo(t.element)>0)
            if(t.right == null)
                t.right = new TNode(s,null,null);//if the element is bigger, it will be added to the right
            else 
                insertTree(s, t.right, r);
    }
    public Result check(String s){//this function calls another function to check if the element is in the tree or not
        Result r2 = new Result();
        findTree(s, root, r2);//function to check if the element is in the tree or not
        return r2;
    }
    public void findTree(String s, TNode t, Result r){
        TNode p = null; //pointer to traverse the tree
        t = root; //another pointer to traverse the tree
        int flag = 0;
        
        while (t!=null){
            if(s.compareTo(t.element)<0){//if less then go to the left part of the tree
                p=t;
                if(t != null){
                    t = t.left;
                    r.numbProbes++;
                }
            }
            if(t != null){
                if(s.compareTo(t.element)>0){ //if bigger then go to the right part
                    p=t;
                    t = t.right;
                    r.numbProbes++;
                }
                else if(s.compareTo(t.element) == 0){//if the element is found
                    flag = 1;
                    r.found = true;
                    break;
                }
            }
        }
        
        if(flag != 1){
            r.found = false;
            r.suggestion = p.element; //the suggestion will be the element to which p is pointing.
        }
    }
}
          
                    
                
    
        
        

