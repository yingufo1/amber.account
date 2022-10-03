package cn.com.amber.api.dto.req;import cn.com.amber.infrastructure.api.BaseReq;import com.fasterxml.jackson.annotation.JsonIgnoreProperties;import lombok.Getter;import lombok.NoArgsConstructor;import lombok.Setter;import org.hibernate.validator.constraints.Range;import javax.validation.constraints.NotBlank;import javax.validation.constraints.NotNull;/** * 账户请求 * * @author yangying * @version 1.0 * @since 2022/9/14 **/@Setter@Getter@NoArgsConstructor@JsonIgnoreProperties(ignoreUnknown=true)public class OpenAccountReq extends BaseReq {    @NotBlank(message="个人姓名或企业名称不能为空")    private String name;    @NotNull(message="法人类型不能为空")    // 开户类型，1-个人，2-企业-资产端，3-企业-资金端    private Integer type;    //当type是2,3时，不能为空    private String legalPersonId;    //当type是1时，不能为空    private String userId;    //指定的开户账户。当openAccountWay=2时，不可为空    private String accountNo;    @NotNull    @Range(min=1,max = 2)    //1-基于后台配置的规则，2-指定科目开子账户    private int openAccountStrategy;    public OpenAccountReq(String requestId){        super(requestId);    }}