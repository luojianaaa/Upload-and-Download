package com.example.myprogress.repository;

import com.example.myprogress.domain.fileinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface fileinfoRepository extends JpaRepository<fileinfo,Integer> {
    //插入
    @Transactional
    @Modifying
    @Query(value ="insert INTO fileinfo(filename,uploadtime,filetype,uploadip,filesize) value (?1,?2,?3,?4,?5)", nativeQuery = true)
    public void insertfile(String filename,String uploadtime,String filetype,String uploadip,String filesize);

    //查询
    @Query(value ="select * from fileinfo",nativeQuery = true)
    public List<fileinfo> select();

    //删除
    @Query("select  id from fileinfo where filename=?1")
    public Integer findByFilename(String filename);
}
