package tech.qijin.me.uploader.server.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.qijin.me.uploader.service.UploaderService;
import tech.qijin.util4j.web.pojo.ResultVo;

import java.io.*;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2020-03-22
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@RestController
@RequestMapping("/api/v1/me/uploader")
public class UploaderController {
    @Autowired
    private UploaderService uploaderService;

    @ApiOperation("上传文件，单个文件大小限制在100MB以内")
    @PostMapping("/file")
    public ResultVo uploadFile(@RequestParam("file") MultipartFile file, @RequestParam(required = false) String scene) throws IOException {
        return ResultVo.instance()
                .data(uploaderService.uploadFile(file.getOriginalFilename(), file.getSize(), file.getInputStream(), Optional.ofNullable(scene)));
    }

    @ApiOperation("上传图片，单个图片大小限制在5MB以内，支持的格式有jpg/jpeg/png/bmp/gif")
    @PostMapping("/image")
    public ResultVo uploadImage(@RequestParam("file") MultipartFile file, @RequestParam(required = false) String scene) throws IOException {
        return ResultVo.instance()
                .data(uploaderService.uploadImage(file.getOriginalFilename(), file.getSize(), file.getInputStream(), Optional.ofNullable(scene)));
    }

    @ApiOperation("上传音频，")
    @PostMapping("/audio")
    public ResultVo uploadAudio(@RequestParam("file") MultipartFile file) throws IOException {
        return null;
    }

    @PostMapping("/video")
    public ResultVo uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        return null;
    }
}
