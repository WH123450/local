package com.dao;

import com.domain.Product;
import com.domain.Student;
import com.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 */
public interface ProductDao {
    public int addProduct(Product product);
    public int addTeacher(User user);
    public int addStudent(Student stu);
   // public int addProducts(Product product);
    public List<Product> showAll();
    public Product findProduct(int id);
    public int updateProduct(Product product);
    public int deleteProduct(int id);
    public boolean findProduct1(String username, String userpassword);
    public boolean findProduct2(String username, String userpassword);
    public List<Product> queryProduct(String keyword);
    public List<Product> queryId(int id);

}
