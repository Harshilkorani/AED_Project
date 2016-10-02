/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.communication;

/**
 *
 * @author Harshil
 */
public class Location {
    
    
    private String latitude;
    private String longitude;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String addressLine1;

    //Constructor
    public Location() {
    }

    //Getter and Setter
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLandmark() {
        return addressLine1;
    }

    public void setLandmark(String landmark) {
        this.addressLine1 = landmark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    //Helper Methods
    public void setCompleteAddress(String AddressLine1,String AddressLine2, String city, String state, String country, String landmark)
    {
        setAddressLine1(addressLine1);
        setAddressLine2(addressLine2);
        setCity(city);
        setState(state);
        setCountry(country);
        setLandmark(landmark);
    }
    
    public void setLatitudeAndLongitude(String latitude, String longitude)
    {
        setLatitude(latitude);
        setLongitude(longitude);
    }
    
}
