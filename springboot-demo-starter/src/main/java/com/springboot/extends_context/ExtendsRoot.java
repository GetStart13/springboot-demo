package com.springboot.extends_context;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p> 2023/1/20 </p>
 * 中间注入 bean，子类实现时如果加入 spring 环境，中间类也会获得 spring 环境
 *
 * @author Fqq
 */
public abstract class ExtendsRoot implements RootInterface {
    @Autowired
    protected MiddleBean middleBean;

    @Override
    public String hello(String say) {
        middleBean.note();
        return talk(say);
    }

    abstract String talk(String say);
}
