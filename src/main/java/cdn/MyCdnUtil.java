package cdn;

import java.util.Date;
import java.util.Random;
import java.util.TreeMap;

import cdn.qcloud.QcloudApiModuleCenter;
import cdn.qcloud.Module.Cdn;

public class MyCdnUtil {

	// 刷新CDN
	public static String flushCdn(String urls[]) {
		TreeMap<String, Object> config = new TreeMap<String, Object>();
		config.put("SecretId", "AKIDjuY2k9fpg6HZvtwav3Ce1d3x4nRC5GPA");
		config.put("SecretKey", "xr1yY0hqR7DL8cVrjWKpG8jOPeaqTUQm");
		config.put("RequestMethod", "GET");
		config.put("DefaultRegion", "sh");
		QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Cdn(), config);
		TreeMap<String, Object> params = new TreeMap<String, Object>();
		String message = "";
		try {
			params.put("Nonce", randomInt());
			params.put("SecretId", "AKIDjuY2k9fpg6HZvtwav3Ce1d3x4nRC5GPA");
			params.put("Action", "RefreshCdnUrl");
			params.put("Timestamp", (new Date().getTime() + "").substring(0, 10));
			for (int i = 0; i < urls.length; i++) {
				params.put("urls." + i, urls[i]);
			}
			message = module.call("RefreshCdnUrl", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	public static int randomInt() {
		int i = 0;
		Random r = new Random();
		i = r.nextInt(10000);
		return i;
	}

}
