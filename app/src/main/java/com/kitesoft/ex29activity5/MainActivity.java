package com.kitesoft.ex29activity5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //안드로이드 운영체제가 설치된 디바이스에 기본적으로 설치되어 있는 시스템앱들을 실행시켜보기
    //ex) 전화걸기앱, 다이얼앱, 문자앱, 웹브라우저앱, 사진보기앱 등등..... 은 기본적적으로 약속된 Intent 액션값을 가지고 있으므로
    // 묵시적 인텐트로 실행할 수 있음.

    public void clickDial(View v){
        //  전화거는 다이얼화면앱 실행하기
        Intent intent= new Intent();
        intent.setAction(Intent.ACTION_DIAL); //다이얼앱의 약속된 액션 문자열 값

        //다이얼화면에 미리 전화번호가 입력되어 있기를 원하다면 setData()설정 [ tel: ]
        Uri uri= Uri.parse("tel:01012345678");
        intent.setData(uri);

        startActivity(intent);
    }


    public void clickSMS(View v){
        //  짧은문자 SMS앱 실행하기
        Intent intent= new Intent();
        intent.setAction(Intent.ACTION_SENDTO); // SMS앱의 약속된 액션 문자열 값
        intent.setData( Uri.parse("smsto:01012345678,01045678945") ); //SMS를 받을 전화번호지정 [ smsto: ]  - 여러개 지정 가능
        intent.putExtra("sms_body", "Hello..nice to meet you"); //추가적으로, 보낼 문자의 내용을 프로그램으로 미리 작성할 수 있음. "sms_body"라는 정해진 키값 사용
        startActivity(intent);
    }

    public void clickWeb(View v){

        // 웹페이지를 보여주는 웹브라우저앱 실행
        // 약속된 액션 문자열 값과 웹페이지주소URL Data를 Intent객체를 생성하면서 설정할 수 있음. 코드가 더 간결하여 선호됨
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
        startActivity(intent);

    }

    public void clickGallery(View v){

        //사진선택앱 실행
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*"); //반드시 MIME타입을 지정해야 하면 *는 확장자(.jpg, .png, .gif)를 구분하지 않는 다는 것임. 참고로 "audio/*", "video/*"로 지정하면 해당 미디어를 선택하는 앱이 실행됨
        startActivity(intent);

    }

    public void clickCamera(View v){

        //카메라 앱 실행
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //약속된 액션문자열값이 Intent클래스가 아니라 MediaStore클래스임을 주의!!!
        startActivity(intent);

    }
}
