package com.applet.common.entity;

//状态码实体类
public class StatusCode {
    public static final int OK = 20000;//成功
    //error
    public static final int ERROR = 20001;//失败
    //login error
    public static final int LOGINERROR = 20002;//用户名或密码错误
    //access error
    public static final int ACCESSERROR = 20003;//权限不足
    //remote error
    public static final int REMOTEERROR = 20004;//远程调用失败
    //repeat error
    public static final int REPERROR = 20005;//重复操作

}
