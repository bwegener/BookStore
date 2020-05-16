package c.bwegener.bookstore;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private long mId;
    private String mTitle;
    private String mAuthorLast;
    private String mAuthorFirst;
    private String mPublisher;
    private String mPublishDate;
    private String mEdition;
    private String mCost;
    private String mRetailPrice;
    private float mRating;
    private String mCoverType;
    private String mGenre;

    private String mBookDescriptionTextFileName;

    public Book() { this(-1, "", "", "", "", "", "","", "", 0.0f, "", "");}

    public Book(String title, String authorLast, String authorFirst, String publisher,
                String publishDate, String edition, String cost, String retailPrice,
                float rating, String coverType, String genre) {
        this(-1, title, authorLast, authorFirst, publisher, publishDate,edition,cost,retailPrice,rating,coverType,genre);
    }

    public Book(long id, String title, String authorLast, String authorFirst, String publisher,
                String publishDate, String edition, String cost, String retailPrice,
                float rating, String coverType, String genre) {
        mId = id;
        mTitle = title;
        mAuthorLast = authorLast;
        mAuthorFirst = authorFirst;
        mPublisher = publisher;
        mPublishDate = publishDate;
        mEdition = edition;
        mCost = cost;
        mRetailPrice = retailPrice;
        mRating = rating;
        mCoverType = coverType;
        mGenre = genre;
    }

    public long getId() { return mId; }

    public void setId(long id) { mId = id; }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthorLast() {
        return mAuthorLast;
    }

    public void setAuthorLast(String authorLast) {
        mAuthorLast = authorLast;
    }

    public String getAuthorFirst() { return mAuthorFirst; }

    public void setAuthorFirst(String authorFirst) { mAuthorFirst = authorFirst; }

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(String publisher) {
        mPublisher = publisher;
    }

    public String getPublishDate() {
        return mPublishDate;
    }

    public void setPublishDate(String publishDate) {
        mPublishDate = publishDate;
    }

    public String getEdition() {
        return mEdition;
    }

    public void setEdition(String edition) {
        mEdition = edition;
    }

    public String getCost() {
        return mCost;
    }

    public void setCost(String cost) {
        mCost = cost;
    }

    public String getRetailPrice() {
        return mRetailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        mRetailPrice = retailPrice;
    }

    public float getRating() {
        return mRating;
    }

    public void setRating(float rating) {
        mRating = rating;
    }

    public String getCoverType() {
        return mCoverType;
    }

    public void setCoverType(String coverType) {
        mCoverType = coverType;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }


    /*
    Might be unnecessary
     */
    public String getBookDescriptionTextFileName() {
        return mBookDescriptionTextFileName;
    }

    public void setBookDescriptionTextFileName(String bookDescriptionTextFileName) {
        mBookDescriptionTextFileName = bookDescriptionTextFileName;
    }

    protected Book(Parcel in) {
        mId = in.readLong();
        mTitle = in.readString();
        mAuthorLast = in.readString();
        mAuthorFirst = in.readString();
        mPublisher = in.readString();
        mPublishDate = in.readString();
        mEdition = in.readString();
        mCost = in.readString();
        mRetailPrice = in.readString();
        mRating = in.readFloat();
        mCoverType = in.readString();
        mGenre = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(mId);
        parcel.writeString(mTitle);
        parcel.writeString(mAuthorLast);
        parcel.writeString(mAuthorFirst);
        parcel.writeString(mPublisher);
        parcel.writeString(mPublishDate);
        parcel.writeString(mEdition);
        parcel.writeString(mCost);
        parcel.writeString(mRetailPrice);
        parcel.writeFloat(mRating);
        parcel.writeString(mCoverType);
        parcel.writeString(mGenre);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel parcel) {
            return new Book(parcel);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public String toString() {
        return "Book{" +
                "mId=" + mId +
                ", mTitle='" + mTitle + '\'' +
                ", mAuthorLast='" + mAuthorLast + '\'' +
                ", mAuthorFirst='" + mAuthorFirst + '\'' +
                ", mPublisher='" + mPublisher + '\'' +
                ", mPublishDate='" + mPublishDate + '\'' +
                ", mEdition='" + mEdition + '\'' +
                ", mCost=" + mCost +
                ", mRetailPrice=" + mRetailPrice +
                ", mRating=" + mRating +
                ", mCoverType='" + mCoverType + '\'' +
                ", mGenre='" + mGenre + '\'' +
                '}';
    }
}
