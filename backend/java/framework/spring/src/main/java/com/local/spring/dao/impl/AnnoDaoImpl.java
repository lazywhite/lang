package com.local.spring.dao.impl;

import com.local.spring.dao.AnnoDao;
import com.local.spring.entity.Anno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by white on 17/8/12.
 */
@Repository("annoDao")
public class AnnoDaoImpl implements AnnoDao {


    @Override
    public List<Anno> getList() {
        List<Anno> list = new ArrayList<>();
        list.add(new Anno("bob", "1234"));
        list.add(new Anno("marry", "1234"));
        list.add(new Anno("alice", "1234"));
        return list;
    }
}
