package za.co.alexanderforbes.filereader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import za.co.alexanderforbes.writefile.WriteFile;

/**
 *
 * @author Keoagile
 */
public class ExcelReader {

    WriteFile file = new WriteFile();

    public ExcelReader() {
    }

    public void displayFromExcel(String xlsPath) {
        InputStream inputStream = null;
        int additions = 0;

        try {
            inputStream = new FileInputStream(xlsPath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the specified path.");
            e.printStackTrace();
        }

        try {

            XSSFWorkbook workBook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workBook.getSheetAt(0);

            Iterator<Row> rows = sheet.rowIterator();

            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();

                //skip the header row
                if (row.getRowNum() == 0) {
                    continue;
                }
                //go through the cells after getting the row
                Iterator<Cell> cells = row.cellIterator();

                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();

                    System.out.println("Cell No.: " + cell.getReference());

                    //display the value of the colums according to their types
                    switch (cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_NUMERIC: {

                            // cell type numeric.
                            System.out.println("Numeric value: " + cell.getNumericCellValue());
                            additions += cell.getNumericCellValue();

                            break;
                        }

                        case XSSFCell.CELL_TYPE_STRING: {

                            // cell type string.
                            XSSFRichTextString richTextString = cell.getRichStringCellValue();

                            System.out.println("String value: " + richTextString.getString());

                            break;
                        }

                        default: {

                            // types other than String and Numeric.
                            System.out.println("Type not supported.");

                            break;
                        }
                    }
                }
            }
            System.out.println("additions: " + additions);

            //write the addition of the colums to the file
            file.writeTxtFile(String.valueOf(additions), "Result.txt");
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
