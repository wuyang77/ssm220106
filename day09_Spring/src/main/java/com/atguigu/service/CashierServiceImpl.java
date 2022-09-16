package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cashierService")
public class CashierServiceImpl implements CashierService{
    @Autowired
    @Qualifier("bookShopService")
    private BookShopService bookShopService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void checkout(String username, List<String> isbns) {
        //结账
        for (String isbn : isbns) {
            bookShopService.purchase(username,isbn);
        }
    }
}
