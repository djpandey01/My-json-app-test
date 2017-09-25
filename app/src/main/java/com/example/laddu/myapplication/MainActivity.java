package com.example.laddu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.PostResponseAsyncTask;
import com.kosalgeek.asynctask.AsyncResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncResponse{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView1);

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, this);
        task.execute("https://api.myjson.com/bins/d8l81");

    }

    @Override
    public void processFinish(String result) {

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

       ArrayList<Post> postList =
                new JsonConverter<Post>().toArrayList(result, Post.class);

        ArrayList<String> titles =
                new ArrayList<String>();
        for(Post value: postList) {
            titles.add(value.city);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        titles);

        listView.setAdapter(adapter);
    }
}