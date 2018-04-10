package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
    public void saveUser(User user);
    public User getUserByName(String username);
}
