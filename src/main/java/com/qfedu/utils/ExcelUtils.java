package com.qfedu.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static List<Map<String, Object>> readExcel(String fileName, InputStream inputStream) throws Exception {
        boolean ret = isXlS(fileName);
        // 定义工作簿接口变量
        Workbook workbook = null;
        if(ret == true){
            workbook = new HSSFWorkbook(inputStream);
        }else{
            workbook = new XSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheetAt(0);
        // 读取标题行
        Row titleRow = sheet.getRow(0);
        List<String> titleList = new ArrayList<>();
        // 获取单元格的个数
        short lastCellNum = titleRow.getLastCellNum();
        for(int i = 0; i < lastCellNum; i++){
            Cell cell = titleRow.getCell(i);
            // 设置单元格类型
            cell.setCellType(CellType.STRING);
            // 保存标题数据
            titleList.add(cell.getStringCellValue());
        }
        List<Map<String, Object>> list = new ArrayList<>();
        // 获取总行数
        int lastRowNum = sheet.getLastRowNum();
        for(int i = 1; i <= lastRowNum; i++){
            Row row = sheet.getRow(i);
            Map<String, Object> map = new HashMap<>();
            for(int j = 0; j < lastCellNum; j++){
                Cell cell = row.getCell(j);
                if(cell == null){
                    continue;
                }
                //cell.setCellType(CellType.STRING);
                /*String value = "";
                if(cell !=null){
                    if(cell.getCellType() == 0){
                        if(HSSFDateUtil.isCellDateFormatted(cell)){
                            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            value = sdf.format(cell.getDateCellValue());
                            map.put(titleList.get(j), value);
                            continue;
                        }
                    }else{
                        cell.setCellType(CellType.STRING);
                        value = cell.getStringCellValue();
                        map.put(titleList.get(j), value);
                    }

                }*/
                // 获取单元格类型
                CellType cellTypeEnum = cell.getCellTypeEnum();
                switch(cellTypeEnum){
                    case STRING:
                        String cellValue = cell.getStringCellValue();
                        System.out.println("cell的值是"+cellValue);
                        map.put(titleList.get(j), cellValue);
                        break;
                    case NUMERIC:
                        String value = "";
                        String aa = cell.getCellStyle().getDataFormatString();
                        System.out.println(aa);
                        if(cell.getCellStyle().getDataFormatString().equals("General")){
                            value = ((int)cell.getNumericCellValue())+"";
                        }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            value = sdf.format(cell.getDateCellValue());
                        }
                        System.out.println("Cell的值是"+value);
                        map.put(titleList.get(j), value);

                        break;
                    case BLANK: // 空值
                        break;
                    case _NONE:
                        break;
                    case FORMULA:// 公式
                        break;
                    case ERROR: // 故障
                        break;
                    case BOOLEAN:
                        break;
                }



                // 将单元格中数据放到map对象中
                //
            }
            // 将每行数据放到list中
            list.add(map);
        }

        workbook.close();
        return list;
    }

    // D:/a.xls    XLS     /^.+\.(xls)$/i
    public static  boolean isXlS(String fileName){
        if(fileName.matches("^.+\\.(?i)(xls)$")){
            return true;
        }else if(fileName.matches("^.+\\.(?i)(xlsx)$")){
            return false;
        }else{
            throw  new RuntimeException("格式错误");
        }
    }
}
