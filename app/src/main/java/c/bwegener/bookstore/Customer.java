package c.bwegener.bookstore;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable {

    private long mId;
    private String mFirstName;
    private String mLastName;
    private String mAddress;
    private String mZipCode;
    private String mPhoneNumber;
    private String mBooks;
    private String mOrders;

    public Customer(long id, String firstName, String lastName, String address, String zipCode, String phoneNumber, String books, String orders) {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mAddress = address;
        mZipCode = zipCode;
        mPhoneNumber = phoneNumber;
        mBooks = books;
        mOrders = orders;
    }

    public Customer(String firstName, String lastName,
                    String address, String zipCode, String phoneNumber,
                    String books, String orders)
    {
        this(-1, firstName, lastName, address, zipCode, phoneNumber, books, orders);
    }

    public long getId() { return mId; }

    public void setId(long id) { mId = id; }

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

    public String getPhoneNumber()
    {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        mPhoneNumber = phoneNumber;
    }

    public String getBooks() { return mBooks; }

    public void setBooks(String books) { mBooks = books; }

    public String getOrders()
    {
        return mOrders;
    }

    public void setOrders(String orders)
    {
        mOrders = orders;
    }

    protected Customer(Parcel in)
    {
        mId = in.readLong();
        mFirstName = in.readString();
        mLastName = in.readString();
        mAddress = in.readString();
        mZipCode = in.readString();
        mPhoneNumber = in.readString();
        mBooks = in.readString();
        mOrders = in.readString();
    }

    @Override
    public int describeContents() { return 0; }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(mId);
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
        parcel.writeString(mAddress);
        parcel.writeString(mZipCode);
        parcel.writeString(mPhoneNumber);
        parcel.writeString(mBooks);
        parcel.writeString(mOrders);
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) { return new Customer(in); }

        @Override
        public Customer[] newArray(int size) { return new Customer[size]; }
    };

    @Override
    public String toString() {
        return "Customer{" +
                "mId=" + mId +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mZipCode='" + mZipCode + '\'' +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mBooks='" + mBooks + '\'' +
                ", mOrders='" + mOrders + '\'' +
                '}';
    }
}
