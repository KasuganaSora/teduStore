package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //事务控制,抛指定异常时回滚(用户自定义异常,现未添加)
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public void register(User user){
        userMapper.saveUser(user);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public boolean checkEmail(String email) {
        int count = userMapper.selectByEmail(email);
        if (count == 1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkPhone(String phone) {
        int count = userMapper.selectByPhone(phone);
        if (count == 1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkUsername(String username) {
        if (getUserByName(username) != null) {
            return false;
        }
        return true;
    }
}
