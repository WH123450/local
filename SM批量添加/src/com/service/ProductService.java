package com.service;

import com.domain.Product;
import com.domain.Student;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 王会
 */
public interface ProductService {
    public int addProduct(Product product);
    public int addProducts(Product product);
    public List<Product> showAll();
    public Product findProduct(int id);
    public boolean findProduct1(String username,String userpassword);
    public boolean findProduct2(String username,String userpassword);
    public int updateProduct(Product product);
    public int deleteProduct(int id);
    public List<Product> queryProduct(String keyword);
}
