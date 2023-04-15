package Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@Data
@Table(name = "ChiTietSP")
@Entity
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public UUID id;

//    @ManyToOne
//    @JoinColumn(name = "idNSX", nullable = false)
//    private NSX idNSX;
//
//    @ManyToOne
//    @JoinColumn(name = "idSP", nullable = false)
//    private SanPham idSP;
//
//    @ManyToOne
//    @JoinColumn(name = "idMauSac", nullable = false)
//    private MauSac idMauSac;
//
//    @ManyToOne
//    @JoinColumn(name = "idDongSP", nullable = false)
//    private DongSP idDongSP;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Float giaNhap;

    @Column(name = "GiaBan")
    private Float giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(float giaBan, float giaNhap, String moTa, Integer namBH, Integer soLuongTon) {
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }
}
