package com.example.petstore.models.util;

import org.apache.commons.lang3.StringUtils;
import com.example.petstore.models.seedwork.AbstractEntity;
import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

public class UpperCaseUUIDGenerator extends UUIDGenerator{

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {//SharedSessionContractImplementor
        if (object instanceof AbstractEntity) {
            AbstractEntity abstractEntity = (AbstractEntity) object;
            if (abstractEntity.getId() != null) {
                return abstractEntity.getId();
            }
        }
        Serializable generated = super.generate(session, object);
        return StringUtils.upperCase((String) generated);
    }

}
