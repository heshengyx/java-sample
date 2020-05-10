package com.hsheng.core.springboot.autoconfig.p2;

import org.springframework.stereotype.Component;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/10 19:04
 * @since TODO
 */
@Component
public class FtpServer implements Server {

    @Override
    public void start() {
        System.out.println("Ftp服务器启动中...");
    }

    @Override
    public void stop() {
        System.out.println("Ftp服务器关闭中...");
    }
}
