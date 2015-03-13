package cn.com.amber.account.service.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.amber.account.service.AccountCategoryService;
import cn.com.amber.account.service.bean.Page;
import cn.com.amber.account.service.bean.PagedListBean;
import cn.com.amber.account.service.bean.vo.AccountCategory;
import cn.com.amber.account.service.exception.AccCateNotExistException;
import cn.com.amber.account.service.exception.AccountCategoryException;
import cn.com.amber.account.service.exception.IllegalParameterException;
import cn.com.amber.account.service.exception.LevelByondLimitException;
import cn.com.amber.account.service.impl.bean.AccountCategoryImpl;
import cn.com.amber.account.service.impl.bean.pojo.PojoAccountCategory;
import cn.com.amber.account.service.impl.dao.AccountCategoryDao;

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
		PojoAccountCategory newPojoAccountCategory = copyBean(accountCategory,
				PojoAccountCategory.class);
		if (accountCategory.getParentId() > 0) {// has parent
			PojoAccountCategory parentAccountCategory = accountDefinitionDao
					.getById(accountCategory.getParentId());
			if (parentAccountCategory == null) {
				throw new AccCateNotExistException("未找到父级类别");
			}
			if (parentAccountCategory.getIsLeafNode()) {
				throw new AccountCategoryException("叶子类别不允许添加子类别");
			}
			if (MAX_LEVEL < parentAccountCategory.getLevel() + 1) {
				throw new LevelByondLimitException(MAX_LEVEL);
			}
			newPojoAccountCategory
					.setLevel(parentAccountCategory.getLevel() + 1);
		}
		if (!accountCategory.getIsLeafNode()) {// if not leaf node
			newPojoAccountCategory.setIsAllowChild(null);
			newPojoAccountCategory.setIsAllowRelate(null);
			newPojoAccountCategory.setAccMaxSurplus(null);
			newPojoAccountCategory.setAccMinSurplus(null);
		}
		newPojoAccountCategory = accountDefinitionDao
				.persist(newPojoAccountCategory);
		AccountCategory savedAccountCategory = copyBean(newPojoAccountCategory,
				AccountCategory.class);
		return savedAccountCategory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AccountCategory getById(long accountCategoryId) {
		PojoAccountCategory accountCategory = accountDefinitionDao.getById(accountCategoryId);
		AccountCategoryImpl accountCategoryImpl = copyBean(accountCategory,AccountCategoryImpl.class);
		return accountCategoryImpl;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void adjustSuplusRegion(long accountCategoryId, long minSurplus,
			long maxSurplus) throws AccountCategoryException,
			IllegalParameterException {
		PojoAccountCategory originPojoAccountCategory = accountDefinitionDao.getById(accountCategoryId);
		if (originPojoAccountCategory == null) {
			throw new AccCateNotExistException();
		}
		if (!originPojoAccountCategory.getIsLeafNode()) {
			throw new AccountCategoryException("该类别不是子类别,无法调整余额区间");
		}
		if (minSurplus < 0 || maxSurplus < 0 || minSurplus < maxSurplus) {
			throw new IllegalParameterException("错误的金额参数");
		}
		originPojoAccountCategory.setAccMinSurplus(minSurplus);
		originPojoAccountCategory.setAccMaxSurplus(maxSurplus);
		accountDefinitionDao.update(originPojoAccountCategory);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void adjustName(long accountCategoryId, String name)
			throws AccountCategoryException {
		PojoAccountCategory originPojoAccountCategory = accountDefinitionDao.getById(accountCategoryId);
		if (originPojoAccountCategory == null) {
			throw new AccountCategoryException("未找到类别");
		}
		originPojoAccountCategory.setName(name);
		accountDefinitionDao.update(originPojoAccountCategory);
	}

	@Override
	public PagedListBean<AccountCategory> findPagedList(
			AccountCategory queryObject, Page page) {
		
		return null;
	}

	@Override
	public PagedListBean<AccountCategory> findPagedList(
			AccountCategory queryObject, String sortPropertyName, Page page) {
		PojoAccountCategory example = copyBean(queryObject, PojoAccountCategory.class);
		return null;
	}
}
