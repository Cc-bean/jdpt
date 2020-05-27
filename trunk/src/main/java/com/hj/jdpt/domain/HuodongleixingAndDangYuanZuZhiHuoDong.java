package com.hj.jdpt.domain;

//import org.apache.catalina.LifecycleState;

import java.util.List;

public class HuodongleixingAndDangYuanZuZhiHuoDong extends Huodongleixing{
    private List<Dangyuanzuzhihuodong> dangyuanzuzhihuodong;

    public List<Dangyuanzuzhihuodong> getDangyuanzuzhihuodong() {
        return dangyuanzuzhihuodong;
    }

    public void setDangyuanzuzhihuodong(List<Dangyuanzuzhihuodong> dangyuanzuzhihuodong) {
        this.dangyuanzuzhihuodong = dangyuanzuzhihuodong;
    }
}
