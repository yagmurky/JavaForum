package com.yagmur;

import com.yagmur.controller.UserController;
import com.yagmur.entity.User;
import com.yagmur.repository.UserRepository;

import java.util.Scanner;


public class Runner_Forum_Odev {

    /**
     * ANAsayfa
     * ***********
     * *** java forum sayfası *****
     * ***** giriş******
     * 1- login
     * 2- register
     * ----------
     * loginpage
     * username:
     * password:
     * -- ya giriş yaoacak ya da şifre username hatalı diyecek
     * Register
     * ad soyad:
     * username:
     * password:
     * --- ya üye olup login sayfasına ayacak ya da bu username daha önce alınmış dicek
     *
     *
     * yapılacaklar:
     * 1- tüm entityleri ve repositoryleri oluştur
     * 2- repository katmanında temel crud işemleri
     * 2- sadece llogin repository de şu ek alanlar olacak:
     * ---dologin(username,password) -> return optional<User>
     *     isUserName (username) -> return true/false
     *     yukarıda tanımlanan ekranları işlevsel hale getirin;
     *
     *
     *
     * 2- Giriş yapan kişinin bilgilerini bir yerde tutacaksınız.
     * ---> Yenii ana ekran
     * ***********************************
     * **** Hoşgeldin [muhammet hoca] ****
     * ***********************************
     * ** 1- Postları Görüntüle
     * ** 2- Kullanıcı Görüntüle
     * ** 3- Logout (Sistemden Çıkış yap login ekranına dön.)
     * -----------------------------------
     * ***********************************
     * ********** POST LİSTESİ ***********
     * ***********************************
     *
     * * * * * * * * * * * * * * * * * * *
     * *       Muhammet Hoca           * *
     * *bugün java öğrenmek için güzel-  *
     * bir gün.                          *
     *                      29.12.2023   *
     * * * * * * * * * * * * * * * * * * * 
     */

    public static void main(String[] args) {

        UserRepository userRepository=new UserRepository();
        int choice;
        do {
            System.out.println("****************************");
            System.out.println("*** Java Forum Sayfası *****");
            System.out.println("*********** Giriş **********");
            System.out.println("1- Login");
            System.out.println("2- Register");
            System.out.println("3- Çıkış");
            System.out.println("----------");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Çıkış yapılıyor.");
                case 1: new UserController().Login(); break;
                case 2: new UserController().Register(); break;
                default:
                    System.out.println("Geçersiz seçenek. Program kapatılıyor.");
            }
        }while (choice!=0);
    }
}
