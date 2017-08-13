package com.local.spring.service.impl;

import com.local.spring.dao.AnnoDao;
import com.local.spring.dao.impl.AnnoDaoImpl;
import com.local.spring.entity.Anno;
import com.local.spring.service.AnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by white on 17/8/12.
 */
@Service("annoService")
public class AnnoServiceImpl implements AnnoService {
    @Autowired
    private AnnoDaoImpl ad;

    public AnnoDaoImpl getAd() {
        return ad;
    }

    public void setAd(AnnoDaoImpl ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "AnnoServiceImpl{" +
                "ad=" + ad +
                '}';
    }

    @Override
    public List<Anno> getList() {
        return ad.getList();
    }
}
