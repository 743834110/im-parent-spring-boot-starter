package xyz.berby.im.vo;

import lombok.*;

import java.util.List;

/**
 * 增删改的数据实体类
 * @author LTF
 * Created on 2019/4/2
 * @param <T>
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputBean<T> {

    private List<T> insert;
    private List<T> update;
    private List<T> delete;
}
