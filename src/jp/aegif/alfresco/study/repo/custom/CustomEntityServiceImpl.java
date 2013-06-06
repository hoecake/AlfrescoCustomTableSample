package jp.aegif.alfresco.study.repo.custom;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import jp.aegif.alfresco.study.repo.domain.CustomEntityDAO;
import jp.aegif.alfresco.study.repo.domain.CustomEntity;

import org.alfresco.error.AlfrescoRuntimeException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Read Content Service Implementation
 */
public class CustomEntityServiceImpl implements CustomEntityService
{
    private static final Log logger = LogFactory
            .getLog(CustomEntityServiceImpl.class);

    private CustomEntityDAO customEntityDAO;

    public void setCustomEntityDAO(CustomEntityDAO customEntityDAO)
    {
        this.customEntityDAO = customEntityDAO;
    }

    public void insertCustomEntity(String userId)
    {

        try
        {
            if (userId.length() > CustomEntityDAO.MAX_LEN_USER_ID)
            {
                throw new IllegalArgumentException("Invalid userId - exceeds "
                        + CustomEntityDAO.MAX_LEN_USER_ID + " chars: " + userId);
            }
        } catch (IllegalArgumentException e)
        {
            // log error and throw exception
            logger.error(e);
            throw new IllegalArgumentException(
                    "Failed to insert custom entity : " + e, e);
        }

        try
        {
            Date runDate = new Date();
            CustomEntity customEntity = new CustomEntity();
            customEntity.setUserId(userId);
            customEntity.setRunDate(runDate);

            try
            {
                long id = customEntityDAO.insertCustomEntity(customEntity);

                if (logger.isDebugEnabled())
                {
                    customEntity.setId(id);
                    logger.debug("Inserted : " + customEntity);
                }
            } catch (SQLException e)
            {
                throw new AlfrescoRuntimeException(
                        "Failed to insert : " + e, e);
            } catch (Throwable t)
            {
                throw new AlfrescoRuntimeException(
                        "Failed to insert : " + t, t);
            }
        } catch (AlfrescoRuntimeException e)
        {
            logger.error(e);
        }
    }

    @Override
    public List<CustomEntity> selectCustomEntitiesByUser(String userId)
    {
        List<CustomEntity> results = null;

        try
        {
            CustomEntity userSpecifiedEntity = new CustomEntity();
            userSpecifiedEntity.setUserId(userId);

            results = customEntityDAO
                    .selectCustomEntitiesByUser(userSpecifiedEntity);
            
        } catch (SQLException e)
        {
            logger.error(new AlfrescoRuntimeException(
                    "Unable to get custom entities : " + e.getMessage(), e));
        }
        
        if (logger.isDebugEnabled()) {
            for (CustomEntity customEntity : results)
                logger.debug("selected entity : " + customEntity.toString());
        }

        return results;
    }
}