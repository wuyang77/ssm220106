package com.atguigu.dao;

public interface BookShopDao {
    public Integer findBookPriceByIsbn(String isbn);
    public void updateBookStock(String isbn);
    public void updateUserAccount(String username,Integer price);
}
