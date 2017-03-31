package com.danmo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danmo.utils.DateTimeUtil;
import com.danmo.utils.Json;
import com.danmo.utils.PropertiesUtil;


@Controller  
public class UploadController {

	private final static Logger log= Logger.getLogger(UploadController.class);
	
	
	@RequestMapping( value = "/upload", method = RequestMethod.POST )  
    @ResponseBody  
    public void upload( HttpServletRequest request ){  
      //  Server server = new Server();  
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;  
        Map<String, Object> result = null;  
        try  
        {  
            MultipartFile file = mRequest.getFile( "imageFile" );  
            String fileName = file.getOriginalFilename();  
            String serverCardId = mRequest.getParameter( "serverCardId" );  
          
                String strFilePath = "D:/" + "upload/photo/";//将文件保存到本地路径  
                String serverPhotoSrc = fileSaveSrc( file,  
                        serverCardId, strFilePath );//将文件保存，并返回文件名  
        }  catch ( IOException e )  
        {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch ( Exception e )  
        {  
            e.printStackTrace();  
        }  
    }  
	    
	    
	    public static String fileSaveSrc( MultipartFile file, String fileName,String fileSrc ) throws IOException  
	    {  
	        String fileOriginalName = file.getOriginalFilename();  
	        String fileType = fileOriginalName  
	                    .substring( fileOriginalName.lastIndexOf( "." ) );//得到文件后缀名  
			return fileType;
	              
	        /* String tempName = fileName + fileType;<span style="font-family: Arial, Helvetica, sans-serif;">// 使用传入名称替换图片原本名称，防止乱码以及覆盖其他文件问题</span>  
	   
	           File uploadfile = new File( fileSrc + tempName );//将文件重新组装起来  
	            if ( !uploadfile.exists() )  
	            {  
	                uploadfile.mkdirs();//创建文件  
	            }  
	            file.transferTo( uploadfile );//将文件上传保存  
	            return tempName;//成功返回文件名  
	      */
	   
	    }  
	    
	    
		/**
		 * 上传图片
		 */
		@ResponseBody
		@RequestMapping(value="/subject/fileUpload")
		public Json fileUpload(@RequestParam MultipartFile myfiles, HttpServletRequest request, HttpServletResponse response,String name) throws IOException{
			 Json j = new Json();
			 System.out.println(name);
			 String logoRealPathDir = request.getSession().getServletContext()
	                 .getRealPath("/");
			//for(MultipartFile myfile : myfiles){
			String originalFilename = myfiles.getOriginalFilename();
			if("".equals(originalFilename)||originalFilename==null){
				j.setSuccess(false);
		        j.setMsg("上传失败！");
				return j;
			}
			String serverName = PropertiesUtil.readValue("/pictureserver.properties", "url");
	    	String spath = PropertiesUtil.readValue("/pictureserver.properties", "path");
	    	String filePath = DateTimeUtil.getSystemDateTime1()+"/";
			String path = spath+filePath;// 路径+文件夹名称
	        String newName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
	        String finalName = new Date().getTime()+"."+newName;  
	        System.out.println(path);  
	        System.out.println("http://"+serverName+path+finalName);
			try {
				File targetFile = new File(path, finalName);
				 if(!targetFile.exists()){  
			            targetFile.mkdirs();  
			        }  
				//FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, originalFilename));
				myfiles.transferTo(targetFile);  
			} catch (IOException e) {
				System.out.println("文件[" + originalFilename + "]上传失败");
				e.printStackTrace();
				j.setSuccess(false);
		        j.setMsg("上传失败！");
				return j;
			}
			j.setSuccess(true);
			j.setObj("http://"+serverName+"/"+filePath+finalName);
	        j.setMsg("上传成功！");
			return j;
		}
		
	    
}
