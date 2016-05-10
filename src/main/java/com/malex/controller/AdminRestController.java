package com.malex.controller;

import com.malex.model.dto.ImageDTO;
import com.malex.model.enums.ImageType;
import com.malex.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Controller
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private ImageService imageService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/image", method = RequestMethod.POST)
    public void admin_image_POST(@RequestParam("file") CommonsMultipartFile file,
                                 @RequestParam("type") ImageType type) {
        if (!file.isEmpty() && type != null) {
            ImageDTO dto = new ImageDTO();
            dto.setAvailable(true);
            dto.setName(file.getOriginalFilename());
            dto.setType(type);
            dto.setImg(file.getBytes());
            imageService.saveDTO(dto);
            System.err.println(file.getOriginalFilename()); //TODO log
            System.err.println(type.toString()); //TODO log
        }
    }
}
