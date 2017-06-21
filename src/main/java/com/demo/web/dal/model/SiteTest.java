package com.demo.web.dal.model;

public class SiteTest {
    private Integer id;

    private String siteName;

    private String siteCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode == null ? null : siteCode.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SiteTest other = (SiteTest) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSiteName() == null ? other.getSiteName() == null : this.getSiteName().equals(other.getSiteName()))
            && (this.getSiteCode() == null ? other.getSiteCode() == null : this.getSiteCode().equals(other.getSiteCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSiteName() == null) ? 0 : getSiteName().hashCode());
        result = prime * result + ((getSiteCode() == null) ? 0 : getSiteCode().hashCode());
        return result;
    }
}