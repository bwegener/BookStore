package c.bwegener.bookstore;

public class Author {

    protected long mId;
    private String mAuthorLast;
    private String mAuthorFirst;
    private String mYearOfBirth;
    private String mYearOfDeath;

    public Author(long id, String authorLast, String authorFirst, String yearOfBirth, String yearOfDeath) {
        mId = id;
        mAuthorLast = authorLast;
        mAuthorFirst = authorFirst;
        mYearOfBirth = yearOfBirth;
        mYearOfDeath = yearOfDeath;
    }

    public long getId() { return mId; }

    public void setId(long id) { mId = id; }

    public String getAuthorLast() {
        return mAuthorLast;
    }

    public void setAuthorLast(String authorLast) {
        mAuthorLast = authorLast;
    }

    public String getAuthorFirst() {
        return mAuthorFirst;
    }

    public void setAuthorFirst(String authorFirst) {
        mAuthorFirst = authorFirst;
    }

    public String getYearOfBirth() {
        return mYearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        mYearOfBirth = yearOfBirth;
    }

    public String getYearOfDeath() {
        return mYearOfDeath;
    }

    public void setYearOfDeath(String yearOfDeath) {
        mYearOfDeath = yearOfDeath;
    }

    @Override
    public String toString() {
        return "Author{" +
                "mId=" + mId +
                ", mAuthorLast='" + mAuthorLast + '\'' +
                ", mAuthorFirst='" + mAuthorFirst + '\'' +
                ", mYearOfBirth='" + mYearOfBirth + '\'' +
                ", mYearOfDeath='" + mYearOfDeath + '\'' +
                '}';
    }
}
