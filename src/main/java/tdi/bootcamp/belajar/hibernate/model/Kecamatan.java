package tdi.bootcamp.belajar.hibernate.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name="Kecamatan", schema="public")
public class Kecamatan{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_kecamatan", updatable = false, nullable = false)
    private int id;
    
    @Column(name = "nama", length= 150)
    private String nama;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}