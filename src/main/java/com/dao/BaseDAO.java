package com.dao;

import java.util.List;

public class BaseDAO<S> implements DAOInterface<S>{
    private static BaseDAO _instance;
    private BaseDAO(){
    }

    public static BaseDAO getInstance(){
        if(_instance == null)
            _instance = new BaseDAO();
        return _instance;
    }

    @Override
    public List<S> get() {
        return null;
    }

    @Override
    public boolean create(S s) {
        return false;
    }

    @Override
    public boolean update(S s) {
        return false;
    }

    @Override
    public boolean delete(S s) {
        return false;
    }

    @Override
    public <K> S find(K id) {
        return null;
    }
}