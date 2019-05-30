package com.cs.yml.utils;

/**
 * @author:CaoShuai
 * @dateTime:5/28/2019 3:04 PM
 * @description:
 */
public class ExceptionInfo {
    private String errorCode;
    private String errorMessage;

    public ExceptionInfo() {
    }

    public ExceptionInfo(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
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
}
