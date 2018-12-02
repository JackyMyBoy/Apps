package edu.ktu.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SecondActivity extends AppCompatActivity{
    private ListView mylist;
    private ListAdapter adapter;
    private Button sortBtn;

    private boolean ascending = true;

    ArrayList<ListItem> items = new ArrayList<>();

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivitydesign);
        mylist = (ListView) findViewById(R.id.listView);



        Intent intent = getIntent();
        if(intent.getBooleanExtra("flag",true)){
            items.add(new ListItem("Jack",R.drawable.ic_3d_rotation_black_24dp,"Mathematics, Chemistry"));
            items.add(new ListItem("Jane",R.drawable.ic_feedback_black_24dp,"Physics, Informatics"));
            items.add(new ListItem("Bob",R.drawable.ic_access_alarm_black_24dp,"Mathematics, Informatics"));
            items.add(new ListItem("Clara",R.drawable.ic_account_box_black_24dp,"Geography, Chemistry"));
            items.add(new ListItem("Sam",R.drawable.ic_accessibility_black_24dp,"Mathematics, Physics"));
        }else{
            items.add(new ListItem("Mathematics",R.drawable.ic_3d_rotation_black_24dp,"Mathematics is the study of topics such as quantity, structure, space and change"));
            items.add(new ListItem("Physics",R.drawable.ic_feedback_black_24dp,"Physics is the natural science that involves the study of matter and its motion through space and time along with related concepts such as energy and force"));
            items.add(new ListItem("Chemistry",R.drawable.ic_access_alarm_black_24dp,"Chemistry is a branch of physical science that studies the composition, structure, properties and change of matter"));
            items.add(new ListItem("Informatics",R.drawable.ic_account_box_black_24dp,"Informatics is the science of information and computer information systems"));
            items.add(new ListItem("Geography",R.drawable.ic_accessibility_black_24dp,"Geography is a field of science devoted to the study of the lands, the features, the inhabitants and the phenomena of Earth"));
        }
        adapter = new ListAdapter(this, items);
        mylist.setAdapter(adapter);
        this.initializeViews();

        Bundle bundle = getIntent().getExtras();
        ArrayList<ListItem> items2 = new ArrayList<>();
        items2 = bundle.getParcelableArrayList("extra");
        if(items2 != null)
        {
            for (int i = 0; i < items2.size(); i++) {
                items.add(items2.get(i));
            }
        }



    }
    private void initializeViews()
    {
        mylist = (ListView) findViewById(R.id.listView);
        sortBtn = (Button) findViewById(R.id.sortBtn);

        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortData(ascending);
                ascending = !ascending;
            }
        });
    }
    private void sortData(boolean asc)
    {
        if(asc) {
            items.sort(new Comparator<ListItem>() {
                @Override
                public int compare(ListItem o1, ListItem o2) {
                    if(o1.getTitle().compareTo(o2.getTitle().toString())>=1){
                        return 1;
                    }
                    else if(o1.getTitle().compareTo(o2.getTitle().toString())>=0 ){
                        return 0;
                    }
                    else return -1;
                }
            });
        }
        else
        {
            Collections.reverse(items);
        }

        adapter = new ListAdapter(this, items);
        mylist.setAdapter(adapter);
    }


}
