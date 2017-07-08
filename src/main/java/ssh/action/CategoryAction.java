package ssh.action;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ssh.entity.Category;
import ssh.service.CategoryService;


@Controller("categoryAction") //即 spring 管理的bean的id值
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>  {
	
     @Resource
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String update() {
		System.out.println("----update----");
		categoryService.update(model);
		return "index";
	}

	public String save() {
		  System.out.println("----save----");  
	       categoryService.save(model);; //直接使用model  
	        return "index";  
	}
	public String delete() {
		  System.out.println("----save----");  
	       categoryService.delete(model.getId()); //直接使用model  
	        return "index";  
	}

	public String query() {
		 List<Category> list=categoryService.query();
		request.put("categoryList", list);
		session.put("categoryList", list);
		application.put("categoryList", list);
		return "index";
	}
  
	 
}