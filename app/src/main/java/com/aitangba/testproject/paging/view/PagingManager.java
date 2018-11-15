package com.aitangba.testproject.paging.view;

import com.aitangba.testproject.paging.PageBean;
import com.aitangba.testproject.paging.Response;

import java.util.List;

/**
 * Created by fhf11991 on 2017/3/16.
 */

public interface PagingManager {

    PageBean getPageBean();

    void checkPaging(List array);

    void checkError(int errorType, boolean refresh);

}
