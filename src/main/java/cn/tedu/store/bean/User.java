package cn.tedu.store.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class User implements Serializable{
    private static final long serialVersionUID = -8273070961814023138L;
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String image;
    private int gender;
    private String createUser;
    private Date createTime;
    private String modifiedUser;
    private Date modifiedTime;
}
