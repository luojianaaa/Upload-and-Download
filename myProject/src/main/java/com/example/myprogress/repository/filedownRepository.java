package com.example.myprogress.repository;

import com.example.myprogress.domain.filedownload;
import com.example.myprogress.domain.fileinfo;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface filedownRepository extends JpaRepository<filedownload,Integer> {
    @Transactional
    @Modifying
    @Query(value ="insert INTO filedownload(filename,filedown_ip,downtime) value (?1,?2,?3)", nativeQuery = true)
    public void addfileinfo(String filename,String filedownIp,String downtime);

    //查询
    @Query(value ="select * from filedownload",nativeQuery = true)
    public List<filedownload> query();

    //删除
    @Query("select  id from fileinfo where filename=?1")
    public Integer findByFilename(String filename);
}
