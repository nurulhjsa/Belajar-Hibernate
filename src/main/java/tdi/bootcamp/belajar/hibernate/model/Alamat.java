package tdi.bootcamp.belajar.hibernate.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Alamat", schema="public")
public class Alamat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_alamat", updatable = false, nullable = false)
    private int id;
    
    @Column(name = "nama", length= 50)
    private String nama;
    
    @Column (name = "kecamatan", length= 50)
    private String kecamatan; 
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kecamatan")

    private Kecamatan kecam;
    
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

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public Kecamatan getKecam() {
        return kecam;
    }

    public void setKecam(Kecamatan kecam) {
        this.kecam = kecam;
    }

    public void setIdEntry(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setAlamat(Alamat alam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdEntry(String user_alam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
