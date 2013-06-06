package jp.aegif.alfresco.study.repo.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class CustomEntityDAOImpl implements CustomEntityDAO
{
    private static final Log logger = LogFactory
            .getLog(CustomEntityDAOImpl.class);

    protected SqlSessionTemplate template;

    public final void setSqlSessionTemplate(
            SqlSessionTemplate sqlSessionTemplate)
    {
        this.template = sqlSessionTemplate;
    }

    @Override
    public long insertCustomEntity(CustomEntity customEntity)
            throws SQLException
    {
        template.insert("alfresco.custom.insert_custom_entity",
                customEntity);
        Long id = customEntity.getId();

        if (logger.isDebugEnabled())
            logger.debug("customEntity.id : " + id);

        return (id != null ? id : -1);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustomEntity> selectCustomEntitiesByUser(
            CustomEntity customEntity) throws SQLException
    {
        if (customEntity.getUserId() != null)
        {
            return (List<CustomEntity>) template.selectList(
                    "alfresco.custom.select_custom_entities_by_user", customEntity);
        } else
        {
            return new ArrayList<CustomEntity>(0);
        }
    }
}
