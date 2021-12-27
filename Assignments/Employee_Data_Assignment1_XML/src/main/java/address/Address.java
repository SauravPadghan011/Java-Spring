package address;

public interface Address {
    String setAddressLine1(String addressLine1);
    String setAddressLine2(String addressLine2);
    String setCity(String city);
    String setState(String state);
    String setPincode(String pincode);

    String getAddressLine1();
    String getAddressLine2();
    String getCity();
    String getState();
    String getPincode();
}
