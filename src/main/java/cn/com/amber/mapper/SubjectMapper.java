package cn.com.amber.mapper;

import cn.com.amber.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper{
    /**
     * 根据账户号查询
     * @param subjectNo
     * @return
     */
    public Subject selectBySubjectNo(String subjectNo);

    /**
     * 新增一个科目
     * @param subject
     * @return
     */
    public int insert(Subject subject);

    public List<Subject> selectBySubjectNoList(List<String> subjectNoList);

    /**
     * 根据会计要素查询
     * @param element
     * @return
     */
    public List<Subject> selectByElement(Integer element);

    /**
     *
     * @param subjectNo
     * @param element
     * @return
     */
    public Subject selectBySubjectNoAndElement(String subjectNo,Integer element);

    /**
     *
     * @param parentId
     * @return
     */
    public List<Subject> selectByParentId(Long parentId);

    public List<Subject> selectAll();
}