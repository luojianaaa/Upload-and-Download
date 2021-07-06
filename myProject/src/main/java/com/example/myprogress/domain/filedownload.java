package com.example.myprogress.domain;

import javax.persistence.*;

@Entity(name = "filedownload")
public class filedownload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String filename;
    private String filedownIp;
    private String downtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiledownIp() {
        return filedownIp;
    }

    public void setFiledownIp(String filedownIp) {
        this.filedownIp = filedownIp;
    }

    public String getDowntime() {
        return downtime;
    }

    public void setDowntime(String downtime) {
        this.downtime = downtime;
    }

    @Override
    public String toString() {
        return "filedown{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filedownIp='" + filedownIp + '\'' +
                ", downtime='" + downtime + '\'' +
                '}';
    }
}
