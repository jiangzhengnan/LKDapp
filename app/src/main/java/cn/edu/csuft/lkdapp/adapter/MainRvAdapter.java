package cn.edu.csuft.lkdapp.adapter;

import android.content.Context;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import cn.edu.csuft.lkdapp.R;

import java.util.ArrayList;
import java.util.List;

import cn.edu.csuft.lkdapp.base.PictureCarouselViewHolder;
import cn.edu.csuft.lkdapp.bean.Communitybean;
import cn.edu.csuft.lkdapp.handler.ImageCarouseHandler;
import cn.edu.csuft.lkdapp.util.MainRvTypeUtil;

/**
 * Created by nangua on 2016/4/7 0007.
 */


public class MainRvAdapter extends RecyclerView.Adapter<PictureCarouselViewHolder> implements MainRvTypeUtil {

    /**
     * 类型集合，adapter对应的数据集合
     */
    private List<Integer> testDates= new ArrayList<>();
    private Context context;
    private ViewPager vp;
    public MainRvAdapter(Context context,Communitybean communitybean,  ImageCarouseHandler handler ) {
        this.context = context;
       this.handler = handler;
        //添加假数据进去
        testDates.add(0);
        testDates.add(1);
        testDates.add(2);
        testDates.add(3);
        testDates.add(4);
    }

    int i = 0;

    private ImageCarouseHandler handler;
    ArrayList<ImageView> views;
    int[] imgres = {
             R.drawable.picturecarousel0
            ,R.drawable.picturecarousel1
            ,R.drawable.picturecarousel2
            ,R.drawable.picturecarousel3
            ,R.drawable.picturecarousel4
            ,R.drawable.picturecarousel5
            ,R.drawable.picturecarousel6};
    ImageView pointimg0,pointimg1,pointimg2,pointimg3,pointimg4,pointimg5,pointimg6;
    ImageView[] pointimgs = {pointimg0,pointimg1,pointimg2,pointimg3,pointimg4,pointimg5,pointimg6};
    int[] pointimgsres = {R.id.picturecarousel_img0
            ,R.id.picturecarousel_img1
            ,R.id.picturecarousel_img2
            ,R.id.picturecarousel_img3
            ,R.id.picturecarousel_img4
            ,R.id.picturecarousel_img5
            ,R.id.picturecarousel_img6};
    @Override
    public PictureCarouselViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (i==0) {
            i++;
            View view = LayoutInflater.from(context).inflate(R.layout.main_home_picturecarousel,null);
            vp = (ViewPager) view.findViewById(R.id.main_picturecarousel_vp);
            views = new ArrayList<>();
            LayoutInflater inflater = LayoutInflater.from(context);
            for (int i = 0;i<7; i++) {
                ImageView imgv = (ImageView) inflater.inflate(R.layout.picturecarouse_item,null);
                imgv.setImageResource(imgres[i]);
                views.add(imgv);
                //初始化点点
                pointimgs[i] = (ImageView) view.findViewById(pointimgsres[i]);
            }
            vp.setAdapter(new ImageAdapter(context,views));
            return new PictureCarouselViewHolder(view,context);
        } else if(i==1){
            PictureCarouselViewHolder holder = new PictureCarouselViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.main_home_menubar, parent,
                    false),context);
            i++;
            return holder;
        } else if(i==2){
            PictureCarouselViewHolder holder = new PictureCarouselViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.main_home_others, parent,
                    false),context);
            i++;
            return holder;
        } else if (i==3) {
            PictureCarouselViewHolder holder = new PictureCarouselViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.main_home_others1, parent,
                    false),context);
            i++;
            return holder;
        } else {
            PictureCarouselViewHolder holder = new PictureCarouselViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.main_home_others2, parent,
                    false),context);
            i++;
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(PictureCarouselViewHolder holder, int position) {

        //这里传入imgs数据
      //  vp.setAdapter(new ImageAdapter(context,holder.imgs));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                showpoint(position);
                handler.sendMessage(Message.obtain(handler, ImageCarouseHandler.MSG_PAGE_CHANGED, position, 0));

            }

            //覆写该方法实现轮播效果
            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        handler.sendEmptyMessage(ImageCarouseHandler.MSG_KEEP_SILENT);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        handler.sendEmptyMessageDelayed(ImageCarouseHandler.MSG_UPDATE_IMAGE, ImageCarouseHandler.MSG_DELAY);
                        break;
                    default:
                        break;
                }
            }
        });
        vp.setCurrentItem(4998);
        //开始轮播效果
        handler.sendEmptyMessageDelayed(ImageCarouseHandler.MSG_UPDATE_IMAGE, ImageCarouseHandler.MSG_DELAY);
        //注意，设置Page 即缓存页面的个数，数过小时会出现fragment重复加载的问题
    }

    private void showpoint(int position) {
        //dian0-白色 dian1-灰色
        for (int i = 0;i<7;i++) {
            pointimgs[i].setImageResource(R.drawable.dian1);
            pointimgs[position%7].setImageResource(R.drawable.dian0);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return testDates.get(position);
    }

    @Override
    public int getItemCount() {
        return testDates.size();
    }


    public   void setViewPagerCurrentItem(int currentItem) {
        vp.setCurrentItem(currentItem);
    }



}

