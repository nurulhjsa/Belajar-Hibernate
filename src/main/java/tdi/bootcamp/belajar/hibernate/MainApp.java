package tdi.bootcamp.belajar.hibernate;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Session;
import tdi.bootcamp.belajar.hibernate.model.Alamat;
import tdi.bootcamp.belajar.hibernate.model.Employee;
import tdi.bootcamp.belajar.hibernate.model.Kecamatan;
import tdi.bootcamp.belajar.hibernate.model.Student;
import tdi.bootcamp.belajar.hibernate.util.HibernateUtil;

public class MainApp {
    
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            
        String result = getNativeQuery( session, "select version()");
        System.out.println(result);
                   
                simpanPegawai(session);
              //updatePegawai(session);
              //updatePegawaiDuo(session);
              //deletePegawai(session);
		
//                List<Employee> listPegawai= getListPegawai(session);
//                    for (Employee employee : listPegawai){
//                    System.out.println(employee.getNama());
//                }

                List<Employee> listPeg= getListPegawaiDanDepartemen(session);
                    for (Employee employee : listPeg){
                    System.out.println(employee.getNama()+" dept"+employee.getDepartment().getNamaDepartment());
                }
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.shutdown();
		
	}
        
        //Perintah Insert Latihan1 Baru
	private static Integer simpanPegawai(Session session) {
                Kecamatan kecam = new Kecamatan();
                kecam.setNama("Gilang");
                
                Student stud = new Student();
                stud.setNama("Anugerah");
                stud.setIdEntry("user_stud");
                stud.setTglEntry(new Timestamp(System.currentTimeMillis()));
                
		Alamat alam = new Alamat();
		alam.setNama("Ramadhan");
		alam.setIdEntry("user_alam");
                alam.setAlamat(alam);
		return (Integer) session.save(stud);
	}
    
	//Perintah Insert Pegawai Baru
//	private static Integer simpanPegawai(Session session) {
//                Department dept = new Department();
//                dept.setNamaDepartment("DIV IT");
//                dept.setIdEntry("userdept");
//                dept.setTglEntry(new Timestamp(System.currentTimeMillis()));
//                
//		Employee emp = new Employee();
//		emp.setNama("NurulH");
//		emp.setAlamat("Jln Pamagersari");
//		emp.setIdEntry("user1dept");
//		emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
//                emp.setDepartment(dept);
//		return (Integer) session.save(emp);
//	}
	
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
        
        private static List<Employee> getListPegawaiDanDept (Session session){
            return session.createQuery("select p from Employee p JOIN FETCH p.department").getResultList();
        }
}
