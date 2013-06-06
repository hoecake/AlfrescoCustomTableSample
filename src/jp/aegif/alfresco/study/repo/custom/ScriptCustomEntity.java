package jp.aegif.alfresco.study.repo.custom;

import java.util.List;

import jp.aegif.alfresco.study.repo.domain.CustomEntity;

import org.alfresco.repo.jscript.BaseScopableProcessorExtension;

/**
 * Scripted Read Content Service.
 */

public class ScriptCustomEntity extends BaseScopableProcessorExtension
{
    private CustomEntityService customEntityService;
    
    public void setCustomEntityService(CustomEntityService customEntityService)
    {
        this.customEntityService = customEntityService;
    }

    /**
     * Insert a read content
     * 
     * @param userId
     *            - required
     * @param uuid
     *            - required
     */
    public void insert(String userId)
    {
        customEntityService.insertCustomEntity(userId);
    }
    
    /**
     * Select read contents by user id
     * 
     * @param userId
     *            - required
     * @return uuid list
     */
    public List<CustomEntity> selectByUser(String userId)
    {
        return customEntityService.selectCustomEntitiesByUser(userId);
    }
    
}
