package tech.qijin.me.uploader.processor;

import org.springframework.stereotype.Service;
import tech.qijin.me.uploader.pojo.UploadedVo;

import java.io.InputStream;
import java.util.Optional;

/**
 * 本地磁盘存储
 *
 * @author michealyang
 * @date 2019-11-21
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@Service
public class DiskUploader implements Uploader {
    @Override
    public UploadedVo upload(Optional<String> sceneOpt, String fileName, Long fileSize, InputStream inputStream) {
        return null;
    }
}
