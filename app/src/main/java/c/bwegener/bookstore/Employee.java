package c.bwegener.bookstore;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {

    private long mId;
    private String mFirstName;
    private String mLastName;
    private String mAddress;
    private String mPhoneNumber;
    private String mDateOfBirth;
    private String mHireDate;
    private String mSales;
    private String mPosition;

    // Constructor
    public Employee(long id, String firstName, String lastName,
                    String address, String phoneNumber, String dateOfBirth,
                    String hireDate, String sales, String position)
    {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mDateOfBirth = dateOfBirth;
        mHireDate = hireDate;
        mSales = sales;
        mPosition = position;
    }

    public Employee(String firstName, String lastName,
                    String address, String phoneNumber, String dateOfBirth, String hireDate,
                    String sales, String position)
    {
        this(-1, firstName, lastName, address, phoneNumber, dateOfBirth, hireDate, sales, position);
    }

    protected Employee(Parcel in)
    {
        mId = in.readLong();
        mFirstName = in.readString();
        mLastName = in.readString();
        mAddress = in.readString();
        mPhoneNumber = in.readString();
        mDateOfBirth = in.readString();
        mHireDate = in.readString();
        mSales = in.readString();
        mPosition = in.readString();
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) { mId = id; }

    public void setID(long id) {
        mId = id;
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

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
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

    public String getSales() { return mSales; }

    public void setSales(String sales) { mSales = sales; }

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
        parcel.writeLong(mId);
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
        parcel.writeString(mAddress);
        parcel.writeString(mPhoneNumber);
        parcel.writeString(mDateOfBirth);
        parcel.writeString(mHireDate);
        parcel.writeString(mSales);
        parcel.writeString(mPosition);
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) { return new Employee(in); }

        @Override
        public Employee[] newArray(int size) { return new Employee[size]; }
    };

    @Override
    public String toString() {
        return "Employee{" +
                "mID=" + mId +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mDateOfBirth='" + mDateOfBirth + '\'' +
                ", mHireDate='" + mHireDate + '\'' +
                ", mSales='" + mSales + '\'' +
                ", mPosition='" + mPosition + '\'' +
                '}';
    }
}
