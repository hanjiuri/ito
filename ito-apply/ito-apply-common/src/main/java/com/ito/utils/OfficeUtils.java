package com.ito.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;
import java.io.*;

/**
 * Created by 韩九日 on 2017/6/23.
 */
public class OfficeUtils {
    /**
     *
     * @Title: getTextFromWord
     * @Description: 读取word文件内容
     * @return: 读出的word的内容
     * @path:文件存放的绝对路径
     */
    //解析word文档
    public String getTextFromWord(String filePath) throws IOException, OpenXML4JException, XmlException {
        String result = null;
        if(filePath.endsWith(".doc")){
            //解析word2003.docx
            InputStream is = new FileInputStream(new File(filePath));
            WordExtractor ex = new WordExtractor(is);
            result = ex.getText();
            is.close();
        }else if(filePath.endsWith(".docx")){
            //解析word2007.doc
            OPCPackage opcPackage = POIXMLDocument.openPackage(filePath);
            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
            result = extractor.getText();
            opcPackage.close();
            extractor.close();
        }
        return result;
    }
    /**
     *
     * @Title: getTextFromPdf
     * @Description: 读取pdf文件内容
     * @return: 读出的pdf的内容
     * @path:文件存放的绝对路径
     */
    //解析pdf
    public String getTextFromPdf(String filePath) throws IOException {
        String result = null;
        if(filePath.endsWith(".pdf")){
            PDDocument helloDocument = null;
            helloDocument = PDDocument.load(new File(filePath));
            PDFTextStripper textStripper = new PDFTextStripper();
            result = textStripper.getText(helloDocument);
            helloDocument.close();
        }
        return result;
    }
    /**
     * @param filePath 文件路径
     * @return 读出的Excel的内容
     */
    //解析excel
    public String getTextFromExcel(String filePath) throws IOException {
        //2003excel
        StringBuffer buff = new StringBuffer();
        // 创建对Excel工作簿文件的引用
        if(filePath.endsWith(".xls")){
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
            // 创建对工作表的引用。
            for (int numSheets = 0; numSheets < wb
                    .getNumberOfSheets(); numSheets++) {
                if (null != wb.getSheetAt(numSheets)) {
                    HSSFSheet aSheet = wb.getSheetAt(numSheets);// 获得一个sheet
                    for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet
                            .getLastRowNum(); rowNumOfSheet++) {
                        if (null != aSheet.getRow(rowNumOfSheet)) {
                            HSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一个行
                            for (int cellNumOfRow = 0; cellNumOfRow <= aRow
                                    .getLastCellNum(); cellNumOfRow++) {
                                if (null != aRow.getCell(cellNumOfRow)) {
                                    HSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                                    switch (aCell.getCellType()) {
                                        case HSSFCell.CELL_TYPE_FORMULA :
                                            break;
                                        case HSSFCell.CELL_TYPE_NUMERIC :
                                            buff.append(
                                                    aCell.getNumericCellValue())
                                                    .append('\t');
                                            break;
                                        case HSSFCell.CELL_TYPE_STRING :
                                            buff.append(
                                                    aCell.getStringCellValue())
                                                    .append('\t');
                                            break;
                                    }
                                }
                            }
                            buff.append('\n');
                        }
                    }
                }
            }
        }else if(filePath.endsWith(".xlsx")){
            //2007excel
            // 创建对Excel工作簿文件的引用
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));
            // 创建对工作表的引用。
            for (int numSheets = 0; numSheets < wb
                    .getNumberOfSheets(); numSheets++) {
                if (null != wb.getSheetAt(numSheets)) {
                    XSSFSheet aSheet = wb.getSheetAt(numSheets);// 获得一个sheet
                    for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet
                            .getLastRowNum(); rowNumOfSheet++) {
                        if (null != aSheet.getRow(rowNumOfSheet)) {
                            XSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一个行
                            for (int cellNumOfRow = 0; cellNumOfRow <= aRow
                                    .getLastCellNum(); cellNumOfRow++) {
                                if (null != aRow.getCell(cellNumOfRow)) {
                                    XSSFCell aCell = aRow.getCell(cellNumOfRow);// 获得列值
                                    switch (aCell.getCellType()) {
                                        case HSSFCell.CELL_TYPE_FORMULA :
                                            break;
                                        case HSSFCell.CELL_TYPE_NUMERIC :
                                            buff.append(
                                                    aCell.getNumericCellValue())
                                                    .append('\t');
                                            break;
                                        case HSSFCell.CELL_TYPE_STRING :
                                            buff.append(
                                                    aCell.getStringCellValue())
                                                    .append('\t');
                                            break;
                                    }
                                }
                            }
                            buff.append('\n');
                        }
                    }
                }
            }
        }
        return buff.toString();
    }
}
