package org.tym.blinking.norwaylife.dal.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
    public void addPhotoPath() throws Exception {
        int count = photoPathDAO.addPhotoPath(new PhotoPath("xxxx.jpg", "xxxx.jpg"));
        System.out.println(count);
    }

    @Test
    public void deletePhotoPath() throws Exception {
        int count = photoPathDAO.deletePhotoPath(new PhotoPath("xxxx.jpg", "xxxx.jpg"));
        System.out.println(count);
    }

    @Test
    public void deletePhotoPathById() throws Exception {
        int count = photoPathDAO.deletePhotoPathById(5);
        System.out.println(count);
    }
}