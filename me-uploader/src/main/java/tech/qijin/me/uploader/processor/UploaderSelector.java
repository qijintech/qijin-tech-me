package tech.qijin.me.uploader.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.me.uploader.config.UploaderProperties;

/**
 * @author michealyang
 * @date 2019-11-21
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@Service
public class UploaderSelector {
    @Autowired
    private UploaderProperties properties;
    @Autowired
    private COSUploader cosUploader;
    @Autowired
    private DiskUploader diskUploader;

    /**
     * 根据配置选取uploader
     *
     * @return
     */
    public Uploader get() {
        switch (properties.getProcessor()) {
            case "disk":
            case "DISK":
                return diskUploader;
            case "cos":
            case "COS":
            default:
                return cosUploader;
        }
    }
}
