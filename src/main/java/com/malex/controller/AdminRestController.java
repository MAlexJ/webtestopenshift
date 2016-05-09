package com.malex.controller;

import com.malex.model.enums.ImageType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
public class AdminRestController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/admin/image", method = RequestMethod.POST)
    public void admin_image_POST(@RequestParam("file") CommonsMultipartFile file,
                          @RequestParam("type") ImageType type) {
        if (!file.isEmpty()) {
            System.err.println(file.getOriginalFilename());
            System.err.println(type.toString());
        }
    }
}
