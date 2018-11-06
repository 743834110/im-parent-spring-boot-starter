package xyz.berby.im.entity;


import java.util.HashMap;
import java.util.Map;

/**
 * 抽象bean基类
 * @param <T>
 */
public abstract class AbstractBean<T> {

    /**
     * 关联子bean类
     */
    private T refBeans;

    /**
     * bean中额外携带到数据
     */
    private Map<String, Object> extra;


    public T getRefBeans() {
        return refBeans;
    }

    public void setRefBeans(T refBeans) {
        this.refBeans = refBeans;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setAttribute(String key, Object value) {
        if (this.extra == null) {
            this.extra = new HashMap<>();
        }
        this.extra.put(key, value);
    }
}
