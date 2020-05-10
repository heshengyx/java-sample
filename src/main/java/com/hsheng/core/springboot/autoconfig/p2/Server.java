package com.hsheng.core.springboot.autoconfig.p2;

/**
 * @description 服务器接口
 * @author hesheng
 * @date 2020/5/10 18:59
 * @since TODO
 */
public interface Server {

    /**
     * 启动服务器
     */
    void start();

    /**
     * 关闭服务器
     */
    void stop();

    /**
     * 服务器类型
     */
    enum Type {
        HTTP, //http服务器
        FTP //ftp服务器
    }
}
