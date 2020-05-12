package c.bwegener.bookstore;

public class Customer {

    private String mFirstName;
    private String mLastName;
    private String mPhoneNumber;
    private String mAddress;
    private String mZipCode;
    private String mOrders;

    public String getFirstName()
    {
        return mFirstName;
    }

    public void setFirstName(String firstName)
    {
        mFirstName = firstName;
    }

    public String getLastName()
    {
        return mLastName;
    }

    public void setLastName(String lastName)
    {
        mLastName = lastName;
    }

    public String getPhoneNumber()
    {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        mPhoneNumber = phoneNumber;
    }

    public String getAddress()
    {
        return mAddress;
    }

    public void setAddress(String address)
    {
        mAddress = address;
    }

    public String getZipCode()
    {
        return mZipCode;
    }

    public void setZipCode(String zipCode)
    {
        mZipCode = zipCode;
    }

    public String getOrders()
    {
        return mOrders;
    }

    public void setOrders(String orders)
    {
        mOrders = orders;
    }
}
