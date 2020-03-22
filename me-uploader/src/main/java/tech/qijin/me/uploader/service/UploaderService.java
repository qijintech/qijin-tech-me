package tech.qijin.me.uploader.service;

import tech.qijin.me.uploader.pojo.UploadedVo;

import java.io.InputStream;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2020-03-22
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
public interface UploaderService {
    UploadedVo uploadFile(String fileName,
                          Long fileSize,
                          InputStream inputStream,
                          Optional<String> sceneOpt);

    UploadedVo uploadImage(String fileName,
                           Long fileSize,
                           InputStream inputStream,
                           Optional<String> sceneOpt);

    UploadedVo uploadAudio(String fileName, Long fileSize, InputStream inputStream);
}
