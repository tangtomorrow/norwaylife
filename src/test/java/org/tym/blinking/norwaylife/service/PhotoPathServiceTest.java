package org.tym.blinking.norwaylife.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tym.blinking.norwaylife.common.util.PropertyUtil;
import org.tym.blinking.norwaylife.config.DataConfig;
import org.tym.blinking.norwaylife.config.RootConfig;

/**
 * Created by tangtomorrow on 2017/3/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, DataConfig.class})
public class PhotoPathServiceTest {

    @Autowired
    private PhotoPathService photoPathService;

    @Test
    public void rebuildPhotoPathIndexByRootPath() throws Exception {
        int count = photoPathService.rebuildPhotoPathIndexByRootPath(PropertyUtil.getString("photo.dir"));
        System.out.println(count);
    }

}