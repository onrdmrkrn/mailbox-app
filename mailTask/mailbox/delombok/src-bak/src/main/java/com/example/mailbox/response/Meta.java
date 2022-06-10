package com.example.mailbox.response;

public class Meta {
    public int errorCode;
    public String errorDesc;

    public Meta(int errorCode) {
        this.errorCode = errorCode;
    }

    public Meta() {
    }

    public Meta(int errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }
}
