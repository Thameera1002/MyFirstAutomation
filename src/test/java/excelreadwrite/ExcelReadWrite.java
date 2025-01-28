package excelreadwrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ExcelReadWrite {
    private static List<Object[]> studentDetail = (List<Object[]>) Arrays.asList(
            new Object[]{"Amal", 25},
            new Object[]{"Sunil", 30},
            new Object[]{"Pasan", 28}
    );

    public static void writeToExcel() throws IOException {
        OutputStream outputStream = new FileOutputStream("studentDetails.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet1");

        IntStream.range(0, studentDetail.size()).forEach((index) -> {
            XSSFRow xssfRow = xssfSheet.createRow(index);
            Object[] stdDetails = studentDetail.get(index);
            List<Object> objValues = Arrays.stream(stdDetails).toList();

            IntStream.range(0, objValues.size()).forEach((index2) -> {
                XSSFCell xssfCell = null;
                if (objValues.get(index2) instanceof String) {
                    xssfCell = xssfRow.createCell(index2, CellType.STRING);
                    xssfCell.setCellValue((String) objValues.get(index2));
                } else {
                    xssfCell = xssfRow.createCell(index2, CellType.NUMERIC);
                    xssfCell.setCellValue((int) objValues.get(index2));
                }
            });
        });

        xssfWorkbook.write(outputStream);
    }

    public static void readFromExcel() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("studentDetails.xlsx");
             XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream)) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheet("Sheet1");

            List<Object[]> readData = new ArrayList<>();

            for (Row row : xssfSheet) {
                List<Object> rowData = new ArrayList<>();
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> rowData.add(cell.getStringCellValue());
                        case NUMERIC -> rowData.add(cell.getNumericCellValue());
                    }
                }
                readData.add(rowData.toArray());
            }

            readData.forEach(row-> System.out.println(Arrays.toString(row)));
        }
    }

    public static void main(String[] args) throws IOException {
        ExcelReadWrite.writeToExcel();

        ExcelReadWrite.readFromExcel();
    }


}
