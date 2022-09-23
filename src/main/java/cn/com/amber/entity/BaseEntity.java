package cn.com.amber.entity;import lombok.AllArgsConstructor;import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;import java.util.Date;/** * 公共的实体基类，包括公共的属性 * * @author yangying * @version 1.0 * @since 2022/9/12 **/@Getter@Setter@NoArgsConstructor@AllArgsConstructorpublic class BaseEntity {    private transient final String  DEFAULT_CREATOR = "SYSTEM";    private transient final String  DEFAULT_MODIFIER = "SYSTEM";    private Date gmtCreated = new Date();    private String creator = DEFAULT_CREATOR;    private Date gmtModified = new Date();    private String modifier = DEFAULT_MODIFIER;    private String isDeleted;}