package org.tym.blinking.norwaylife.dal.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.tym.blinking.norwaylife.dal.po.PhotoPath;

import java.util.List;

/**
 * Created by tangtomorrow on 2017/2/28.
 */
@Repository
public interface PhotoPathDAO {

    @Select("SELECT id,file_name AS fileName,file_path AS filePath,insert_time AS insertTime,update_time AS updateTime FROM photo_path")
    List<PhotoPath> getAllPhotoPath();

    @Insert("INSERT INTO photo_path(file_name,file_path) VALUES(#{photoPath.fileName},#{photoPath.filePath})")
    int addPhotoPath(@Param("photoPath") PhotoPath photoPath);

    @Delete("DELETE FROM photo_path WHERE file_name = #{photoPath.fileName} and file_path = #{photoPath.filePath}")
    int deletePhotoPath(@Param("photoPath") PhotoPath photoPath);

    @Delete("DELETE FROM photo_path WHERE id = #{id}")
    int deletePhotoPathById(@Param("id") int id);

}
