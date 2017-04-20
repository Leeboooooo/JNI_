package com.example.mobaolibo.jni;

/**
 * Created by mobao.libo on 2017-04-19-0019.
 */

public class AndroidJni {

    static AndroidJni instance;

    public static AndroidJni getInstance() {
        if (instance == null)
            instance = new AndroidJni();
        return instance;
    }

    static{
        try {
            System.loadLibrary("vxg-lib");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 动态注册
     */
    public native void dynamicLog();

    public native void staticLog();

}
