package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class SqliteDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);
    }

    // A function which will work as our fragment manager
    public void ChangeFragment(View view){

        //variable
        Fragment fragment;

        // Firstly, checking which button is been pressed and
        // then apply the logic of a simple fragment manager

        if(view == findViewById(R.id.create_btn)){
            // Creating a CreateFragment object
            fragment = new CreateFragment();
            // initializing fragmentmanager
            FragmentManager fragmentManager = getSupportFragmentManager();
            //Starting fragment transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // Replacing fragment layout
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            // Commiting
            fragmentTransaction.commit();
        }

        if(view == findViewById(R.id.read_btn)){
            // Creating a ReadFragment object
            fragment = new ReadFragment();
            // initializing fragmentmanager
            FragmentManager fragmentManager = getSupportFragmentManager();
            //Starting fragment transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // Replacing fragment layout
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            // Commiting
            fragmentTransaction.commit();
        }

        if(view == findViewById(R.id.update_btn)){
            // Creating a UpdateFragment object
            fragment = new UpdateFragment();
            // initializing fragmentmanager
            FragmentManager fragmentManager = getSupportFragmentManager();
            //Starting fragment transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // Replacing fragment layout
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            // Commiting
            fragmentTransaction.commit();
        }

        if(view == findViewById(R.id.delete_btn)){
            // Creating a DeleteFragment object
            fragment = new DeleteFragment();
            // initializing fragmentmanager
            FragmentManager fragmentManager = getSupportFragmentManager();
            //Starting fragment transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // Replacing fragment layout
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            // Commiting
            fragmentTransaction.commit();
        }

    }
}