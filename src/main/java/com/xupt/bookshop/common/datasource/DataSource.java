package com.xupt.bookshop.common.datasource;

import java.lang.annotation.*;

/**
 * Created by zhangge on 16-4-22.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSource {
    String value() default DataSource.master;

    public static String master = "dataSource_w";
    public static String slave = "dataSource_r";

}
