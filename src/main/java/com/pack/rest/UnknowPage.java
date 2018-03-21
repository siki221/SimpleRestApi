package com.pack.rest;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UnknowPage {

    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("per_page")
    @Expose
    public Integer perPage;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("data")
    @Expose
    public List<DataUnknow> data = null;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("page", page).append("perPage", perPage).append("total", total).append("totalPages", totalPages).append("data", data).toString();
    }

}