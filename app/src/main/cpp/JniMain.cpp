//
// Created by mobao.libo on 2017-04-19-0019.
//

#include <jni.h>
#include "JniLog.h"

#define LOG_TAG "JNI_MAIN"
#define MAIN_JNI_CLASS "com/example/mobaolibo/jni/AndroidJni"

static void nativeDynamicLog(JNIEnv *env,jobject obj){
    LOGE("halo main:dynamic");
}

/*
 * Class:     com_example_mobaolibo_jni_AndroidJni
 * Method:    staticLog
 * Signature: ()V
 */
extern "C"
JNIEXPORT void JNICALL Java_com_example_mobaolibo_jni_AndroidJni_staticLog
        (JNIEnv *, jobject){
    LOGE("static register log");
}

JNINativeMethod nativeMethod[] = {{"dynamicLog","()V",(void*)nativeDynamicLog},};

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *jvm,void *reserved){
    JNIEnv *env;
    if(jvm->GetEnv((void**)&env,JNI_VERSION_1_4) != JNI_OK){
        return -1;
    }

    LOGE("JNI_OnLoad coming");
    jclass  jclz = env->FindClass(MAIN_JNI_CLASS);
    env->RegisterNatives(jclz,nativeMethod, sizeof(nativeMethod)/ sizeof(nativeMethod[0]));
    return JNI_VERSION_1_4;
}


