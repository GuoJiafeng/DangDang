<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<s:action name="showEditorialRecommendationAction" namespace="/goods" executeResult="true"/>
		<s:iterator var="list" value="#request.showEditorialRecommendation">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='<s:url action="showBookDetailAction" namespace="/goods"/>?bookid=<s:property value="good_id"/>' target='_blank'><img src="../productImages/<s:property value="good_image"/>" width=70 border=0 /> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='<s:url action="showBookDetailAction" namespace="/goods"/>?bookid=<s:property value="good_id"/>' target='_blank' title='输赢'><s:property value="good_name"/></a>
				</h3>
				<h4>
					作者：<s:property value="good_author"/> 著
					<br />
					出版社：<s:property value="good_press"/> &nbsp;&nbsp;&nbsp;&nbsp;出版时间：2006-7-1
				</h4>
				<h5>
					<s:property value="good_content_validity"/>
				</h5>
				<h6>
					定价：￥<s:property value="good_price"/>&nbsp;&nbsp;当当价：￥<s:property value="good_dangdang_price"/>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>

		</s:iterator>
		
	</div>
</div>
