package com.springboot.bean_conflict;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * bean 冲突与位置检测，另一个 bean 在 jar 包中
 */
@Component
public class BeanConflictDemo {
    @Resource // @Autowired 会有警告信息，提示已经存在多个同类型的 bean，Resource 没有警告信息，且两者对于 bean 冲突的报错信息不同
    private RootBean rootBean;

    @PostConstruct
    void init() {
        rootBean.conflict();
    }
}
