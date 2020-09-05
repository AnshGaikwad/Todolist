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

public class UpdateFragment extends Fragment {

    // variables
    EditText idText;
    EditText taskText;
    EditText descriptionText;
    Button updateBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_update, container, false);

        // Creating MyDbHandler object
        final MyDbHandler db = new MyDbHandler(getActivity());

        // initializing
        idText = rootview.findViewById(R.id.id__text);
        taskText = rootview.findViewById(R.id.task__text);
        descriptionText = rootview.findViewById(R.id.description__text);
        updateBtn = rootview.findViewById(R.id.update__btn);

        // Setting on click listener on update btn
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Retrieving text from edit texts
                final String id = idText.getText().toString();
                final String name = taskText.getText().toString();
                final String description = descriptionText.getText().toString();

                //Creating and initializing a new task object
                Task task = new Task();
                task.setId(Integer.parseInt(id));
                task.setName(name);
                task.setDescription(description);

                // updating the above task object
                int affectedRows = db.updateTask(task);

                // affectedRows returns the number of enteries afftected,
                // it will always return 1 in this case you can check it
                // through Log.d or a Toast message

                Log.d("db", "No of affected rows are: " + affectedRows);
                Toast.makeText(getActivity(), "UPDATED!!!", Toast.LENGTH_SHORT).show();
            }
        });

        return rootview;
    }
}