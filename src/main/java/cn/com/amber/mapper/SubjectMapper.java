package cn.com.amber.mapper;

import cn.com.amber.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubjectMapper{
    public Subject selectBySubjectNo(String subjectNo);

    public int insert(Subject subject);
}