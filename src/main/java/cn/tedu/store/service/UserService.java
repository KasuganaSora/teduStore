package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserAlreadyExistException;
import cn.tedu.store.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //事务控制,抛指定异常时回滚
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class,UserAlreadyExistException.class})
    public void register(User user){
        if (getUserByName(user.getUsername()) != null) {
            throw new UserAlreadyExistException("该用户已经存在");
        }
        userMapper.saveUser(user);
    }

    public User login(String username, String password){
        User user = getUserByName(username);
        if (user == null) {
            throw new UserNotFoundException("用户不存在");
        } else if (!user.getUsername().equals(username)) {
            throw new PasswordNotMatchException("密码错误");
        }
        return user;
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
