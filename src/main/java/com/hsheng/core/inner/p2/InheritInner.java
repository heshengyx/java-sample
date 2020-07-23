package com.hsheng.core.inner.p2;

/**
 * @description 继承内部类
 * @author hesheng
 * @date 2020/7/9 11:18
 * @since TODO
 */
public class InheritInner extends WithInner.Inner {

    //- InheritInner() {} // Won't compile
    public InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}

class WithInner {
    class Inner {}
}
