package com.example.springbootcommonspool.object;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/6/30 17:19
 * @description:
 */
@Log4j2
public class StuPooledObjectFactory implements PooledObjectFactory<Stu> {
    /**
     * Creates an instance that can be served by the pool and wrap it in a
     * {@link PooledObject} to be managed by the pool.
     *
     * @return a {@code PooledObject} wrapping an instance that can be served by the pool
     * @throws Exception if there is a problem creating a new instance,
     *                   this will be propagated to the code requesting an object.
     */
    @Override
    public PooledObject<Stu> makeObject() throws Exception {
        DefaultPooledObject<Stu> object=new DefaultPooledObject<>(
                new Stu("小明","28")
        );
        log.info("makeObject.....state=>{}",object.getState());
        return object;
    }

    /**
     * Destroys an instance no longer needed by the pool, using the default (NORMAL)
     * DestroyMode.
     * <p>
     * It is important for implementations of this method to be aware that there
     * is no guarantee about what state {@code obj} will be in and the
     * implementation should be prepared to handle unexpected errors.
     * </p>
     * <p>
     * Also, an implementation must take in to consideration that instances lost
     * to the garbage collector may never be destroyed.
     * </p>
     *
     * @param p a {@code PooledObject} wrapping the instance to be destroyed
     * @throws Exception should be avoided as it may be swallowed by
     *                   the pool implementation.
     * @see #validateObject
     * @see ObjectPool#invalidateObject
     */
    @Override
    public void destroyObject(PooledObject<Stu> p) throws Exception {
        log.info("destroyObject.....state=>{}",p.getState());
    }

    /**
     * Ensures that the instance is safe to be returned by the pool.
     *
     * @param p a {@code PooledObject} wrapping the instance to be validated
     * @return {@code false} if {@code obj} is not valid and should
     * be dropped from the pool, {@code true} otherwise.
     */
    @Override
    public boolean validateObject(PooledObject<Stu> p) {
        log.info("validateObject.....state=>{}",p.getState());
        return true;
    }

    /**
     * Reinitializes an instance to be returned by the pool.
     *
     * @param p a {@code PooledObject} wrapping the instance to be activated
     * @throws Exception if there is a problem activating {@code obj},
     *                   this exception may be swallowed by the pool.
     * @see #destroyObject
     */
    @Override
    public void activateObject(PooledObject<Stu> p) throws Exception {
        log.info("activateObject.....state=>{}",p.getState());
    }

    /**
     * Uninitializes an instance to be returned to the idle object pool.
     *
     * @param p a {@code PooledObject} wrapping the instance to be passivated
     * @throws Exception if there is a problem passivating {@code obj},
     *                   this exception may be swallowed by the pool.
     * @see #destroyObject
     */
    @Override
    public void passivateObject(PooledObject<Stu> p) throws Exception {
        log.info("passivateObject.....state=>{}",p.getState());
    }
}
