package com.springboot.multi_bean;

import java.util.Objects;

/**
 * <p> 2023/4/4 </p>
 * 抽象类对信息只处理一次
 *
 * @author Fqq
 */
public abstract class PeopleAbstract implements People {

    private static volatile String msg;

    /**
     * 双检索单例模式
     *
     * @param msg 传过来的消息
     */
    @Override
    public void say(String msg) {
        // 数据发生变化时重新赋值
        if (PeopleAbstract.msg == null || !Objects.equals(PeopleAbstract.msg, msg)) {
            synchronized (this) {
                if (PeopleAbstract.msg == null || !Objects.equals(PeopleAbstract.msg, msg)) {
                    PeopleAbstract.msg = msg;
                }
            }
        }
        sayNotChange(PeopleAbstract.msg);
    }

    public abstract void sayNotChange(String msg);
}
