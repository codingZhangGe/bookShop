package com.xupt.bookshop.common.utils;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ge.zhang on 16-4-18.
 */
public class FileUtils {
    private static Pattern pattern = Pattern.compile(".*\\.(bmp|dib|gif|jpe|jpeg|jpg|png|tif|ico)$");
    private static Splitter splitter = Splitter.on('.').omitEmptyStrings();

    public static String getFileType(String fileName) { // 获得图片类型
        Preconditions.checkNotNull(fileName);
        List<String> list = splitter.splitToList(fileName);
        Preconditions.checkArgument(!(list.size() > 2));
        if (list == null || list.size() <= 1) {
            return fileName;
        }
        return list.get(1);
    }

    public static String getFullName(String uuidName, String fileName) { // 生成文件名
        return uuidName + "." + getFileType(fileName);
    }

    public static boolean isPictures(CommonsMultipartFile[] files) {// 判断是否为图片
        Preconditions.checkNotNull(files);
        for (CommonsMultipartFile file : files) {
            Matcher matcher = pattern.matcher(file.getFileItem().getName());
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;

    }

}
