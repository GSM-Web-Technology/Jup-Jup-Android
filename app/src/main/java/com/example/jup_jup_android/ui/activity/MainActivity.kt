package com.example.jup_jup_android.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.viewpager.widget.ViewPager
import com.example.jup_jup_android.R
import com.example.jup_jup_android.entity.singleton.ItemStatusAdapter
import com.example.jup_jup_android.entity.singleton.ItemStatusListManager
import com.example.jup_jup_android.ui.util.SetItemStatusList_PageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val NEXT_PAGE = +1
    private val PREV_PAGE = -1
    private val THIS_PAGE = 0
    var lastPage = 0
    private lateinit var textViewArrayList: ArrayList<TextView>
    private lateinit var viewPager : ViewPager

    //마지막으로 뒤로가기 버튼 누른 시간
    var backKeyPressedTime : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        SetItemStatusList_PageView(applicationContext, pageView_MainActivity, ItemStatusListManager.getDividedItemStatusList()).initViewPager()

        setTitleBarItemsOnclick()
    }

    //타이틀 바 위젯들 온클릭 등록
    private fun setTitleBarItemsOnclick() {

        imageView_SearchMode_MainActivity.setOnClickListener {
            setTitleBarSearchMode()
        }

        imageView_MyPage_MainActivity.setOnClickListener {
            startActivity(Intent(applicationContext, MyPageActivity::class.java))
        }

        imageView_BackArrow_MainActivitySearchMode.setOnClickListener {
            setTitleBarViewMode()
        }

        setSearchFuntion()

    }

    private fun setSearchFuntion() {
        editText_SearchText_MainActivitySearchMode.addTextChangedListener {
            Log.d("TestLog", "${it}")

            ItemStatusListManager.processShowList(it.toString().toLowerCase())
            ItemStatusAdapter.getViewPagerAdapter().notifyDataSetChanged()

        }
    }

    private fun setTitleBarSearchMode() {
        titleBar_ViewMode_MainActivity.visibility = View.GONE
        titleBar_SearchMode_MainActivity.visibility = View.VISIBLE
    }

    private fun setTitleBarViewMode() {
        titleBar_ViewMode_MainActivity.visibility = View.VISIBLE
        titleBar_SearchMode_MainActivity.visibility = View.GONE
        ItemStatusListManager.processShowList("")
        ItemStatusAdapter.getViewPagerAdapter().notifyDataSetChanged()

    }

    //뒤로가기 버튼 눌렀을 때
    override fun onBackPressed() {

        //1번 눌렀을 때
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            Toast.makeText(applicationContext, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
        //2초 안에 2번 눌렀을 때 종료
        else if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finishApp()
        }
    }

    private fun finishApp(){
        moveTaskToBack(true);						// 태스크를 백그라운드로 이동
        finishAndRemoveTask();						// 액티비티 종료 + 태스크 리스트에서 지우기
        android.os.Process.killProcess(android.os.Process.myPid());	// 앱 프로세스 종료
    }

}