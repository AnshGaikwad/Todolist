package com.example.todolist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist.sqlitepackage.MyDbHandler;

public class DeleteFragment extends Fragment {

    // variables
    EditText idText;
    Button delBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_delete, container, false);

        // Creating MyDbHandler object
        final MyDbHandler db = new MyDbHandler(getActivity());

        //Initializing
        idText = rootview.findViewById(R.id.id___text);
        delBtn = rootview.findViewById(R.id.delete__btn);

        // Setting on click listener on delete btn
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Retrieving id from edit text
                final String id = idText.getText().toString();

                // deleting the task from database
                db.deleteTaskById(Integer.parseInt(id));

                // toast message
                Toast.makeText(getActivity(), "DELETED!!!", Toast.LENGTH_SHORT).show();
            }
        });


        return rootview;
    }
}