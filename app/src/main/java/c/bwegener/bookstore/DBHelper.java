package c.bwegener.bookstore;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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
    private static final String FIELD_BOOKS_COVER_TYPE = "book_cover_type";
    private static final String FIELD_BOOKS_GENRE = "book_genre";


    // TODO: REOPEN EVERY DATABASE ONCE THEY ARE ACTIVATED AND USED
    /*
    // Database 2 -- Authors Database + Fields
    private static final String AUTHORS_TABLE = "Authors";
    private static final String AUTHORS_KEY_FIELD_ID = "_id";
    private static final String FIELD_AUTHORS_LAST = "author_last";                 // Relational Database
    private static final String FIELD_AUTHORS_FIRST = "author_first";               // Relational Database
    private static final String FIELD_AUTHORS_YEAR_BIRTH = "author_year_birth";
    private static final String FIELD_AUTHORS_YEAR_DEATH = "author_year_death";     // If Applicable
    */

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
    private static final String FIELD_CUSTOMERS_ADDRESS = "customer_address";        // Not required
    private static final String FIELD_CUSTOMERS_ZIP = "customer_zip";                // Not required
    private static final String FIELD_CUSTOMERS_PHONE = "customer_phone";            // Not required
    private static final String FIELD_CUSTOMERS_BOOKS = "customer_books";            // Not required
    private static final String FIELD_CUSTOMERS_ORDERS = "customer_orders";          // Not required

    // Database 5 -- Cart Database + Fields
    private static final String CART_TABLE = "Cart";
    private static final String FIELD_ID = "_id";
    private static final String FIELD_BOOKS_ID = "books_id";


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
    public void onCreate(SQLiteDatabase database) {
        // Create Books table
        String createQuery = "CREATE TABLE " + BOOKS_TABLE + "("
                + BOOKS_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_BOOKS_TITLE + " TEXT, "
                + FIELD_BOOKS_AUTHOR_LAST + " TEXT, "
                + FIELD_BOOKS_AUTHOR_FIRST + " TEXT, "
                + FIELD_BOOKS_PUBLISHER + " TEXT, "
                + FIELD_BOOKS_PUBLICATION_DATE + " TEXT, "
                + FIELD_BOOKS_EDITION + " TEXT, "
                + FIELD_BOOKS_COST + " TEXT, "
                + FIELD_BOOKS_RETAIL_PRICE + " TEXT, "
                + FIELD_BOOKS_RATING + " REAL, "
                + FIELD_BOOKS_COVER_TYPE + " TEXT, "
                + FIELD_BOOKS_GENRE + " TEXT" + ")";
        database.execSQL(createQuery);

        /*
        // Create Authors table
        createQuery = "CREATE TABLE " + AUTHORS_TABLE + "("
                + AUTHORS_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_AUTHORS_FIRST + " TEXT, "
                + FIELD_AUTHORS_LAST + " TEXT, "
                + FIELD_AUTHORS_YEAR_BIRTH + " TEXT, "
                + FIELD_AUTHORS_YEAR_DEATH + " TEXT" + ")";
        database.execSQL(createQuery);
        */

        // Create Employees table
        createQuery = "CREATE TABLE " + EMPLOYEES_TABLE + "("
                + EMPLOYEES_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_EMPLOYEES_FIRST + " TEXT, "
                + FIELD_EMPLOYEES_LAST + " TEXT, "
                + FIELD_EMPLOYEES_ADDRESS + " TEXT, "
                + FIELD_EMPLOYEES_PHONE + " TEXT, "
                + FIELD_EMPLOYEES_BIRTH + " TEXT, "
                + FIELD_EMPLOYEES_HIRE + " TEXT, "
                + FIELD_EMPLOYEE_SALES + " TEXT, "
                + FIELD_EMPLOYEE_POSITION + " TEXT" + ")";
        database.execSQL(createQuery);

        // Create Customers table
        createQuery = "CREATE TABLE " + CUSTOMERS_TABLE + "("
                + CUSTOMERS_KEY_FIELD_ID + " INTEGER PRIMARY KEY, "
                + FIELD_CUSTOMERS_FIRST + " TEXT, "
                + FIELD_CUSTOMERS_LAST + " TEXT, "
                + FIELD_CUSTOMERS_ADDRESS + " TEXT, "
                + FIELD_CUSTOMERS_ZIP + " TEXT, "
                + FIELD_CUSTOMERS_PHONE + " TEXT, "
                + FIELD_CUSTOMERS_BOOKS + " TEXT, "
                + FIELD_CUSTOMERS_ORDERS + " TEXT" + ")";
        database.execSQL(createQuery);

        // Create Cart table
        createQuery = "CREATE TABLE " + CART_TABLE + "("
                + FIELD_ID + " INTEGER, "
                + "FOREIGN KEY(" + FIELD_BOOKS_ID + ") REFERENCES "
                + BOOKS_TABLE + "(" + BOOKS_KEY_FIELD_ID + "))";
        database.execSQL(createQuery);
    }


    // ******************* ON UPGRADE ***********************


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BOOKS_TABLE);
        /*
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + AUTHORS_TABLE);
        */
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EMPLOYEES_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CUSTOMERS_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CART_TABLE);

        onCreate(sqLiteDatabase);
    }

    // ******************* ADD TO TABLES ***********************

    public void addBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_BOOKS_TITLE, book.getTitle());
        values.put(FIELD_BOOKS_AUTHOR_LAST, book.getAuthorLast());
        values.put(FIELD_BOOKS_AUTHOR_FIRST, book.getAuthorFirst());
        values.put(FIELD_BOOKS_PUBLISHER, book.getPublisher());
        values.put(FIELD_BOOKS_PUBLICATION_DATE, book.getPublishDate());
        values.put(FIELD_BOOKS_EDITION, book.getEdition());
        values.put(FIELD_BOOKS_COST, book.getCost());
        values.put(FIELD_BOOKS_RETAIL_PRICE, book.getRetailPrice());
        values.put(FIELD_BOOKS_RATING, book.getRating());
        values.put(FIELD_BOOKS_COVER_TYPE, book.getCoverType());
        values.put(FIELD_BOOKS_GENRE, book.getGenre());

        long id = db.insert(BOOKS_TABLE, null, values);

        book.setId(id);
        db.close();
    }

    /*
    public void addAuthor(Author author)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_AUTHORS_FIRST, author.getAuthorFirst());
        values.put(FIELD_AUTHORS_LAST, author.getAuthorLast());
        values.put(FIELD_AUTHORS_YEAR_BIRTH, author.getYearOfBirth());
        values.put(FIELD_AUTHORS_YEAR_DEATH, author.getYearOfDeath());

        long id = db.insert(AUTHORS_TABLE, null, values);

        author.setId(id);
        db.close();
    }
    */

    public void addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_EMPLOYEES_FIRST, employee.getFirstName());
        values.put(FIELD_EMPLOYEES_LAST, employee.getLastName());
        values.put(FIELD_EMPLOYEES_ADDRESS, employee.getAddress());
        values.put(FIELD_EMPLOYEES_PHONE, employee.getPhoneNumber());
        values.put(FIELD_EMPLOYEES_BIRTH, employee.getDateOfBirth());
        values.put(FIELD_EMPLOYEES_HIRE, employee.getHireDate());
        values.put(FIELD_EMPLOYEE_SALES, employee.getSales());
        values.put(FIELD_EMPLOYEE_POSITION, employee.getPosition());

        long id = db.insert(EMPLOYEES_TABLE, null, values);

        employee.setId(id);
        db.close();
    }

    public void addCustomer(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_CUSTOMERS_FIRST, customer.getFirstName());
        values.put(FIELD_CUSTOMERS_LAST, customer.getLastName());
        values.put(FIELD_CUSTOMERS_ADDRESS, customer.getAddress());
        values.put(FIELD_CUSTOMERS_ZIP, customer.getZipCode());
        values.put(FIELD_CUSTOMERS_PHONE, customer.getPhoneNumber());
        values.put(FIELD_CUSTOMERS_BOOKS, customer.getBooks());
        values.put(FIELD_CUSTOMERS_ORDERS, customer.getOrders());

        long id = db.insert(CUSTOMERS_TABLE, null, values);

        customer.setId(id);
        db.close();
    }

    // ADDS A BOOK TO THE CART TABLE
    public void addToCart(long id, int bookId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_ID, id);
        values.put(FIELD_BOOKS_ID, bookId);

        db.insert(CART_TABLE, null, values);

        db.close();
    }


    //**************** UPDATE TABLES **************************


    public void updateBook(Book book)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(FIELD_BOOKS_TITLE, book.getTitle());
        values.put(FIELD_BOOKS_AUTHOR_LAST, book.getAuthorLast());
        values.put(FIELD_BOOKS_AUTHOR_FIRST, book.getAuthorFirst());
        values.put(FIELD_BOOKS_PUBLISHER, book.getPublisher());
        values.put(FIELD_BOOKS_PUBLICATION_DATE, book.getPublishDate());
        values.put(FIELD_BOOKS_EDITION, book.getEdition());
        values.put(FIELD_BOOKS_COST, book.getCost());
        values.put(FIELD_BOOKS_RETAIL_PRICE, book.getRetailPrice());
        values.put(FIELD_BOOKS_RATING, book.getRating());
        values.put(FIELD_BOOKS_COVER_TYPE, book.getCoverType());
        values.put(FIELD_BOOKS_GENRE, book.getGenre());

        db.update(BOOKS_TABLE, values, BOOKS_KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(book.getId())});
        db.close();
    }

    /*
    public void updateAuthor(Author author)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(FIELD_AUTHORS_FIRST, author.getAuthorFirst());
        values.put(FIELD_AUTHORS_LAST, author.getAuthorLast());
        values.put(FIELD_AUTHORS_YEAR_BIRTH, author.getYearOfBirth());
        values.put(FIELD_AUTHORS_YEAR_DEATH, author.getYearOfDeath());

        db.update(AUTHORS_TABLE, values, AUTHORS_KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(author.getId())});
        db.close();
    }
    */

    public void updateEmployee(Employee employee)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(FIELD_EMPLOYEES_FIRST, employee.getFirstName());
        values.put(FIELD_EMPLOYEES_LAST, employee.getLastName());
        values.put(FIELD_EMPLOYEES_ADDRESS, employee.getAddress());
        values.put(FIELD_EMPLOYEES_PHONE, employee.getPhoneNumber());
        values.put(FIELD_EMPLOYEES_BIRTH, employee.getDateOfBirth());
        values.put(FIELD_EMPLOYEES_HIRE, employee.getHireDate());
        values.put(FIELD_EMPLOYEE_SALES, employee.getSales());
        values.put(FIELD_EMPLOYEE_POSITION, employee.getPosition());

        db.update(EMPLOYEES_TABLE, values, EMPLOYEES_KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(employee.getId())});
        db.close();
    }


    public void updateCustomer(Customer customer)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        values.put(FIELD_CUSTOMERS_FIRST, customer.getFirstName());
        values.put(FIELD_CUSTOMERS_LAST, customer.getLastName());
        values.put(FIELD_CUSTOMERS_ADDRESS, customer.getAddress());
        values.put(FIELD_CUSTOMERS_ZIP, customer.getZipCode());
        values.put(FIELD_CUSTOMERS_PHONE, customer.getPhoneNumber());
        values.put(FIELD_CUSTOMERS_BOOKS, customer.getBooks());
        values.put(FIELD_CUSTOMERS_ORDERS, customer.getOrders());

        db.update(CUSTOMERS_TABLE, values, CUSTOMERS_KEY_FIELD_ID + " = ?",
                new String[]{String.valueOf(customer.getId())});
        db.close();
    }

    public void updateCart(Cart cart) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_BOOKS_ID, cart.getBook().getId());

        db.update(CART_TABLE, values, FIELD_ID + " = ?",
                new String[]{String.valueOf(cart.getId())});

        db.close();
    }

    // ******************* GET TABLES ***********************

    public Book getBook(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                BOOKS_TABLE,
                new String[]{BOOKS_KEY_FIELD_ID,
                        FIELD_BOOKS_TITLE,
                        FIELD_BOOKS_AUTHOR_LAST,
                        FIELD_BOOKS_AUTHOR_FIRST,
                        FIELD_BOOKS_PUBLISHER,
                        FIELD_BOOKS_PUBLICATION_DATE,
                        FIELD_BOOKS_EDITION,
                        FIELD_BOOKS_COST,
                        FIELD_BOOKS_RETAIL_PRICE,
                        FIELD_BOOKS_RATING,
                        FIELD_BOOKS_COVER_TYPE,
                        FIELD_BOOKS_GENRE},
                BOOKS_KEY_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        if(cursor != null) cursor.moveToFirst();

        Book book = new Book(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getFloat(9),
                cursor.getString(10),
                cursor.getString(11));

        cursor.close();
        db.close();
        return book;
    }

    /*
    public Author getAuthor(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                AUTHORS_TABLE,
                new String[]{AUTHORS_KEY_FIELD_ID,
                FIELD_AUTHORS_LAST,
                FIELD_AUTHORS_FIRST,
                FIELD_AUTHORS_YEAR_BIRTH,
                FIELD_AUTHORS_YEAR_DEATH},
                AUTHORS_KEY_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        if(cursor != null) cursor.moveToFirst();

        Author author = new Author(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));

        cursor.close();
        db.close();
        return author;
    }

    */

    public Employee getEmployee(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                EMPLOYEES_TABLE,
                new String[]{EMPLOYEES_KEY_FIELD_ID,
                        FIELD_EMPLOYEES_FIRST,
                        FIELD_EMPLOYEES_LAST,
                        FIELD_EMPLOYEES_ADDRESS,
                        FIELD_EMPLOYEES_PHONE,
                        FIELD_EMPLOYEES_BIRTH,
                        FIELD_EMPLOYEES_HIRE,
                        FIELD_EMPLOYEE_SALES,
                        FIELD_EMPLOYEE_POSITION},
                EMPLOYEES_KEY_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null,null, null);

        if(cursor != null) cursor.moveToFirst();

        Employee employee = new Employee(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8));

        cursor.close();
        db.close();
        return employee;
    }

    public Customer getCustomer(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                CUSTOMERS_TABLE,
                new String[]{CUSTOMERS_KEY_FIELD_ID,
                        FIELD_CUSTOMERS_FIRST,
                        FIELD_CUSTOMERS_LAST,
                        FIELD_CUSTOMERS_ADDRESS,
                        FIELD_CUSTOMERS_ZIP,
                        FIELD_CUSTOMERS_PHONE,
                        FIELD_CUSTOMERS_BOOKS,
                        FIELD_CUSTOMERS_ORDERS},
                CUSTOMERS_KEY_FIELD_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);

        if(cursor != null) cursor.moveToFirst();

        Customer customer = new Customer(cursor.getLong(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7));

        cursor.close();
        db.close();
        return customer;
    }

    // ******************* DELETE TABLES ***********************



    public void deleteCart(Cart cart)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(CART_TABLE, FIELD_ID + " = ?",
                new String[]{String.valueOf(cart.getId())});
        db.close();
    }



    // ******************* DELETE ALL TABLES ***********************


    public void deleteAllBooks()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(BOOKS_TABLE, null, null);
        db.close();
    }

    /*
    public void deleteAllAuthors()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(AUTHORS_TABLE, null, null);
        db.close();
    }
    */

    public void deleteAllEmployees()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(EMPLOYEES_TABLE, null, null);
        db.close();
    }

    public void deleteAllCustomers()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(CUSTOMERS_TABLE, null, null);
        db.close();
    }

    public void deleteAllCarts()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(CART_TABLE, null, null);
        db.close();
    }

    // ******************* GET ALL TABLES ***********************


    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> bookList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                BOOKS_TABLE,
                new String[]{BOOKS_KEY_FIELD_ID, FIELD_BOOKS_TITLE, FIELD_BOOKS_AUTHOR_LAST,
                FIELD_BOOKS_AUTHOR_FIRST, FIELD_BOOKS_PUBLISHER, FIELD_BOOKS_PUBLICATION_DATE,
                FIELD_BOOKS_EDITION, FIELD_BOOKS_COST, FIELD_BOOKS_RETAIL_PRICE, FIELD_BOOKS_RATING,
                FIELD_BOOKS_COVER_TYPE, FIELD_BOOKS_GENRE},
                null, null, null, null, null, null);

        // Collect each row in the table
        if(cursor.moveToFirst()) {
            do {
                Book book = new Book(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getFloat(9),
                        cursor.getString(10),
                        cursor.getString(11));
                bookList.add(book);
            } while (cursor.moveToNext());
        }
        return bookList;
    }

    /*
    public ArrayList<Author> getAllAuthors() {
        ArrayList<Author> authorList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                AUTHORS_TABLE,
                new String[]{AUTHORS_KEY_FIELD_ID, FIELD_AUTHORS_LAST, FIELD_AUTHORS_FIRST,
                        FIELD_AUTHORS_YEAR_BIRTH, FIELD_AUTHORS_YEAR_DEATH},
                null, null, null, null, null, null);

        // Collect each row in the table
        if(cursor.moveToFirst()) {
            do {
                Author author = new Author(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
                authorList.add(author);
            } while (cursor.moveToNext());
        }
        return authorList;
    }
    */

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                EMPLOYEES_TABLE,
                new String[]{EMPLOYEES_KEY_FIELD_ID, FIELD_EMPLOYEES_FIRST, FIELD_EMPLOYEES_LAST,
                        FIELD_EMPLOYEES_ADDRESS, FIELD_EMPLOYEES_PHONE,
                        FIELD_EMPLOYEES_BIRTH, FIELD_EMPLOYEES_HIRE,
                        FIELD_EMPLOYEE_SALES, FIELD_EMPLOYEE_POSITION},
                null, null, null, null, null, null);

        // Collect each row in the table
        if(cursor.moveToFirst()) {
            do {
                Employee employee = new Employee(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8));
                employeeList.add(employee);
            } while (cursor.moveToNext());
        }
        return employeeList;
    }


    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                CUSTOMERS_TABLE,
                new String[]{CUSTOMERS_KEY_FIELD_ID, FIELD_CUSTOMERS_FIRST, FIELD_CUSTOMERS_LAST,
                        FIELD_CUSTOMERS_ADDRESS, FIELD_CUSTOMERS_ZIP,
                        FIELD_CUSTOMERS_PHONE, FIELD_CUSTOMERS_BOOKS,
                        FIELD_CUSTOMERS_ORDERS},
                null, null, null, null, null, null);

        // Collect each row in the table
        if(cursor.moveToFirst()) {
            do {
                Customer customer = new Customer(cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7));
                customerList.add(customer);
            } while (cursor.moveToNext());
        }
        return customerList;
    }

    public ArrayList<Cart> getAllCart() {
        ArrayList<Cart> cartList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                CART_TABLE,
                new String[]{FIELD_ID, FIELD_BOOKS_ID},
                null,
                null,
                null,
                null, null, null);

        if(cursor.moveToFirst()) {
            do {
                Book book = getBook(cursor.getLong(1));
                Cart newCart = new Cart(cursor.getInt(0), book);

                cartList.add(newCart);
            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return cartList;
    }


    // ******************* IMPORT FROM CSV ***********************


    public boolean importBooksFromCSV(String csvFileName) {
        AssetManager am = mContext.getAssets();
        InputStream inStream;
        try {
            inStream = am.open(csvFileName);
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));
        String line;
        try {
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 12) {
                    Log.d("Book Finder", "Skipping Bad CSV Row: " + Arrays.toString(fields));
                    continue;
                }
                int id = Integer.parseInt(fields[0].trim());
                String title = fields[1].trim();
                String authorFirst = fields[2].trim();
                String authorLast = fields[3].trim();
                String publisher = fields[4].trim();
                String publishDate = fields[5].trim();
                String edition = fields[6].trim();
                String cost = fields[7].trim();
                String retailPrice = fields[8].trim();
                String r = fields[9].trim();
                float rating = Float.valueOf(r);
                String coverType = fields[10].trim();
                String genre = fields[11].trim();

                addBook(new Book(id, title, authorFirst,
                        authorLast, publisher, publishDate,
                        edition, cost, retailPrice,
                        rating, coverType, genre));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean importEmployeesFromCSV(String csvFileName) {
        AssetManager am = mContext.getAssets();
        InputStream inStream;
        try {
            inStream = am.open(csvFileName);
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));
        String line;
        try {
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 9) {
                    Log.d("Employees Finder", "Skipping Bad CSV Row: " + Arrays.toString(fields));
                    continue;
                }
                int id = Integer.parseInt(fields[0].trim());
                String employeeFirst = fields[1].trim();
                String employeeLast = fields[2].trim();
                String employeeAddress = fields[3].trim();
                String employeePhone = fields[4].trim();
                String employeeBirth = fields[5].trim();
                String employeeHire = fields[6].trim();
                String employeeSales = fields[7].trim();
                String employeePosition = fields[8].trim();
                addEmployee(new Employee(id, employeeFirst, employeeLast,
                        employeeAddress, employeePhone, employeeBirth,
                        employeeHire, employeeSales, employeePosition));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean importCustomersFromCSV(String csvFileName) {
        AssetManager am = mContext.getAssets();
        InputStream inStream;
        try {
            inStream = am.open(csvFileName);
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));
        String line;
        try {
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 8) {
                    Log.d("Customers Finder", "Skipping Bad CSV Row: " + Arrays.toString(fields));
                    continue;
                }
                int id = Integer.parseInt(fields[0].trim());
                String customerFirst = fields[1].trim();
                String customerLast = fields[2].trim();
                String customerAddress = fields[3].trim();
                String customerZip = fields[4].trim();
                String customerPhone = fields[5].trim();
                String customerBooks = fields[6].trim();
                String customerOrders = fields[7].trim();
                addCustomer(new Customer(id, customerFirst, customerLast,
                        customerAddress, customerZip, customerPhone,
                        customerBooks, customerOrders));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // ******************* EXPORT TO CSV ***********************


}
