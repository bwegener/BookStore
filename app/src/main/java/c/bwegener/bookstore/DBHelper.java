package c.bwegener.bookstore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private Context mContext;

    private static final String TAG = "DBHelper";

    static final String DATABASE_NAME = "AntiqueBookStore";
    private static final int DATABASE_VERSION = 1;

    // Database 1 -- Books Database + Fields
    private static final String BOOKS_TABLE = "Books";
    private static final String BOOKS_KEY_FIELD_ID = "_id";
    private static final String FIELD_BOOKS_TITLE = "book_title";
    private static final String FIELD_BOOKS_AUTHOR_LAST = "book_author_last";       // Relational Database
    private static final String FIELD_BOOKS_AUTHOR_FIRST = "book_author_first";     // Relational Database
    private static final String FIELD_BOOKS_PUBLISHER = "book_publisher";
    private static final String FIELD_BOOKS_PUBLICATION_DATE = "book_publication_date";
    private static final String FIELD_BOOKS_EDITION = "book_edition";
    private static final String FIELD_BOOKS_COST = "book_cost";
    private static final String FIELD_BOOKS_RETAIL_PRICE = "book_retail_price";
    private static final String FIELD_BOOKS_RATING = "book_rating";

    // Database 2 -- Authors Database + Fields
    private static final String AUTHORS_TABLE = "Authors";
    private static final String AUTHORS_KEY_FIELD_ID = "_id";
    private static final String FIELD_AUTHORS_LAST = "author_last";         // Relational Database
    private static final String FIELD_AUTHORS_FIRST = "author_first";       // Relational Database
    private static final String FIELD_AUTHORS_YEAR_BIRTH = "author_year_birth";
    private static final String FIELD_AUTHORS_YEAR_DEATH = "author_year_death";     // If Applicable

    // Database 3 -- Employee Database + Fields
    private static final String EMPLOYEES_TABLE = "Employees";
    private static final String EMPLOYEES_KEY_FIELD_ID = "_id";
    private static final String FIELD_EMPLOYEES_FIRST = "employee_first";
    private static final String FIELD_EMPLOYEES_LAST = "employee_last";
    private static final String FIELD_EMPLOYEES_ADDRESS = "employee_address";
    private static final String FIELD_EMPLOYEES_PHONE = "employee_phone";
    private static final String FIELD_EMPLOYEES_BIRTH = "employee_birth";
    private static final String FIELD_EMPLOYEES_HIRE = "employee_hire";
    // manager tracks employee sales
    private static final String FIELD_EMPLOYEE_SALES = "employee_sales";
    // Owner, Assistant Manager, Full Time Sales Clerk, Part Time Sales Clerk
    private static final String FIELD_EMPLOYEE_POSITION = "employee_position";

    // Database 4 -- Customer Database + Fields
    private static final String CUSTOMERS_TABLE = "Customers";
    private static final String CUSTOMERS_KEY_FIELD_ID = "_id";
    private static final String FIELD_CUSTOMERS_FIRST = "customer_first";
    private static final String FIELD_CUSTOMERS_LAST = "customer_last";
    private static final String FIELD_CUSTOMERS_PHONE = "customer_phone";            // Not required
    private static final String FIELD_CUSTOMERS_ADDRESS = "customer_address";        // Not required
    private static final String FIELD_CUSTOMERS_BOOKS = "customer_books";            // Not required
    private static final String FIELD_CUSTOMERS_PURCHASED = "customer_purchased";    // Not required


    /*
    DEAL WITH THIS DATABASE LAST

    // Database 5 -- Sales Database + Fields
    private static final String SALES_TABLE = "Sales";
    private static final String SALES_KEY_FIELD_ID = "_id";
    private static final String FIELD_SALES_BOOK_IS_SOLD = "book_sold";           // Relational Database
    //  Relational Database -- Customer who bought the book
    private static final String FIELD_SALES_CUSTOMER = "sales_customer";          // Relational Database
    // Salesperson who sold the book
    private static final String FIELD_SALES_EMPLOYEE = "sales_employee";          // Relational Database
    // Double or String -- Total cost of sales
    private static final String FIELD_SALES_TOTAL = "sales_total";                // Relational Database
    // String -- Date of sale
    private static final String FIELD_SALES_DATE = "sales_date";                  // Relational Database
    // Bool to check if the book is picked up
    private static final String FIELD_SALES_PICKED_UP = "sales_picked_up";
    // Bool to check if book is shipped
    private static final String FIELD_SALES_SHIPPED = "sales_shipped";
    // Bool to check if book is paid for, cannot be shipped unless paid for
    private static final String FIELD_SALES_PAID = "sales_paid";
    // String -- Drop Down -- Payment type -- CASH/CHECK/CREDIT
    private static final String FIELD_SALES_PAYMENT = "sales_payment";
    */


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create Books table
        String createQuery = "CREATE TABLE " + BOOKS_TABLE + "("
                + BOOKS_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_BOOKS_TITLE + " TEXT, "
                + FIELD_BOOKS_AUTHOR_LAST + " TEXT, "
                + FIELD_BOOKS_AUTHOR_FIRST + " TEXT, "
                + FIELD_BOOKS_PUBLISHER + " TEXT, "
                + FIELD_BOOKS_PUBLICATION_DATE + " INTEGER, "
                + FIELD_BOOKS_EDITION + " TEXT, "
                + FIELD_BOOKS_COST + " REAL, "
                + FIELD_BOOKS_RETAIL_PRICE + " REAL, "
                + FIELD_BOOKS_RATING + " TEXT" + ")";
        sqLiteDatabase.execSQL(createQuery);

        // Create Authors table


        // Create Employees table


        // Create Customers table

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
