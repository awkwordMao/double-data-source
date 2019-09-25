package shiyue.jery.doubledatasourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shiyue.jery.doubledatasourse.db2.service.MoneyService;
import shiyue.jery.doubledatasourse.entity.Money;

/**
 * @author Jery
 * @date 2019/9/25
 */
@RestController
public class MoneyController {

    @Autowired
    MoneyService moneyService;

    @RequestMapping(value = "/db2/money", method = RequestMethod.GET)
    public void findMoney(){
        int id = 1;
        Money money = moneyService.findMoney(id);
        System.out.println(money.toString());
    }
}
