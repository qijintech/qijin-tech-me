package tech.qijin.me.uploader.service;

import tech.qijin.me.uploader.pojo.MultiUploadResp;

/**
 * @author michealyang
 * @date 2020-03-22
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
public interface MultiUploaderService {
    MultiUploadResp uploadFile();

    MultiUploadResp uploadImage();
}
