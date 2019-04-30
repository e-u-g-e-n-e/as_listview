package jetbrains.eugene.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FullProfile extends AppCompatActivity {
    TextView hero_name;
    TextView hero_description;
    ImageView hero_img;
    public static String SELECTED_HERO = "selected_hero";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_profile);

        hero_name = findViewById(R.id.txt_name_v2);
        hero_description = findViewById(R.id.txt_description_v2);
        hero_img = findViewById(R.id.img_photo_v2);

        Hero hero = getIntent().getParcelableExtra(SELECTED_HERO);

        hero_name.setText(hero.getName());
        hero_description.setText(hero.getDescription());
        hero_img.setImageResource(hero.getPhoto());
    }
}
