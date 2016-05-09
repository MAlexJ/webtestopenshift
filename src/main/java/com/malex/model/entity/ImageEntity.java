package com.malex.model.entity;

import com.malex.model.entity.templ.BaseEntity;
import com.malex.model.enums.ImageType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "image")
public class ImageEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Lob
    @Column(name = "img", nullable = false)
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] img;

    @Column(name = "available", nullable = false)
    private boolean isAvailable;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ImageType type;

    @OneToOne(mappedBy = "image")
    private ArticleEntity article;
}
