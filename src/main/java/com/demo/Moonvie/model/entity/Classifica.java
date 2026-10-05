package com.demo.Moonvie.model.entity;

import jakarta.persistence.*;

public class Classifica {

   private ClassificaId Id;
   private boolean codStatus;

    public ClassificaId getId() {
    return Id;
    }

    public void setId(ClassificaId id) {
    Id = id;
    }

    public boolean isCodStatus() {
        return codStatus;
    }
    
    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

}
