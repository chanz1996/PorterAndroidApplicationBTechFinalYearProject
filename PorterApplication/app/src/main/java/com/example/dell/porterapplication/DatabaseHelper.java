package com.example.dell.porterapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 3/17/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Porter.db";


    public static final String User_Table = "User";
    public static final String User_Id = "User_Id";
    public static final String User_First_Name = "User_First_Name";
    public static final String User_Last_Name = "User_Last_Name";
    public static final String User_Gender = "User_Gender";
    public static final String User_Age = "User_Age";
    public static final String User_Email = "User_Email";
    public static final String User_Password = "User_Password";
    public static final String User_Phone_No = "User_Phone_No";
    public static final String User_Aadhar = "User_Aadhar";
    public static final String User_Points = "User_Points";
    public static final String User_Image = "User_Image";


    public static final String Porter_Table = "Porter";
    public static final String Porter_Id = "Porter_Id";
    public static final String Porter_First_Name = "Porter_First_Name";
    public static final String Porter_Last_Name = "Porter_Last_Name";
    public static final String Porter_Gender = "Porter_Gender";
    public static final String Porter_Age = "Porter_Age";
    public static final String Porter_Email = "Porter_Email";
    public static final String Porter_Phone_No = "Porter_Phone_No";
    public static final String Porter_Aadhar = "Porter_Aadhar";
    public static final String Porter_Points = "Porter_Points";
    public static final String Porter_Image = "Porter_Image";
    public static final String Porter_Status = "Porter_Status";
    public static final String Porter_Station_Id = "Porter_Station_Id";


    public static final String Train_Table = "Train";
    public static final String Train_Id = "Train_Id";
    public static final String Train_Name = "Train_Name";
    public static final String No_Of_Coach = "No_Of_Coach";


    public static final String Station_Table = "Station";
    public static final String Station_Id = "Station_Id";
    public static final String Station_Name = "Station_Name";


    public static final String Train_Route_Table = "Train_Route";
    public static final String Route_Id = "Route_Id";
    public static final String Route_Train_Id = "Route_Train_Id";
    public static final String Departure_Station_Id = "Departure_Station_Id";
    public static final String Arrival_Station_Id = "Arrival_Station_Id";
    public static final String Departure_Time = "Departure_Time";
    public static final String Arrival_Time = "Arrival_Time";


    public static final String Booking_Train_Table = "Booking_Train";
    public static final String Pnr = "Pnr";
    public static final String Bt_User_Id= "Bt_User_Id";
    public static final String Bt_Route_Id = "Bt_Route_Id";
    public static final String Coach_No = "Coach_No";
    public static final String Seat_No = "Seat_No";
    public static final String Booking_Date = "Booking_Date";
    public static final String Arrival_Date = "Arrival_Date";
    public static final String Destination_Date = "Destination_Date";


    public static final String Check_Point_Table = "Check_Point";
    public static final String Check_Point_Id = "Check_Point_Id";
    public static final String Check_Point_Name= "Check_Point_Name";
    public static final String Check_Point_Longitude = "Check_Point_Longitude";
    public static final String Check_Point_Lattitude = "Check_Point_Lattitude";


    public static final String Payment_Table = "Payment";
    public static final String Payment_Id = "Payment_Id";
    public static final String Payment_Type= "Payment_Type";
    public static final String Discount_Percentage = "Discount_Percentage";
    public static final String Amount = "Amount";
    public static final String Net_Amount = "Net_Amount";
    public static final String Pay_Booking_Id="Pay_Booking_Id";


    public static final String Feedback_Table = "Feedback";
    public static final String Feedback_Id = "Feedback_Id";
    public static final String Satisfaction_Level = "Satisfaction_Level";
    public static final String Feedback_Description = "Feedback_Description";


    public static final String Booking_Porter_Table = "Booking_Porter";
    public static final String Booking_Id = "Booking_Id";
    public static final String Bp_User_Id= "Bp_User_Id";
    public static final String Bp_Porter_Id = "Bp_Porter_Id";
    public static final String Bp_Pnr = "Bp_Pnr";
    public static final String Bp_Check_Point_Id = "Bp_Check_Point_Id";
    public static final String Trip_Status = "Trip_Status";
    public static final String Bp_Payment_Id = "Bp_Payment_Id";
    public static final String Bp_Feedback_Id = "Bp_Feedback_Id";
    public static final String Luggage_Weight = "Luggage_Weight";

    public static final int DATABASE_VERSION = 2;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_String = "CREATE TABLE IF NOT EXISTS " + User_Table + " ( " +
                User_Id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                User_First_Name + " TEXT, " +
                User_Last_Name + " TEXT, " +
                User_Gender +" TEXT, "+
                User_Age+" INTEGER, "+
                User_Email+" TEXT, "+
                User_Password+" TEXT, "+
                User_Phone_No+" INTEGER, "+
                User_Aadhar+" TEXT, "+
                User_Points+" REAL, "+
                User_Image+" BLOB "+" )";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS "+ Station_Table + " ( " +
                Station_Id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                Station_Name+ " TEXT "+
                " ) ";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS " + Porter_Table + " ( " +
                Porter_Id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                Porter_First_Name + " TEXT, " +
                Porter_Last_Name + " TEXT, " +
                Porter_Gender +" TEXT, "+
                Porter_Age+" INTEGER, "+
                Porter_Email+" TEXT, "+
                Porter_Phone_No+" INTEGER, "+
                Porter_Aadhar+" TEXT, "+
                Porter_Points+" REAL, "+
                Porter_Image+" BLOB, "+
                Porter_Status+" TEXT, "+
                Porter_Station_Id+" INTEGER, "+
                " FOREIGN KEY( "+Porter_Station_Id+" ) "+ " REFERENCES " +Station_Table+" ( "+Station_Id+" ) ON DELETE SET NULL "+
                ")";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS "+ Train_Table + " ( " +
                Train_Id + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                Train_Name+ " TEXT, "+
                No_Of_Coach+ " INTEGER "+
                " ) ";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS "+ Train_Route_Table+" ( "+
                Route_Id+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
                Route_Train_Id+" INTEGER NOT NULL, "+
                Departure_Station_Id+" INTEGER NOT NULL, "+
                Arrival_Station_Id+" INTEGER NOT NULL, "+
                Departure_Time+" TEXT NOT NULL, "+
                Arrival_Time+" TEXT NOT NULL, "+
                " FOREIGN KEY( "+Arrival_Station_Id+" ) "+ " REFERENCES " +Station_Table+" ( "+Station_Id+" ) ON DELETE SET NULL, "+
                " FOREIGN KEY("+Departure_Station_Id+" ) "+ " REFERENCES " +Station_Table+" ( "+Station_Id+" ) ON DELETE SET NULL, "+
                " FOREIGN KEY("+Route_Train_Id+" ) "+ " REFERENCES " +Train_Table+" ( "+Train_Id+" ) ON DELETE SET NULL "+
                ")";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS "+ Booking_Train_Table+" ( "+
                Pnr+" TEXT NOT NULL PRIMARY KEY UNIQUE, "+
                Bt_User_Id+" INTEGER NOT NULL, "+
                Bt_Route_Id+" INTEGER NOT NULL, "+
                Coach_No+" INTEGER NOT NULL, "+
                Seat_No+" INTEGER NOT NULL, "+
                Booking_Date+" INTEGER NOT NULL, "+
                Arrival_Date+ " INTEGER NOT NULL, "+
                Destination_Date+ " INTEGER NOT NULL, "+
                " FOREIGN KEY("+Bt_User_Id+" ) "+ " REFERENCES " +User_Table+" ( "+User_Id+" ) ON DELETE SET NULL, "+
                " FOREIGN KEY("+Bt_Route_Id+" ) "+ " REFERENCES " +Train_Route_Table+" ( "+Route_Id+" ) ON DELETE SET NULL "+
                ")";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS "+ Check_Point_Table+" ( "+
                Check_Point_Id+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
                Check_Point_Name+" TEXT NOT NULL, "+
                Check_Point_Lattitude+" REAL NOT NULL, "+
                Check_Point_Longitude+" REAL NOT NULL "+
                ")";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS "+ Feedback_Table+" ( "+
                Feedback_Id+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
                Satisfaction_Level+" TEXT NOT NULL, "+
                Feedback_Description+" TEXT NOT NULL "+
                ")";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS "+ Booking_Porter_Table+" ( "+
                Booking_Id+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
                Bp_User_Id+" INTEGER NOT NULL, "+
                Bp_Porter_Id+" INTEGER NOT NULL, "+
                Bp_Pnr+" TEXT NOT NULL, "+
                Bp_Check_Point_Id+" INTEGER NOT NULL, "+
                Trip_Status+" TEXT NOT NULL, "+
                Bp_Feedback_Id+ " INTEGER, "+
                Luggage_Weight+ " REAL, "+
                " FOREIGN KEY("+Bp_User_Id+" ) "+ " REFERENCES " +User_Table+" ( "+User_Id+" ) ON DELETE SET NULL, "+
                " FOREIGN KEY("+Bp_Porter_Id+" ) "+ " REFERENCES " +Porter_Table+" ( "+Porter_Id+" ) ON DELETE SET NULL, "+
                " FOREIGN KEY("+Bp_Pnr+" ) "+ " REFERENCES " +Booking_Train_Table+" ( "+Pnr+" ) ON DELETE SET NULL "+
                ")";
        db.execSQL(SQL_String);

        SQL_String = "CREATE TABLE IF NOT EXISTS "+ Payment_Table+" ( "+
                Payment_Id+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "+
                Pay_Booking_Id+ " INTEGER NOT NULL, "+
                Payment_Type+" TEXT NOT NULL, "+
                Discount_Percentage+" REAL NOT NULL, "+
                Amount+" INTEGER NOT NULL, "+
                Net_Amount+ "INTEGER NOT NULL, "+
                " FOREIGN KEY("+Pay_Booking_Id+" ) "+ " REFERENCES " +Booking_Porter_Table+" ( "+Booking_Id+" ) ON DELETE SET NULL "+
                ")";
        db.execSQL(SQL_String);


        ContentValues values = new ContentValues();
        values.put(this.User_Email,"taneja.ravneet@gmail.com");
        values.put(this.User_Password,"1234567");
        long id = db.insert(this.User_Table,null,values);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+Payment_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+Booking_Porter_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+Feedback_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+Check_Point_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+Booking_Train_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+Train_Route_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+Train_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+Porter_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+Station_Table);
        db.execSQL(" DROP TABLE IF EXISTS "+User_Table);
        onCreate(db);
    }
}
