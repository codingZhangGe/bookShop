package com.xupt.bookshop.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xupt.bookshop.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import qunar.api.pojo.CodeMessage;
import qunar.api.pojo.json.JsonV2;

import com.google.common.base.Preconditions;
import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.model.upload.UploadItemParam;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public class ParameterCheckUtil {
    /* 异常信息 */
    public static final String NULL_PARAM_EXCEPTION = "参数为空";

    private static Pattern telephonePattern = Pattern.compile(Constants.TELEPHONE_REGEX);

    private static DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 检查参数是否为空，返回指定异常信息
     */
    public static <T> T checkNotNull(T param) throws ParameterException {
        if (param == null) {
            throw new ParameterException(NULL_PARAM_EXCEPTION);
        }
        return param;
    }

    /**
     * 检查参数是否为空，返回自定义异常信息
     */
    public static <T> T checkNotNull(T param, String message) throws ParameterException {
        if (param == null) {
            throw new ParameterException(message);
        }
        return param;
    }

    /**
     * 检查条件是否为真，返回默认异常信息
     */
    public static void checkArgument(boolean expression) throws ParameterException {
        if (!expression) {
            throw new ParameterException();
        }
    }

    /**
     * 检查条件是否为真，返回自定义异常信息
     */
    public static void checkArgument(boolean expression, String exceptionMsg) throws ParameterException {
        if (!expression) {
            throw new ParameterException(exceptionMsg);
        }
    }

    public static String checkStringNotBlank(String param, String message) throws ParameterException {
        if (param == null || param.equals("")) {
            throw new ParameterException(message);
        }
        return param;
    }

    /**
     * 检查电话号码是否正确
     */
    public static void checkTelephone(String telephone) throws ParameterException {
        Matcher m = telephonePattern.matcher(telephone);
        if (!m.matches()) {
            throw new ParameterException("电话号码不正确");
        }
    }

    /**
     * 检查上传信息的合法性
     */
    public static JsonV2 checkUploadItem(UploadItemParam item) {
        Preconditions.checkNotNull(item);


        DateTime dateTime = DateTime.now();

        if (StringUtils.isBlank(item.getBookId())) {
            return new JsonV2(CodeMessage.SYSTEM_ERROR, "itemId不能为空", "");
        }
        return new JsonV2(CodeMessage.OK, "信息校验正确", "");
    }



    public static String checkBingResultParam(BindingResult result) {

        if (result.hasErrors()) {
            StringBuilder builder = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                builder.append(error.getDefaultMessage()).append(";");
            }

            return builder.toString();
        } else {
            return "true";
        }
    }

}
