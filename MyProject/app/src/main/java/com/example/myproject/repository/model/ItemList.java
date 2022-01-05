package com.example.myproject.repository.model;


import java.util.ArrayList;

public class ItemList {

    private static final long serialVersionUID = 1L;

    private  String thumbnail;
    private  String title;
    private  String subTitle;
    private  String detail;
    private  int item_num;

    public ItemList(String thumbnail, String title, String subTitle, String detail, int item_num) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.detail = detail;
        this.item_num = item_num;
    }

    public String getThumbnail() { return thumbnail; }

    public String getTitle() { return title; }

    public String getSubTitle() { return subTitle; }

    public String getDetail() { return detail; }

    public int getItem_num() { return item_num; }

    // https://cdn.pixabay.com/photo/2016/03/27/07/12/apple-1282241__340.jpg - 노트북
    // https://cdn.pixabay.com/photo/2010/12/13/10/05/berries-2277__340.jpg - 베리
    // https://cdn.pixabay.com/photo/2021/09/20/16/47/pumpkins-6641314__340.jpg - 호박
    // https://cdn.pixabay.com/photo/2017/01/09/02/02/pink-wine-1964457__340.jpg - 와인
    // https://cdn.pixabay.com/photo/2017/01/21/21/15/beer-1998293__340.jpg - 맥주
    // https://cdn.pixabay.com/photo/2016/01/05/09/48/pork-1122171__340.jpg - 삼겹살
    // https://cdn.pixabay.com/photo/2020/05/15/08/28/switch-5172817__340.png - 닌텐도
    // https://cdn.pixabay.com/photo/2020/05/14/02/07/office-5169618__480.jpg - 프린터
    // https://cdn.pixabay.com/photo/2015/03/04/14/14/iphone-658840__340.jpg - 아이폰
    // https://cdn.pixabay.com/photo/2014/07/09/23/19/headphones-388674__340.jpg - 헤드셋


    public static ArrayList<ItemList> getSampleData(){
        ArrayList<ItemList> list = new ArrayList<>();
        list.add(new ItemList("https://cdn.pixabay.com/photo/2016/03/27/07/12/apple-1282241__340.jpg", "노트북", "가격1", "Detail1", 2));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2016/03/27/07/12/apple-1282241__340.jpg", "노트북", "가격1", "Detail1", 2));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2010/12/13/10/05/berries-2277__340.jpg", "베리", "가격2", "Detail2", 1));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2021/09/20/16/47/pumpkins-6641314__340.jpg", "호박", "가격3", "Detail3", 1));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2017/01/09/02/02/pink-wine-1964457__340.jpg", "와인", "가격4", "Detail4", 1));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2017/01/21/21/15/beer-1998293__340.jpg", "맥주", "가격5", "Detail5", 1));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2016/01/05/09/48/pork-1122171__340.jpg", "삼겹살", "가격6", "Detail6", 1));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2020/05/15/08/28/switch-5172817__340.png", "닌텐도", "가격7", "Detail7", 2));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2020/05/14/02/07/office-5169618__480.jpg", "프린터", "가격8", "Detail8", 2));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2015/03/04/14/14/iphone-658840__340.jpg", "아이폰", "가격9", "Detail9", 2));
        list.add(new ItemList("https://cdn.pixabay.com/photo/2014/07/09/23/19/headphones-388674__340.jpg", "헤드셋", "가격10", "Detail10", 2));

        return list;
    }


}

