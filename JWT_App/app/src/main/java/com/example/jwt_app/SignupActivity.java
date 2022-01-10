package com.example.jwt_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jwt_app.databinding.ActivitySignupBinding;
import com.example.jwt_app.repository.JwtService;
import com.example.jwt_app.repository.models.request.ReqSignUp;
import com.example.jwt_app.repository.models.response.ResSignUp;
import com.example.jwt_app.utils.KeyboardUtil;
import com.google.android.material.snackbar.Snackbar;

import java.security.Key;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    static final String TAG = SignupActivity.class.getName();

    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_signup);

//        EditText userIdEt = findViewById(R.id.SignUpUserIdEt);
//        EditText userEmailEt = findViewById(R.id.SignUpUserEmailEt);
//        EditText passwordEt = findViewById(R.id.SignUpUserPwEt);
//        EditText rePasswordEt = findViewById(R.id.SignUpUserRePwEt);

        Button signUpBtn = findViewById(R.id.SignUpBtn);
        TextView goSignInPage = findViewById(R.id.goSignInPage);

        signUpBtn.setOnClickListener(view -> {
            // 지역변수
            String id = binding.userIdEt.getText().toString();
            String pw = binding.passwordEt.getText().toString();
            String rePw = binding.rePasswordEt.getText().toString();
            String email = binding.userEmailEt.getText().toString();

            if(id.length() > 3 && pw.length() > 3 && email.length() > 3){
                KeyboardUtil.hideKeyboard(view.getContext(), view);
                if(!KeyboardUtil.isValidEmail(email)){
                    Snackbar.make(view, "이메일 형식이 아닙니다.", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(pw.equals(rePw)){
                    // todo
                    // 여기서 회원가입 요청하기
                    JwtService jwtService = JwtService.retrofit.create(JwtService.class);
                    ReqSignUp reqSignUp = new ReqSignUp(id, pw, email);
                    jwtService.saveMember(reqSignUp).enqueue(new Callback<ResSignUp>() {
                        @Override
                        public void onResponse(Call<ResSignUp> call, Response<ResSignUp> response) {
                            ResSignUp resSignUp = response.body();
                            Snackbar.make(view, resSignUp.getMsg(), Snackbar.LENGTH_SHORT).show();
                            // 콜백메서드 만들어서 msg 전달
                            finish();
                        }

                        @Override
                        public void onFailure(Call<ResSignUp> call, Throwable t) {
                            Snackbar.make(view, "회원가입 실패", Snackbar.LENGTH_SHORT).show();
                        }
                    });
                } else{
                    Snackbar.make(view, "비밀번호가 다릅니다.", Snackbar.LENGTH_SHORT).show();
                }

            } else{
                Snackbar.make(view, "잘못된 입력입니다.", Snackbar.LENGTH_SHORT).show();
            }

        });

        goSignInPage.setOnClickListener(view -> {
            finish();
        });
        
    }
}