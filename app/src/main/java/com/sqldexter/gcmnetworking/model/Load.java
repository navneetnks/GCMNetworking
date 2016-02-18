package com.sqldexter.gcmnetworking.model;

/**
 * Created by HOME on 17-02-2016.
 */
public class Load extends  BaseData{
    private int shipper_id;
    private String route_start;
    private String route_end;
    private int tonnage;

    private String truck_type;
    private int  truck_no_reqd;
    private boolean is_active;
    private String load_state;
    private int quoted_price;
    private String pickup_date;
    private String material_type;
    private boolean read;


    public int getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
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

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public int getTruck_no_reqd() {
        return truck_no_reqd;
    }

    public void setTruck_no_reqd(int truck_no_reqd) {
        this.truck_no_reqd = truck_no_reqd;
    }

    public boolean is_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getLoad_state() {
        return load_state;
    }

    public void setLoad_state(String load_state) {
        this.load_state = load_state;
    }

    public int getQuoted_price() {
        return quoted_price;
    }

    public void setQuoted_price(int quoted_price) {
        this.quoted_price = quoted_price;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(String material_type) {
        this.material_type = material_type;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }


}
