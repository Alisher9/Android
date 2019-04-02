package com.example.empty.myapplication;

import android.annotation.SuppressLint;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Contact> contacts;
   static Custom_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv = findViewById(R.id.listView);
        addContact();

        adapter = new Custom_adapter(this, contacts);
        lv.setAdapter(adapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_menu:

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final View view = getLayoutInflater().inflate(R.layout.add_dialog, null);
                final EditText mName = (EditText)view.findViewById(R.id.etName);
                final EditText mPhone = (EditText)view.findViewById(R.id.etPhone);
                Button mButton = (Button)view.findViewById(R.id.buttonAdd);
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();


                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mName.getText().toString().isEmpty() && !mPhone.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this, "Contact was added", Toast.LENGTH_SHORT).show();
                            addcon(mName.getText().toString(),mPhone.getText().toString());

                            dialog.hide();


                        }
                        else{
                            Toast.makeText(MainActivity.this, "Please fill everything", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                return true;
            case R.id.settings:
                Toast.makeText(getApplicationContext(),
                        "Settings menu", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addContact(){
        contacts = new ArrayList<>();
        contacts.add(new Contact("Bob",
                "87475418588", R.drawable.mike));
        contacts.add(new Contact("Drake",
                "87078955985", R.drawable.user));
        contacts.add(new Contact("Josh",
                "87071237895", R.drawable.user));
        contacts.add(new Contact("Camilia",
                "87771234567", R.drawable.user));
        contacts.add(new Contact("Amanda",
                "87789876543", R.drawable.user));
        Collections.sort(contacts, Contact.StuNameComparator);
    }

    public void addcon(String name, String number){


        contacts.add(new Contact(name,
                number, R.drawable.user));

        adapter.notifyDataSetChanged();
        lv.setAdapter(adapter);
        Collections.sort(contacts, Contact.StuNameComparator);


    }
}
