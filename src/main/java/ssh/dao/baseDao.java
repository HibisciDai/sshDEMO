package ssh.dao;
import java.util.List;
/***
 * 2017年5月13日16:55:58
 * @author zwl
 *
 */
public interface baseDao<T> {
	  public void add(T t);  
	  
	    public void update(T t);  
	      
	    public void delete(int id);  
	      
	    public T get(int id);  
	      
	    public List<T> query();  
}
