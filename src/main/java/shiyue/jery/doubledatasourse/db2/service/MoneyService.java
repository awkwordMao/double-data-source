package shiyue.jery.doubledatasourse.db2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shiyue.jery.doubledatasourse.db2.dao.MoneyDao;
import shiyue.jery.doubledatasourse.entity.Money;

/**
 * @author Jery
 * @date 2019/9/25
 */
@Service
public class MoneyService {

    @Autowired
    MoneyDao moneyDao;

    public Money findMoney(int id){
        return moneyDao.selectMoney(id);
    }
}
