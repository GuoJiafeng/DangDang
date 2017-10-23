<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8"%>

<s:action name="showNewHotBooksAction" namespace="/goods" executeResult="true"/>
<s:iterator var="list" value="#request.showNewHotBooks">
<ul>
	<li><a  target='_blank' href="<s:url action="showBookDetailAction" namespace="/goods"/>?bookid=<s:property value="good_id"/>"><s:property value="good_name"/> </a></li>

</ul>
</s:iterator>
