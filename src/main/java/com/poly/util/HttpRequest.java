package com.poly.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequest {
    /**
     * ��ָ��URL����GET����������
     * 
     * @param url
     *            ���������URL
     * @param param
     *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return URL ������Զ����Դ����Ӧ���
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // �򿪺�URL֮�������
            URLConnection connection = realUrl.openConnection();
            // ����ͨ�õ���������
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // ����ʵ�ʵ�����
            connection.connect();
            // ��ȡ������Ӧͷ�ֶ�
            Map<String, List<String>> map = connection.getHeaderFields();
            // �������е���Ӧͷ�ֶ�
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // ���� BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("����GET��������쳣��" + e);
            e.printStackTrace();
        }
        // ʹ��finally�����ر�������
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * ��ָ�� URL ����POST����������
     * 
     * @param url
     *            ��������� URL
     * @param param
     *            ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
     * @return ������Զ����Դ����Ӧ���
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
            // �����������
            out.print(param);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
    
    public static void sendMsg(String msg,String phone) throws Exception{
    	msg = java.net.URLEncoder.encode(msg,"utf-8");
		String str = "http://www.10690071.com:9007/url_sms/struts/urlCurrentAction!toCurrentSms?userName=admin&compCode=blcm&pwd=5EFA1616F10DBF3F54E4998C571D3235&message=" + msg + "&phone="+phone;
		URL url = new URL(str);  
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();    
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod("POST");  
        urlConnection.connect();
        url.openStream();
    }
    
    
    public static void main(String[] args) throws Exception{
        //���� GET ����
        //String s=HttpRequest.sendGet("http://localhost:6144/Home/RequestString", "key=123&v=456");
        //System.out.println(s);
        
        //���� POST ����
        //String sr=HttpRequest.sendPost("http://tuan.315che.com/xp/service_apply", "carId=594&modelId=1460&name=����&phone=15618842073&area=''&isFootFrom=3");
        //System.out.println(sr);
    	 
    	String msg = "��֤��Ϊ��"+123+"����ӭע��С�ֿ����Ż����̳ǣ���Ǳ��˲���������Ա����š�";
    	msg = java.net.URLEncoder.encode(msg,"utf-8");
		//HttpRequest.sendPost("http://www.10690071.com:9007/url_sms/struts/urlCurrentAction!toCurrentSms", "userName=admin&compCode=blcm&pwd=5EFA1616F10DBF3F54E4998C571D3235&message="+msg+"&phone=15618842073");
		
		
		
		//int num = create();
		//String msg ="�𾴵��û�:" + num+ "�����Ķ�����֤�룬��Ч��30����[����]";
		
		//String e_msg =  java.net.URLEncoder.encode(msg,"utf-8");

		 String str = "http://www.10690071.com:9007/url_sms/struts/urlCurrentAction!toCurrentSms?userName=admin&compCode=blcm&pwd=5EFA1616F10DBF3F54E4998C571D3235&message=" + msg + "&phone=15618842073";
		 URL url = new URL(str);  
         HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();    
         urlConnection.setDoInput(true);
         urlConnection.setRequestMethod("POST");  
         urlConnection.connect();
         url.openStream();
    }
}
