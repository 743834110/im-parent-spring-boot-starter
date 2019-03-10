package xyz.berby.im.entity;

import java.util.List;

public abstract class AbstractUser<A extends AbstractAuth, R extends AbstractRole>{

    public abstract List<A> getAuthList();

    public abstract List<R> getRoleList();
}
