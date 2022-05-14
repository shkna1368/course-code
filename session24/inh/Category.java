package com.nicico.hse.ppe.category;

import com.nicico.hse.common.HseBaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name = "T_BIM_CATEGORIES")
public class Category extends HseBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "create_category_id")
    @SequenceGenerator(name = "create_category_id", sequenceName = "category_seq", allocationSize = 1)
    @Column(name = "C_ID")
    private Long id;

    @Column(name = "C_PERSIAN_TITLE")
    @NotNull(message = "Should not be null")
    private String persianTitle;

    @Column(name = "C_ENGLISH_TITLE")
    private String englishTitle;

    @Column(name = "C_FULL_PERSIAN_TITLE")
    private String fullPersianTitle;

    @Column(name = "C_LEVEL")
    private Integer level;

    @Column(name = "C_IS_LAST_LEVEL_NODE")
    private Boolean isLastLevelNode;

    @Column(name = "C_DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "C_PARENT_ID")
    private Category parent;

    @Transient
    private Boolean hasChild;


}
