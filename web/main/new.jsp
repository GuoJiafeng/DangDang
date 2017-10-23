<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8" %>
<h2>
    <span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>

    <div class="book_c_04">

        <!--热销图书A开始-->
<s:action name="showNewBooksAction" namespace="/goods" executeResult="true"/>
<s:iterator var="list" value="#request.showNewBooks">
        <div class="second_d_wai">
            <div class="img">
                <a href="<s:url action="showBookDetailAction" namespace="/goods"/>?bookid=<s:property value="good_id"/>" target='_blank'><img
                        src="../productImages/<s:property value="good_image"/>"/> </a>
            </div>
            <div class="shuming">
                <a href="<s:url action="showBookDetailAction" namespace="/goods"/>?bookid=<s:property value="good_id"/>" target="_blank"><s:property value="good_name"/></a><a href="#" target="_blank"></a>
            </div>
            <div class="price">
                定价：￥<s:property value="good_price"/>
            </div>
            <div class="price">
                当当价：￥<s:property value="good_dangdang_price"/>
            </div>
        </div>
        <div class="book_c_xy_long"></div>
</s:iterator>
        <!--热销图书A结束-->

    </div>

<div class="clear"></div>