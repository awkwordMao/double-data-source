package shiyue.jery.doubledatasourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shiyue.jery.doubledatasourse.db1.service.UserService;
import shiyue.jery.doubledatasourse.entity.User;

/**
 * @author Jery
 * @date 2019/9/25
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/db1/user", method = RequestMethod.GET)
    public void findUser(){
        String name = "李杰";
        User user = userService.findUserByName(name);
        System.out.println(user.toString());
    }
}
