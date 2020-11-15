package com.lxqljc.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.lxqljc.roomdemo.adapter.StudentAdapter;
import com.lxqljc.roomdemo.model.Student;
import com.lxqljc.roomdemo.task.AddStudentTask;
import com.lxqljc.roomdemo.task.QueryStudentTask;

public class MainActivity extends AppCompatActivity {

    private Button mBtnAdd;
    private RecyclerView mRecyclerView;
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAdd = findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setIcon(android.R.drawable.sym_def_app_icon);
            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            EditText et1 = new EditText(MainActivity.this);
            et1.setHint("请输入姓名");
            EditText et2 = new EditText(MainActivity.this);
            et2.setHint("请输入年龄");
            linearLayout.addView(et1);
            linearLayout.addView(et2);
            builder.setView(linearLayout);
            builder.setNegativeButton("取消", null);
            builder.setPositiveButton("确定", (dialogInterface, i) -> {
                String name = et1.getText().toString();
                String age = et2.getText().toString();
                //添加一个学生
                AddStudentTask addStudentTask = new AddStudentTask(MainActivity.this);
                Student student = new Student(name, Integer.parseInt(age));
                addStudentTask.execute(student);
                //查询更新列表
                QueryStudentTask queryTask = new QueryStudentTask(MainActivity.this, mAdapter);
                queryTask.execute();
            }).create().show();
        });
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new StudentAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        //查询数据
        QueryStudentTask queryTask = new QueryStudentTask(this, mAdapter);
        queryTask.execute();
    }
}