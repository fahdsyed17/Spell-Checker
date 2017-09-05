
package project2;
import java.io.*;
import java.lang.String;
import javax.swing.JOptionPane;

public class TestSpellChecker {
    public static void main(String[] args) throws Exception{
        String filename;
        filename = JOptionPane.showInputDialog("Enter the input filename = ");
        String i;
        String result = "";
        
        int counter = 1;
        BinarySearchTree bst = new BinarySearchTree ("Dictionary.txt");
        
        BufferedReader in1 = new BufferedReader (new FileReader(filename));
        
        while((i=in1.readLine())!= null){
            Result r = bst.check(i);
            if(r.found == true)
                result += "\r\n"+" "+counter+" "+i+":"+" "+"Yes the word is found in the Dictionary. "+"The no. of probes traversed = "+r.numbProbes;
            else
                result += "\r\n"+" "+counter+" "+i+":"+" "+"No, the word is not found in the Dictionary."+" "+"The alternative spelling could be: "+r.suggestion+". "+"The no. of probes traversed = "+r.numbProbes;
            counter++;
        }
        OutputResult(result);    
    }
    
    public static void OutputResult(String r)throws Exception{
        String Outname;
        Outname = JOptionPane.showInputDialog("Enter Filename for Output = ");
        PrintWriter output = new PrintWriter(new FileWriter(Outname));
        
        output.write(r);
        output.close();
    }
}

