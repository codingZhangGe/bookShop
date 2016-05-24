package com.xupt.bookshop.common.datasource;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by zhangge on 16-4-22.
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    private Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(com.xupt.bookshop.common.datasource.DataSource)")
    public void aspect() {

    }

    @Before("aspect()")
    public void before(JoinPoint point) throws NoSuchMethodException {
        // 获取方法上面的注解信息

        // 实体类
        Object target = point.getTarget();
        // 方法名称
        String methodName = point.getSignature().getName();
        // 参数类型
        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        // 注解
        Class clazz = target.getClass();
        DataSource sConfig = (DataSource) clazz.getAnnotation(DataSource.class);
        if (sConfig != null && StringUtils.isNotBlank(sConfig.value())) {
            DynamicDataSourceHolder.setDataSource(sConfig.value());
        } else {
            DynamicDataSourceHolder.setDataSource(DataSource.master);
        }
        // 获取方法级别的注解
        Method method = clazz.getMethod(methodName, parameterTypes);
        if (method != null && method.isAnnotationPresent(DataSource.class)) {
            DataSource source = method.getAnnotation(DataSource.class);
            if (source != null && StringUtils.isNotBlank(source.value())) {
                DynamicDataSourceHolder.setDataSource(source.value());
            } else {
                DynamicDataSourceHolder.setDataSource(DataSource.master);
            }
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
