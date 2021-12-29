package com.example.testview.models;

import java.util.ArrayList;

public class Item {

    private final String thumbnail;
    private final String title;
    private final String subTitle;
    private final String detail;
    private final String price;

    public Item(String thumbnail, String title, String subTitle, String detail, String price) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.detail = detail;
        this.price = price;
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

    public String getPrice() {return price;}

    // 1. https://cdn.pixabay.com/photo/2016/04/15/08/04/strawberry-1330459__340.jpg 딸기
    // 2. https://cdn.pixabay.com/photo/2017/01/06/17/49/honey-1958464__340.jpg 꿀
    // 3. https://cdn.pixabay.com/photo/2015/10/02/15/59/olive-oil-968657__340.jpg 올리브오일
    // 4. https://cdn.pixabay.com/photo/2014/08/14/14/21/shish-kebab-417994__340.jpg 케밥
    // 5. https://cdn.pixabay.com/photo/2017/07/05/15/41/milk-2474993__340.jpg 우유
    // 6. https://cdn.pixabay.com/photo/2017/04/01/12/36/bread-2193537__340.jpg 빵
    // 7. https://cdn.pixabay.com/photo/2014/05/23/23/17/dessert-352475__340.jpg 컵케이크
    // 8. https://cdn.pixabay.com/photo/2016/10/22/20/34/wines-1761613__340.jpg 와인
    // 9. https://cdn.pixabay.com/photo/2016/09/10/11/42/quadrocopter-1658967__340.png 드론
    // 10. https://cdn.pixabay.com/photo/2010/12/13/10/24/cheese-2785__340.jpg 치즈
    public static ArrayList<Item> getSampleData(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("https://cdn.pixabay.com/photo/2016/04/15/08/04/strawberry-1330459__340.jpg", "딸기", "SubTitle1", "평점1", "15,000원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2017/01/06/17/49/honey-1958464__340.jpg", "꿀", "SubTitle2", "평점2", "8,000원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2015/10/02/15/59/olive-oil-968657__340.jpg", "올리브오일", "SubTitle3", "평점3", "22,000원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2014/08/14/14/21/shish-kebab-417994__340.jpg", "케밥", "SubTitle4", "평점4", "18,000원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2017/07/05/15/41/milk-2474993__340.jpg", "우유", "SubTitle5", "평점5", "12,000원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2017/04/01/12/36/bread-2193537__340.jpg", "빵", "SubTitle6", "평점6", "35,000원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2014/05/23/23/17/dessert-352475__340.jpg", "컵케이크", "SubTitle7", "평점7", "14,500원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2016/10/22/20/34/wines-1761613__340.jpg", "와인", "SubTitle8", "평점8", "95,000원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2016/09/10/11/42/quadrocopter-1658967__340.png", "드론", "SubTitle9", "평점9", "165,000원"));
        items.add(new Item("https://cdn.pixabay.com/photo/2010/12/13/10/24/cheese-2785__340.jpg", "치즈", "SubTitle10", "평점10", "55,000원"));

        return items;
    }
}
