package com.sqldexter.gcmnetworking.model;

/**
 * Created by HOME on 17-02-2016.
 */
public class Truck extends BaseData{
    private int driver_id;
    private String truck_number;
    private String truck_company;
    private String truck_type;
    private int tonnage;
    private String truck_year;
    private String route_start;
    private String route_end;
    private String status;
    private String trucker_id;
    private String chassis_no;

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getTruck_number() {
        return truck_number;
    }

    public void setTruck_number(String truck_number) {
        this.truck_number = truck_number;
    }

    public String getTruck_company() {
        return truck_company;
    }

    public void setTruck_company(String truck_company) {
        this.truck_company = truck_company;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public String getTruck_year() {
        return truck_year;
    }

    public void setTruck_year(String truck_year) {
        this.truck_year = truck_year;
    }

    public String getRoute_start() {
        return route_start;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public String getRoute_end() {
        return route_end;
    }

    public void setRoute_end(String route_end) {
        this.route_end = route_end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrucker_id() {
        return trucker_id;
    }

    public void setTrucker_id(String trucker_id) {
        this.trucker_id = trucker_id;
    }

    public String getChassis_no() {
        return chassis_no;
    }

    public void setChassis_no(String chassis_no) {
        this.chassis_no = chassis_no;
    }


}
