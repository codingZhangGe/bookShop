package com.qunar.qauction.web.filter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Description: HttpServletRequestWrapper重新包装HttpServletRequest的参数
 *
 * @author lingtong.fu
 * @version 2016-04-18 15:40
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 转义HttpServletRequest参数
     *
     * @return HttpServletRequest被转义过后的参数
     */
    @Override
    public String[] getParameterValues(String parameter) {
        String[] originalParamsArray = super.getParameterValues(parameter);
        if (originalParamsArray == null) {
            return null;
        }
        String[] encodedValues = new String[originalParamsArray.length];
        int index = 0;
        // foreach无法修改内容
        for (String paraValue : originalParamsArray) {
            encodedValues[index] = stripXSS(paraValue);
            index++;
        }
        return encodedValues;
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        return stripXSS(value);
    }

    /**
     * 转义HttpServletRequest HEADER参数
     *
     * @return HttpServletRequest HEADER被转义后的参数
     */
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return stripXSS(value);
    }

    /**
     * 对接收的非空字符串进行转义|对于后期不支持的需加正则表达式进行转义并添加三元表达式
     */
    private String stripXSS(String value) {
        return !StringUtils.isBlank(value) ? StringEscapeUtils.escapeHtml4(value) : value;
    }
}
