package tdi.bootcamp.belajar.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department", schema="public")
public class Department extends BaseClass{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_dept", updatable = false, nullable = false)
    private int id;
    
    @Column(name = "nama_dept", length= 150)
    private String namaDepartment;
    
 // @OneToOne(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaDepartment() {
        return namaDepartment;
    }

    public void setNamaDepartment(String namaDepartment) {
        this.namaDepartment = namaDepartment;
    }
}
