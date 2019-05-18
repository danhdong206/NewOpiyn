package com.example.thanhdong.projectandroidstudio.retrofitmain;

import com.google.gson.annotations.SerializedName;

public class Statements {
    @SerializedName("opiynstatement4")
    private String opiynStatement4;
    @SerializedName("opiynstatement3")
    private String opiynStatement3;
    @SerializedName("opiynstatement5")
    private String opiynStatement5;
    @SerializedName("opiynstatement2")
    private String opiynStatement2;
    @SerializedName("opiynstatement1")
    private String opiynStatement1;

    public Statements(String opiynStatement4, String opiynStatement3, String opiynStatement5, String opiynStatement2, String opiynStatement1) {
        this.opiynStatement4 = opiynStatement4;
        this.opiynStatement3 = opiynStatement3;
        this.opiynStatement5 = opiynStatement5;
        this.opiynStatement2 = opiynStatement2;
        this.opiynStatement1 = opiynStatement1;
    }

    public String getOpiynStatement4() {
        return opiynStatement4;
    }

    public void setOpiynStatement4(String opiynStatement4) {
        this.opiynStatement4 = opiynStatement4;
    }

    public String getOpiynStatement3() {
        return opiynStatement3;
    }

    public void setOpiynStatement3(String opiynStatement3) {
        this.opiynStatement3 = opiynStatement3;
    }

    public String getOpiynStatement5() {
        return opiynStatement5;
    }

    public void setOpiynStatement5(String opiynStatement5) {
        this.opiynStatement5 = opiynStatement5;
    }

    public String getOpiynStatement2() {
        return opiynStatement2;
    }

    public void setOpiynStatement2(String opiynStatement2) {
        this.opiynStatement2 = opiynStatement2;
    }

    public String getOpiynStatement1() {
        return opiynStatement1;
    }

    public void setOpiynStatement1(String opiynStatement1) {
        this.opiynStatement1 = opiynStatement1;
    }
}
