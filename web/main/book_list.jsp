<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>当当图书 – 全球最大的中文网上书店</title>
    <script type="text/javascript" src="../js/prototype-1.6.0.3.js">
    </script>
    <link href="../css/book.css" rel="stylesheet" type="text/css"/>
    <link href="../css/second.css" rel="stylesheet" type="text/css"/>
    <link href="../css/secBook_Show.css" rel="stylesheet" type="text/css"/>
    <link href="../css/list.css" rel="stylesheet" type="text/css"/>
</head>
<body>
&nbsp;

<!-- 头部开始 -->
<%@include file="../common/head.jsp" %>
<!-- 头部结束 -->

<div style="width: 962px; margin: auto;">
    <a href="#"><img src="../images/default/book_banner_081203.jpg" border="0"/> </a>
</div>
<div class='your_position'>
    您现在的位置:&nbsp;
    <a href='/main/main.jsp'>当当图书</a>&gt;&gt;

    <font style='color: #cc3300'>
        <s:if test='#request.typeFatherById.type_father_name!=null'>
            <strong><s:property value="#request.typeFatherById.type_father_name"/></strong>
        </s:if>
        <s:else>
            <strong>
                <a href="<s:url action="showBookListAction" namespace="/type"/>?fid=<s:property value="#request.typeSonById.type_father_id"/>">
                    <s:property value="#request.typeSonById.type_father_name"/>
                </a>
            </strong>
            &gt;&gt;
            <s:iterator var="list" value="#request.typeSonById.typeSons">
                <s:property value="type_son_name"/>
            </s:iterator>
        </s:else>
    </font>
</div>

