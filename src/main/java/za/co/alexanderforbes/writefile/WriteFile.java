/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.alexanderforbes.writefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Keoagile
 */
public class WriteFile {
    
    public void writeTxtFile(String fileContent, String fileName){

        //write file to the project directory
        // If the file doesn't exists, create and write to it
        // If the file exists, truncate (remove all content) and write to it
        
        
        
        try (FileWriter writer = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(fileContent);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    
    
}
