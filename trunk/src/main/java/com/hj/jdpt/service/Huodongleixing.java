package com.hj.jdpt.service;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Dangyuanzuzhihuodong;
import com.hj.jdpt.domain.HuodongleixingAndDangYuanZuZhiHuoDong;

import java.util.HashMap;
import java.util.List;

public interface Huodongleixing {
    public List<HuodongleixingAndDangYuanZuZhiHuoDong> queryAll(Integer cun_id);

    public Page<HuodongleixingAndDangYuanZuZhiHuoDong> queryAllLeiXing(Integer cun_id);

    public Page<Dangyuanzuzhihuodong> queryAllHD(Integer LX_id,Integer cun_id);
}
