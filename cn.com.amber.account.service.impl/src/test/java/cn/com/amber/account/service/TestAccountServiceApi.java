package cn.com.amber.account.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.amber.account.service.bean.Page;
import cn.com.amber.account.service.bean.PagedListBean;
import cn.com.amber.account.service.bean.vo.AccountDefinition;
import cn.com.amber.account.service.impl.bean.AccountDefinitionImpl;

public class TestAccountServiceApi {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public void init(){
		
	}
	
	public void testAccountDefinition(){
		AccountDefinitionService accDefiService = (AccountDefinitionService)context.getBean("");
		AccountDefinitionImpl queryObject = new AccountDefinitionImpl();
		
		@SuppressWarnings("unused")
		PagedListBean<AccountDefinition> accDefiList =  accDefiService.findPagedList(queryObject, Page.originalPage()); 
		
		AccountDefinitionImpl newAccDefi = new AccountDefinitionImpl();
		accDefiService.add(newAccDefi);
		
		
	}
	
}
