package com.am.plus;

import org.apache.shiro.crypto.hash.SimpleHash;

public class test1 {
//    MD5加密
    public static void main(String[] args) {
        String type="MD5";//加密类型
        Object times=1024;//加密次数
        Object slat=null;//盐（用于同样的密码，在数据库显示也不一样）
        Object password="123456";//加密数据
        SimpleHash simpleHash = new SimpleHash(type, password, slat, (Integer) times);
        System.out.println(simpleHash);
    }
}
