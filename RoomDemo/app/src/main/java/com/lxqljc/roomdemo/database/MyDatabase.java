package com.lxqljc.roomdemo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lxqljc.roomdemo.dao.StudentDao;
import com.lxqljc.roomdemo.model.Student;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/15
 * description: 描述
 */
@Database(entities = {Student.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_db";

    private static MyDatabase databaseInstance;

    public static synchronized MyDatabase getInstance(Context context) {

        if (databaseInstance == null) {

            databaseInstance = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, DATABASE_NAME).build();
        }
        return databaseInstance;
    }

    public abstract StudentDao studentDao();
}
