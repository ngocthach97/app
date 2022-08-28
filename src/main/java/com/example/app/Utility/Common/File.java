package com.example.app.Utility.Common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import java.math.BigDecimal;

public class File {
    public String readCellContent(Cell cell) {
        String content = null;
//        switch (cell.getCellType()) {
//            case 0:
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    content = cell.getDateCellValue().toString();
//                } else {
//                    content = new BigDecimal(cell.getNumericCellValue()).toString();
//                }
//                break;
//            case 1:
//                content = cell.getStringCellValue();
//                break;
//            case 2:
//                content = cell.getCellFormula() + "";
//                break;
//            case 4:
//                content = cell.getBooleanCellValue() + "";
//                break;
//            default:
//                content = "";
//        }
        return content;
    }

    public boolean checkIfRowIsEmpty(Row row) {
        if (row == null || row.getLastCellNum() <= 0) {
            return true;
        }
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null) {
                return false;
            }
        }
        return true;
    }
}
