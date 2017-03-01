package org.tym.blinking.norwaylife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tym.blinking.norwaylife.dal.io.PhotoPathScanner;
import org.tym.blinking.norwaylife.dal.po.PhotoPath;

import java.util.List;

/**
 * Created by tangtomorrow on 2017/2/28.
 */
@Repository
public class PhotoPathService {

    @Autowired
    private PhotoPathScanner scanner;

    public List<PhotoPath> getPhotoPathList(String rootDir) {
        return scanner.scanPath(rootDir);
    }

}
