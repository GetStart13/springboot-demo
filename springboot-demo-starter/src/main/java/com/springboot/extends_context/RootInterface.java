package com.springboot.extends_context;

/**
 * <p> 2023/1/20 </p>
 * 多个实现类，一个接口，指定不同的 bean 的名字以注入 spring 上下文，实现多态
 *
 * @author Fqq
 */
public interface RootInterface {
    String hello(String say);
}
