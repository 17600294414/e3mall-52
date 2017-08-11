package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

/**
 * 
 * @ClassName: PictureController
 * @Description: 文件上传Controller
 * @author 王铁臻
 * @date 2017年8月9日 上午10:24:15
 * @version V1.0
 */
@Controller
public class PictureController {

	@Value("${image.server.url}")
	private String imageServerUrl;

	@RequestMapping(value = "/pic/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {

		try {
			// 把文件上传到图片服务器
			// 1）取文件原始名称
			String originalFilename = uploadFile.getOriginalFilename();
			// 2）取文件扩展名
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			// 3）创建一个FastDFSClient对象
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			// 4）上传文件，返回url
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			// 5、把返回的url拼接成完成的url。
			url = imageServerUrl + url;
			// 6、创建一个map
			Map result = new HashMap<>();
			// 7、把返回的结果添加到map中
			result.put("error", 0);
			result.put("url", url);
			// 8、返回map
			String json = JsonUtils.objectToJson(result);
			return json;

		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			// 7、把返回的结果添加到map中
			result.put("error", 1);
			result.put("message", "图片上传失败");
			// 8、返回map
			String json = JsonUtils.objectToJson(result);
			return json;

		}
	}

}
