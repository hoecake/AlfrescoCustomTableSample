package jp.aegif.alfresco.study.repo.domain;

import java.util.Date;

public class CustomEntity
{
    private Long id; // internal DB-generated sequence id
    private Date runDate;
    private String userId;
    
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public Date getRunDate()
    {
        return runDate;
    }
    public void setRunDate(Date runDate)
    {
        this.runDate = runDate;
    }
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    // for debug only
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("CustomEntity\n[");
        sb.append("id=").append(id).append(",");
        sb.append("runDate=").append(runDate).append(",");
        sb.append("userId=").append(userId).append(",");
        return sb.toString();
    }
    
}
