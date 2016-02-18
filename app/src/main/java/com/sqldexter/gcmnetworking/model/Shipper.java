package com.sqldexter.gcmnetworking.model;

/**
 * Created by HOME on 17-02-2016.
 */
public class Shipper extends BaseData{

    private boolean is_verfied;
    private String company_name;
    private String office_phone_no;
    private String state;
    private String city;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean is_verfied() {
        return is_verfied;
    }

    public void setIs_verfied(boolean is_verfied) {
        this.is_verfied = is_verfied;
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



}
