package jp.aegif.alfresco.study.repo.domain;

import java.sql.SQLException;
import java.util.List;


/**
 * Common interface for custom entity DAO service
 */
public interface CustomEntityDAO
{
    public static final int MAX_LEN_USER_ID = 255;         // needs to match schema: read_user_id
    public static final int MAX_LEN_UUID = 36;         // needs to match schema: read_uuid
    
    public List<CustomEntity> selectCustomEntitiesByUser(CustomEntity customEntity) throws SQLException;
        
    public long insertCustomEntity(CustomEntity customEntity) throws SQLException;
    
}
