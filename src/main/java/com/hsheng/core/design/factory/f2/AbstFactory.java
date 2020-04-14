package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:26
 * @since TODO
 */
public abstract class AbstFactory {

    public static AbstFactory getFactory(String classname) {
        AbstFactory factory = null;
        try {
            factory = (AbstFactory) Class.forName(classname).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到" + classname + "类");
        }
        return factory;
    }

    protected abstract AbstLink createLink(String caption, String url);

    protected abstract AbstTray createTray(String caption);

    protected abstract AbstPage createPage(String title, String author);
}
