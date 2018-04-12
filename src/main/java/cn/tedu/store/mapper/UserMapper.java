package cn.tedu.store.mapper;

import cn.tedu.store.bean.User;

public interface UserMapper {
    /**
     * 添加用户;
     * @param user
     * @return 返回主键
     */
    public void saveUser(User user);

    /**
     * 根据用户名获得用户信息
     * @param username
     * @return 返回User信息;
     */
    public User getUserByName(String username);

    /**
     * 根据用户id获取用户信息;
     * @param id
     * @return
     */
    public User getUserById(Integer id);

    /**
     * 检查邮箱是否存在
     * @param email
     * @return
     */
    public Integer selectByEmail(String email);

    /**
     * 检查手机号是否存在;
     * @param phone
     * @return
     */
    public Integer selectByPhone(String phone);

    /**
     * 更新用户;
     * @param user
     */
    public void updateUserById(User user);
}
