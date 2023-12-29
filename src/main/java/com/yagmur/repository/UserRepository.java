package com.yagmur.repository;

import com.yagmur.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserRepository implements Repository<User> {

    private CRUD crud;
    private String sql;
    Scanner scanner = new Scanner(System.in);
    private ResultSet resultSet;

    public UserRepository() {
        crud = new CRUD();
    }

    public boolean isUserNameTaken(String username) {
        String sql = "SELECT * FROM tbluser WHERE username = ?";
        try (ResultSet resultSet = crud.getAllTableRows(sql)) {
            return resultSet != null && resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    Hoca repo interfacei oluşturdu ordan implement aldık aşağıdakiler dersteki çzöümler
     **********************************************************************
     */

    @Override
    public boolean save(User entity) {
        sql = "insert into tbluser(adsoyad,username,password,avatar) values ('"
                +entity.getName()+"','"+entity.getUsername()+"','"+entity.getPassword()
                +"','"+entity.getImageUrl()+"') ";
        crud.executeUpdate(sql);
        return false;
    }

    @Override
    public boolean update(User entity) {
        crud.executeUpdate(sql);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        crud.executeUpdate(sql);
        return false;
    }

    @Override
    public List<User> findAll() {
        resultSet = crud.getAllTableRows(sql);
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        resultSet = crud.getAllTableRows(sql);
        return Optional.empty();
    }


    public Optional<User> doLogin(String username,String password){
        sql = "select * from tbluser where username = '"+username+"' and password= '"+password+"'";
        resultSet = crud.getAllTableRows(sql);
        Optional<User> userOptional = Optional.empty();
        try {
            while (resultSet.next()){
                Long db_id = resultSet.getLong("id");
                String db_adSoyad = resultSet.getString("adsoyad");
                String db_userName = resultSet.getString("username");
                String db_password = resultSet.getString("password");
                String db_avatar = resultSet.getString("avatar");

                User user = new User(db_id,db_adSoyad,db_userName,db_password,db_avatar);
                userOptional = Optional.of(user); //
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userOptional;
    }

    public boolean isUserName(String username){
        sql = "select * from tbluser where username = '"+username+"'";
        resultSet = crud.getAllTableRows(sql);
        boolean isUser = false;
        try {
            while (resultSet.next()){
                isUser =true;
            }
            //direkt isUser=resultSet.next()) de yazılabilir whilea almadan. try içine.
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isUser;
    }
}


