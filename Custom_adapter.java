package com.example.empty.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class Custom_adapter extends ArrayAdapter<Contact> {
    ArrayList<Contact> contacts;
    public Custom_adapter(@NonNull Context context,
                          ArrayList<Contact> c) {
        super(context, R.layout.list_item);
        contacts = c;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View custom_view = inflater.inflate(R.layout.list_item, parent, false);
        ImageView iv = custom_view.findViewById(R.id.imageView);
        TextView name_tv = custom_view.findViewById(R.id.textView);
        final TextView phone_tv = custom_view.findViewById(R.id.textView2);
        iv.setImageResource(contacts.get(position).getImage());
        name_tv.setText(contacts.get(position).getName());
        phone_tv.setText(contacts.get(position).getPhone_number());






        custom_view.setOnTouchListener( new OnSwipeTouchListener(getContext()){

            public void onSwipeRight() {
                Toast.makeText(getContext(), "right", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone_tv.getText().toString()));
                getContext().startActivity(intent);

            }
            public void onSwipeLeft() {
                Toast.makeText(getContext(), "left", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+phone_tv.getText().toString()));
                getContext().startActivity(intent);
            }

            @Override
            public void onLongClick() {
                Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
                contacts.remove(position);
                MainActivity.adapter.notifyDataSetChanged();
                super.onLongClick();
            }
        });

        return custom_view;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }
}
