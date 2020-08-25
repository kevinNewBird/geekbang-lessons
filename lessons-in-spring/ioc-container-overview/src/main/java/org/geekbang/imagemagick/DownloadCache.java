package org.geekbang.imagemagick;


import java.util.Hashtable;

public class DownloadCache /*extends CMSObj*/ {

    protected Hashtable<String, Object> m_hProperties = null; // 对象属性集合

    /**
     * 对象类型编号
     */
    public final static int OBJ_TYPE = 61140196;

    /**
     * 对象数据存储的数据库名
     */
    public final static String DB_TABLE_NAME = "XWCMDOWNLOADCACHELOG";

    /**
     * 对象数据存储的ID字段名
     */
    public final static String DB_ID_NAME = "LOGID";

    /**
     * 构造函数：保留默认接口
     */
    public DownloadCache() {
        super();
    }

    // ==============================================================================
    // 重载父类中的抽象接口函数

    /**
     * 取对象数据存储的数据表名称
     *
     * @return 对象数据存储的数据表名称
     */
    public String getDbTableName() {
        return DB_TABLE_NAME;
    }

    /**
     * 取对象数据存储的ID字段名
     *
     * @return ID字段名
     */
    public String getIdFieldName() {
        return DB_ID_NAME;
    }

    /**
     * 取得该对象的类型编号
     *
     * @return 对象的类型编号
     */
    public int getWCMType() {
        return OBJ_TYPE;
    }


    public Hashtable<String, Object> getProperties() {
        return getProperties(false);
    }

    /**
     * 获取属性值的MAP
     *
     * @param _bNeedCheckInit 是否需要初始化
     * @return 属性值的MAP（如果为NULL，则返回新建的MAP对象）
     */
    protected Hashtable<String, Object> getProperties(boolean _bNeedCheckInit) {
        if (m_hProperties == null && _bNeedCheckInit) {
            m_hProperties = new Hashtable<>();
        }
        return m_hProperties;
    }
}