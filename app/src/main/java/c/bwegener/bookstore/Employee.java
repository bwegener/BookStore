package c.bwegener.bookstore;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {

    private long mID;
    private String mUserName;
    private String mPassword;
    private String mFirstName;
    private String mLastName;
    private String mPhoneNumber;
    private String mAddress;
    private String mDateOfBirth;
    private String mHireDate;
    private String mPosition;

    // Constructor
    public Employee(long id, String userName, String password, String firstName, String lastName,
                    String phoneNumber, String address, String dateOfBirth, String hireDate, String position)
    {
        mID = id;
        mUserName = userName;
        mPassword = password;
        mFirstName = firstName;
        mLastName = lastName;
        mPhoneNumber = phoneNumber;
        mAddress = address;
        mDateOfBirth = dateOfBirth;
        mHireDate = hireDate;
        mPosition = position;
    }

    public Employee(String userName, String password, String firstName, String lastName,
                    String phoneNumber, String address, String dateOfBirth, String hireDate, String position)
    {
        this(-1, userName, password, firstName, lastName, phoneNumber, address, dateOfBirth, hireDate, position);
    }

    protected Employee(Parcel in)
    {
        mID = in.readLong();
        mUserName = in.readString();
        mPassword = in.readString();
        mFirstName = in.readString();
        mLastName = in.readString();
        mPhoneNumber = in.readString();
        mAddress = in.readString();
        mDateOfBirth = in.readString();
        mHireDate = in.readString();
        mPosition = in.readString();
    }

    public long getID() {
        return mID;
    }

    public void setID(long ID) {
        mID = ID;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    protected String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public String getHireDate() {
        return mHireDate;
    }

    public void setHireDate(String hireDate) {
        mHireDate = hireDate;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

    @Override
    public int describeContents() { return 0; }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(mID);
        parcel.writeString(mUserName);
        parcel.writeString(mPassword);
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
        parcel.writeString(mPhoneNumber);
        parcel.writeString(mAddress);
        parcel.writeString(mDateOfBirth);
        parcel.writeString(mHireDate);
        parcel.writeString(mPosition);
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) { return new Employee(in); }

        @Override
        public Employee[] newArray(int size) { return new Employee[size]; }
    };

}
