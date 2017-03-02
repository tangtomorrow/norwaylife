package org.tym.blinking.norwaylife.dal.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.tym.blinking.norwaylife.dal.po.PhotoPath;

import java.util.List;

/**
 * Created by tangtomorrow on 2017/2/28.
 */
@Repository
public interface PhotoPathDAO {

    // 获取所有记录
    @Select("SELECT id,file_name AS fileName,file_path AS filePath,file_size AS fileSize,insert_time AS insertTime,update_time AS updateTime FROM photo_path")
    List<PhotoPath> getAllPhotoPath();

    // 根据id获取单条记录
    @Select("SELECT id,file_name AS fileName,file_path AS filePath,file_size AS fileSize,insert_time AS insertTime,update_time AS updateTime FROM photo_path WHERE id = #{id}")
    PhotoPath getPhotoPathById(@Param("id") int id);

    // 根据filePath获取单条记录
    @Select("SELECT id,file_name AS fileName,file_path AS filePath,file_size AS fileSize,insert_time AS insertTime,update_time AS updateTime FROM photo_path WHERE file_path = #{filePath}")
    PhotoPath getPhotoPathByFilePath(@Param("filePath") String filePath);

    // 插入单条记录
    @Insert("INSERT INTO photo_path(file_name,file_path,file_size) VALUES(#{photoPath.fileName},#{photoPath.filePath},#{photoPath.fileSize})")
    int insertPhotoPath(@Param("photoPath") PhotoPath photoPath);

    // 批量插入
    @Insert({
            "<script>",
            "INSERT INTO photo_path(file_name,file_path,file_size)",
            "VALUES",
            "<foreach collection='photoPathList' item='photoPath' separator=','>",
            "(#{photoPath.fileName}, #{photoPath.filePath}, #{photoPath.fileSize})",
            "</foreach>",
            "</script>"
    })
    int insertPhotoPathBatch(@Param("photoPathList") List<PhotoPath> photoPathList);

    // 根据id更新
    @Update("UPDATE photo_path SET file_name=#{photoPath.fileName},file_path=#{photoPath.filePath},file_size=#{photoPath.fileSize} WHERE id=#{photoPath.id}")
    int updatePhotoPathById(@Param("photoPath") PhotoPath photoPath);

    // 根据path删除
    @Delete("DELETE FROM photo_path WHERE file_path = #{filePath}")
    int deletePhotoPath(@Param("filePath") String filePath);

    // 根据id删除
    @Delete("DELETE FROM photo_path WHERE id = #{id}")
    int deletePhotoPathById(@Param("id") int id);

    // 删除全部记录
    @Delete("DELETE FROM photo_path WHERE id >= 0")
    int deleteAllPhotoPath();

}
