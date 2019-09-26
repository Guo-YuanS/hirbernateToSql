package Success;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class WriteToSql {
	
	public void write(List<ArrayObject> oberons) {
		// 读取xml配置文件
		Configuration cfg = new Configuration().configure();
		// 建立sessionfactory
		SessionFactory factory = cfg.buildSessionFactory();
		//获得取得session
		Session session = null;
		try {
			session = factory.openSession();
			// 开启事务
			session.beginTransaction();
 
			// 获取ArrayObject数组对象
			// 保存array对象
			for(int i=0;i<oberons.size();i++) {
				session.save(oberons.get(i));
			}
			// 提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// 关闭session
					session.close();
				}
			}
		}
	}
}
