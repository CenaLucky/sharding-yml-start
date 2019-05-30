package com.cs.yml.utils;


import java.io.Serializable;
/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 3:03 PM
 * @description:
 */

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 2944008908509299972L;
    protected boolean success;
    protected String errorCode;
    protected String errorMessage;
    protected T model;

    public Result() {
        this.success = false;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, T model) {
        this.success = success;
        this.model = model;
    }

    public Result(boolean success, T model, String errorCode, String errorMessage) {
        this.success = success;
        this.model = model;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Result(boolean success, T model, ExceptionInfo info) {
        this.success = success;
        this.model = model;
        this.errorCode = info.getErrorCode();
        this.errorMessage = info.getErrorMessage();
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getModel() {
        return this.model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public void setException(ExceptionInfo info) {
        this.errorCode = info.getErrorCode();
        this.errorMessage = info.getErrorMessage();
    }

    public ExceptionInfo getExceptionInfo() {
        return new ExceptionInfo(this.getErrorCode(), this.getErrorMessage());
    }
}

