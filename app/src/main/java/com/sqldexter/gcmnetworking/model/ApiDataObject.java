package com.sqldexter.gcmnetworking.model;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by HOME on 17-02-2016.
 */
public class ApiDataObject extends BaseData{

    private int shipper_id;
    private String route_start;
    private String route_end;
    private int booking_price;
    private String status;
    private boolean pending_trucker_confirmation;
    private boolean pending_shipper_confirmation;
    private int load_id;
    private int total_amount;
    private String truck_type;
    private int trucker_request_id;
    private boolean read;
    private int consigner_id;

    private String  pickup_address;
    private String  drop_address;

    private Shipper  shipper;
    private Trucker  trucker;
    private Load load;
    private TruckerRequest trucker_request;
    private List<Truck> trucks;




    public ApiDataObject(JSONObject data){

    }

    public String getPickup_address() {
        return pickup_address;
    }

    public void setPickup_address(String pickup_address) {
        this.pickup_address = pickup_address;
    }

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

    public int getBooking_price() {
        return booking_price;
    }

    public void setBooking_price(int booking_price) {
        this.booking_price = booking_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPending_trucker_confirmation() {
        return pending_trucker_confirmation;
    }

    public void setPending_trucker_confirmation(boolean pending_trucker_confirmation) {
        this.pending_trucker_confirmation = pending_trucker_confirmation;
    }

    public boolean isPending_shipper_confirmation() {
        return pending_shipper_confirmation;
    }

    public void setPending_shipper_confirmation(boolean pending_shipper_confirmation) {
        this.pending_shipper_confirmation = pending_shipper_confirmation;
    }

    public int getLoad_id() {
        return load_id;
    }

    public void setLoad_id(int load_id) {
        this.load_id = load_id;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public int getTrucker_request_id() {
        return trucker_request_id;
    }

    public void setTrucker_request_id(int trucker_request_id) {
        this.trucker_request_id = trucker_request_id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getConsigner_id() {
        return consigner_id;
    }

    public void setConsigner_id(int consigner_id) {
        this.consigner_id = consigner_id;
    }

    public String getDrop_address() {
        return drop_address;
    }

    public void setDrop_address(String drop_address) {
        this.drop_address = drop_address;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Trucker getTrucker() {
        return trucker;
    }

    public void setTrucker(Trucker trucker) {
        this.trucker = trucker;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public TruckerRequest getTrucker_request() {
        return trucker_request;
    }

    public void setTrucker_request(TruckerRequest trucker_request) {
        this.trucker_request = trucker_request;
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck>  trucks) {
        this.trucks = trucks;
    }

}
