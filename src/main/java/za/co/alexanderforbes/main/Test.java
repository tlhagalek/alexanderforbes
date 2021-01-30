/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.alexanderforbes.main;

import za.co.alexanderforbes.filereader.ExcelReader;

/**
 *
 * @author Keoagile
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExcelReader poiExample = new ExcelReader();
        
        String xlsPath = "C:\\Users\\Keoagile\\Downloads\\Input.xlsx";

        poiExample.displayFromExcel(xlsPath);
        
    }
    
}
