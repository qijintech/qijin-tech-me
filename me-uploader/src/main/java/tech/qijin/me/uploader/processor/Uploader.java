package tech.qijin.me.uploader.processor;

import tech.qijin.me.uploader.pojo.UploadedVo;

import java.io.InputStream;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2019-11-21
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
public interface Uploader {
    UploadedVo upload(Optional<String> sceneOpt, String fileName, Long fileSize, InputStream inputStream);
}
