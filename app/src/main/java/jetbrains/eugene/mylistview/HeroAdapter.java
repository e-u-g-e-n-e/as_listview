package jetbrains.eugene.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HeroAdapter extends BaseAdapter {
    /**
     * Kelas HeroAdapter merupakan pelebaran dari kelas BaseAdpter
     * Harus di-Override
     * Menambahkan 2 data yakni context(Context) dan heroes(ArrayList<Hero>)
     * Membuat Constructor dari Context dan menambah setter heroes di dalamnya
     * Membuat Setter dengan heroes
     * Buat class baru ViewHolder dalam kelas ini yang bertanggungjawab pada setiap item*/

    private Context context;
    private ArrayList<Hero> heroes;

    public HeroAdapter(Context context) {
        this.context = context;
        heroes = new ArrayList<>();
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_hero, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view); //menangani apa isi data dan view untuk menampilkannya
        Hero hero = (Hero)getItem(position);
        viewHolder.bind(hero);
        return view;
        // kembali ke main activity
    }

    private class ViewHolder {
        /**
         * ViewHolder adalah kelas java yang memegang tiap tiap view sesuai dengan
         * Butuh 3 handle : foto, text, nama
         * Membuat Constructor dan metode bind untuk mencocokkan
         * Ubah View getView()*/
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            // mencocokkan dengan view di item hero
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Hero hero) {
            // Mau mamasukkan obj hero / data ke ui
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());
            imgPhoto.setImageResource(hero.getPhoto());
        }

    }
}
