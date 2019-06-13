package com.qfedu.utils;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtil {
    //重命名
    public static String renameFile(String fn){
        if (fn.length()>20){
            fn=fn.substring(fn.length()-20);
        }
        return UUID.randomUUID().toString().replace("-","")+"_"+fn;
    }

    //存储文件夹
    public static File createDir(String rootPath){
        File dir = new File(rootPath, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        if (!dir.exists()){
            dir.mkdirs();
        }
        return dir;
    }

}
