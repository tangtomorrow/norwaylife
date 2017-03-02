package org.tym.blinking.norwaylife.dal.dao;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tym.blinking.norwaylife.config.DataConfig;
import org.tym.blinking.norwaylife.config.RootConfig;
import org.tym.blinking.norwaylife.dal.po.PhotoPath;

import java.util.List;

/**
 * Created by tangtomorrow on 2017/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, DataConfig.class})
public class PhotoPathDAOTest {

    @Autowired
    private PhotoPathDAO photoPathDAO;

    @Test
    public void getAllPhotoPath() throws Exception {
        List<PhotoPath> photoPaths = photoPathDAO.getAllPhotoPath();
        Assert.assertNotNull(photoPaths);
    }

    @Test
    public void getPhotoPathById() throws Exception {
        int id = 7;
        PhotoPath photoPath = photoPathDAO.getPhotoPathById(id);
        System.out.println(photoPath);
    }

    @Test
    public void getPhotoPathByFilePath() throws Exception {
        String filePath = "7.jpg";
        PhotoPath photoPath = photoPathDAO.getPhotoPathByFilePath(filePath);
        System.out.println(photoPath);
    }

    @Test
    public void insertPhotoPath() throws Exception {
        int count = photoPathDAO.insertPhotoPath(new PhotoPath("2.jpg", "22.jpg", 10));
        System.out.println(count);
    }

    @Test
    public void insertPhotoPathBatch() throws Exception {
        List<PhotoPath> photoPaths = Lists.newArrayList();
        photoPaths.add(new PhotoPath("5.jpg", "0.jpg", 10));
        photoPaths.add(new PhotoPath("6.jpg", "6.jpg", 10));
        photoPaths.add(new PhotoPath("7.jpg", "7.jpg", 10));
        photoPaths.add(new PhotoPath("8.jpg", "8.jpg", 10));

        int count = photoPathDAO.insertPhotoPathBatch(photoPaths);
        System.out.println(count);
    }

    @Test
    public void updatePhotoPathById() throws Exception {
        PhotoPath photoPath = new PhotoPath(11, "2.jpg", "food/2.jpg", 100L);
        int count = photoPathDAO.updatePhotoPathById(photoPath);
        System.out.println(count);
    }

    @Test
    public void deletePhotoPath() throws Exception {
        int count = photoPathDAO.deletePhotoPath("22.jpg");
        System.out.println(count);
    }

    @Test
    public void deletePhotoPathById() throws Exception {
        int count = photoPathDAO.deletePhotoPathById(6);
        System.out.println(count);
    }

    @Test
    public void deleteAllPhotoPath() throws Exception {
        int count = photoPathDAO.deleteAllPhotoPath();
        System.out.println(count);
    }
}