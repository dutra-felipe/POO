package com.bookmarks.service;

import com.bookmarks.dao.SiteDAO;
import com.bookmarks.model.Site;
import java.sql.SQLException;
import java.util.List;

public class SiteService {
    private final SiteDAO siteDAO;

    public SiteService() {
        this.siteDAO = new SiteDAO();
    }

    public void createSite(Site site) {
        try {
            siteDAO.create(site);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar site", e);
        }
    }

    public Site getSite(Long id) {
        try {
            return siteDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar site", e);
        }
    }

    public List<Site> getSitesByUser(String userAccessKey) {
        try {
            return siteDAO.findByUser(userAccessKey);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar sites do usuário", e);
        }
    }

    public void updateSite(Site site) {
        try {
            siteDAO.update(site);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar site", e);
        }
    }

    public void deleteSite(Long id) {
        try {
            siteDAO.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar site", e);
        }
    }
}
