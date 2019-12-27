package com.dao.impl;

import com.dao.ProductDao;
import com.domain.Product;
import com.domain.Student;
import com.domain.User;
import com.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 王会
 */
public class ProductDaoImpl1 implements ProductDao {
    //增加
    public int addProduct(Product product){
        int result=0;
        //获取连接
        DbUtil dbUtil=new DbUtil();
        Connection conn = dbUtil.getConnection();
        //sql
        String sql = "INSERT INTO CST1(id, name, chinese, math,english,classes)"+
               "values("+"?,?,?,?,?,?)";
        //预编译
        PreparedStatement preparedStatement = null; //预编译SQL，减少sql执行
        try {
            preparedStatement = conn.prepareStatement(sql);
            //传参
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getChinese());
            preparedStatement.setDouble(4, product.getMath());
            preparedStatement.setDouble(5, product.getEnglish());
            preparedStatement.setString(6, product.getClasses());

            //执行
            result=preparedStatement.executeUpdate();

            dbUtil.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addProducts(Product product) {
        int result=0;
        //获取连接
        DbUtil dbUtil=new DbUtil();
        Connection conn = dbUtil.getConnection();
        //sql
        String sql = "INSERT INTO CST1(chinese,math,english) values (?,?,?)";
        //预编译
        PreparedStatement preparedStatement=null ; //预编译SQL，减少sql执行
        try {
            preparedStatement = conn.prepareStatement(sql);
            //传参
            preparedStatement.setDouble(1,product.getChinese());
            preparedStatement.setDouble(2, product.getMath());
            preparedStatement.setDouble(3, product.getEnglish());

            //执行
            result=preparedStatement.executeUpdate();

            dbUtil.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Product> showAll() {
        List<Product> list=new ArrayList<Product>();
        DbUtil dbUtil=new DbUtil();
        Connection conn=dbUtil.getConnection();
        String sql="select * from CST1";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=conn.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product=new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setChinese(resultSet.getDouble("chinese"));
                product.setMath(resultSet.getDouble("math"));
                product.setEnglish(resultSet.getDouble("english"));
                product.setClasses(resultSet.getString("classes"));
                list.add(product);
            }
            dbUtil.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Product findProduct(int id) {
        Product product=new Product();
        ResultSet resultSet=null;
        DbUtil dbUtil=new DbUtil();
        Connection conn=dbUtil.getConnection();
        String sql = "select * from CST1 WHERE id=?";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setChinese(resultSet.getDouble("chinese"));
            product.setMath(resultSet.getDouble("math"));
            product.setEnglish(resultSet.getDouble("english"));
            product.setClasses(resultSet.getString("classes"));
            dbUtil.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    public boolean findProduct1(String username,String userpassword){
        User user=new User(username,userpassword);
        ResultSet resultSet=null;
        DbUtil dbUtil=new DbUtil();
        Connection conn=dbUtil.getConnection();
        String sql="select * from user WHERE username=?and userpassword=?";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet  = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
            //dbUtil.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {dbUtil.closeConn();
        }
        return false;
    }

    public boolean findProduct2(String username,String userpassword){
        User user=new User(username,userpassword);
        ResultSet resultSet=null;
        DbUtil dbUtil=new DbUtil();
        Connection conn=dbUtil.getConnection();
        String sql="select * from user2 WHERE username=?and userpassword=?";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
            //dbUtil.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {dbUtil.closeConn();
        }
        return false;
    }

    @Override
    public int updateProduct(Product product) {
        int result=0;
        //获取连接
        DbUtil dbUtil=new DbUtil();
        Connection conn = dbUtil.getConnection();
        //sql
        String sql = "UPDATE CST1 SET chinese=?,math=?,english=?  where id=? ";
        //预编译
        PreparedStatement preparedStatement=null ; //预编译SQL，减少sql执行
        try {
            preparedStatement = conn.prepareStatement(sql);
            //传参
            preparedStatement.setDouble(1,product.getChinese());
            preparedStatement.setDouble(2, product.getMath());
            preparedStatement.setDouble(3, product.getEnglish());
            preparedStatement.setInt(4,product.getId());


            //执行
            result=preparedStatement.executeUpdate();

            dbUtil.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteProduct(int id) {
        int result=0;
        //获取连接
        DbUtil dbUtil=new DbUtil();
        Connection conn = dbUtil.getConnection();
        //sql
        String sql = "DELETE FROM CST1 where id=? ";
        //预编译
        PreparedStatement preparedStatement = null; //预编译SQL，减少sql执行
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            //执行
            result=preparedStatement.executeUpdate();

            dbUtil.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Product> queryProduct(String keyword) {
        List<Product> list=new ArrayList<Product>();
        DbUtil dbUtil=new DbUtil();
        Connection conn=dbUtil.getConnection();
        String sql="select * from CST1 WHERE name LIKE '%"+keyword+"%'";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=conn.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product=new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setChinese(resultSet.getDouble("chinese"));
                product.setMath(resultSet.getDouble("math"));
                product.setEnglish(resultSet.getDouble("english"));
                product.setClasses(resultSet.getString("classes"));
                list.add(product);
            }
            dbUtil.closeConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

}
