package cn.com.amber.mapper;

import cn.com.amber.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    public Account selectByAccountNo(String legalPersonId,String accountNo);

    public int insert(Account account);

    public List<Account> selectByLegalPersonId(String legalPersonId);

    public int saveBatch(List<Account> accountList);
}