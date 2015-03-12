package cn.com.amber.account.service.impl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.amber.account.service.bean.vo.AccountDefinition;
import cn.com.amber.account.service.impl.bean.pojo.PojoAccountDefinition;
import cn.com.amber.account.service.impl.dao.AccountDefinitionDao;

@Repository
class AccountDefinitionDaoImpl extends BasoDaoImpl<PojoAccountDefinition>
		implements AccountDefinitionDao {
	
	@Override
	public List<PojoAccountDefinition> queryByProperty(
			AccountDefinition accountDefinition) {
		return null;
	}
	
	@Override
	public long countByProperty(AccountDefinition accountDefinition) {
		return 0;
	}
}
