package com.example.demo.service;

import com.example.demo.service.impl.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceIml implements UploadService {
    @Autowired
    ServletContext app;


    @Override
    public File save(MultipartFile file, String folder) {
        File dir =new File(app.getRealPath("/assets/"+folder));
        if(!dir.exists()){
            dir.mkdir();
        }
        String s = System.currentTimeMillis()+file.getOriginalFilename();
        String name = Integer.toHexString(s.hashCode())+s.substring(s.lastIndexOf("."));

        try{
            File saveFile = new File(dir,name);
            file.transferTo(saveFile);
            System.out.println(saveFile.getAbsolutePath());
            return saveFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
