package cn.com.amber.account.service.impl.dao;

import java.util.List;

import cn.com.amber.account.service.bean.vo.AccountDefinition;
import cn.com.amber.account.service.impl.bean.pojo.PojoAccountDefinition;

public interface AccountDefinitionDao extends BaseDao<PojoAccountDefinition>{
	
	public List<PojoAccountDefinition> queryByProperty(AccountDefinition accountDefinition);
	public long countByProperty(AccountDefinition accountDefinition);
	
}
