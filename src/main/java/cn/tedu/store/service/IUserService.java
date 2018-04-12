package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
    /**
     * 注册用户服务
     * @param user
     */
    public void register(User user);

    /**
     * 用户登录
     * @param username
     * @return
     */
    public User login(String username, String password);

    /**
     * 通过用户名获得用户信息;
     * @param username
     * @return
     */
    public User getUserByName(String username);

    /**
     * 更新用户;
     * @param user
     */
    public void updateUserById(User user);

    /**
     *  更新密码;
     * @param id
     * @param oldPwd
     * @param newPwd
     */
    public void updatePassword(Integer id, String oldPwd, String newPwd);

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
