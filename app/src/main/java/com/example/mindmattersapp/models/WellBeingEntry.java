package com.example.mindmattersapp.models;

public class WellBeingEntry {

    private String msgHeader;
    private String msgMoreInfo;
    private int msgImgId;
    private String msgPath;

    public WellBeingEntry(String msgHeader, String msgMoreInfo, int msgImgId, String msgPath) {
        this.msgHeader = msgHeader;
        this.msgMoreInfo = msgMoreInfo;
        this.msgImgId = msgImgId;
        this.msgPath = msgPath;
    }

    public String getMsgHeader() {
        return msgHeader;
    }

    public void setMsgHeader(String msgHeader) {
        this.msgHeader = msgHeader;
    }

    public String getMsgMoreInfo() {
        return msgMoreInfo;
    }

    public void setMsgMoreInfo(String msgMoreInfo) {
        this.msgMoreInfo = msgMoreInfo;
    }

    public int getMsgImgId() {
        return msgImgId;
    }

    public void setMsgImgId(int msgImgId) {
        this.msgImgId = msgImgId;
    }

    public String getMsgPath() {
        return msgPath;
    }

    public void setMsgPath(String msgPath) {
        this.msgPath = msgPath;
    }
}
