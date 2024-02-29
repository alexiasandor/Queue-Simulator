package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    File file = new File("log.txt");
    public WriteFile(){

    }
    public void create() throws IOException{
        this.file.createNewFile();
    }

    public void writeInFile(String name)throws IOException{
        try{
            FileWriter writer = new FileWriter("D:\\PT2023_30228_Sandor_Alexia_Assigment2\\log1.txt.txt", true);
            BufferedWriter buffWr= new BufferedWriter(writer);
            buffWr.append(name);
            buffWr.newLine();
            buffWr.close();
            writer.close();

        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
