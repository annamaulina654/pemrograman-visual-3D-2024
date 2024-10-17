/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas2;

import java.time.LocalDate;
import java.util.LinkedHashMap;

/**
 *
 * @author HP
 */
public class DataMahasiswa {
    private String nim, nama, prodi;
    private int spp;
    private LinkedHashMap<String, String[]> pembayaranBulan;

    // Constructor
    public DataMahasiswa(String nim, String nama, String prodi, int spp) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.spp = spp;
        this.pembayaranBulan = new LinkedHashMap<>();
        
        LocalDate ts = LocalDate.now();
        String bs = ts.getMonth().name();
        String[] bulans = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (String bulan : bulans) {
            pembayaranBulan.put(bulan, new String[]{"nunggak", ""});
            if (bulan.equalsIgnoreCase(bs)) break;
        }
    }

    // Getters and Setters
    public String getNim() {
        return nim;
    }
    public String getNama() {
        return nama;
    }
    public String getProdi() {
        return prodi;
    }
    public int getSpp() {
        return spp;
    }
    
    public LinkedHashMap<String, String[]> getPembayaranBulan() {
        return pembayaranBulan;
    }
    public void setPembayaranBulan(String bulan, String status, String tanggal) {
        pembayaranBulan.put(bulan, new String[]{status, tanggal});
    }
    public String getStatusPembayaran() {
        int nunggak = 0;
        for (String[] status : pembayaranBulan.values()) {
            if (status[0].equals("nunggak")) {
                nunggak++;
            }
        }
        return nunggak == 0 ? "Lunas" : "Nunggak " + nunggak + " bulan";
    }
}
