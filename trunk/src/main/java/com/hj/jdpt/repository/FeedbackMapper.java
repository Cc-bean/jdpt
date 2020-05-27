//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hj.jdpt.repository;

import com.github.pagehelper.Page;
import com.hj.jdpt.domain.Feedback;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component("feedbackMapper")
public interface FeedbackMapper {
    @Insert({"insert into feedback(F_Type,F_AdmissibleUnit,F_Title,F_Content,F_ImagePath,F_PeopleId,F_Time,F_beiyong1,F_beiyong2,F_Handle,F_Judge) values(#{fType},#{fAdmissibleunit},#{fTitle},#{fContent},#{fImagepath},#{fPeopleid},#{fTime},#{fBeiyong1},#{fBeiyong2},#{fHandle},#{fJudge})"})
    Boolean AddFeedback(Feedback feedback);

    @Select({"select * from feedback where F_Handle=1 and F_PeopleId=#{userid}"})
    Page<Feedback> Yichuli(@Param("userid") Integer userid);

    @Select({"select * from feedback where Feedback_Id=#{id}"})
    Feedback YichuliInfo(Integer id);

    @Select({"select * from feedback where F_PeopleId=#{userid} and F_Handle=1 and F_Time like '${value}%'"})
    Page<Feedback> YichuliSearch(@Param("userid") Integer userid, @Param("value") String year);

    @Select({"select * from feedback where F_Handle=0 and F_PeopleId=#{userid}"})
    Page<Feedback> Weichuli(@Param("userid") Integer userid);

    @Select({"select * from feedback where F_PeopleId=#{userid} and F_Handle=0 and F_Time like '${value}%'"})
    Page<Feedback> WeichuliSearch(@Param("userid") Integer userid, @Param("value") String year);

    @Select({"select * from feedback where F_PeopleId=#{userId} and F_Time like '${value}%'"})
    List<Feedback> meiritiaoshuo(@Param("userId") Integer userId, @Param("value") String value);
}
