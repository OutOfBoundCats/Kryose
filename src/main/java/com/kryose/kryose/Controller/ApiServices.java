package com.kryose.kryose.Controller;


import com.kryose.kryose.Util.JwtUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
public class ApiServices {
    @Autowired
    private JwtUtil jwtUtil;

    Logger logger= LoggerFactory.getLogger(ApiServices.class);

    @PostMapping(value = "/ml_process" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String ml_process(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //get info from auth header so as to cut points from user account
        String username = null;
        String jwt = null;
        final String authorizationHeader = request.getHeader("Authorization");
        jwt = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwt);
        logger.error(username);
        //END
        //get the file from request body and save it
        File convertFile = new File("./image/"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        //end
        //upload image to s3 bucket then pass url to flask app for processing

        return "url of return image";

    }

    @PostMapping(value = "/multi_ml_process" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String multi_ml_process(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException {
        //get info from auth header so as to cut points from user account
        String username = null;
        String jwt = null;
        final String authorizationHeader = request.getHeader("Authorization");
        jwt = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwt);
        logger.error(username);
        //END
        //get the files from request body and save it
        for (MultipartFile indi_file : files){
            logger.error("inside for loop");
            File convertFile = new File("./image/"+indi_file.getOriginalFilename());
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(indi_file.getBytes());
            logger.error("inside for loop file written");
            fout.close();

        }


        //end
        //upload image to s3 bucket then pass url to flask app for processing

        return "url of return images";

    }




}
