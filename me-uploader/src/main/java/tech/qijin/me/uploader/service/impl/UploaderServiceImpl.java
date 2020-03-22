package tech.qijin.me.uploader.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.me.uploader.config.UploaderProperties;
import tech.qijin.me.uploader.processor.UploaderSelector;
import tech.qijin.me.uploader.service.UploaderService;
import tech.qijin.me.uploader.pojo.UploadedVo;
import tech.qijin.util4j.lang.constant.Const;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.FileUtil;
import tech.qijin.util4j.utils.MAssert;

import java.io.InputStream;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2020-03-22
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@Slf4j
@Service
public class UploaderServiceImpl implements UploaderService {
    @Autowired
    private UploaderSelector uploaderSelector;
    @Autowired
    private UploaderProperties properties;


    @Override
    public UploadedVo uploadFile(String fileName,
                                 Long fileSize,
                                 InputStream inputStream,
                                 Optional<String> sceneOpt) {
        checkInputFile(fileName, fileSize);
        if (!sceneOpt.isPresent()) {
            sceneOpt = Optional.of("file");
        }
        return uploaderSelector.get().upload(sceneOpt, fileName, fileSize, inputStream);
    }

    @Override
    public UploadedVo uploadImage(String fileName,
                                  Long fileSize,
                                  InputStream inputStream,
                                  Optional<String> sceneOpt) {
        checkImage(fileName, fileSize);
        if (!sceneOpt.isPresent()) {
            sceneOpt = Optional.of("img");
        }
        return uploaderSelector.get().upload(sceneOpt, fileName, fileSize, inputStream);
    }

    @Override
    public UploadedVo uploadAudio(String fileName, Long fileSize, InputStream inputStream) {
        return null;
    }

    private void checkInputFile(String fileName, Long fileSize) {
        MAssert.notBlank(fileName, ResEnum.INVALID_PARAM);
        MAssert.isTrue(fileSize != null && fileSize > 0, ResEnum.INVALID_PARAM);
        // check file size upper limit
        MAssert.isTrue(fileSize <= 100 * Const.MB, "上传文件不能超过100MB");
    }

    private void checkImage(String fileName, Long fileSize) {
        checkInputFile(fileName, fileSize);
        // check image suffix
        String suffix = FileUtil.suffix(fileName);
        MAssert.isTrue(Const.JPG.equalsIgnoreCase(suffix)
                        || Const.JPEG.equalsIgnoreCase(suffix)
                        || Const.BMP.equalsIgnoreCase(suffix)
                        || Const.GIF.equalsIgnoreCase(suffix)
                        || Const.PNG.equalsIgnoreCase(suffix),
                "不支持的图片后缀类型");
        // check file size
        MAssert.isTrue(fileSize <= 5 * Const.MB, "上传图片不能超过5MB");
    }
}
