package com.example.myrecyclerview.models;

import java.util.ArrayList;

public class Food {

    private final String thumbnail;
    private final String title;
    private final String subTitle;
    private final String detail;

    public Food(String thumbnail, String title, String subTitle, String detail) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getDetail() {
        return detail;
    }

    // sample Data
    public static ArrayList<Food> getSampleData(){
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food1", "SubTitle1", "Detail1"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/03/23/15/00/ice-cream-1274894__340.jpg", "Food2", "SubTitle2", "Detail2"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/01/26/02/06/platter-2009590__340.jpg", "Food3", "SubTitle3", "Detail3"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/05/07/08/56/pancakes-2291908__340.jpg", "Food4", "SubTitle4", "Detail4"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/08/30/17/12/waffle-hearts-2697904__340.jpg", "Food5", "SubTitle5", "Detail5"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2016/03/23/15/00/ice-cream-1274894__340.jpg", "Food6", "SubTitle6", "Detail6"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/05/07/08/56/pancakes-2291908__340.jpg", "Food7", "SubTitle7", "Detail7"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/08/30/17/12/waffle-hearts-2697904__340.jpg", "Food8", "SubTitle8", "Detail8"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2017/01/26/02/06/platter-2009590__340.jpg", "Food9", "SubTitle9", "Detail9"));
        foods.add(new Food("https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__340.jpg", "Food10", "SubTitle10", "Detail10"));

        return foods;
    }
}
