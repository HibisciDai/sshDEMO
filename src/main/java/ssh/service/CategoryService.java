package ssh.service;

import ssh.entity.Category;

import java.util.List;




public interface CategoryService     {
	 public void save(Category t);
	  
	    public void update(Category t);  
	      
	    public void delete(int id);  
	      
	    public Category get(int id);  
	      
	    public List<Category> query(); 
}
