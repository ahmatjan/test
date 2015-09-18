package ons;

import java.util.Properties;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;

/**
 * @ClassName: ConsumerClient
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年9月16日 下午4:59:27
 */
public class ConsumerClient {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.ConsumerId, "CID_15454wd");
		properties.put(PropertyKeyConst.AccessKey, "DjKWsUrgJGpUeDsO");
		properties.put(PropertyKeyConst.SecretKey, "8Achu94AEaJHrWGdDCzDUwnnzl3nLS");
		Consumer consumer = ONSFactory.createConsumer(properties);
		consumer.subscribe("nos_test_shenny", "*", new MessageListener() {

			@Override
			public Action consume(Message message, ConsumeContext context) {

				System.err.println(new String(message.getBody()));
				Action a=Action.ReconsumeLater;
				System.err.println(a.name());
				return Action.CommitMessage;
			}

		});
		consumer.start();
	}

}
