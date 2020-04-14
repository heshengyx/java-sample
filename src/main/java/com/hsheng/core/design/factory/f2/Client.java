package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:31
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        AbstFactory factory = AbstFactory.getFactory("com.hsheng.core.design.factory.f2.ListFactory");
        AbstLink people = factory.createLink("人民日报", "http://www.people.com.cn");

        AbstTray traynews = factory.createTray("日报");
        traynews.add(people);

        AbstPage page = factory.createPage("LinkPage", "张珊");
        page.add(traynews);
        page.output();
    }
}
