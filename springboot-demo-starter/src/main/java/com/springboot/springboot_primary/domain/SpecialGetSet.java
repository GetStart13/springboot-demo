package com.springboot.springboot_primary.domain;

public class SpecialGetSet {
    private boolean flag;
    private String iName;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getIName() {
        return iName;
    }

    public void setIName(String iName) {
        this.iName = iName;
    }

    @Override
    public String toString() {
        return "SpecialGetSet{" +
                "flag=" + flag +
                ", iName='" + iName + '\'' +
                '}';
    }
}
