package com.ito.web.conterller;

import com.ito.domain.User;
import com.ito.service.interfce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/showUser")
    public String showUser(User user){
        List<User> userList = userService.getAllUser(user);
        if(userList.size()==0){
            return "defeat";
        }
        return "ddd";
    }
}
