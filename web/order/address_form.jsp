<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />


		<script type="text/javascript">
            function findAddressByAddressId(a){
                var id = a.value;

                if(id != -1){
                    location.href="<s:url action="selectAddressByAddressId" namespace="/address"/>?address.address_id="+id;
                }else{
                    location.href="<s:url action="addNewAddress" namespace="/address"/>";
                }
            }
		</script>
	</head>
	<body>
	<s:action name='selectAddressByUserId'  namespace="/address" executeResult="true" id="action1"/>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>


				选择地址：
				<select id="address"  onchange="findAddressByAddressId(this)">
					<option value="-1">
						填写新地址
					</option>

					<s:iterator value="#session.addresslist" var="addresslist">



						<s:if test="#session.address.address_id == #addresslist.address_id">
						<option value="<s:property value="address_id"/>" selected>
							<s:property value="#addresslist.address_detail"/>
						</option>
						</s:if>
						<s:else>
							<option value="<s:property value="address_id"/>">
								<s:property value="address_detail"/>
							</option>
						</s:else>

					</s:iterator>
				</select>
			</p>
			<form name="ctl00" method="get" action="<s:url action="addOrderAction" namespace="/order"/>" id="f" >
				<input type="hidden" name="address.address_id" id="addressId"  value="<s:property value="#session.address.address_id"/>"/>

				<table class="tab_login">

					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="address.address_user_name"
								id="receiveName" value="<s:property value="#session.address.address_user_name"/>" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="address.address_detail" class="text_input"
								id="fullAddress"  value="<s:property value="#session.address.address_detail"/>"/>
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="address.address_post_number"
								id="postalCode"  value="<s:property value="#session.address.address_post_number"/>"/>
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="address.address_user_phone"
								id="phone" value="<s:property value="#session.address.address_user_phone"/>"/>
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<input type="text" class="text_input" name="address.address_user_mobile_phone"
								id="mobile" value="<s:property value="#session.address.address_user_mobile_phone"/>"/>
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<a href="order_info.jsp"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>

				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

