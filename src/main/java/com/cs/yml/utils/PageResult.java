package com.cs.yml.utils;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 3:05 PM
 * @description:
 */
import java.io.Serializable;

public class PageResult<T> extends Result<T> implements Serializable {
    private static final long serialVersionUID = 3703154210703924121L;
    private int total;

    public PageResult() {
        this.success = false;
    }

    public PageResult(boolean success) {
        this.success = success;
    }

    public PageResult(boolean success, T model) {
        this.success = success;
        this.model = model;
    }

    public PageResult(boolean success, T model, String errorCode, String errorMessage) {
        this.success = success;
        this.model = model;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public PageResult(boolean success, T model, ExceptionInfo info) {
        this.success = success;
        this.model = model;
        this.errorCode = info.getErrorCode();
        this.errorMessage = info.getErrorMessage();
    }

    @Override
    public boolean isSuccess() {
        return this.success;
    }

    @Override
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public T getModel() {
        return this.model;
    }

    @Override
    public void setModel(T model) {
        this.model = model;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public void setException(ExceptionInfo info) {
        this.errorCode = info.getErrorCode();
        this.errorMessage = info.getErrorMessage();
    }
    @Override
    public ExceptionInfo getExceptionInfo() {
        return new ExceptionInfo(this.getErrorCode(), this.getErrorMessage());
    }
}
