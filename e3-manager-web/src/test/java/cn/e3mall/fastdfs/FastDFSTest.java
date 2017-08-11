package cn.e3mall.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class FastDFSTest {
	
	@Test
	public void testUploadFile() throws Exception{
		ClientGlobal.init("D:/框架工作空间/store/e3-manager-web/src/main/resources/conf/client.conf");
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageClient storageClient = new StorageClient(trackerServer, null);
		String[] strings = storageClient.upload_file("D:/框架/商城/day01/01.教案-3.0/01.参考资料/广告图片/9a80e2d06170b6bb01046233ede701b3.jpg", "jpg", null);
		for (String string : strings) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testFastDfSClient() throws Exception{
		//创建一个FastDFSClient对象
		FastDFSClient fastDFSClient = new FastDFSClient("D:/框架工作空间/store/e3-manager-web/src/main/resources/conf/client.conf");
		//使用对象上传文件,返回文件路径
		String result = fastDFSClient.uploadFile("D:/框架/商城/day01/01.教案-3.0/01.参考资料/广告图片/f5fe1218bf3098984ec744bf993ee2fd.jpg");
		//打印结果
		System.out.println(result);
	}
}
