package com.ito.service.impl;

import com.ito.dao.UserDao;
import com.ito.domain.User;
import com.ito.service.interfce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    
    public List<User> getAllUser(User user) {
        return userDao.selectAllUser(user);
    }
}
