package cn.e3mall.solrj;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrCloudTest {

	@Test
	public void testCloudSolrServer() throws Exception {
		// 1、创建一个SolrServer对象，连接集群使用CloudSolrServer类。
		CloudSolrServer solrServer = new CloudSolrServer("192.168.25.128:2181,192.168.25.128:2182,192.168.25.128:2183");
		// 2、构造参数zkHost，zookeeper的地址列表使用逗号分隔。
		// 3、设置属性defaultCollection，如果不设置回抛异常。
		solrServer.setDefaultCollection("collection2");
		// 4、创建一个SolrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		// 5、向文档中添加域
		document.addField("id", "1");
		document.addField("item_title", "测试商品标题01");
		document.addField("item_price", 100);
		// 6、把文档添加到索引库
		solrServer.add(document);
		// 7、提交
		solrServer.commit();
	}
}
