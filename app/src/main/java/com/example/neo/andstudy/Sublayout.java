package com.example.neo.andstudy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by neo on 2017-06-17.
 */

public class Sublayout extends LinearLayout {

    //java 객체로 생성하게 되면 해당 생성자가 호출 됨.
    public Sublayout(Context context) {
        super(context);
        init(context);
    }

    //xml에서 레이아웃에 포함하여 인플레이션 시키는 경우에 attributeset 객체를 사용하게 된다.
    //xml 태그로 추가된 경우엔 해당 생성자가 호출 됨.
    public Sublayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //true는 생성되는 동시에 붙음.
        //false는 필요한 시점에 붙음.
        inflater.inflate(R.layout.inplration_sub, this, true);

    }
}
