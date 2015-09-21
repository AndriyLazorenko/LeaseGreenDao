package com.example.leasegreendao.model;

import com.example.leasegreendao.model.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "LEASE".
 */
public class Lease {

    private Long id;
    private String item;
    private String comment;
    private Long leasedate;
    private Long returndate;
    private Long personId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient LeaseDao myDao;

    private Person person;
    private Long person__resolvedKey;


    public Lease() {
    }

    public Lease(Long id) {
        this.id = id;
    }

    public Lease(Long id, String item, String comment, Long leasedate, Long returndate, Long personId) {
        this.id = id;
        this.item = item;
        this.comment = comment;
        this.leasedate = leasedate;
        this.returndate = returndate;
        this.personId = personId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLeaseDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getLeasedate() {
        return leasedate;
    }

    public void setLeasedate(Long leasedate) {
        this.leasedate = leasedate;
    }

    public Long getReturndate() {
        return returndate;
    }

    public void setReturndate(Long returndate) {
        this.returndate = returndate;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /** To-one relationship, resolved on first access. */
    public Person getPerson() {
        Long __key = this.personId;
        if (person__resolvedKey == null || !person__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PersonDao targetDao = daoSession.getPersonDao();
            Person personNew = targetDao.load(__key);
            synchronized (this) {
                person = personNew;
            	person__resolvedKey = __key;
            }
        }
        return person;
    }

    public void setPerson(Person person) {
        synchronized (this) {
            this.person = person;
            personId = person == null ? null : person.getId();
            person__resolvedKey = personId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
