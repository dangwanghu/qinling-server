package com.tfssoft.qinling.base.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tfssoft.qinling.web.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "File" }, description = "Api list")
@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

	@ApiOperation(value = "上传文件", httpMethod = "POST")
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/*", headers = "content-type=multipart/form-data")
	public void postFile(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String newFileName = new Date().getTime() + "_" + file.getOriginalFilename();
			String newFilePath = Constants.IMG_STORE + newFileName;
			File newFile = new File(newFilePath);
			file.transferTo(newFile);
			writeJson(Constants.IMG_PATH + newFileName, response);
		} catch (Exception e) {
			e.printStackTrace();
			error("上传出错！", response);
		}
	}

}
