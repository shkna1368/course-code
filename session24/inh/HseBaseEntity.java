package com.nicico.hse.common;

import com.nicico.copper.common.domain.Auditable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import javax.persistence.*;



@Audited
//@AuditOverride(forClass = Auditable.class, isAudited = true)
@Getter
@Setter
@MappedSuperclass
public class HseBaseEntity extends Auditable {

    @Column(name = "C_IS_ACTIVE", columnDefinition = "NUMBER(1) default 1 not null")
    private Boolean isActive = true;

    @Column(name = "C_USER_IP")
    private String userIp;

//    @Column(name = "C_IS_DELETED", columnDefinition = "NUMBER(1) default 1 not null")
//    private Boolean isDeleted;


}
