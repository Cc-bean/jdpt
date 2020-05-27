package com.hj.jdpt.bean;
/**
 *
 * @Param success   //封装ajax请求结果
 * @Param data  //封装ajax请求数据
 * */
public class AJAXResult {

    private boolean success ;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
