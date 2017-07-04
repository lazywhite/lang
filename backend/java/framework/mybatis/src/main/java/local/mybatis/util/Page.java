package local.mybatis.util;

import java.util.Map;

/**
 * Created by white on 17/7/4.
 */
public class Page {
    private int pageSize = 5;
    private int totalRecords;
    private int curPage = 1;
    private int totalPages;
    private int offset;
    private Map<String, Object> condition;

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public int getTotalPages() {
        totalPages = totalRecords % pageSize == 0? totalRecords/pageSize: totalPages/pageSize + 1;
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getOffset() {
        offset = (curPage - 1) * pageSize;
        return offset;
    }

    public Page() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
}
