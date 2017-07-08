package ssh.dao.impl;

import org.springframework.stereotype.Repository;
import ssh.dao.categoryDao;
import ssh.entity.Category;

/***
 * 2017年5月13日16:55:58
 * @author zwl
 *
 */
@Repository("categoryDaoImpl")
public class categoryDaoImpl extends baseDaoImpl<Category> implements categoryDao {
  //(ˇˍˇ) 想～添加新方法 直接添加 接口方法，实现类调用 getSession 实现数据库持久
}
