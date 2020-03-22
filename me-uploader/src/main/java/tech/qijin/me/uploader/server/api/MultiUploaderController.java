package tech.qijin.me.uploader.server.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.util4j.web.pojo.ResultVo;

/**
 * @author michealyang
 * @date 2020-03-22
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@RestController
@RequestMapping("/api/v1/me/uploader/multi")
public class MultiUploaderController {

    @PostMapping("/file")
    public ResultVo uploadFile() {
        return null;
    }

    @PostMapping("/img")
    public ResultVo uploadImage() {
        return null;
    }

    @PostMapping("/audio")
    public ResultVo uploadAudio() {
        return null;
    }

    @PostMapping("/video")
    public ResultVo uploadVideo() {
        return null;
    }
}
