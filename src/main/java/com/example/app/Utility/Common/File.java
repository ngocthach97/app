package com.example.app.Utility.Common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class File {
    public String readCellContent(Cell cell) {
        String content;
        switch (cell.getCellType()) {
            case 1:
                content = "";
                break;
            default:
                content = "";
        }
        return content;
    }

    public boolean checkIfRowIsEmpty(Row row) {
        return true;
    }
}
