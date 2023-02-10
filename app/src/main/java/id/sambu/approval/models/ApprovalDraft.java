package id.sambu.approval.models;

public class ApprovalDraft {
    private Integer kategori;
    private String jenisDraft;
    private String nama;
    private String jabatan;
    private String bagian;
    private String tglIzin;
    private String tglSelesaiIzin;
    private String alasan;
    private Integer status;
    private String pic;

    public ApprovalDraft(Integer kategori,String jenisDraft,String nama,String jabatan,String bagian,String tglIzin,String tglSelesaiIzin,String alasan,String pic){
        this.kategori = kategori;
        this.jenisDraft = jenisDraft;
        this.nama = nama;
        this.jabatan=jabatan;
        this.bagian = bagian;
        this.tglIzin = tglIzin;
        this.tglSelesaiIzin = tglSelesaiIzin;
        this.alasan = alasan;
        this.pic = pic;
    }

    public Integer getKategori(){return kategori;}
    public void setKategori(Integer kategori){this.kategori=kategori;}

    public String getJenisDraft(){return jenisDraft;}
    public void setJenisDraft(String jenisDraft){this.jenisDraft=jenisDraft;}

    public String getNama(){return nama;}
    public void setNama(String nama){this.nama=nama;}

    public String getJabatan(){return jabatan;}
    public void setJabatan(String jabatan){this.jabatan=jabatan;}

    public String getBagian(){return bagian;}
    public void setBagian(String bagian){this.bagian=bagian;}

    public String getTglIzin(){return tglIzin;}
    public void setTglIzin(String tglIzin){this.tglIzin=tglIzin;}

    public String getTglSelesaiIzin(){return tglSelesaiIzin;}
    public void setTglSelesaiIzin(String tglSelesaiIzin){this.tglSelesaiIzin=tglSelesaiIzin;}

    public Integer getStatus(){return status;}
    public void setStatus(Integer status){this.status=status;}

    public String getAlasan(){return alasan;}
    public void setAlasan(String alasan){this.alasan=alasan;}

    public String getPIC(){return pic;}
    public void setPIC(String pic){this.pic=pic;}
}
