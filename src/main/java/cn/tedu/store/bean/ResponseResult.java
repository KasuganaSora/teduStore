package cn.tedu.store.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 *  返回的封装状态信息;
 * @param <T>
 */
@Data
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 7442276529724968691L;
    @NonNull
    private Integer status;
    private String message;
    private T data;
}
