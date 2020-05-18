package c.bwegener.bookstore;

import android.os.Parcel;
import android.os.Parcelable;

public class Orders implements Parcelable {

    private long mId;
    private String mCustomer;
    private String mEmployee;
    private String mTotal;
    private String mDate;
    private String mPaymentType;
    private boolean mPaid;
    private boolean mComplete;

    public Orders(long id, String customer, String employee,
                  String total, String date, String paymentType,
                  boolean paid, boolean complete)
    {
        mId = id;
        mCustomer = customer;
        mEmployee = employee;
        mTotal = total;
        mDate = date;
        mPaymentType = paymentType;
        mPaid = paid;
        mComplete = complete;
    }

    public Orders(String customer, String employee, String total, String date,
                  String paymentType, boolean paid, boolean complete)
    {
        this(-1, customer, employee, total, date, paymentType, paid, complete);
    }


    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getCustomer() {
        return mCustomer;
    }

    public void setCustomer(String customer) {
        mCustomer = customer;
    }

    public String getEmployee() {
        return mEmployee;
    }

    public void setEmployee(String employee) {
        mEmployee = employee;
    }

    public String getTotal() {
        return mTotal;
    }

    public void setTotal(String total) {
        mTotal = total;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getPaymentType() { return mPaymentType; }

    public void setPaymentType(String paymentType) { mPaymentType = paymentType; }

    public boolean isPaid() {
        return mPaid;
    }

    public void setPaid(boolean paid) {
        mPaid = paid;
    }

    public boolean isComplete() {
        return mComplete;
    }

    public void setComplete(boolean complete) {
        mComplete = complete;
    }

    protected Orders(Parcel in)
    {
        mId = in.readLong();
        mCustomer = in.readString();
        mEmployee = in.readString();
        mTotal = in.readString();
        mDate = in.readString();
        mPaymentType = in.readString();
        mPaid = in.readByte() != 0;
        mComplete = in.readByte() != 0;
    }

    @Override
    public int describeContents() { return 0; }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(mId);
        parcel.writeString(mCustomer);
        parcel.writeString(mEmployee);
        parcel.writeString(mTotal);
        parcel.writeString(mDate);
        parcel.writeString(mPaymentType);
        parcel.writeByte((byte) (mPaid ? 1 : 0));
        parcel.writeByte((byte) (mComplete ? 1 : 0));
    }

    public static final Creator<Orders> CREATOR = new Creator<Orders>() {
        @Override
        public Orders createFromParcel(Parcel in) { return new Orders(in); }

        @Override
        public Orders[] newArray(int size) { return new Orders[size]; }
    };

    @Override
    public String toString() {
        return "Orders{" +
                "mId=" + mId +
                ", mCustomer='" + mCustomer + '\'' +
                ", mEmployee='" + mEmployee + '\'' +
                ", mTotal='" + mTotal + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mPaymentType='" + mPaymentType + '\'' +
                ", mPaid=" + mPaid +
                ", mComplete=" + mComplete +
                '}';
    }
}
