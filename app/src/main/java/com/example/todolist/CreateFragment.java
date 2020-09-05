package com.example.todolist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist.sqlitepackage.MyDbHandler;
import com.example.todolist.sqlitepackage.Task;

public class CreateFragment extends Fragment {

    // variables
    EditText taskName;
    EditText taskDescription;
    Button createBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_create, container, false);

        // Creating MyDbHandler object
        final MyDbHandler db = new MyDbHandler(getActivity());

        //Initializing
        taskName = rootview.findViewById(R.id.taskname_text);
        taskDescription = rootview.findViewById(R.id.description_text);
        createBtn = rootview.findViewById(R.id.create__btn);

        // Setting on click listener on create btn
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Retrieving text from edit texts
                final String name = taskName.getText().toString();
                final String description = taskDescription.getText().toString();

                //Creating and initializing a new task object
                Task task = new Task();
                task.setName(name);
                task.setDescription(description);

                // Adding task to database
                db.addTask(task);

                // Toast message
                Toast.makeText(getActivity(), "CREATED!!!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootview;
    }
}