package cn.com.amber.account.service;

import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.amber.account.service.bean.vo.AccountCategory;

public class TestAccountCategoryFunc {

	private ApplicationContext applictionContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private AccountCategoryService accountCategoryService = null;
	
	@Before
	public void init(){
		accountCategoryService = applictionContext.getBean(AccountCategoryService.class);
	}
	
	public void testFunc(){
		 
	}
	
	private List<AccountCategoryStub> loadFromXml(String path) throws DocumentException, IllegalArgumentException, IllegalAccessException{
		InputStream input = this.getClass().getResourceAsStream(path);
		input = new DataInputStream(input);
		SAXReader reader = new SAXReader();
		Document doc = reader.read(input);
		
		Element root = doc.getRootElement();
		
		@SuppressWarnings("unchecked")
		List<Element> testcases =  root.elements("content/testcase");
		
		Field[] fields =  AccountCategoryStub.class.getFields();
		List<AccountCategoryStub> testStubList = new ArrayList<TestAccountCategoryFunc.AccountCategoryStub>();
		for(Element testcase:testcases){
			AccountCategoryStub accountCategoryStub = new AccountCategoryStub();
			
			for(Element element :(List<Element>)testcase.elements()){
				for(Field field:fields){
					if(field.getName().equals(element.getName())){
						String text = element.getText();
						if(text!=null&&!text.trim().equals("")){
							Class fieldClass = field.getType();
							if(fieldClass instanceof Object){
								field.set(accountCategoryStub, text);
							}
						}
					}
				}
			}
			testStubList.add(accountCategoryStub);
		}
		return testStubList;
	}
	
	private class AccountCategoryStub implements AccountCategory{
		private long id;
		private String name;
		private String code;
		private Long accMinSurplus;
		private Long accMaxSurplus;
		private Boolean isAllowChild;
		private Boolean isAllowRelate;
		private Boolean isLeafNode;
		private int level;
		private long parentId;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Long getAccMinSurplus() {
			return accMinSurplus;
		}
		public void setAccMinSurplus(Long accMinSurplus) {
			this.accMinSurplus = accMinSurplus;
		}
		public Long getAccMaxSurplus() {
			return accMaxSurplus;
		}
		public void setAccMaxSurplus(Long accMaxSurplus) {
			this.accMaxSurplus = accMaxSurplus;
		}
		public Boolean getIsAllowChild() {
			return isAllowChild;
		}
		public void setIsAllowChild(Boolean isAllowChild) {
			this.isAllowChild = isAllowChild;
		}
		public Boolean getIsAllowRelate() {
			return isAllowRelate;
		}
		public void setIsAllowRelate(Boolean isAllowRelate) {
			this.isAllowRelate = isAllowRelate;
		}
		public Boolean getIsLeafNode() {
			return isLeafNode;
		}
		public void setIsLeafNode(Boolean isLeafNode) {
			this.isLeafNode = isLeafNode;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		public long getParentId() {
			return parentId;
		}
		public void setParentId(long parentId) {
			this.parentId = parentId;
		}
	}
}
