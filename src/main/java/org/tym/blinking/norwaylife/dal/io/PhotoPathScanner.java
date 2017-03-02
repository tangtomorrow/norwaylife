package org.tym.blinking.norwaylife.dal.io;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.tym.blinking.norwaylife.dal.po.PhotoPath;

import java.io.File;
import java.util.List;

/**
 * Created by tangtomorrow on 2017/2/27.
 */
@Component
public class PhotoPathScanner {

    public List<PhotoPath> scanPath(String rootPath) {
        Preconditions.checkNotNull(rootPath, "root path is null");

        File rootDir = new File(rootPath);

        Preconditions.checkState(rootDir.exists(), "rootDir not exists");
        Preconditions.checkState(rootDir.isDirectory(), "rootDir is not directory");

        List<PhotoPath> photoPaths = Lists.newArrayList();

        scanRecursive(rootPath, rootDir, photoPaths);

        return photoPaths;
    }

    private void scanRecursive(String rootPath, File rootDir, List<PhotoPath> photoPaths) {
        if (rootDir.isDirectory()) {
            File[] files = rootDir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    scanRecursive(rootPath, file, photoPaths);
                } else {
                    photoPaths.add(genPhotoPath(rootPath, file));
                }
            }
        } else {
            photoPaths.add(genPhotoPath(rootPath, rootDir));
        }
    }

    private PhotoPath genPhotoPath(String rootPath, File file) {
        PhotoPath photoPath = new PhotoPath();
        photoPath.setFileName(file.getName());
        photoPath.setFilePath(photoRelativePath(rootPath, file.getAbsolutePath()));
        photoPath.setFileSize(file.length());

        return photoPath;
    }

    private String photoRelativePath(String rootPath, String absolutePath) {
        Preconditions.checkNotNull(rootPath, "root path is null");
        Preconditions.checkNotNull(absolutePath, "absolute path is null");

        absolutePath = absolutePath.replace("\\", "/");
        rootPath = rootPath.replace("\\", "/");

        Preconditions.checkArgument(rootPath.length() <= absolutePath.length(), "absolute path is short than root path");
        Preconditions.checkArgument(absolutePath.indexOf(rootPath) == 0, "root path is not parent path of absolute path");

        return absolutePath.substring(rootPath.length());
    }

}
