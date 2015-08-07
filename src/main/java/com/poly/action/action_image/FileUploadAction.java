package com.poly.action.action_image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;

import net.sf.json.JSONArray;

import com.poly.action.MyActionSupport;
import com.poly.util.IconUtil;
import com.poly.util.ImageUtil;
import com.poly.util.MyConfig;
import com.poly.util.TimeUtils;

public class FileUploadAction extends MyActionSupport{
	
	private String username;
    
	    //注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
		private File file;

		//提交过来的file的名字
	    private String fileFileName;
	    
	    //提交过来的file的MIME类型
	    private String fileContentType;

	    public String getUsername()
	    {
	        return username;
	    }

	    public void setUsername(String username)
	    {
	        this.username = username;
	    }
	    
	    @Override
	    public String execute() throws Exception
	    {
	        String root = MyConfig.html_pic_upload_path;
	        
	        InputStream is = new FileInputStream(file);
	        
	        String savePath = root+TimeUtils.getNowDate();
	        if(fileContentType.equals("application/x-shockwave-flash")){
	        	savePath = savePath +"/swf";
	        }
	        File dir = new File(savePath);
	        System.out.println(savePath);
			if (!dir.exists())
				dir.mkdirs();
			
			String newFilename = UUID.randomUUID().toString()+fileFileName.substring(fileFileName.lastIndexOf('.'),fileFileName.length());
	        
	        File newFile = new File(savePath, newFilename);
	        
	        OutputStream os = new FileOutputStream(newFile);
	        
	        System.out.println("fileFileName: " + fileFileName);

		    // 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
	        System.out.println("file: " + file.getName());
	        System.out.println("file: " + file.getPath());
	        
	        byte[] buffer = new byte[500];
	        int length = 0;
	        
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
	        if(!fileContentType.equals("application/x-shockwave-flash")){
	        	 String iconName = "";
	 	        for (int j = 0; j < IconUtil.iconList().size(); j++) {
	 				iconName = ImageUtil.zoomToIcon(newFile, IconUtil.iconList().get(j).getWidth(), IconUtil.iconList()
	 						.get(j).getHeigth());
	 			}
	 	       System.out.println("file: " + iconName);
	        }
	        os.close();
	        is.close();
	        HashMap<String,String> map = new HashMap<String,String>();
	        map.put("uploadPath", MyConfig.img_che_url+savePath.replace(root, "upload/")+"/"+newFilename);//显示图片路径;
	        map.put("imgPath", savePath.replace(root, "ct1/upload/")+"/"+newFilename);//存入数据库路径;
	        map.put("oldImageName",fileFileName);//原图片名
	        JSONArray json = JSONArray.fromObject(map);
	        setAjax(json.toString());
	        return AJAX;
	    }
	    
		

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}

		public String getFileFileName() {
			return fileFileName;
		}

		public void setFileFileName(String fileFileName) {
			this.fileFileName = fileFileName;
		}

		public String getFileContentType() {
			return fileContentType;
		}

		public void setFileContentType(String fileContentType) {
			this.fileContentType = fileContentType;
		}


}
