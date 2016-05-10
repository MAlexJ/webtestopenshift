package com.malex.model.dto;

import com.malex.model.enums.ImageType;

import java.util.Arrays;

public class ImageDTO {

    private String name;

    private byte[] img;

    private boolean isAvailable;

    private ImageType type;

    public ImageDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageDTO imageDTO = (ImageDTO) o;

        if (isAvailable != imageDTO.isAvailable) return false;
        if (name != null ? !name.equals(imageDTO.name) : imageDTO.name != null) return false;
        if (!Arrays.equals(img, imageDTO.img)) return false;
        return type == imageDTO.type;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(img);
        result = 31 * result + (isAvailable ? 1 : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
