package android.example.hw_recyclerview.activities;

import android.example.hw_recyclerview.R;
import android.example.hw_recyclerview.adapter.AdapterGrid;
import android.example.hw_recyclerview.adapter.AdapterUser;
import android.example.hw_recyclerview.model.user;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_change_view, btn_read_data;
    ArrayList<user> mlist;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    AdapterUser adapterUser;
    AdapterGrid adapterGrid;
    int i=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlist = new ArrayList<>();
        init();
    }

    private void init() {
        btn_change_view = findViewById(R.id.changed_view_button);
        btn_read_data = findViewById(R.id.read_data_button);
        recyclerView = findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        adapterGrid = new AdapterGrid(this, mlist);
        adapterUser = new AdapterUser(this, mlist);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterUser);
        adapterUser.notifyDataSetChanged();

    }

    private void generatedata() {
        user u;

        u = new user(R.drawable.ic_android_black_24dp, "Android", "This is Android");
        mlist.add(u);

        u = new user(R.drawable.ic_art_track_black_24dp, "Image", "This is Image");
        mlist.add(u);

        u = new user(R.drawable.ic_assistant_photo_black_24dp, "Flag", "This is Flag");
        mlist.add(u);
    }

    public void handler(View view) {
        switch (view.getId()) {
            case R.id.changed_view_button:
                if(i==1) click_toggle();
                else  click_toggle_back();
                break;
            case R.id.read_data_button:
                generatedata();
                adapterGrid.notifyDataSetChanged();
                adapterUser.notifyDataSetChanged();
                break;
        }
    }

    private void click_toggle() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterGrid);
        i=2;

    }

    private void click_toggle_back() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this );

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterUser);
        i=1;
    }
}
