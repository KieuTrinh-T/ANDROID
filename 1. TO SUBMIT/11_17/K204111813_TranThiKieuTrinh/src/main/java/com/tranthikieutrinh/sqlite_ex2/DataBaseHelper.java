package com.tranthikieutrinh.sqlite_ex2;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "products.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "Product";
    public static final String COL_ID = "ProductId";
    public static final String COL_NAME = "ProductName";
    public static final String COL_PRICE = "ProductPrice";




    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + " ( "+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                                                    COL_NAME + " VARCHAR(50), "+
                                                                    COL_PRICE + "REAL)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TBL_NAME);
        onCreate(sqLiteDatabase);

    }

    //SELECT
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);

    }
    //INSERT, UPDATE, DELETE
    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public int getNumOfRows(){
        Cursor cursor = getData("SELECT * FROM "+ TBL_NAME);
        int numOfRows = cursor.getCount();
        cursor.close();
        return numOfRows;
    }
    public void createSampleData(){
        if(getNumOfRows()==0){
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Toco',19000) ");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Koi',40000) ");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'StarBuck',17000) ");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Highland',80000) ");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, 'Hot&Cold',23000) ");


        }
    }
}
