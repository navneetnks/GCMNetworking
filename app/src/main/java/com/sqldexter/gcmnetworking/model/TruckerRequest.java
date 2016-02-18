package com.sqldexter.gcmnetworking.model;

/**
 * Created by HOME on 17-02-2016.
 */
public class TruckerRequest extends BaseData{
    private int request_id;
    private String route_start;
    private String route_end;
    private int tonnage;
    private int trucks_no_available;

    private boolean is_active;
    private int quoted_price;
    private String truck_type;
    private int trucker_id;
    private String request_state;
    private boolean read;
    private String pickup_date;
    private boolean check_near_location;
    private boolean check_near_location_route_end;


    public boolean is_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
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

    public int getTrucks_no_available() {
        return trucks_no_available;
    }

    public void setTrucks_no_available(int trucks_no_available) {
        this.trucks_no_available = trucks_no_available;
    }

    public int getQuoted_price() {
        return quoted_price;
    }

    public void setQuoted_price(int quoted_price) {
        this.quoted_price = quoted_price;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public int getTrucker_id() {
        return trucker_id;
    }

    public void setTrucker_id(int trucker_id) {
        this.trucker_id = trucker_id;
    }

    public String getRequest_state() {
        return request_state;
    }

    public void setRequest_state(String request_state) {
        this.request_state = request_state;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public boolean isCheck_near_location() {
        return check_near_location;
    }

    public void setCheck_near_location(boolean check_near_location) {
        this.check_near_location = check_near_location;
    }

    public boolean isCheck_near_location_route_end() {
        return check_near_location_route_end;
    }

    public void setCheck_near_location_route_end(boolean check_near_location_route_end) {
        this.check_near_location_route_end = check_near_location_route_end;
    }



}
