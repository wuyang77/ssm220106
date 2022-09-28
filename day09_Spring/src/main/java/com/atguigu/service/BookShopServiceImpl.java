package com.atguigu.service;

import com.atguigu.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 两种结账方式
 * 1.去结账时判断余额是否充足，余额不足，一本书都不能买
 * 2.去结账时判断余额是否充足，余额不足，最后那本导致余额不足的书不能购买
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    @Qualifier("bookShopDao")
    private BookShopDao bookShopDao;

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.SERIALIZABLE,
            timeout = 5,//设置强制回滚的时间
            readOnly = false, //一般只有在查询操作中，才将事务设置为只读
            noRollbackFor = ArithmeticException.class//遇见算术异常不要回滚
    )
    public void purchase(String username, String isbn) {
        //查询书的价格
        Integer price = bookShopDao.findBookPriceByIsbn(isbn);
        //修改用户
        bookShopDao.updateBookStock(isbn);
        //修改余额
        bookShopDao.updateUserAccount(username,price);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
