package org.tym.blinking.norwaylife.dal.po;

import com.google.common.base.MoreObjects;

import java.sql.Timestamp;

/**
 * Created by tangtomorrow on 2017/2/27.
 */
public class PhotoPath {
    private int id;
    private String fileName;
    private String filePath;
    private long fileSize;
    private Timestamp insertTime;
    private Timestamp updateTime;

    public PhotoPath() {
    }

    public PhotoPath(String fileName, String filePath, long fileSize) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    public PhotoPath(int id, String fileName, String filePath, long fileSize, Timestamp insertTime, Timestamp updateTime) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.insertTime = insertTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("fileName", fileName)
                .add("filePath", filePath)
                .add("fileSize", fileSize)
                .add("insertTime", insertTime)
                .add("updateTime", updateTime)
                .toString();
    }
}
