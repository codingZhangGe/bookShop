package com.xupt.bookshop.common.utils.beanmapper;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description: used to scan the class by some include/exclude filters, e.g. filter by annotation
 * <p> now we use ClassPathScanningCandidateComponentProvider to scan the class, maybe change it in the future
 * @author lingtong.fu
 * @version 2016-04-20 21:50
 */
public class MapClassScanner {
    private final ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);

    /**
    * find class in basePackages, should add filter before find class
    * @param basePackages
    * @return
    */
    public final Collection<Class<?>> scan(String basePackages) {
        final List<Class<?>> classes = new ArrayList<Class<?>>();
        String[] basePackageArray = StringUtils.tokenizeToStringArray(basePackages,
                ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);

        for (final String basePackage : basePackageArray) {
            for (final BeanDefinition candidate : scanner.findCandidateComponents(
                    basePackage)) {
                classes.add(ClassUtils.resolveClassName(
                        candidate.getBeanClassName(),
                        ClassUtils.getDefaultClassLoader()));
            }
        }

        return classes;
    }

    /**
    * add include filter for this scanner
    * @param filter
    */
    public void addIncludeFilter(TypeFilter filter) {
        scanner.addIncludeFilter(filter);
    }

    /**
    * add exclude filter for this scanner
    * @param filter
    */
    public void addExcludeFilter(TypeFilter filter) {
        scanner.addExcludeFilter(filter);
    }
}
