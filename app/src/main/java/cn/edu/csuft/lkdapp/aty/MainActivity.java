package cn.edu.csuft.lkdapp.aty;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;

import cn.edu.csuft.lkdapp.R;

import java.util.ArrayList;
import java.util.List;

import cn.edu.csuft.lkdapp.frag.HomeFrag;
import cn.edu.csuft.lkdapp.frag.SchoolFrag;
import cn.edu.csuft.lkdapp.frag.UserFrag;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    // 主界面适配器
    FragmentPagerAdapter fPagerAdapter;
    // 所有的Tab
    private List<View> views;
    // 碎片每个碎片为一个布局
    private ArrayList<Fragment> fragments;
    // 导航式Tab
    private ViewPager vp;
    //四个radiobtn按钮id
    private int[] radiobtnid = {R.id.rbtn_main_home, R.id.rbtn_main_school,
            R.id.rbtn_main_user};
    //四个radiobtn按钮
    private RadioButton[] radiobtns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置沉浸式标题栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        // 创建碎片集合
        fragments = new ArrayList<Fragment>();
        initView();

    }

    private void initView() {
        //绑定按钮组件
        radiobtns = new RadioButton[3];
        for (int i = 0; i < 3; i++) {
            final int j = i;
            radiobtns[i] = (RadioButton) findViewById(radiobtnid[i]);
            radiobtns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeTagView(j);
                }
            });
        }


        LayoutInflater inflater = LayoutInflater.from(this);
        // 添加滑动
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.main_home_frag, null));
        views.add(inflater.inflate(R.layout.main_school_frag, null));
        views.add(inflater.inflate(R.layout.main_user_frag, null));
        vp = (ViewPager) findViewById(R.id.main_viewPager);
        fPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragments.get(arg0);
            }
        };
        // 声明各个Tab的实例
        HomeFrag homeFrag = new HomeFrag();
        SchoolFrag schoolFrag = new SchoolFrag();
        UserFrag userFrag = new UserFrag();
        fragments.add(homeFrag);
        fragments.add(schoolFrag);
        fragments.add(userFrag);
        vp.setAdapter(fPagerAdapter);
        vp.setOnPageChangeListener(this);
        //注意，设置Page 即缓存页面的个数，数过小时会出现fragment重复加载的问题
        vp.setOffscreenPageLimit(4);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 自定义按钮选择的方法
     * @param position
     */
    private void pageCheck(int position) {
        radiobtns[position].setChecked(true);
        for(int i = 0;i<3;i++) {
            if (i!=position) {
                radiobtns[i].setChecked(false);
            }
        }
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                pageCheck(position);
                break;
            case 1:
                pageCheck(position);
                break;
            case 2:
                pageCheck(position);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    // 更换标签
    private void changeTagView(int change) {
        vp.setCurrentItem(change, false);
    }
}
