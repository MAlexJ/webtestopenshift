package com.malex.service.impl;

import com.malex.model.dto.ImageDTO;
import com.malex.model.dto.ImageNamesAndIdsDTO;
import com.malex.model.entity.ImageEntity;
import com.malex.repository.ImageRepository;
import com.malex.service.ImageService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository repository;

    @Autowired
    private Mapper beanMapper;

    @Override
    public ImageDTO saveDTO(ImageDTO dto) {
        ImageEntity entity = beanMapper.map(dto, ImageEntity.class);
        entity = save(entity);
        return beanMapper.map(entity, ImageDTO.class);
    }

    @Override
    public ImageEntity save(ImageEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public ImageEntity update(ImageEntity entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public ImageEntity findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<ImageEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ImageNamesAndIdsDTO> findAllNamesDTO() {
        List<ImageEntity> images = findAll();
        List<ImageNamesAndIdsDTO> imagesDTO = new ArrayList<>();
        for (ImageEntity entity : images) {
            imagesDTO.add(beanMapper.map(entity, ImageNamesAndIdsDTO.class));
        }
        return imagesDTO;
    }

    @Override
    public ImageDTO findByIdDTO(Long id) {
        return beanMapper.map(findById(id), ImageDTO.class);
    }
}
