package edu.ktu.myfirstapplication;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ListItem implements Parcelable{
    private String title;
    private int imageId;
    private String description;

    public ListItem(){

    }
    public ListItem(String title,int imageId,String description){
        this.title =title;
        this.imageId=imageId;
        this.description=description;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public int getImageId(){
        return imageId;
    }
    public void setImageId(int imageId){
        this.imageId=imageId;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public int compareTo(String t){
        return toString().compareTo(t.toString());
    }


    public int describeContents(){
        return 0;
    }
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(title);
        out.writeInt(imageId);
        out.writeString(description);
    }
    public ListItem(Parcel in){
        title = in.readString();
        imageId = in.readInt();
        description = in.readString();
    }
    public static final Parcelable.Creator<ListItem> CREATOR
            = new Parcelable.Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };
}
