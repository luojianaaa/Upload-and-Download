package com.example.myprogress.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class time {
    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public String modifyCompany(long size) {
        if (size <= 1024) {
            String format = String.format("%.2f", ((double) size));
            return format + "B";
        } else if (size <= Math.pow(1024, 2)) {
            String format = String.format("%.2f", ((double) size / 1024));
            return format + "KB";
        } else if (size <= Math.pow(1024, 3)) {
            String format = String.format("%.2f", ((double) size / Math.pow(1024, 2)));
            return format + "MB";
        } else if (size <= Math.pow(1024, 4)) {
            String format = String.format("%.2f", ((double) size / Math.pow(1024, 3)));
            return format + "GB";
        } else if (size <= Math.pow(1024, 5)) {
            String format = String.format("%.2f", ((double) size / Math.pow(1024, 4)));
            return format + "TB";
        }
        return size + "";
    }


}

