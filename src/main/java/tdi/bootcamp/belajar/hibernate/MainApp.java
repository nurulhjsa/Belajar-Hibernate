package tdi.bootcamp.belajar.hibernate;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Session;
import tdi.bootcamp.belajar.hibernate.model.Employee;
import tdi.bootcamp.belajar.hibernate.util.HibernateUtil;

public class MainApp {
    
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            
        String result = getNativeQuery( session, "select version()");
        System.out.println(result);
            
              //simpanPegawai(session);
              //updatePegawai(session);
              //updatePegawaiDuo(session);
                deletePegawai(session);
                List<Employee> listPegawai= getListPegawai(session);
                for (Employee employee : listPegawai){
                    System.out.println(employee.getNama());
                }
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.shutdown();
		
	}
	//Perintah Insert Pegawai Baru
	private static Integer simpanPegawai(Session session) {
		Employee emp = new Employee();
		emp.setNama("Nurul");
		emp.setAlamat("Jln Bidar");
		emp.setIdEntry("user1");
		emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
		return (Integer) session.save(emp);
	}
	
	//Perintah Select Semua Pegawai
        private static List<Employee> getListPegawai(Session session){
            return session.createQuery("select d from Employee d").getResultList();
        }
        
        //Update Pegawai Berdasarkan ID
        private static void updatePegawai(Session session) {
		Employee emp = session.find (Employee.class, 2);
		emp.setNama("nama abcd update");
		emp.setAlamat("Jl Tes ABCDE update");
		emp.setIdEntry("user1");
		emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
                    session.update(emp);
	}
        
        //Update Pegawai Berdasarkan Parameter
        private static int updatePegawaiDuo(Session session) {
		return session.createQuery("update Employee set name = :nama where id = :id")
		.setParameter("nama", "nama update sql")
		.setParameter("id", 1).executeUpdate();
	}
        
        //Perintah Delete Berdasarkan ID =2
        private static void deletePegawai(Session session){
            Employee emp = session.find(Employee.class, 1);
                session.delete( emp);
        }
        
	private static String getNativeQuery(Session session, String sql) {
		
		return (String) session.createNativeQuery(sql).getSingleResult();
	}	
}
