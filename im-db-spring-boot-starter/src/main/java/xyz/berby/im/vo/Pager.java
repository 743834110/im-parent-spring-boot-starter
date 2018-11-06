package xyz.berby.im.vo;

import java.util.List;

/**
 * 分页视图对象
 * @author litianfeng
 * Created on 2018/11/2
 */
public class Pager<T> {

    /**
     * 实体入参数
     */
    private T param;
    /**
     * 偏离值
     */
    private Integer offset = 0;
    /**
     * 分页大小
     */
    private Integer limit = 10;
    /**
     * 查询结果
     */
    private List<T> result;
    /**
     * 符合条件记录数
     */
    private Integer size;


    public Pager() {
    }

    public Pager(T param) {
        this.param = param;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
