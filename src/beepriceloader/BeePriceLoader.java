/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beepriceloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Artem
 */
public class BeePriceLoader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        prefixParser();
        if(true)
            return;
        File fl = new File("C:\\Users\\Artem\\Documents\\EXPERT\\20181121.csv");
        if(!fl.isFile()){
            System.out.println("Is not open");
            return;
        }
        try(BufferedReader fr = new BufferedReader( new FileReader(fl))){
            String line;
            int lineCounter = 0;
            while((line = fr.readLine())!=null){
                //System.out.println(line);
                line.replaceAll("\\\\\"", " ");
                String[] lineArr = line.split(";");
                if(lineArr[2].split(",").length>1){
                    String[] locationGroup = lineArr[2].split(",");
                    for(int ind=0; ind<locationGroup.length; ind++){
                        if(locationGroup[ind].split("-").length>1){
                            //System.out.println("Diapasone"+locationGroup[ind]);
                            long start = Long.parseLong(locationGroup[ind].split("-")[0].trim());
                            long end = Long.parseLong(locationGroup[ind].split("-")[1].trim());
                            while(start<=end){
                                lineCounter++;
                                System.out.println(lineCounter+" Country Code: "+lineArr[1]+" \t Local Code: "
                                        +start+"\t Rate: "+lineArr[3]+"\t Comment: "+lineArr[4]
                                        +"\t EFFECTIVED: "+lineArr[5]+"\t Destenation: "+lineArr[0]);
                                start++;
                            }
                            continue;
                        }
                        else
                            lineCounter++;
                            System.out.println(lineCounter+" Country Code: "+lineArr[1]+" \t Local Code: "
                                    +locationGroup[ind]+"\t Rate: "+lineArr[3]+"\t Comment: "+lineArr[4]
                                        +"\t EFFECTIVED: "+lineArr[5]+"\t Destenation: "+lineArr[0]);
                    }
                }
                else{
                    lineCounter++;
                    System.out.println(lineCounter+" Country Code: "+lineArr[1]+" \t Local Code: "
                            +lineArr[2]+"\t Rate: "+lineArr[3]+"\t Comment: "+lineArr[4]
                                        +"\t EFFECTIVED: "+lineArr[5]+"\t Destenation: "+lineArr[0]);
                }
            }
        }
        catch(Exception ex ){
            System.out.println("Error "+ex.getMessage());
        }
    }
    public static void prefixParser(){
        File fl = new File("C:\\Users\\Artem\\Documents\\EXPERT\\20181121.csv");
        if(!fl.isFile()){
            System.out.println("Is not open");
            return;
        }
        try(BufferedReader fr = new BufferedReader( new FileReader(fl))){
            String line;
            int lineCounter = 0;
            while((line = fr.readLine())!=null){
                //System.out.println(line);
                line.replaceAll("\\\\\"", " ");
                String[] lineArr = line.split(";");
                if(lineArr[2].split(",").length>1){
                    String[] locationGroup = lineArr[2].split(",");
                    for(int ind=0; ind<locationGroup.length; ind++){
                        if(locationGroup[ind].split("-").length>1){
                            //System.out.println("Diapasone"+locationGroup[ind]);
                            long start = Long.parseLong(locationGroup[ind].split("-")[0].trim());
                            long end = Long.parseLong(locationGroup[ind].split("-")[1].trim());
                            while(start<=end){
                                lineCounter++;
                                System.out.println(lineCounter+" prefex: "+lineArr[1].trim()+start+
                                        "\t Rate: "+lineArr[3].trim()+"\t Comment: "+lineArr[4].trim()
                                        +"\t EFFECTIVED: "+lineArr[5].trim()+"\t Destenation: "+lineArr[0].trim());
                                start++;
                            }
                            continue;
                        }
                        else
                            lineCounter++;
                            System.out.println(lineCounter+" Country Code: "+lineArr[1].trim()+locationGroup[ind].trim()
                                    +"\t Rate: "+lineArr[3].trim()+"\t Comment: "+lineArr[4].trim()
                                        +"\t EFFECTIVED: "+lineArr[5].trim()+"\t Destenation: "+lineArr[0].trim());
                    }
                }
                else{
                    lineCounter++;
                    System.out.println(lineCounter+" Country Code: "+lineArr[1].trim()+lineArr[2].trim()
                            +"\t Rate: "+lineArr[3].trim()+"\t Comment: "+lineArr[4].trim()
                                        +"\t EFFECTIVED: "+lineArr[5].trim()+"\t Destenation: "+lineArr[0].trim());
                }
            }
        }
        catch(Exception ex ){
            System.out.println("Error "+ex.getMessage());
        }
    }
}
