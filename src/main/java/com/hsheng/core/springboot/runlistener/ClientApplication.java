package com.hsheng.core.springboot.runlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * springboot启动流程
 * 核心分为2个步骤：
 * 1、创建 SpringApplication 对象
 * 2、调用 SpringApplication run 实现启动同时返回当前的容器上下文
 *
 * 流程分析：
 * 1、创建 SpringApplication 对象 Springboot容器初始化操作
 * 2、获取当前应用容器类型 原理：判断当前classpath是否有加载servlet类 返回servlet web 启动方式
 *    webApplicationType 分为三种类型
 *    1) NONE 不会嵌入 web 容器启动 (将springboot项目放入外部容器运行)
 *    2) SERVLET 基于web 容器启动
 *    3) REACTIVE 响应式启动 (Spring5新特性)
 * 3、setInitializers 读取Springboot包下的META-INF/spring.factories获取对应的ApplicationContextInitializer实现类，装配到集合中
 * 4、setListeners 读取Springboot包下的META-INF/spring.factories获取对应的ApplicationListener实现类，装配到集合中
 * 5、mainApplicationClass 获取当前运行的主函数
 * 6、调用 SpringApplication run 实现启动同时返回当前的容器上下文
 * 7、StopWatch stopWatch = new StopWatch() 记录springboot项目启动时间
 * 8、getRunListeners(args) 读取Springboot包下的META-INF/spring.factories获取对应的SpringApplicationRunListener实现类，装配到集合中
 * 9、listeners.starting() 循环调用监听strarting方法
 * 10、listeners.environmentPrepared(evironment) 读取配置文件到Springboot容器中
 * 11、Banner banner = printBanner(evironment) 打印Springboot banner
 * 12、创建Springboot上下文AnnotationConfigServletWebServerApplicationContext对象
 * 13、refreshContext(context) 刷新Springboot上下文
 * 14、开始创建tomcat容器
 * 15、开始加载SpringMVC
 * 16、afterRefresh 定义一个空的模板给其他子类实现重写
 * 17、listeners.started(context) 使用广播和回调机制通知监听器 Springboot容器已启动成功
 * 18、listeners.running(context) 使用广播和回调机制通知监听器 Springboot容器已成功running
 * @description TODO
 * @author hesheng
 * @date 2020/6/3 8:35
 * @since TODO
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        //启动并返回当前容器上下文
        ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class, args);
        //关闭容器
        context.close();
    }
}
