<%@page import="DrRAJ.DAO.ReletedProductDAO"%>
<%@page import="DrRAJ.Bean.RelatedProductBean"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Controller.ProductDeleteServlet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | Related Product Insert</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
<link rel="icon" href="imgs/daiict.png" />
</head>
<body>

	<%
		Gson gson = new Gson();
		List<ProductBean> productBeans = new ProductDAO().getList();
		String product = gson.toJson(productBeans);
		List<RelatedProductBean> relatedProductBeans = new ReletedProductDAO().getList();
		String relatedProduct = gson.toJson(relatedProductBeans);
	%>
	
	<div class="productRawData" style="display: none;"><%=product%></div>
	<div class="relatedProductRawData" style="display: none;"><%=relatedProduct%></div>
	
	<%@ include file="AdminHeader.jsp"%>
	<div style="margin-top: -850px; margin-left: 250px;">
		<section class="content-header">
		<h1>
			Related Product <small>Insert</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="AdminDashBoard.jsp"><i class="fa fa-dashboard"></i>
					Home</a></li>
			<li class="active">Admin</li>
		</ol>
		</section>
		<br> <br>
		<div class="col-lg-6">
			<div class="container">
				<div class="subform">
					<label>How many related products you want insert?</label>
					<input type="text" class="form-control howmanytextbox" style="width:300px;margin-bottom:5px;" value="1"/>
					<input type="button" value="Next" class="btn btn-success nextbutton">
				</div>
				<form action="ReletedProductInsertServlet" method="post" class="mainform" style="display:none;">
					<br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Select
								Product </font>
						</label>
						<div class="col-lg-6">
							<select name="txtProductId" class="form-control productID">
								<option value="0" selected="selected">Select Product</option>
								<%
									
									for (int i = 0; i < productBeans.size(); i++) {

										String tmp = "unselected";
										String type = (String) request.getAttribute("txtProductId");
										if (type == null || type.equals("0"))
											tmp = "unselected";
										else if (productBeans.get(i).getProductId().equals(type))
											tmp = "selected";
								%>
								<option value=<%=productBeans.get(i).getProductId()%> <%=tmp%>>
									<%=productBeans.get(i).getProductName()%></option>
								<%
									}
								%>
							</select><%-- <font color="red">${product}</font> --%>
						</div>
					</div>
					<br />
					<div class="row">
						<label class="col-sm-2"> <font size="+1">Select
								Related Product(s) </font>
						</label>
						<div class="col-lg-6 rproductInputContainer">
							
						</div>
					</div>
					<input type="text" name="txtDummy" class="relatedProductTextBox" style="display:none;"/>
					<br /> <br /> <br /> <label class="col-sm-2 control-label"></label>
					<!-- <input type="reset" value="Reset" name="reset"
						class="btn  btn-danger"> -->
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="Submit" value="Add" name="submit"
						class="btn btn-success">

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jq.js"></script>
	<script type="text/javascript">
		var products=$.parseJSON($(".productRawData").text());
		$(".productRawData").remove();
		var rproducts=$.parseJSON($(".relatedProductRawData").text());
		$(".relatedProductRawData").remove();
		$(".howmanytextbox").blur(function(){
			if($(this).val()=="")$(this).val("1");
		});	
		var rprocount=0;
		$(".nextbutton").click(function(){
			var val=parseInt($(".howmanytextbox").val());
			if(isNaN(val)){
				val=1;
				$(".howmanytextbox").val();
			}
			rprocount=val;
			$(".mainform").css("display","block");
			$(".subform").css("display","none");
		});
		function getProductById(id){
			for(var pro of products){
				if(pro.productId==id)return pro;
			}
			return null;
		}
		function getRelatedProducts(proid){
			var retval=new Array();
			for(var rpro of rproducts){
				if(rpro.productId==proid)retval.push(rpro);
			}
			return retval;
		}
		function getListOfRelatedProducts(proid){
			var retval=new Array();
			var relatedProducts=getRelatedProducts(proid);
			for(var pro of products){
				if(pro.productId!=proid){
					retval.push(pro);
				}
			}
			for(var i=0;i<retval.length;i++){
				var rpro=retval[i];
				for(var t of relatedProducts){
					if(t.reletedId==rpro.productId){
						retval.splice(i,1);
						i=-1;
						break;
					}
				}
			}
			return retval;
		}
		$(".productID").change(function(){
			var val=$(this).val();
			$(".rproductInputContainer").children("select").remove();
			if(val!="0"){
				var rpros=getListOfRelatedProducts(val);
				for(var i=0;i<rprocount;i++){
					var selectString="";
					selectString+="<select class='form-control rpro"+i+" relatedProduct' style='margin-bottom:5px;'>";
					selectString+="<option value='0' selected>Select Related Product</option>";
					for(var rpro of rpros){
						selectString+="<option value='"+rpro.productId+"'>"+rpro.productName+"</option>";
					}
					selectString+="</select>";
					$(".rproductInputContainer").append(selectString);
				}
				updateValues();
			}
		});
		$("body").on("change",".relatedProduct",function(){
			updateValues();
		});
		function updateValues(){
			var finalString="";
			for(var i=0;i<rprocount;i++){
				var val=$(".rpro"+i).val();
				if(val!="0"){
					finalString+=val+" ";
				}
			}
			finalString=finalString.substr(0,finalString.length-1);
			$(".relatedProductTextBox").val(finalString);
		}
	</script>
</body>
</html>