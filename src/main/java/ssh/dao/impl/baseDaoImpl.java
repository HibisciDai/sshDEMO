package ssh.dao.impl;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import ssh.dao.baseDao;

/***
 * 2017年5月13日16:55:58
 * @author zwl
 *
 */
@Repository("baseDaoImpl")
@Lazy(true)
public class baseDaoImpl<T> implements baseDao<T> {
	
	 private Class clazz; //存储T
	 @Resource
	 private SessionFactory sessionFactory; //自动注入
	 
	 public baseDaoImpl() {
			// 拿到泛型的参数类型 java反射，即拿到 本类的泛型T的类型
			 
			 ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
		     clazz = (Class)type.getActualTypeArguments()[0];  
	 }
	 protected Session getSession() {
			// 从当前线程获取session，如果没有则创建一个新的session
		return sessionFactory.getCurrentSession();
	 }
	 
		@Override
		public void add(T t) {
			 getSession().save(t);

		}

		@Override
		public void update(T t) {
			 getSession().update(t);

		}

		@Override
		public void delete(int id) {
			
			 String simpleClass=clazz.getSimpleName();
			 System.out.println(simpleClass+"*************"+id);
			 String hql="delete "+simpleClass+" where id=:id";
			 getSession().createQuery(hql).setInteger("id", id).executeUpdate();

		}

		@Override
		public T get(int id) {
			return (T) getSession().get(clazz, id);
		}

		@Override
		public List<T> query() {
			  String hql="from "+clazz.getSimpleName();
			  return getSession().createQuery(hql).list();
		}

}
