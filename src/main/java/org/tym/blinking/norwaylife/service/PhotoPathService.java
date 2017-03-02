package org.tym.blinking.norwaylife.service;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tym.blinking.norwaylife.dal.dao.PhotoPathDAO;
import org.tym.blinking.norwaylife.dal.io.PhotoPathScanner;
import org.tym.blinking.norwaylife.dal.po.PhotoPath;

import java.util.List;

/**
 * Created by tangtomorrow on 2017/2/28.
 */
@Service
public class PhotoPathService {

    @Autowired
    private PhotoPathScanner scanner;

    @Autowired
    private PhotoPathDAO photoPathDAO;

    // TODO 增加事务支持
    public int rebuildPhotoPathIndexByRootPath(String rootDir) {
        Preconditions.checkNotNull(rootDir, "rootDir is null");

        // 删除现有的目录索引
        int originIndexCount = photoPathDAO.deleteAllPhotoPath();

        // 扫描目录并获取文件列表
        List<PhotoPath> photoPaths = scanner.scanPath(rootDir);

        // 将现在的列表更新到数据库中
        int currentIndexCount = photoPathDAO.insertPhotoPathBatch(photoPaths);

        return currentIndexCount;
    }

}
