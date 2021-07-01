package com.example.springbootcommonspool.object;

import lombok.val;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/6/30 17:13
 * @description:
 */
class StuTest {
    @Test
public void cp() throws Exception {
        GenericObjectPool<Stu> pool = new GenericObjectPool<Stu>(new StuPooledObjectFactory());
         Stu stu = pool.borrowObject();
         stu.setName("小高");
         pool.returnObject(stu);

    }
}
