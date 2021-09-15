package com.clearsky77.kotlinnativefn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      1. 전화 걸기(DIAL) Intent 활용
        dialBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString() //전화 번호를 받아
            val myUri = Uri.parse("tel:${inputPhoneNum}") //전화 걸 정보(Uri)로 가공. android.net.Uri사용
            // 전화 화면으로 이동 + Uri 조합 -> intent
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

//      2. 전화 걸기(CALL)
        callBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

//      3. 문자 전송(SANDTO)
        smsBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "내용") //미리 보내줄 내용 적어두기
            startActivity(myIntent)
        }

//      4. 인터넷 창 띄우기(VIEW)
        naverLinkBtn.setOnClickListener {
            val myUri = Uri.parse("https://naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

//      5. 플레이 스토어 연결(VIEW)
        cacaoStoreLinkBtn.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.kakao.talk&hl=ko")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }
    }
}