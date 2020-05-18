package c.bwegener.bookstore;


import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private long mId;
    private String mUserName;
    private String mPassword;

    public User(long id, String userName, String password) {
        mId = id;
        mUserName = userName;
        mPassword = password;
    }

    public User(String username, String password)
    {
        this(-1, username, password);
    }

    public long getId() {return mId;}

    public void setId(long id) { mId = id;}

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    protected User(Parcel in)
    {
        mId = in.readLong();
        mUserName = in.readString();
        mPassword = in.readString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(mId);
        parcel.writeString(mUserName);
        parcel.writeString(mPassword);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) { return new User(in); }

        @Override
        public User[] newArray(int size) { return new User[size]; }
    };

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mUserName='" + mUserName + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }
}
