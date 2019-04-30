package jetbrains.eugene.mylistview;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /** Tambahkan array string
     * ambil referensi listView dari layout
     * buat arrayAdapter dengan data dari array string
     * Sambungkan array
     * Buat array adapter
     * Sambungkan*/

    /* Standard data 1
    private String[] dataName = {"Cut Nyak Dien",
            "Ki Hajar Dewantara",
            "R. A. Kartini"};*/
    /**
     * Buat method baru untuk tambahkan item baru dari heroes nama addItem
     * Buat method prepare*/
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Hero> heroes;

    private HeroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        // layout ditentukan dari bawaan adapter Standard layout 1
        ListView listView = findViewById(R.id.lv_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                dataName);
        listView.setAdapter(adapter);*/

        adapter = new HeroAdapter(this);
        prepare();
        addItem();
        adapter.setHeroes(heroes);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, heroes.get(position).getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hero hero = new Hero();
                hero.setName(heroes.get(position).getName());
                hero.setDescription(heroes.get(position).getDescription());
                hero.setPhoto(heroes.get(position).getPhoto());

                Intent newHeroIntent = new Intent(MainActivity.this, FullProfile.class);
                newHeroIntent.putExtra(FullProfile.SELECTED_HERO, hero);
                startActivity(newHeroIntent);

            }
        });

    }

    private void addItem() {
        heroes = new ArrayList<>();
        for(int i=0; i<dataName.length; i++) {
            Hero hero = new Hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            heroes.add(hero); // ditambah ke ArrayList menggunakan method add
        }
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
}
