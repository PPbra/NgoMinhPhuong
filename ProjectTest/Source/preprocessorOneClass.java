

import java.io.*;
import java.util.*;

public class preprocessorOneClass {

public ArrayList<String> removeComment(String input){
    String StringTemp = new String();
    String source = readFile(input);
    StringTemp=source.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
    ArrayList<String> outputString = this.removeAllInsideMethod(StringTemp);

    return outputString;

}

 
private String readFile(String fileName) {    

        File file = new File(fileName);    

        char[] buffer = null;    

        try {    
                BufferedReader bufferedReader = new BufferedReader( new FileReader(file));    

                buffer = new char[(int)file.length()];    

                int i = 0;    
                int line = bufferedReader.read();    

                while (line != -1) {    
                    buffer[i++] = (char)line;    
                    line = bufferedReader.read();    
                }    

        } catch (IOException e) {    
            e.printStackTrace();    
        }    

        return new String(buffer);    
    }


private ArrayList<String>  removeAllInsideMethod(String input){

    String[] arrayStringTmp = input.split("\\n");
    ArrayList<String> listLineAfterReprcession = new ArrayList<String>();
    for(String a:arrayStringTmp){
        listLineAfterReprcession.add(a.trim().replaceAll("\\s+"," "));
    }
  
    return listLineAfterReprcession;

}



    
}