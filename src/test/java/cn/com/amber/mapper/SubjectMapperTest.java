package cn.com.amber.mapper;import cn.com.amber.BaseContainerTest;import cn.com.amber.entity.Subject;import cn.com.amber.entity.enums.AccountingElementEnum;import com.alibaba.fastjson2.JSONObject;import org.junit.Assert;import org.junit.Test;import javax.annotation.Resource;public class SubjectMapperTest extends BaseContainerTest {    @Resource    private SubjectMapper subjectMapper;    @Test    public void test() {        Subject subject = new Subject();        subject.setSubjectName("应收款");        subject.setElement(AccountingElementEnum.ASSERT.getCode());        subject.setDirection("D");        subject.setLevel(1);        subject.setParentId(null);        subject.setSubjectNo(subject.generateSubjectNo("1122"));        //int insertRow = subjectMapper.insert(subject);        //Assert.assertEquals(1, insertRow);        subject = subjectMapper.selectBySubjectNo(subject.getSubjectNo());        Assert.assertNotNull(subject);        System.out.println(JSONObject.toJSONString(subject));    }}