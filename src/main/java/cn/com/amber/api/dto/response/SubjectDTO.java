package cn.com.amber.api.dto.response;import lombok.Builder;import lombok.Data;import java.util.List;/** * 科目对象 * * @author yangying * @version 1.0 * @since 2022/9/28 **/@Builder@Datapublic class SubjectDTO {    //科目编号,唯一,编码规则：1位会计要素+1位级别+4位会计准则编码+1位余额方向    private String subjectNo;    //科目名称    private String subjectName;    //会计要素    private int element;    //级别    private int level;    private String parentSubjectNo;    //余额方向，C-贷记;D-借记    private String direction;    private List<SubjectDTO> children;}