# me-uploader

## 资源上传服务

资源上传方式有两种：
* 客户端直接上传
* 客户端先上传服务器，再上传云服务
* 表单上传

支持功能有：
* 客户端上传 - 获取普通上传token
* 客户端上传 - 获取分片上传token
* 服务器上传 - 普通上传
* 服务器上传 - 分片上传
* web上传 - 表单上传

附加功能：
* 拉取外网资源到自己平台
* 上传文件大小限制
* 上传图片压缩

#### 简单文件上传
##### 上传种类
* 普通文件: `/uploader/file`。支持任意文件类型上传，不能大于大小100MB。
* 图片文件: `/uploader/image`。图片文件上传，不能大于5MB，仅支持如下文件类型：
    * `jpg`
    * `jpeg`
    * `bmp`
    * `png`
    * `gif`
* 音频文件
* 视频文件

#### 配置文件上传的位置
##### 配置文件

```yaml
me:
  uploader:
    processor: cos
```

#### 可选值
* `cos`: 腾讯云-对象存储
* `oss`: 阿里云-对象存储
* `disk`: 本地磁盘存储

#### 配置文件上传的bucket和host等
##### 配置文件
```yaml
sdk:
  tencent:
    cloud:
      host: http://file.qijin.tech
      bucket: file-1300635595
      region: ap-chengdu
      routes[0]:
        scene: file
        host: http://file.qijin.tech
        bucket: file-1300635595
        region: ap-chengdu
      routes[1]:
        scene: img
        host: http://img.qijin.tech
        bucket: img-1300635595
        region: ap-beijing
```
* 支持自定义场景。自定义场景值对应请求参数中的`scene`参数。如"http://api/v1/me/uploader/file?scene=test"，参数`scene`的值是`test`，那么对应的host和bucket配置如下：
```yaml
sdk:
  tencent:
    cloud:
      routes[0]:
        scene: test
        host: http://test.qijin.tech
        bucket: test-1300635595
        region: ap-chengdu
```
* 当请求参数中没有`scene`时，根据url寻找配置，如
    *  `/api/v1/me/uploader/file`的`scene`的默认值是`file`
    *  `/api/v1/me/uploader/image`的`scene`的默认值是`img`
