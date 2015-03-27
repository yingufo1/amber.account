package cn.com.amber.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.amber.account.service.AccountCategoryService;
import cn.com.amber.account.service.BasePagedListBean;
import cn.com.amber.account.service.PageCondition;
import cn.com.amber.account.service.bean.PagedListBean;
import cn.com.amber.account.service.bean.pojo.PojoAccountCategory;
import cn.com.amber.account.service.bean.vo.AccountCategory;
import cn.com.amber.account.service.dao.AccountCategoryDao;
import cn.com.amber.account.service.exception.AccountCategoryNotFoundException;
import cn.com.amber.account.service.exception.AccountCategoryException;
import cn.com.amber.account.service.exception.IllegalParameterException;
import cn.com.amber.account.service.exception.LevelBeyondException;
import cn.com.amber.account.service.exception.NotLeafNodeException;

@Service
public class AccountCategoryServiceImpl extends BaseServiceImpl implements
		AccountCategoryService {

	@Autowired
	private AccountCategoryDao accountDefinitionDao;

	private final static Integer MAX_LEVEL = 3;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AccountCategory add(AccountCategory accountCategory)
			throws AccountCategoryException {
		PojoAccountCategory newPojoAccountCategory = copyBeanDepeSpring(accountCategory,PojoAccountCategory.class);
		if (accountCategory.getParentCategory() != null) {// has parent
			PojoAccountCategory parentAccountCategory = accountDefinitionDao
					.getById(accountCategory.getParentCategory().getId());
			if (parentAccountCategory == null) {
				throw new AccountCategoryNotFoundException("未找到父级类别");
			}
			if (parentAccountCategory.getIsLeafNode()) {
				throw new AccountCategoryException("叶子类别不允许添加子类别");
			}
			if (MAX_LEVEL < parentAccountCategory.getCategoryLevel() + 1) {
				throw new LevelBeyondException(MAX_LEVEL);
			}
			newPojoAccountCategory
					.setCategoryLevel(parentAccountCategory.getCategoryLevel() + 1);
		}
		
		if (!accountCategory.getIsLeafNode()) {// if not leaf node
			newPojoAccountCategory.setIsAllowRelate(null);
			newPojoAccountCategory.setMaxSurplus(null);
			newPojoAccountCategory.setMinSurplus(null);
		}
		newPojoAccountCategory = accountDefinitionDao
				.persist(newPojoAccountCategory);
		AccountCategory savedAccountCategory = copyBeanDepeSpring(newPojoAccountCategory,AccountCategory.class);
		return savedAccountCategory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AccountCategory getById(long accountCategoryId) {
		PojoAccountCategory pojoAccountCategory = accountDefinitionDao
				.getById(accountCategoryId);
		AccountCategory accountCategory = copyBeanDepeSpring(pojoAccountCategory, AccountCategory.class);
		return accountCategory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void modify(long accountCategoryId, long minSurplus, long maxSurplus)
			throws AccountCategoryException, IllegalParameterException {
		PojoAccountCategory originPojoAccountCategory = accountDefinitionDao
				.getById(accountCategoryId);
		if (originPojoAccountCategory == null) {
			throw new AccountCategoryNotFoundException();
		}
		modify(originPojoAccountCategory, originPojoAccountCategory.getName(),
				minSurplus, maxSurplus);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void modify(long accountCategoryId, String name)
			throws AccountCategoryException {
		PojoAccountCategory originPojoAccountCategory = accountDefinitionDao
				.getById(accountCategoryId);
		if (originPojoAccountCategory == null) {
			throw new AccountCategoryNotFoundException();
		}
		modify(originPojoAccountCategory, originPojoAccountCategory.getName(),
				originPojoAccountCategory.getMinSurplus(),
				originPojoAccountCategory.getMaxSurplus());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void modify(long accountCategoryId, String name, long minSurplus,
			long maxSurplus) throws AccountCategoryException {
		PojoAccountCategory originPojoAccountCategory = accountDefinitionDao
				.getById(accountCategoryId);
		if (originPojoAccountCategory == null) {
			throw new AccountCategoryNotFoundException();
		}
		modify(originPojoAccountCategory, name, minSurplus, maxSurplus);
	}

	private void modify(PojoAccountCategory pojoAccountCategory, String name,
			long minSurplus, long maxSurplus) throws NotLeafNodeException {
		if ((minSurplus != pojoAccountCategory.getMinSurplus() || (maxSurplus != pojoAccountCategory
				.getMaxSurplus())) && !pojoAccountCategory.getIsLeafNode()) {
			// 非叶子节点并且最大余额与最小余额修改过，抛出异常
			// 非叶子节点不能修改余额区间
			throw new NotLeafNodeException();
		}
		pojoAccountCategory.setName(name);
		pojoAccountCategory.setMinSurplus(minSurplus);
		pojoAccountCategory.setMaxSurplus(maxSurplus);
		accountDefinitionDao.update(pojoAccountCategory);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PagedListBean<AccountCategory> findPagedList(
			PageCondition<AccountCategory> pageCondition) {
		PojoAccountCategory example = copyBeanDepeSpring(pageCondition.getTemplate(),
				PojoAccountCategory.class);
		List<PojoAccountCategory> pojoAccountCategoryList = accountDefinitionDao
				.findByPageCondition(example, pageCondition.getPage(),
						pageCondition.getPageSize(), pageCondition.getOrder()
								.getCode(), pageCondition.getSortPropertyName());
		List<AccountCategory> accountCategoryList = new ArrayList<AccountCategory>();

		for (PojoAccountCategory pojoAccountCategory : pojoAccountCategoryList) {
			AccountCategory accountCategory = copyBeanDepeSpring(pojoAccountCategory,
					AccountCategory.class);
			accountCategoryList.add(accountCategory);
		}
		long total = accountDefinitionDao.countByPageCondition(example);

		PagedListBean<AccountCategory> result = new BasePagedListBean<AccountCategory>(
				accountCategoryList, total);
		return result;
	}
}