<div class="book">

    <!--左栏开始-->
    <div id="left" class="book_left">
        <div id="__fenleiliulan">
            <div class=second_l_border2>
                <h2>
                    分类浏览
                </h2>
                <ul>
                    <li>
                        <div>
                            <div class=second_fenlei>
                                <s:if test="#request.typeFatherById!=null">
                                <span style="color:red;">
                                    &middot;全部&nbsp;(<s:property value="#request.typeSonAndFather.type_father_count"/>)
                                      </span>
                                </s:if>

                                <s:else>
                                    <a href="<s:url action="showBookListAction" namespace="/type"/>?fid=<s:property value="#request.typeSonAndFather.type_father_id"/>">
                                        &middot;全部&nbsp;(<s:property
                                            value="#request.typeSonAndFather.type_father_count"/>)
                                    </a>
                                </s:else>
                            </div>
                        </div>
                    </li>
                    <div class="clear"></div>

                    <!--2级分类开始-->
                    <s:iterator value="#request.typeSonById.typeSons" var="typeSonByidlist"></s:iterator>
                    <s:iterator value="#request.typeSonAndFather.typeSons" var="typeSonslist">
                    <li>
                        <div>
                            <div class=second_fenlei>
                                &middot;
                            </div>

                            <div class=second_fenlei>
                                <s:if test="type_son_id == #typeSonByidlist.type_son_id">
                               <span style="color:red;">
                                   <s:property value="type_son_name"/> &nbsp;(<s:property value="type_son_count"/>)
                                   </span>
                                </s:if>

                                <s:else>
                                    <a href="<s:url action="showBookListAction" namespace="/type"/>?fid=<s:property value="#request.typeSonAndFather.type_father_id"/>&&sid=<s:property value="type_son_id"/>"><s:property
                                            value="type_son_name"/> &nbsp;(<s:property value="type_son_count"/>)</a>
                                </s:else>
                            </div>
                        </div>
                    </li>
                    <div class="clear"></div>
                    <li>
                        <div>
                            <!--2级分类结束-->
                            </s:iterator>
                    <li>
                        <div></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!--左栏结束-->

    <!--中栏开始-->
    <div class="book_center">

        <!--图书列表开始-->
        <div id="divRight" class="list_right">

            <div id="book_list" class="list_r_title">
                <div class="list_r_title_text">
                    排序方式
                </div>
                <select onchange='' name='select_order' size='1'
                        class='list_r_title_ml'>
                    <option value="">
                        按上架时间 降序
                    </option>
                </select>
                <div id="divTopPageNavi" class="list_r_title_text3">

                    <!--分页导航开始-->

                    <div class='list_r_title_text3a'>
                        <%--<a name=link_page_next--%>
                        <%--href="#">--%>
                        <%--<img src='../images/page_up.gif'/> </a>--%>
                    </div>
                    <s:if test='#request.typeFatherById.type_father_name!=null'>
                        <s:if test="#request.pb.pageNum>1">
                            <%--<a href="${pageContext.request.contextPath}/showAllEmpAction?pageNum=${requestScope.pb.pageNum-1}">上一页</a>--%>
                            <a href="<s:url action="showBookListAction" namespace="/type" />?pageNum=<s:property value="#request.pb.pageNum-1"/>&&fid=<s:property value="#request.typeFatherById.type_father_id"/>">上一页</a>
                        </s:if>
                        <span style="margin-left:10px">&nbsp;</span>

                        <s:if test="#request.pb.totalPage > #request.pb.pageNum">
                            <%--<a href="${pageContext.request.contextPath}/showAllEmpAction?pageNum=${requestScope.pb.pageNum+1}">下一页</a>--%>
                            <a href="<s:url action="showBookListAction" namespace="/type" />?pageNum=<s:property value="#request.pb.pageNum+1"/>&&fid=<s:property value="#request.typeFatherById.type_father_id"/>">下一页</a>
                        </s:if>
                    </s:if>


                    <s:else>
                        <s:if test="#request.pb.pageNum>1">
                            <s:iterator var="list" value="#request.typeSonById.typeSons">
                                <%--<a href="${pageContext.request.contextPath}/showAllEmpAction?pageNum=${requestScope.pb.pageNum-1}">上一页</a>--%>
                                <a href="<s:url action="showBookListAction" namespace="/type" />?pageNum=<s:property value="#request.pb.pageNum-1"/>&&fid=<s:property value="#request.typeSonById.type_father_id"/>&&sid=<s:property value="type_son_id"/>">上一页</a>
                            </s:iterator>
                        </s:if>
                        <span style="margin-left:10px">&nbsp;</span>
                        <s:if test="#request.pb.totalPage > #request.pb.pageNum">
                            <s:iterator var="list" value="#request.typeSonById.typeSons">
                                <%--<a href="${pageContext.request.contextPath}/showAllEmpAction?pageNum=${requestScope.pb.pageNum+1}">下一页</a>--%>
                                <a href="<s:url action="showBookListAction" namespace="/type" />?pageNum=<s:property value="#request.pb.pageNum+1"/>&&fid=<s:property value="#request.typeSonById.type_father_id"/>&&sid=<s:property value="type_son_id"/>">下一页</a>
                            </s:iterator>
                        </s:if>
                    </s:else>

                    <div class='list_r_title_text3a'>
                        <%--<img src='../images/page_up_gray.gif'/>--%>
                        <%--</div>--%>

                        <%--<div class='list_r_title_text3b'>--%>
                        <%--第1页/共5页--%>
                        <%--</div>--%>

                        <%--<div class='list_r_title_text3a'>--%>
                        <%--<a name=link_page_next--%>
                        <%--href="#">--%>
                        <%--<img src='../images/page_down.gif'/> </a>--%>
                        <%--</div>--%>

                        <%--<div class='list_r_title_text3a'>--%>
                        <%--<img src='../images/page_down_gray.gif'/>--%>
                    </div>

                    <!--分页导航结束-->
                </div>
            </div>

            <!--商品条目开始-->

            <s:iterator var="list" value="#request.showBookList">


                <div class="clear"></div>
                <div class="list_r_list">
    <span class="list_r_list_book"><a name="link_prd_img"
                                      href='<s:url action="showBookDetailAction" namespace="/goods"/>?bookid=<s:property value="good_id"/>'>
    <img src="../productImages/<s:property value="good_image"/>"/> </a> </span>
                    <h2>
                        <a name="link_prd_name"
                           href='<s:url action="showBookDetailAction" namespace="/goods"/>?bookid=<s:property value="good_id"/>'><s:property
                                value="good_name"/></a>
                    </h2>
                    <h3>
                        顾客评分：100
                    </h3>
                    <h4 class="list_r_list_h4">
                        作 者:
                        <a href='#' name='作者'><s:property value="good_author"/></a>
                    </h4>
                    <h4>
                        出版社：
                        <a href='#' name='出版社'><s:property value="good_press"/></a>
                    </h4>
                    <h4>
                        出版时间： <s:property value="good_publication_time"/>
                    </h4>
                    <h5>
                        <s:property value="good_content_validity"/>
                    </h5>
                    <div class="clear"></div>
                    <h6>
                        <span class="del"><s:property value="good_price"/></span>
                        <span class="red"><s:property value="good_dangdang_price"/></span>
                        节省：￥<s:property value="good_price - good_dangdang_price"/>
                    </h6>
                    <span class="list_r_list_button">
    <a href="<s:url action="addGoodsAction" namespace="/cart"/>?good_id=<s:property value="good_id"/>">
    <img src='../images/buttom_goumai.gif'/> </a>
    <span id="cartinfo"></span>
                </div>
                <div class="clear"></div>
            </s:iterator>
            <!--商品条目结束-->

            <div class="clear"></div>
            <div id="divBottomPageNavi" class="fanye_bottom">
            </div>

        </div>
        <!--图书列表结束-->

    </div>
    <!--中栏结束-->
    <div class="clear"></div>
</div>

<!--页尾开始 -->
<%@include file="../common/foot.jsp" %>
<!--页尾结束 -->
</body>
</html>
