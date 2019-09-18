
import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;

public class FileAvl{
    
    AvlTree<String> tree = new AvlTree<>();
    LinkedList<Integer> numbers = new LinkedList<>();
    
    public FileAvl(String word){
        
    }
    
    public void indexWord(String word, int line){
        
        tree.insert( word, line );
        
    }

    public LinkedList getLinesForWord(String word){ 
        return tree.printList(word, tree.getNode(word)); //to retrun
    }
    
    public void printIndex(){
        tree.printTree();
    }
}
