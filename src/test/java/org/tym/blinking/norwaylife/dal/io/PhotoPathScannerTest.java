package org.tym.blinking.norwaylife.dal.io;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tym.blinking.norwaylife.common.util.PropertyUtil;
import org.tym.blinking.norwaylife.config.RootConfig;

/**
 * Created by tangtomorrow on 2017/2/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class PhotoPathScannerTest {

    @Autowired
    private PhotoPathScanner scanner;

    @Test
    public void scanPath() throws Exception {
        String rootPath = "C:/Work/Intellij/norwaylife/photo/";
        scanner.scanPath(rootPath);
    }

    @Test(expected = IllegalStateException.class)
    public void scanPathNoExists() throws Exception {
        String rootPath = "C:/Work/Intellij/norwaylife/notexists/";
        scanner.scanPath(rootPath);
    }

    @Test(expected = IllegalStateException.class)
    public void scanPathNotFile() throws Exception {
        String rootPath = "C:/Work/Intellij/norwaylife/sql/schema.sql";
        scanner.scanPath(rootPath);
    }

    @Test
    public void photoRelativePath() {
        String rootPath = PropertyUtil.getString("photo.dir");
        String absPath = "C:\\Work\\Intellij\\norwaylife\\photo\\food\\noodle.jpg".replace("\\", "/");

        int index = absPath.indexOf(rootPath);
        if (index != 0) {
            System.out.println("error");
            return;
        }

        String subStr = absPath.substring(rootPath.length());
        System.out.println(subStr);
    }

}