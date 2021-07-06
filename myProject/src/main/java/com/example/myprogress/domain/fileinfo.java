package com.example.myprogress.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="fileinfo")
public class fileinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String filename;
    private  String uploadtime;
    private  String filetype;
    private String uploadip;
    private String filesize;

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

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getUploadip() {
        return uploadip;
    }

    public void setUploadip(String uploadip) {
        this.uploadip = uploadip;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    @Override
    public String toString() {
        return "fileinfo{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", uploadtime='" + uploadtime + '\'' +
                ", filetype='" + filetype + '\'' +
                ", uploadip='" + uploadip + '\'' +
                ", filesize='" + filesize + '\'' +
                '}';
    }
}
