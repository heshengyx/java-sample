package com.hsheng.core.springboot.autoconfig.p2;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/10 19:06
 * @since TODO
 */
public class ServerImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableServer.class.getName());
        Server.Type type = (Server.Type) annotationAttributes.get("type");

        String[] importClassNames = new String[0];
        switch (type) {
            case HTTP:
                importClassNames = new String[] {HttpServer.class.getName()};
                break;
            case FTP:
                importClassNames = new String[] {FtpServer.class.getName()};
                break;
        }
        return importClassNames;
    }
}
