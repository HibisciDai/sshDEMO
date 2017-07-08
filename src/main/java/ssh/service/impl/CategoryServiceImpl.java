package ssh.service.impl;



import javax.annotation.Resource;
import javax.persistence.Transient;


import org.springframework.stereotype.Service;
import ssh.dao.categoryDao;
import ssh.entity.Category;
import ssh.service.CategoryService;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl   implements CategoryService {
       
	@Resource
	 private categoryDao categoryDaoImpl;  //自动注入
	
	//加入事务 ，自动回滚
	@Transient
	@Override
	public void save(Category t) {
		categoryDaoImpl.add(t);
	}
	//加入事务 ，自动回滚
	@Transient
	@Override
	public void update(Category t) {
		categoryDaoImpl.update(t);
	}
	//加入事务 ，自动回滚
	@Transient
	@Override
	public void delete(int id) {
		categoryDaoImpl.delete(id);
		
	}

	@Override
	public Category get(int id) {
		return categoryDaoImpl.get(id);
	}

	@Override
	public List<Category> query() {
		return categoryDaoImpl.query();
	}
	
}
