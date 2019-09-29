package shiyue.jery.doubledatasourse.db1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import shiyue.jery.doubledatasourse.db1.dao.UserDao;
import shiyue.jery.doubledatasourse.entity.User;

/**
 * @author Jery
 * @date 2019/9/25
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User findUserByName(String name){
        User user = new User();
        user = userDao.selectUser(name);
        if(ObjectUtils.isEmpty(user)){
            return new User();
        }
        return user;
    }
}
