package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Emp;
//import util.Pagination;

import dao.EmpDao;
import dao.impl.EmpDaoImpl;
import model.EmpWrapper;

import java.util.*;


/**
 * Created by white on 17/6/17.
 */
public class EmpViewAction extends ActionSupport{
    /**
     * 输入参数
     */
//    private Pagination aPage; 
    private Integer curPage;
    private Integer pageSize;
    private String name;
    private String sex;

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<EmpWrapper> getEmps() {
        return emps;
    }

    public void setEmps(List<EmpWrapper> emps) {
        this.emps = emps;
    }

    private List<EmpWrapper> emps;
    private Integer totalPage;

    private EmpDao ed = new EmpDaoImpl();

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String execute() throws Exception {
        Map<String, Object> map = new HashMap<>();
        if(name != null && !"".equals(name)){
            map.put("name", name);
        }
        if(sex != null && !"".equals(sex)){
            map.put("sex", sex);
        }
        if (curPage == null){
            curPage = 1;
        }
        if(pageSize == null){
            pageSize = 3;
        }
        emps = ed.findEmpByPage(curPage, pageSize, map);
        int totalRecords = ed.countRecords(map);
        totalPage = totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize + 1;
        return "success";
    }
}
