package com.lxqljc.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.lxqljc.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Book book = new Book();
        book.bookName = "狂人日记";
        book.bookPrice = "￥23";
        binding.setBook(book);
        binding.btnNewBook.setOnClickListener(view -> {
            book.bookName = "基督上伯爵";
            book.bookPrice = "￥29";
            binding.setBook(book);
        });
    }
}