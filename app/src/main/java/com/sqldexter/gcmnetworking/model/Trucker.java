package com.sqldexter.gcmnetworking.model;

/**
 * Created by HOME on 17-02-2016.
 */
public class Trucker extends BaseData{
    private boolean is_verified;
    private String trucker_name;
    private String company_name;

    private String pan_no;
    private String office_phone_no;
    private String state;
    private String city;
    private int fleet_size;

    public String getPan_no() {
        return pan_no;
    }

    public void setPan_no(String pan_no) {
        this.pan_no = pan_no;
    }

    public boolean is_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getTrucker_name() {
        return trucker_name;
    }

    public void setTrucker_name(String trucker_name) {
        this.trucker_name = trucker_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getOffice_phone_no() {
        return office_phone_no;
    }

    public void setOffice_phone_no(String office_phone_no) {
        this.office_phone_no = office_phone_no;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFleet_size() {
        return fleet_size;
    }

    public void setFleet_size(int fleet_size) {
        this.fleet_size = fleet_size;
    }

}
