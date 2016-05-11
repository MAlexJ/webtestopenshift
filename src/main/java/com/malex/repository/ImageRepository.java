package com.malex.repository;

import com.malex.model.entity.ImageEntity;
import com.malex.model.enums.ImageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

    List<ImageEntity> findByIsAvailableAndType(boolean isAvailable, ImageType type);
}
