package com.kryose.kryose.Controller;


import com.kryose.kryose.Util.JwtUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
public class ApiServices {
    @Autowired
    private JwtUtil jwtUtil;

    Logger logger= LoggerFactory.getLogger(ApiServices.class);

    @PostMapping(value = "/ml_process" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> ml_process(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //get info from auth header so as to cut points from user account
        String username = null;
        String jwt = null;
        final String authorizationHeader = request.getHeader("Authorization");
        jwt = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwt);
        logger.error(username);
        //END

        File convertFile = new File("./image/"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();

        String filename = "./image/"+file.getOriginalFilename();
        File file1 = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file1));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(file1.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;

    }


}
