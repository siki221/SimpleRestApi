package com.pack.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Unknow {
    @SerializedName("data")
    @Expose
    public DataUnknow data;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("data", data).toString();
    }

}
