package jp.aegif.alfresco.study.repo.custom;

import java.util.List;

import jp.aegif.alfresco.study.repo.domain.CustomEntity;

/**
 * Common interface for custom entity service
 */
public interface CustomEntityService
{
    /**
     * Insert uuid of the run date and user id
     *
     * @param userId - required
     */
    public void insertCustomEntity(String userId);
    
    /**
     * Select custom entities by user id
     *
     * @param userId - required
     * @return list of custom entities
     */
    public List<CustomEntity> selectCustomEntitiesByUser(String userId);
    
}
