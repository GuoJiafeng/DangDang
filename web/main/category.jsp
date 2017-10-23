<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<s:action name="showBookTypeAction" namespace="/type" executeResult="true"/>
		<!--1级分类开始-->
		<s:iterator var="typeFatherList"  value="#request.list">


			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>

						[<a href='<s:url action="showBookListAction" namespace="/type"/>?fid=<s:property value="type_father_id"/>'><s:property value="type_father_name"/></a>]

				</h3>
				<ul class="ul_left_list">
						<!--2级分类开始-->
					<s:iterator var="typeSonList" value="typeSons">
						<li>
							<a href='<s:url action="showBookListAction" namespace="/type"/>?fid=<s:property value="type_father_id"/>&&sid=<s:property value="type_son_id"/>'><s:property value="type_son_name"/></a>
						</li>
					</s:iterator>
						<!--2级分类结束-->
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->
		</s:iterator>

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
