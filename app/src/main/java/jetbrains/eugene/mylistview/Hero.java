package jetbrains.eugene.mylistview;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {
    /**
     * Membuat Plain Old Java Object (POJO)
     * Membuat static resource item_hero, strings, dan drawable
     * Buat adapter baru class HeroAdapter*/
    private String name;
    private String description;
    private int photo;

    public Hero() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }



    protected Hero(Parcel in) {
        name = in.readString();
        description = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(photo);
    }
}
