//
// Created by mobao.libo on 2017-04-19-0019.
//
#include <android/log.h>

#ifndef JNI_JNILOG_H
#define JNI_JNILOG_H
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

#endif //JNI_JNILOG_H
