
package project2;

public class Result {
    
    boolean found;
    int numbProbes;
    String suggestion;
    public String toString(){
        String result = "";
        if(this.found == true)
            result += "\r\n"+" "+" "+":"+" "+"Yes the word is found in the Dictionary. "+ " "+"The no. of probes traversed = "+this.numbProbes;
        else
            result += "\r\n"+" "+" "+":"+"No, the word is not found in the Dictionary."+" "+"The alternative spelling could be: "+this.suggestion+". "+"The no. of probes traversed = "+this.numbProbes;
            
            return (result);
    }
}
