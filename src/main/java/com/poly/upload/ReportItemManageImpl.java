package com.poly.upload;


public interface ReportItemManageImpl
{
    void init();

    ReportItemImpl getItem();

    void save(ReportItemImpl reportitem);

    void dispose();
}
