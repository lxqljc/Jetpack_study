package com.lxqljc.roomdemo.task;

import android.content.Context;
import android.os.AsyncTask;

import com.lxqljc.roomdemo.adapter.StudentAdapter;
import com.lxqljc.roomdemo.database.MyDatabase;
import com.lxqljc.roomdemo.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/15
 * description: 描述
 */
public class QueryStudentTask extends AsyncTask<Void, Void, Void> {

    private List<Student> studentList = new ArrayList<>();

    private StudentAdapter adapter;

    private Context context;

    public QueryStudentTask(Context context, StudentAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        studentList.clear();
        studentList.addAll(MyDatabase.getInstance(context).studentDao().getStudentList());
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        adapter.addAll(studentList);
    }
}
