package com.example.myrealm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

// 테이블 클래스 정의
public class School extends RealmObject {
    // @Required // name null 이 될수 없음
    @PrimaryKey
    private String name;
    private String location;

    public School() {} //반드시 생성 
    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
