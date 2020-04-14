package com.hsheng.core.design.factory.f2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:18
 * @since TODO
 */
public abstract class AbstTray extends AbstItem {

    protected List<AbstItem> items = new ArrayList<>();

    public AbstTray(String caption) {
        super(caption);
    }

    public void add(AbstItem item) {
        items.add(item);
    }
}
