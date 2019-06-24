package com.john.showmecode.springbootcook.cookAppHome;

import org.springframework.boot.system.ApplicationHome;

import java.io.File;

/**
 * @Author: kangq
 * @Date: 2019/6/24 15:28
 */
public class GetAppHome {

    public static void main(String[] args) {
        ApplicationHome applicationHome = new ApplicationHome(GetAppHome.class);
        File file = applicationHome.getDir();
        System.out.println(file.getAbsolutePath());
    }
}
