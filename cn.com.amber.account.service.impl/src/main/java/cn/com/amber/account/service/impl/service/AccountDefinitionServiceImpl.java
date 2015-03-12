package cn.com.amber.account.service.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.amber.account.service.AccountDefinitionService;
import cn.com.amber.account.service.bean.Page;
import cn.com.amber.account.service.bean.PagedListBean;
import cn.com.amber.account.service.bean.vo.AccountDefinition;
import cn.com.amber.account.service.impl.dao.AccountDefinitionDao;

@Service
public class AccountDefinitionServiceImpl implements AccountDefinitionService{
	
	@Autowired
	private AccountDefinitionDao accountDefinitionDao;
	
	 

	@Override
	public AccountDefinition add(
			AccountDefinition accountDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDefinition getById(long accountDefinitionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDefinition update(
			AccountDefinition accountDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagedListBean<AccountDefinition> findPagedList(
			AccountDefinition queryObject, Page page) {
		 return null;
	}

	@Override
	public PagedListBean<AccountDefinition> findPagedList(
			AccountDefinition queryObject, String sortPropertyName, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

}
