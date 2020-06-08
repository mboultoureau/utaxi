package fr.iutlannion.map;

public class LatLng {

    private double latitude;
    private double longitude;

    public LatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String toString() {
        return "x: " + latitude + ", y : " + longitude;
    }

    public String internalString() {
        return latitude + ", " + longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

}
