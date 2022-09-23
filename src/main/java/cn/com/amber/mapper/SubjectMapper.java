package cn.com.amber.mapper;

import cn.com.amber.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper{
    public Subject selectBySubjectNo(String subjectNo);

    public int insert(Subject subject);

    public List<Subject> selectAll();

    public List<Subject> selectBySubjectNoList(List<String> subjectNoList);
}