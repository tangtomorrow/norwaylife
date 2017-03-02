package org.tym.blinking.norwaylife.web.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tym.blinking.norwaylife.common.util.PropertyUtil;
import org.tym.blinking.norwaylife.dal.po.PhotoPath;
import org.tym.blinking.norwaylife.service.PhotoPathService;
import org.tym.blinking.norwaylife.web.vo.common.RestResult;
import org.tym.blinking.norwaylife.web.vo.common.ResultCode;

/**
 * Created by tangtomorrow on 2017/3/2.
 */
@RestController
@RequestMapping("/api/photo")
public class PhotoPathController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoPathController.class);

    @Autowired
    private PhotoPathService photoPathService;

    @GetMapping("/rebuild")
    public RestResult<Integer> rebuild() {
        RestResult<Integer> result = new RestResult<Integer>();
        String rootDir = PropertyUtil.getString("photo.dir");

        rebuild(rootDir, result);

        return result;
    }

    @PostMapping("/rebuild")
    public RestResult<Integer> rebuild(@RequestParam String rootDir) {
        RestResult<Integer> result = new RestResult<Integer>();

        rebuild(rootDir, result);

        return result;
    }

    private void rebuild(String rootDir, RestResult<Integer> result) {
        try {
            int count = photoPathService.rebuildPhotoPathIndexByRootPath(rootDir);
            result.setData(count);
            result.setResultCode(ResultCode.SUCCESS);
        } catch (Exception e) {
            LOGGER.error("rebuild photoPath error", e);
            result.setResultCode(ResultCode.ERROR);
            result.setErrorMsg("rebuild photoPath error");
        }
    }
}
