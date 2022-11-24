package com.k204111813.tranthikieutrinh;

import androidx.annotation.Nullable;

public class ServiceClass {
    private String service_name;
    public int imgid;
    public ServiceClass( String service_name, int imgid) {
        this.service_name = service_name;
        this.imgid = imgid;
    }
    public String getService_name() {
        return service_name;
    }
    public int getImgid() {
        return imgid;
    }
    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
    public void setTmgid(int imgid) {
        this.imgid = imgid;
    }
}
