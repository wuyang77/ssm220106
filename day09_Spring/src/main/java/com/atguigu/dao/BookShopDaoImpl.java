package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer findBookPriceByIsbn(String isbn) {
        //根据书号查询书的价格
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        //修改库存
        String sql = "update book_stock set stock=stock-1 where isbn = ?";
        jdbcTemplate.update(sql,isbn);
        //验证库存
        String sql2 = "select stock from book_stock where isbn = ?";
        Integer newStock = jdbcTemplate.queryForObject(sql2, Integer.class,isbn);
        if (newStock <= 0) {
            throw new RuntimeException("库存不足！");
        }
    }

    @Override
    public void updateUserAccount(String username, Integer price) {
        //查询余额，看余额是否充足
        String sql1 = "select balance from account where username = ?";
        Integer balance = jdbcTemplate.queryForObject(sql1, Integer.class, username);
        if (balance < price) {
            throw new RuntimeException("余额不足！");
        }
        //修改用户余额
        String sql = "update account set balance=balance-? where username = ?";
        jdbcTemplate.update(sql,price,username);
    }
}
