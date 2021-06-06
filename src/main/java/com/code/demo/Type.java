package com.code.demo;

public enum Type {
    SHEN_ZHEN_KANGTAI("深圳康泰","36"),
    BEI_JING_BIOLOGICAL("北京生物","02"),
    BEI_JING_KEXIN("科兴中维","80"),
    WU_HAN_BIOLOGICAL("武汉生物","10"),
    KANG_XI_BIOLOGICAL("康希诺生物","81"),
    AN_HUI_DU_FEI("安徽智飞","999"),
    ;

    private String code;
    private String description;
    Type(String corpName, String code) {
        this.description = corpName;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }
}
