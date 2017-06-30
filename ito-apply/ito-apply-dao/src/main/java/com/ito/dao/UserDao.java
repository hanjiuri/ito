package com.ito.dao;

import com.ito.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 韩九日 on 2017/6/30.
 */

@Repository
public interface UserDao {
    List<User> selectAllUser(User user);
}
