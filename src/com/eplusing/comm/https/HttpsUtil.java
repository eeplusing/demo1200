package com.eplusing.comm.https;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.junit.Test;

public class HttpsUtil {
	public static void main(String[] args) throws IOException {
		String uri = "https://f.hiphotos.baidu.com/image/pic/item/960a304e251f95cacc952852c5177f3e660952f5.jpg";
		byte[] bytes = HttpsUtil.doGet(uri);
		FileOutputStream fos = new FileOutputStream("file/金丝皇菊.jpg");
		fos.write(bytes);
		fos.close();
		System.out.println("done!");
	}

	private static final class DefaultTrustManager implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}

	private static HttpsURLConnection getHttpsURLConnection(String uri, String method) throws IOException {
		SSLContext ctx = null;
		DefaultTrustManager trustManager = new DefaultTrustManager();
		/*trustManager.checkClientTrusted(chain, authType);
		trustManager.checkServerTrusted(chain, authType);*/
		try {
			ctx = SSLContext.getInstance("TLS");
			ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		SSLSocketFactory ssf = ctx.getSocketFactory();

		URL url = new URL(uri);
		HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
		httpsConn.setSSLSocketFactory(ssf);
		httpsConn.setHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});
		httpsConn.setRequestMethod(method);
		httpsConn.setDoInput(true);
		httpsConn.setDoOutput(true);
		return httpsConn;
	}
	
	private static HttpsURLConnection getHttpsURLConnection2(String uri, String method) {
		//创建SSLContext对象，并使用我们指定的信任管理器初始化
		// 创建URL对象
		HttpsURLConnection httpsConn = null;
		try {
			TrustManager[] tm = {new DefaultTrustManager ()};
			SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());

			//从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			//创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
			
			URL reqURL = new URL("https://www.oracle.com/sun/index.html");
			httpsConn = (HttpsURLConnection) reqURL.openConnection();
			
			httpsConn.setSSLSocketFactory(ssf);
			httpsConn.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			});
			httpsConn.setRequestMethod(method);
			httpsConn.setDoInput(true);
			httpsConn.setDoOutput(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpsConn;
	}

	private static byte[] getBytesFromStream(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] kb = new byte[1024];
		int len;
		while ((len = is.read(kb)) != -1) {
			baos.write(kb, 0, len);
		}
		byte[] bytes = baos.toByteArray();
		baos.close();
		is.close();
		return bytes;
	}

	private static void setBytesToStream(OutputStream os, byte[] bytes) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		byte[] kb = new byte[1024];
		int len;
		while ((len = bais.read(kb)) != -1) {
			os.write(kb, 0, len);
		}
		os.flush();
		os.close();
		bais.close();
	}

	public static byte[] doGet(String uri) throws IOException {
		HttpsURLConnection httpsConn = getHttpsURLConnection(uri, "GET");
		return getBytesFromStream(httpsConn.getInputStream());
	}

	public static byte[] doPost(String uri, String data) throws IOException {
		HttpsURLConnection httpsConn = getHttpsURLConnection(uri, "POST");
		setBytesToStream(httpsConn.getOutputStream(), data.getBytes());
		return getBytesFromStream(httpsConn.getInputStream());
	}

	@Test
	public void testPlainHttps() {
		URL reqURL;
		try {
			reqURL = new URL("https://www.oracle.com/sun/index.html");
			// 创建URL对象
			HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();

			/*
			 * 下面这段代码实现向Web页面发送数据，实现与网页的交互访问 httpsConn.setDoOutput(true);
			 * OutputStreamWriter out = new
			 * OutputStreamWriter(huc.getOutputStream(), "8859_1"); 
			 * out.write("……" ); 
			 * out.flush(); 
			 * out.close();
			 */

			// 取得该连接的输入流，以读取响应内容
			InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());
			// 读取服务器的响应内容并显示
			int respInt = insr.read();
			while (respInt != -1) {
				System.out.print((char) respInt);
				respInt = insr.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
