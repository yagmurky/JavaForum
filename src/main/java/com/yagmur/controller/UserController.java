package com.yagmur.controller;

import com.yagmur.entity.User;
import com.yagmur.repository.UserRepository;

import java.util.Optional;
import java.util.Scanner;

public class UserController {

    private UserRepository userRepository;
    public UserController(){
        this.userRepository = new UserRepository();
    }

    public void Login (){
        System.out.println("""
                ********************************
                ******* KULLANICI GİRİŞİ *******
                ********************************

                """);

        System.out.println("Kullanıcı adı:");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Şifre:");
        String password = new Scanner(System.in).nextLine();
        Optional<User> userOptional = userRepository.doLogin(username,password);
        if (userOptional.isPresent()){
            System.out.println("Giriş yapıldı");
        }else {
            System.out.println("Kullanıcı adı veya şifre hatalıdır.");
        }


    }

    public void Register (){
        System.out.println("""
                ********************************
                ***** YENİ KULLANICI KAYDI *****
                ********************************

                """);

        System.out.println("ad soyad:");
        String adsoyad = new Scanner(System.in).nextLine();

        String username;
        boolean isUser;
        do {
            System.out.println("Kullanıcı adı:");
            username = new Scanner(System.in).nextLine();
            isUser = userRepository.isUserName(username);
            if (isUser)
                System.out.println("Farklı bir kullanıcı adı deneyiniz.");
        }while (isUser);

        System.out.println("Şifre:");
        String password = new Scanner(System.in).nextLine();

        User user = new User(adsoyad,username,password,"");
        userRepository.save(user);
    }




}
