package org.springboot.example.bean_conflict.different;

import org.springboot.example.bean_conflict.RootBean;

/**
 * <p> 2023/1/29 </p>
 * 如果是在同一个路径中。同一个名字，就会发生 jar 包冲突，此时另一个 ConflictOne 将被覆盖，因此启动时不会报错
 * <p> 这里加入 different 文件夹，更改路径，bean 发生冲突
 *
 * <p> 当 bean 名字不一样时报错：No qualifying bean of type 'com.springboot.bean_conflict.RootBean' available:
 * expected single matching bean but found 2: conflictTwo,conflictOne
 *
 * <p> 当 bean 名字一样时报错：Annotation-specified bean name 'conflictOne' for bean class
 * [com.springboot.bean_conflict.ConflictOne] conflicts with existing,
 * non-compatible bean definition of same name and class [com.springboot.bean_conflict.different.ConflictOne]
 *
 * @author Fqq
 */
//@Component // 先注释掉，不然项目启动不了
public class ConflictOne implements RootBean {
    @Override
    public void conflict() {
        System.out.println("=== ConflictOne ===");
    }
}
