package com.example.myrealm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/*
* orm 방식
* - SQL Query 를 몰라도 작성이 가능하다. (ORM : Object Relational Mapping)
* - DBMS 에 대한 종속성을 줄일 수 있다.
* - 성능이 뛰어나다
* - 라이브러리 크기 때문에 앱 용량이 2 ~ 3 MB 증가할 수 있다.
* */
public class MainActivity extends AppCompatActivity {

    Button btnSave;
    Button btnLoad;
    Button btnDelete;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        // 설정 파일 처리
        RealmConfiguration configuration = new RealmConfiguration
                .Builder()
                .name("schooldb")
                .allowQueriesOnUiThread(true)   // UI Thread(main) 에서도 realm 에 접근할 수 있도록 한다.
                .allowWritesOnUiThread(true)    //
                .deleteRealmIfMigrationNeeded() // 데이터를 전부 지워 버리겠다.
                .build();

        // 마이그레이션이 필요한 경우 지워 버리겠다. (마이그레이션 : 동기화 시켜 주겠다)
        // 이름       학번      학교

        // 홍길동1     1       부산대
        // 홍길동2     2       부산대

        // 필드가 새로 생겼을 때 기존에 있던 데이터베이스와 새로 생긴 데이터 베이스를 합쳐줘야한다.
        // 이렇게 합치는 것을 마이그레이션이라 한다.

        Realm.setDefaultConfiguration(configuration);

        // Realm 객체를 얻는 방법
        realm = Realm.getDefaultInstance();

        initData();
        addEventListener();
    }

    private void initData(){
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
    }

    private void addEventListener(){
        btnSave.setOnClickListener(view -> {
            realm.executeTransaction(transactionRealm -> {
                // A 테이블에서 데이터를 가져온다 --> 10, ( 9 ) 동기화처리
                // B 테이블에서 데이터를 가져온다
                // C 테이블에서 데이터를 가져온다
                // 조합을 한다.
                // D 테이블에 저장을 한다.

                School school = new School("부산대학교");
                school.setLocation("부산시금정구");
                transactionRealm.insert(school);
            });
        });
        btnLoad.setOnClickListener(view -> {

            realm.executeTransaction(realm1 -> {
                School school = realm1.where(School.class).findFirst();
                if(school != null) {
                    Log.d("TAG", school.toString());
                } else{
                    Log.d("TAG", "null 입니다.");
                }
            });

        });
        btnDelete.setOnClickListener(view -> {

            realm.executeTransaction(realm1 -> {
                // 전체 row 를 찾고 전체 삭제 처리
                realm1.where(School.class).findAll().deleteAllFromRealm();
            });

        });
    }
}