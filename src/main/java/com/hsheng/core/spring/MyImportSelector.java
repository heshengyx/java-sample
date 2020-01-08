package com.hsheng.core.spring;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/8 10:12
 * @since TODO
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {ColorBlack.class.getName(), ColorWhite.class.getName()};
    }
}
