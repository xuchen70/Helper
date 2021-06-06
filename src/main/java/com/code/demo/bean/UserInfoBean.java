package com.code.demo.bean;

import java.util.List;

public class UserInfoBean {

    private WxUserDTO wxUser;
    private List<RegisterUserDTO> registerUser;

    public static class WxUserDTO {
        private String oauthOpenid;
        private String oauthNickname;
        private String oauthSex;
        private String oauthIsFirstOauth;
        private String oauthReusId;
        private String oauthToken;
        private String oauthGuid;
        private Integer oauthUserType;
        private Boolean addUser;

        public String getOauthOpenid() {
            return oauthOpenid;
        }

        public void setOauthOpenid(String oauthOpenid) {
            this.oauthOpenid = oauthOpenid;
        }

        public String getOauthNickname() {
            return oauthNickname;
        }

        public void setOauthNickname(String oauthNickname) {
            this.oauthNickname = oauthNickname;
        }

        public String getOauthSex() {
            return oauthSex;
        }

        public void setOauthSex(String oauthSex) {
            this.oauthSex = oauthSex;
        }

        public String getOauthIsFirstOauth() {
            return oauthIsFirstOauth;
        }

        public void setOauthIsFirstOauth(String oauthIsFirstOauth) {
            this.oauthIsFirstOauth = oauthIsFirstOauth;
        }

        public String getOauthReusId() {
            return oauthReusId;
        }

        public void setOauthReusId(String oauthReusId) {
            this.oauthReusId = oauthReusId;
        }

        public String getOauthToken() {
            return oauthToken;
        }

        public void setOauthToken(String oauthToken) {
            this.oauthToken = oauthToken;
        }

        public String getOauthGuid() {
            return oauthGuid;
        }

        public void setOauthGuid(String oauthGuid) {
            this.oauthGuid = oauthGuid;
        }

        public Integer getOauthUserType() {
            return oauthUserType;
        }

        public void setOauthUserType(Integer oauthUserType) {
            this.oauthUserType = oauthUserType;
        }

        public Boolean getAddUser() {
            return addUser;
        }

        public void setAddUser(Boolean addUser) {
            this.addUser = addUser;
        }

        @Override
        public String toString() {
            return "WxUserDTO{" +
                    "oauthOpenid='" + oauthOpenid + '\'' +
                    ", oauthNickname='" + oauthNickname + '\'' +
                    ", oauthSex='" + oauthSex + '\'' +
                    ", oauthIsFirstOauth='" + oauthIsFirstOauth + '\'' +
                    ", oauthReusId='" + oauthReusId + '\'' +
                    ", oauthToken='" + oauthToken + '\'' +
                    ", oauthGuid='" + oauthGuid + '\'' +
                    ", oauthUserType=" + oauthUserType +
                    ", addUser=" + addUser +
                    '}';
        }
    }

    public static class RegisterUserDTO {
        private String reusId;
        private String reusGuid;
        private String reusTrueName;
        private String reusMobile;
        private String reusRegisterTime;
        private Integer reusRegisterSource;
        private Integer reusSex;
        private Integer reusUse;
        private String reusOpenid;
        private String reusAppId;
        private String reusBirthday;
        private Boolean rsaFlag;
        private String reusIdCard;

        public String getReusId() {
            return reusId;
        }

        public void setReusId(String reusId) {
            this.reusId = reusId;
        }

        public String getReusGuid() {
            return reusGuid;
        }

        public void setReusGuid(String reusGuid) {
            this.reusGuid = reusGuid;
        }

        public String getReusTrueName() {
            return reusTrueName;
        }

        public void setReusTrueName(String reusTrueName) {
            this.reusTrueName = reusTrueName;
        }

        public String getReusMobile() {
            return reusMobile;
        }

        public void setReusMobile(String reusMobile) {
            this.reusMobile = reusMobile;
        }

        public String getReusRegisterTime() {
            return reusRegisterTime;
        }

        public void setReusRegisterTime(String reusRegisterTime) {
            this.reusRegisterTime = reusRegisterTime;
        }

        public Integer getReusRegisterSource() {
            return reusRegisterSource;
        }

        public void setReusRegisterSource(Integer reusRegisterSource) {
            this.reusRegisterSource = reusRegisterSource;
        }

        public Integer getReusSex() {
            return reusSex;
        }

        public void setReusSex(Integer reusSex) {
            this.reusSex = reusSex;
        }

        public Integer getReusUse() {
            return reusUse;
        }

        public void setReusUse(Integer reusUse) {
            this.reusUse = reusUse;
        }

        public String getReusOpenid() {
            return reusOpenid;
        }

        public void setReusOpenid(String reusOpenid) {
            this.reusOpenid = reusOpenid;
        }

        public String getReusAppId() {
            return reusAppId;
        }

        public void setReusAppId(String reusAppId) {
            this.reusAppId = reusAppId;
        }

        public String getReusBirthday() {
            return reusBirthday;
        }

        public void setReusBirthday(String reusBirthday) {
            this.reusBirthday = reusBirthday;
        }

        public Boolean getRsaFlag() {
            return rsaFlag;
        }

        public void setRsaFlag(Boolean rsaFlag) {
            this.rsaFlag = rsaFlag;
        }

        public String getReusIdCard() {
            return reusIdCard;
        }

        public void setReusIdCard(String reusIdCard) {
            this.reusIdCard = reusIdCard;
        }

        @Override
        public String toString() {
            return "RegisterUserDTO{" +
                    "reusId='" + reusId + '\'' +
                    ", reusGuid='" + reusGuid + '\'' +
                    ", reusTrueName='" + reusTrueName + '\'' +
                    ", reusMobile='" + reusMobile + '\'' +
                    ", reusRegisterTime='" + reusRegisterTime + '\'' +
                    ", reusRegisterSource=" + reusRegisterSource +
                    ", reusSex=" + reusSex +
                    ", reusUse=" + reusUse +
                    ", reusOpenid='" + reusOpenid + '\'' +
                    ", reusAppId='" + reusAppId + '\'' +
                    ", reusBirthday='" + reusBirthday + '\'' +
                    ", rsaFlag=" + rsaFlag +
                    ", reusIdCard='" + reusIdCard + '\'' +
                    '}';
        }
    }

    public WxUserDTO getWxUser() {
        return wxUser;
    }

    public void setWxUser(WxUserDTO wxUser) {
        this.wxUser = wxUser;
    }

    public List<RegisterUserDTO> getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(List<RegisterUserDTO> registerUser) {
        this.registerUser = registerUser;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "wxUser=" + wxUser +
                ", registerUser=" + registerUser +
                '}';
    }
}
