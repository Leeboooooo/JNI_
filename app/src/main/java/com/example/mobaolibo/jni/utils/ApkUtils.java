package com.example.mobaolibo.jni.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Environment;

/**
 * Created by mobao.libo on 2017-04-20-0020.
 */

public class ApkUtils {

    public static String getApkPath(Activity activity){
        String srcApk = "";
        try {
            srcApk = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 0).sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return srcApk;
    }

    public static String getPatch(){
        return  Environment.getExternalStorageDirectory().toString() + "/JNITest/p.patch";
    }

    public static String getNewApkPath(){
        return  Environment.getExternalStorageDirectory().toString() + "/JNITest/new.apk";
    }
}
