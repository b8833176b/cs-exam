package com.ares.exam.dto;
/**
 * 封装json对象，所有返回结果都使用它
 */
public class Result<T> {
	private boolean success;// 是否成功标志

    private T data;// 成功时返回的数据

    private String msg;// 信息
    public Result() {
    	
    }
    // 带返回数据的构造器
    public Result(boolean success,String msg,T data) {
    	this.success = success;
    	this.msg=msg;
        this.data = data;
    }
  
    public Result(boolean success,String msg) {
    	this.success = success;
        this.msg = msg;
    }
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
    
}
