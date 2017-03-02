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

    // 获取所有记录
    @Select("SELECT id,file_name AS fileName,file_path AS filePath,insert_time AS insertTime,update_time AS updateTime FROM photo_path")
    List<PhotoPath> getAllPhotoPath();

    // 根据id获取单条记录
    @Select("SELECT id,file_name AS fileName,file_path AS filePath,insert_time AS insertTime,update_time AS updateTime FROM photo_path WHERE id = #{id}")
    PhotoPath getPhotoPathById(@Param("id") int id);

    // 根据filePath获取单条记录
    @Select("SELECT id,file_name AS fileName,file_path AS filePath,insert_time AS insertTime,update_time AS updateTime FROM photo_path WHERE file_path = #{filePath}")
    PhotoPath getPhotoPathByFilePath(@Param("filePath") String filePath);

    // 插入单条记录
    @Insert("INSERT INTO photo_path(file_name,file_path) VALUES(#{photoPath.fileName},#{photoPath.filePath})")
    int insertPhotoPath(@Param("photoPath") PhotoPath photoPath);

    // 批量插入
    @Insert({
            "<script>",
            "INSERT INTO photo_path(file_name,file_path)",
            "VALUES",
            "<foreach collection='photoPathList' item='photoPath' separator=','>",
            "(#{photoPath.fileName,jdbcType=VARCHAR}, #{photoPath.filePath,jdbcType=VARCHAR})",
            "</foreach>",
            "</script>"
    })
    int insertPhotoPathBatch(@Param("photoPathList") List<PhotoPath> photoPathList);

    // 根据name和path删除
    @Delete("DELETE FROM photo_path WHERE file_name = #{photoPath.fileName} and file_path = #{photoPath.filePath}")
    int deletePhotoPath(@Param("photoPath") PhotoPath photoPath);

    // 根据id删除
    @Delete("DELETE FROM photo_path WHERE id = #{id}")
    int deletePhotoPathById(@Param("id") int id);

    // 删除全部记录
    @Delete("DELETE FROM photo_path WHERE id >= 0")
    int deleteAllPhotoPath();

}
