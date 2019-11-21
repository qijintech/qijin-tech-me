package tech.qijin.me.uploader.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.util4j.web.pojo.ResultVo;

/**
 * @author michealyang
 * @date 2019-11-21
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/me/uploader/base")
public class BaseController {
    @GetMapping("/alive")
    public ResultVo alive() {
        return ResultVo.instance().data("Alive");
    }
}
