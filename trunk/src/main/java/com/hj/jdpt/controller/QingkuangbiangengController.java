package com.hj.jdpt.controller;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hj.jdpt.domain.Qingkuangbiangeng;
import com.hj.jdpt.repository.QingkuangbiangengMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@RestController
public class QingkuangbiangengController {
    @Autowired
    private QingkuangbiangengMapper QingkuangbiangengMapper;

    @GetMapping(value = "/pageFindQingkuangbiangengByQkbgYearandVillageId/{zVillage}/{qkbgYear}/{startPage}/{pageSize}")
    public Map<String, Object> pageFindQingkuangbiangengByQkbgYearandVillageId(@PathVariable(value = "zVillage") Integer zVillage,
                                                                            @PathVariable(value = "qkbgYear") Integer qkbgYear,
                                                                            @PathVariable(value = "startPage") Integer startPage,
                                                                            @PathVariable(value = "pageSize") Integer pageSize
    ) {

        PageHelper.startPage(startPage, pageSize);
        Page<Qingkuangbiangeng> QingkuangbiangengPage = QingkuangbiangengMapper.pageFindQingkuangbiangengByQkbgYearandVillageId(qkbgYear, zVillage);
        Map<String, Object> result = new HashMap<>();
        result.put("record", QingkuangbiangengPage);
        //总页数
        result.put("total", QingkuangbiangengPage.getPages());
        //记录总数
        result.put("count", QingkuangbiangengPage.getTotal());
        //当前第几页
        result.put("nowPage", QingkuangbiangengPage.getPageNum());
        return result;
    }


    @GetMapping(value = "/pageFindQingkuangbiangengByQkbgYear/{qkbgYear}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindQingkuangbiangengByQkbgYear(@PathVariable(value = "qkbgYear") Integer qkbgYear,
                                                                            @PathVariable(value = "startPage") Integer startPage,
                                                                            @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Qingkuangbiangeng> QingkuangbiangengPage =  QingkuangbiangengMapper.pageFindQingkuangbiangengByQkbgYear(qkbgYear);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",QingkuangbiangengPage);
        //总页数
        result.put("total",QingkuangbiangengPage.getPages());
        //记录总数
        result.put("count",QingkuangbiangengPage.getTotal());
        //当前第几页
        result.put("nowPage",QingkuangbiangengPage.getPageNum());
        return result;
    }

    @GetMapping(value = "/pageFindQingkuangbiangengByVillageId/{zVillage}/{startPage}/{pageSize}")
    public Map<String ,Object> pageFindQingkuangbiangengByVillageId(
                                                                            @PathVariable(value = "zVillage") Integer zVillage,
                                                                            @PathVariable(value = "startPage") Integer startPage,
                                                                            @PathVariable(value = "pageSize") Integer pageSize
    ){

        PageHelper.startPage(startPage,pageSize);
        Page<Qingkuangbiangeng> QingkuangbiangengPage =  QingkuangbiangengMapper.pageFindQingkuangbiangengByVillageId(zVillage);
        Map<String ,Object> result = new HashMap<>();
        result.put("record",QingkuangbiangengPage);
        //总页数
        result.put("total",QingkuangbiangengPage.getPages());
        //记录总数
        result.put("count",QingkuangbiangengPage.getTotal());
        //当前第几页
        result.put("nowPage",QingkuangbiangengPage.getPageNum());
        return result;
    }

}
