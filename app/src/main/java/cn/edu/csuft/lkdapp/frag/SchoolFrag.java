package cn.edu.csuft.lkdapp.frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.csuft.lkdapp.R;

/**
 * Created by Administrator on 2016/4/5 0005.
 */
public class SchoolFrag extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_school_frag,container,false);
        return v;
    }
}
