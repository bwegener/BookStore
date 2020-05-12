package c.bwegener.bookstore;

public class Book {

    private String mTitle;
    private String mAuthor;
    private String mPublisher;
    private String mPublishDate;
    private String mEdition;
    private double mCost;
    private double mRetailPrice;
    private double mRating;         // variable to store rating bar
    private String mCoverType;
    private String mGenre;


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

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

    public double getCost() {
        return mCost;
    }

    public void setCost(double cost) {
        mCost = cost;
    }

    public double getRetailPrice() {
        return mRetailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        mRetailPrice = retailPrice;
    }

    public double getRating() {
        return mRating;
    }

    public void setRating(double rating) {
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

}
