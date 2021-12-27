package address;

public class AddressProperties implements Address{
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;


    /**
     * Setters for all the address fields
     */
    @Override
    public String setAddressLine1(String addressLine1) {
        return this.addressLine1 = addressLine1;
    }

    @Override
    public String setAddressLine2(String addressLine2) {
        return this.addressLine2 = addressLine2;
    }

    @Override
    public String setCity(String city) {
        return this.city = city;
    }

    @Override
    public String setState(String state) {
        return this.state = state;
    }

    @Override
    public String setPincode(String pincode) {
        return this.pincode = pincode;
    }


    /**
     * Getter for all the address details
     */
    @Override
    public String getAddressLine1() {
        return addressLine1;
    }

    @Override
    public String getAddressLine2() {
        return addressLine2;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getPincode() {
        return pincode;
    }
}