package cn.com.amber.account.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.amber.account.service.bean.PagedListBean;
import cn.com.amber.account.service.bean.vo.AccountCategory;
import cn.com.amber.account.service.exception.AccountCategoryException;

public class AccountCategoryServiceTest {

	private static final Log log = LogFactory
			.getLog(AccountCategoryServiceTest.class);
	private ApplicationContext applictionContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private AccountCategoryService accountCategoryService = null;

	@Before
	public void init() {
		accountCategoryService = applictionContext
				.getBean(AccountCategoryService.class);
	}

	@Test
	public void test() {
		try {
			List<AccountCategory> newAccountCategorys = generTestCase(25);
			List<AccountCategory> addResult = new ArrayList<AccountCategory>();
			int leafNodeNum = 0;
			int allowRelateNum = 0;
			for (AccountCategory accountCategory : newAccountCategorys) {
				if (accountCategory.getIsLeafNode()) {
					leafNodeNum++;
				}else if (accountCategory.getIsAllowRelate()!=null&&accountCategory.getIsAllowRelate()) {
					allowRelateNum++;
				}
				addResult.add(accountCategoryService.add(accountCategory));
			}

			for (AccountCategory accountCategory : addResult) {
				accountCategoryService.modify(accountCategory.getId(),
						accountCategory.getName() + "_modify",
						accountCategory.getMinSurplus() + 1, 1000);
			}

			AccountCategory queryAccountCatetory = new AccountCategory();
			// queryAccountCatetory.setIsAllowRelate(true);
			PagedListBean<AccountCategory> pageResult = accountCategoryService
					.findPagedList(PageConditions
							.newDefaultPageCondition(queryAccountCatetory));

			Assert.assertEquals(pageResult.getTotalCount(), addResult.size());

			queryAccountCatetory = new AccountCategory();
			queryAccountCatetory.setIsAllowRelate(true);
			pageResult = accountCategoryService.findPagedList(PageConditions
					.newDefaultPageCondition(queryAccountCatetory));
			Assert.assertEquals(allowRelateNum, pageResult.getTotalCount());

			queryAccountCatetory = new AccountCategory();
			queryAccountCatetory.setIsLeafNode(true);
			pageResult = accountCategoryService.findPagedList(PageConditions
					.newDefaultPageCondition(queryAccountCatetory));
			Assert.assertEquals(leafNodeNum, pageResult.getTotalCount());

			queryAccountCatetory = newAccountCategorys.get(0);
			pageResult = accountCategoryService.findPagedList(PageConditions
					.newDefaultPageCondition(queryAccountCatetory));
			Assert.assertEquals(
					accountCategoryService
							.getById(queryAccountCatetory.getId()).getId(),
					pageResult.getItem().get(0).getId());
		} catch (AccountCategoryException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		} 
	}

	private static List<AccountCategory> generTestCase(int caseNum) {
		List<AccountCategory> testCaseList = new ArrayList<AccountCategory>();

		List<AccountCategory> toplist = new ArrayList<AccountCategory>();
		Random random = new Random(17);
		for (int i = 0; i <= caseNum; i++) {
			boolean isTop = random.nextBoolean();
			boolean isLeafNode = random.nextBoolean();
			boolean isAllowRelate = random.nextBoolean();
			AccountCategory accountCategory = new AccountCategory();
			if (i == 0) {
				isTop = true;
				isLeafNode = false;
			}

			if (isTop) {
				accountCategory.setCategoryLevel(1);
				toplist.add(accountCategory);
			} else {
				accountCategory
						.setParentCategory(toplist.get(toplist.size() - 1));
				accountCategory.setCategoryLevel(toplist.get(toplist.size() - 1)
						.getCategoryLevel() + 1);
			}

			if (isLeafNode) {
				accountCategory.setMinSurplus(0L);
				accountCategory.setMaxSurplus(999999999999L);
				accountCategory.setIsAllowRelate(isAllowRelate);
			}
			accountCategory.setIsLeafNode(isLeafNode);
			accountCategory.setName("测试" + i);
			accountCategory.setCode("100100" + i);
			testCaseList.add(accountCategory);
		}
		return testCaseList;
	}
}
