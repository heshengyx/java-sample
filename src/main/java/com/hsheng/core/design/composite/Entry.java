package com.hsheng.core.design.composite;

/**
 * @description composite模式
 * @author hesheng
 * @date 2020/4/16 8:15
 * @since TODO
 */
public abstract class Entry {

    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }
    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}
