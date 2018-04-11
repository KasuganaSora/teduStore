package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
    /**
     * 注册用户服务
     * @param user
     */
    public void register(User user);
    public User getUserByName(String username);

    /**
     * 检查email
     * @param email
     * @return
     */
    public boolean checkEmail(String email);

    /**
     * 检查phone
     * @param phone
     * @return
     */
    public boolean checkPhone(String phone);

    /**
     *  检查用户名是否存在
     * @param username
     * @return 如果返回false 说明 已存在相同用户名,失败, 反之,true说明没有相同的用户名,正确;
     */
    public boolean checkUsername(String username);
}
