package com.hsheng.core.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description TODO
 * @author hesheng
 * @date 2019/12/21 15:00
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
/*
//根据参数类型可以知道，其实可以传入多个annotatedClasses，但是这种情况出现的比较少
public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
    //调用无参构造函数，会先调用父类GenericApplicationContext的构造函数
    //父类的构造函数里面就是初始化DefaultListableBeanFactory，并且赋值给beanFactory
    //本类的构造函数里面，初始化了一个读取器：AnnotatedBeanDefinitionReader read，一个扫描器ClassPathBeanDefinitionScanner scanner
    //scanner的用处不是很大，它仅仅是在我们外部手动调用 .scan 等方法才有用，常规方式是不会用到scanner对象的
    this();
    //把传入的类进行注册，这里有两个情况，
    //传入传统的配置类
    //传入bean（虽然一般没有人会这么做
    //看到后面会知道spring把传统的带上@Configuration的配置类称之为FULL配置类，不带@Configuration的称之为Lite配置类
    //但是我们这里先把带上@Configuration的配置类称之为传统配置类，不带的称之为普通bean
    register(annotatedClasses);
    //以上两行代码，主要是把我们的配置类和内置的几个后置处理器放到了两个集合中
    //this.beanDefinitionMap.put(beanName, beanDefinition);
    //this.beanDefinitionNames.add(beanName);
    //刷新
    refresh();
}*/
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        //System.out.println(userService);
        //后来才知道spring允许我们手动添加BeanFactoryPostProcessor
        //context.addBeanFactoryPostProcessor(null);
        System.out.println("----------------------------------");
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        System.out.println("----------------------------------");

        Blue blue = context.getBean(Blue.class);
        blue.print();
        Yellow yellow = context.getBean(Yellow.class);
        yellow.print();

        System.out.println("----------------------------------");
        MyMapper myMapper = (MyMapper) context.getBean("myFactoryBean");
        myMapper.getName();
        //System.out.println(context.getBean("myFactoryBean"));
        //System.out.println(context.getBean("#myFactoryBean"));
        context.destroy();

        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(MyMapper.class.getName());
    }
}
/**
 * public class AnnotationConfigApplicationContext extends GenericApplicationContext implements AnnotationConfigRegistry
 * public AnnotationConfigApplicationContext() {
 *     //会隐式调用父类的构造方法，初始化DefaultListableBeanFactory
 *     //初始化一个Bean读取器
 *     this.reader = new AnnotatedBeanDefinitionReader(this);
 *     //初始化一个扫描器，它仅仅是在我们外部手动调用 .scan 等方法才有用，常规方式是不会用到scanner对象的
 *     this.scanner = new ClassPathBeanDefinitionScanner(this);
 * }
 */
/**
 * DefaultListableBeanFactory是相当重要的，从字面意思就可以看出它是一个Bean的工厂，什么是Bean的工厂？当然就是用来生产和获得Bean的
 * public class GenericApplicationContext extends AbstractApplicationContext implements BeanDefinitionRegistry {
 *     private final DefaultListableBeanFactory beanFactory;
 *     public GenericApplicationContext() {
 *         this.beanFactory = new DefaultListableBeanFactory();
 *     }
 * }
 * 这里的BeanDefinitionRegistry当然就是AnnotationConfigApplicationContext的实例了
 * public AnnotatedBeanDefinitionReader(BeanDefinitionRegistry registry) {
 *     this(registry, getOrCreateEnvironment(registry));
 * }
 */
/**
 * BeanDefinition是什么，顾名思义，它是用来描述Bean的，里面存放着关于Bean的一系列信息，比如Bean的作用域，Bean所对应的Class，
 * 是否懒加载，是否Primary等等，这个BeanDefinition也相当重要
 *
 * //beanDefinitionMap是Map<String, BeanDefinition>，
 * //这里就是把beanName作为key，beanDefinition作为value，推到map里面
 * this.beanDefinitionMap.put(beanName, beanDefinition);
 *
 * //beanDefinitionNames就是一个List<String>,这里就是把beanName放到List中去
 * this.beanDefinitionNames.add(beanName);
 * 从这里可以看出DefaultListableBeanFactory就是我们所说的容器了，里面放着beanDefinitionMap，beanDefinitionNames，
 * beanDefinitionMap是一个hashMap，beanName作为Key,beanDefinition作为Value，beanDefinitionNames是一个集合，里面存放了beanName。
 */
/**
 * public void refresh() throws BeansException, IllegalStateException {
 *         synchronized(this.startupShutdownMonitor) {
 *             this.prepareRefresh(); //刷新预处理，和主流程关系不大，就是保存了容器的启动时间，启动标志等
 *             //这个方法和主流程关系也不是很大，可以简单的认为，就是把beanFactory取出来而已
 *             ConfigurableListableBeanFactory beanFactory = this.obtainFreshBeanFactory();
 *             //还是一些准备工作，添加了两个后置处理器：ApplicationContextAwareProcessor，ApplicationListenerDetector
 *             this.prepareBeanFactory(beanFactory);
 *
 *             try {
 *                 this.postProcessBeanFactory(beanFactory); //空方法，可能以后Spring会进行扩展
 *                 //执行自定义的BeanFactoryProcessor和内置的BeanFactoryProcessor
 *                 this.invokeBeanFactoryPostProcessors(beanFactory); //重点代码
 *                 this.registerBeanPostProcessors(beanFactory);
 *                 this.initMessageSource();
 *                 this.initApplicationEventMulticaster();
 *                 this.onRefresh();
 *                 this.registerListeners();
 *                 //用来实例化懒加载单例Bean的，也就是我们的Bean都是在这里被创建出来的
 *                 this.finishBeanFactoryInitialization(beanFactory);
 *                 this.finishRefresh();
 *             } catch (BeansException var9) {
 *                 if (this.logger.isWarnEnabled()) {
 *                     this.logger.warn("Exception encountered during context initialization - cancelling refresh attempt: " + var9);
 *                 }
 *
 *                 this.destroyBeans();
 *                 this.cancelRefresh(var9);
 *                 throw var9;
 *             } finally {
 *                 this.resetCommonCaches();
 *             }
 *
 *         }
 *     }
 */