package com.malex.service;

import com.malex.model.dto.ImageDTO;
import com.malex.model.dto.ImageNamesAndIdsDTO;
import com.malex.model.entity.ImageEntity;
import com.malex.model.enums.ImageType;

import java.util.List;

public interface ImageService {

    ImageDTO saveDTO(ImageDTO dto);

    ImageEntity save(ImageEntity entity);

    ImageEntity update(ImageEntity entity);

    void delete(Long id);

    ImageEntity findById(Long id);

    List<ImageEntity> findAll();

    List<ImageNamesAndIdsDTO> findAllNamesDTO();

    ImageDTO findByIdDTO(Long id);

    List<ImageNamesAndIdsDTO> findByIsAvailableAndType(boolean isAvailable, ImageType type);
}
