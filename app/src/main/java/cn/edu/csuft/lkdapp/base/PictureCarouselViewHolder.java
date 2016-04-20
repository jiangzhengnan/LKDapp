package cn.edu.csuft.lkdapp.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import cn.edu.csuft.lkdapp.R;

import java.util.ArrayList;

/**
 *
 */
public class PictureCarouselViewHolder extends RecyclerView.ViewHolder{
    //轮播的图片
    public ArrayList<ImageView> imgs;
    //轮播的图片资源id
    int[] imgres = {
            R.drawable.picturecarousel0,
            R.drawable.picturecarousel1,
            R.drawable.picturecarousel2,
            R.drawable.picturecarousel3,
            R.drawable.picturecarousel4,
            R.drawable.picturecarousel5,
            R.drawable.picturecarousel6};

    public ViewPager vp;
    /**
     * 点点资源初始化
     */
    ImageView pointimg0,pointimg1,pointimg2,pointimg3,pointimg4,pointimg5,pointimg6;
    ImageView[] pointimgs = {pointimg0,pointimg1,pointimg2,pointimg3,pointimg4,pointimg5,pointimg6};
    int[] pointimgsres = {R.id.picturecarousel_img0
            ,R.id.picturecarousel_img1
            ,R.id.picturecarousel_img2
            ,R.id.picturecarousel_img3
            ,R.id.picturecarousel_img4
            ,R.id.picturecarousel_img5
            ,R.id.picturecarousel_img6};
    /**
     * 构造方法
     * @param itemView
     * @param context
     */
    public PictureCarouselViewHolder(View itemView,Context context) {
        super(itemView);
         View view = LayoutInflater.from(context).inflate(R.layout.main_home_picturecarousel, null);


    }
}
