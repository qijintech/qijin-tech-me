package tech.qijin.me.uploader.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.me.uploader.pojo.UploadedVo;
import tech.qijin.sdk.tencent.cloud.TxCosService;
import tech.qijin.sdk.tencent.cloud.pojo.CosUploadVo;

import java.io.InputStream;
import java.util.Optional;

/**
 * 上传腾讯COS
 *
 * @author michealyang
 * @date 2019-11-21
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@Service
public class COSUploader implements Uploader {
    @Autowired
    private TxCosService txCosService;

    @Override
    public UploadedVo upload(Optional<String> sceneOpt, String fileName, Long fileSize, InputStream inputStream) {
        CosUploadVo cosUploadVo = txCosService.uploadFile(sceneOpt, Optional.of(fileName), fileSize, inputStream);
        return UploadedVo.builder()
                .url(cosUploadVo.getUrl())
                .build();
    }
}
