package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.todolist.adapter.RecyclerViewAdapter;
import com.example.todolist.sqlitepackage.MyDbHandler;
import com.example.todolist.sqlitepackage.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SqliteDemo extends AppCompatActivity{

   private RecyclerView recyclerView;
   private RecyclerViewAdapter recyclerViewAdapter;
   private ArrayList<Task> taskArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);

        final MyDbHandler db = new MyDbHandler(SqliteDemo.this);

        //Recyclerview initialization
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initRecyclerView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SqliteDemo.this);
                View mView = getLayoutInflater().inflate(R.layout.cudialog, null);
                final EditText task_name = mView.findViewById(R.id.d_task);
                final EditText task_description = mView.findViewById(R.id.d_description);
                builder.setView(mView);
                builder.setCancelable(false);
                builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String name = task_name.getText().toString();
                        String description = task_description.getText().toString();

                        Task task = new Task();
                        task.setName(name);
                        task.setDescription(description);
                        db.addTask(task);
                        initRecyclerView();
                    }
                });
                builder.setNegativeButton("Discard", null);
                builder.show();
            }
        });
    }

    private void initRecyclerView() {

        MyDbHandler db = new MyDbHandler(SqliteDemo.this);

        taskArrayList = new ArrayList<>();

        final List<Task> taskList = db.getAllTasks();
        for(Task task: taskList){
            taskArrayList.add(task);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(SqliteDemo.this, taskArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

    }


}
