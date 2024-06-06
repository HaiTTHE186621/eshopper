/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Product {
    private int pid;
    private String pname;
    private String pimage;
    private int pprice;
    private String pdes;
    private int cid;
    private int forid;

    public Product() {
    }

    public Product(int pid, String pname, String pimage, int pprice, String pdes, int cid, int forid) {
        this.pid = pid;
        this.pname = pname;
        this.pimage = pimage;
        this.pprice = pprice;
        this.pdes = pdes;
        this.cid = cid;
        this.forid = forid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public String getPdes() {
        return pdes;
    }

    public void setPdes(String pdes) {
        this.pdes = pdes;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getForid() {
        return forid;
    }

    public void setForid(int forid) {
        this.forid = forid;
    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", pname=" + pname + ", pimage=" + pimage + ", pprice=" + pprice + ", pdes=" + pdes + ", cid=" + cid + ", forid=" + forid + '}';
    }
    
    
}
