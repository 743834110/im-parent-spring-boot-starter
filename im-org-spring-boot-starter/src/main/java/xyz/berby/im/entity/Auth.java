package xyz.berby.im.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Auth)实体类
 *
 * @author makejava
 * @since 2018-12-11 10:45:37
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Auth implements Serializable {
    private static final long serialVersionUID = 401001060523467193L;
    
    private String authId;
    
    private String authName;
    
    private String authUrl;
    
    private String parentId;
    
    private String authType;
    
    private String apiUrl;


}