package com.lxqljc.roomdemo.task;

import android.content.Context;
import android.os.AsyncTask;

import com.lxqljc.roomdemo.adapter.StudentAdapter;
import com.lxqljc.roomdemo.database.MyDatabase;
import com.lxqljc.roomdemo.model.Student;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/15
 * description: 描述
 */
public class AddStudentTask extends AsyncTask<Student, Void, Void> {

    private Context context;


    public AddStudentTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Student... students) {
        MyDatabase.getInstance(context).studentDao().insertStudent(students[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
