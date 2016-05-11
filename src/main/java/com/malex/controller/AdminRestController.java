package com.malex.controller;

import com.malex.model.dto.ImageDTO;
import com.malex.model.dto.ImageNamesAndIdsDTO;
import com.malex.model.enums.ImageType;
import com.malex.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private ImageService imageService;

    // ********************   Image *********************

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
        }
    }

    @RequestMapping(path = "/image", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImageNamesAndIdsDTO> admin_image_GET() {
        return imageService.findAllNamesDTO();
    }

    @RequestMapping(path = "/image/{id}", method = RequestMethod.DELETE)
    public void admin_image_DELETE(@PathVariable Long id) {
        if (id > 0) {
            imageService.delete(id);
        }
    }

    @RequestMapping(path = "/image/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ImageDTO admin_image_GET(@PathVariable Long id) {
        if (id > 0) {
            return imageService.findByIdDTO(id);
        }
        return null;
    }

    // ********************   Article  *********************
    @RequestMapping(path = "/article_image", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImageNamesAndIdsDTO> admin_article_image_GET() {
        return imageService.findByIsAvailableAndType(true, ImageType.ARTICLE);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/article", method = RequestMethod.POST)
    public void admin_article_POST(@RequestParam("title") String title,
                                   @RequestParam("description") String description,
                                   @RequestParam("text") String text,
                                   @RequestParam("imgId") Long id) {
        if (!title.equals("") && !description.equals("") && !text.equals("") && id > 0) {
            System.err.println("title: " + title);
            System.err.println("description: " + description);
            System.err.println("text: " + text);
            System.err.println("id: " + id);
        }
    }

}
