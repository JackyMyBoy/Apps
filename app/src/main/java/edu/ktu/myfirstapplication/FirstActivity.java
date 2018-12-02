package edu.ktu.myfirstapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class FirstActivity extends AppCompatActivity{

    private EditText myTitle;
    private EditText myDescription;
    private ListView mylist;

    private Button addButton;
    private TextView mytextField;
    private Button secondActivityButton;
    private Context context = this;
    ArrayList<ListItem> items = new ArrayList<>();
    private boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstactivitydesign);

        addButton = (Button) findViewById(R.id.firstActivityAddButton);
        secondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        mytextField = (TextView) findViewById(R.id.textfield);

        addButton.setOnClickListener(addButtonClick);
        secondActivityButton.setOnClickListener(startSecondActivity);
        secondActivityButton.setOnLongClickListener(startSecondActivityLong);
    }

    View.OnClickListener addButtonClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            myTitle = (EditText) findViewById(R.id.title_input);
            myDescription = (EditText) findViewById(R.id.text_input);
            items.add(new ListItem(myTitle.getText().toString(),R.drawable.ic_3d_rotation_black_24dp,myDescription.getText().toString()));
        }
    };

    public void runSecondActivity(boolean b){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("flag",b);
        context.startActivity(intent);
    }
    public void runSecondActivity2(ArrayList<ListItem> a){
        Intent intent = new Intent(context, SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("extra", a);
        intent.putExtra("extra",a);
        context.startActivity(intent);
    }

    View.OnClickListener startSecondActivity = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(clicked == false)
            {
            items.add(new ListItem("Whack",R.drawable.ic_battery_alert_black_24dp,"Empty, Battery"));
            items.add(new ListItem("Shmack",R.drawable.ic_battery_charging_20_black_24dp,"Charging, Battery"));
            items.add(new ListItem("Waba",R.drawable.ic_battery_charging_full_black_24dp,"Full, Battery"));
            clicked = true;
            }
            runSecondActivity(true);
            runSecondActivity2(items);
        }
    };

    View.OnLongClickListener startSecondActivityLong = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v){
            runSecondActivity(false);
            return true;
        }
    };

    public void sendMessage(View view){
        Intent startNewActivity = new Intent(this,ThirdActivity.class);
        startActivity(startNewActivity);
    }
}
