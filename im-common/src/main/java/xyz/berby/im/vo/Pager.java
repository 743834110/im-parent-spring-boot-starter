package xyz.berby.im.vo;

import java.util.List;
import java.util.Map;

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
     * 进行or运算的参数
     */
    private T and;
    /**
     * 进行or运算的参数
     */
    private T or;
    /**
     * 数据成组过滤
     */
    private Map<String, String[]> filter;

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

    /**
     * 输出数据排序记录
     */
    private Map<String, String> sorter;


    public Pager() {
    }

    public Map<String, String> getSorter() {
        return sorter;
    }

    public void setSorter(Map<String, String> sorter) {
        this.sorter = sorter;
    }

    public Pager(T param) {
        this.param = param;
    }

    public Pager(T param, int limit) {
        this.param = param;
        this.limit = limit;
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

    // 由于mybatis中and属于关键字，所以做一层转换
    public T getAndOperator() {
        return and;
    }

    public void setAnd(T and) {
        this.and = and;
    }

    // 由于mybatis中or属于关键字，所以做一层转换
    public T getOrOperator() {
        return or;
    }

    public void setOr(T or) {
        this.or = or;
    }

    public Map<String, String[]> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, String[]> filter) {
        this.filter = filter;
    }

    /**
     * 获取当前页数和页码对应的开始行数
     * @return Integer
     */
    public Integer getCurrentOffset() {
        return offset * limit;
    }
}
