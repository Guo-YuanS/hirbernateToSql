package Success;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class WriteToSql {
	
	public void write(List<ArrayObject> oberons) {
		// ��ȡxml�����ļ�
		Configuration cfg = new Configuration().configure();
		// ����sessionfactory
		SessionFactory factory = cfg.buildSessionFactory();
		//���ȡ��session
		Session session = null;
		try {
			session = factory.openSession();
			// ��������
			session.beginTransaction();
 
			// ��ȡArrayObject�������
			// ����array����
			for(int i=0;i<oberons.size();i++) {
				session.save(oberons.get(i));
			}
			// �ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// �ع�����
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// �ر�session
					session.close();
				}
			}
		}
	}
}
