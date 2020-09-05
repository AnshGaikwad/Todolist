package com.example.todolist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.todolist.sqlitepackage.MyDbHandler;
import com.example.todolist.sqlitepackage.Task;

import java.util.ArrayList;
import java.util.List;

public class ReadFragment extends Fragment {

    // listview variable
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_read, container, false);

        // Creating MyDbHandler object
        MyDbHandler db = new MyDbHandler(getActivity());

        // Creating ArrayList object of type String
        ArrayList<String> tasks = new ArrayList<>();

        // initializing
        listView = rootview.findViewById(R.id.list_view);

        // Calling getAllTasks() function from class MyDbHandler
        List<Task> allTasks = db.getAllTasks();

        // Adding allTasks to tasks which is our arraylist
        for(Task task: allTasks){
            tasks.add("Task Id: " + task.getId() + "\n" + "Task Name: " + task.getName() + "\n" + "Task Description: " + task.getDescription());
        }

        // initializing arrayadapter for our listview
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.my_simple_layout, tasks); // using my own custom layout here to adjust text size

        // setting arrayadapter to our listview
        listView.setAdapter(arrayAdapter);

        return rootview;
    }
}