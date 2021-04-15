package com.example.exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class viewdata extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener  {

    SearchView searchView;
    private ListView list;
    private ListViewAdapter adapter;
    String[] listnama;
    public static ArrayList<com.example.exercise1.ClassNama> classNamaArrayList = new ArrayList<com.example.exercise1.ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;
    String Kontak;

    ArrayAdapter<String > arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView = findViewById(R.id.search_bar);
        listnama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul",
                "Intan", "Vina", "Gita", "Vian", "Lutfi" };
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listnama);
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listnama.length; i++) {
            com.example.exercise1.ClassNama classNama = new com.example.exercise1.ClassNama(listnama[i]);
            classNamaArrayList.add(classNama);
            adapter = new ListViewAdapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Kontak = classNamaArrayList.get(position).getNama();
                    bundle.putString("a", Kontak.trim());
                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                    pm.setOnMenuItemClickListener(viewdata.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();

                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    viewdata.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    viewdata.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });

        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),data_activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor_kontak = Kontak.trim();
                String Nomor = "";
                if (nomor_kontak == "Inayah"){
                    Nomor = "08121122334";
                }
                else if (nomor_kontak == "Ilham"){
                    Nomor = "08122345234";
                }
                else if (nomor_kontak == "Eris"){
                    Nomor = "08128123941";
                }
                else if (nomor_kontak == "Fikri"){
                    Nomor = "08128122819";
                }
                else if (nomor_kontak == "Maul"){
                    Nomor = "08122777642";
                }
                else if (nomor_kontak == "Intan"){
                    Nomor = "08122224321";
                }
                else if (nomor_kontak == "Vina"){
                    Nomor = "08122559685";
                }
                else if (nomor_kontak == "Gita"){
                    Nomor = "08199221204";
                }
                else if (nomor_kontak == "Lutfi"){
                    Nomor = "08128887345";
                }
                else if (nomor_kontak == "Vian"){
                    Nomor = "08144425678";
                }

                Toast.makeText(getApplicationContext(),Nomor, Toast.LENGTH_LONG).show();
                break;

        }
        return false;

    }

}