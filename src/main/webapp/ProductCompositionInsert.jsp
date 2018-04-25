<%@page import="com.google.gson.Gson"%>
<%@page import="DrRAJ.DAO.ProductCompositionDAO"%>
<%@page import="DrRAJ.DAO.ProductCategoryDAO"%>
<%@page import="DrRAJ.Bean.ProductCompositionBean"%>
<%@page import="DrRAJ.Bean.IngredientBean"%>
<%@page import="DrRAJ.DAO.IngredientDAO"%>
<%@page import="DrRAJ.DAO.ProductDAO"%>
<%@page import="DrRAJ.Bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Composition</title>
<noscript>
	<div style="color: #FF0000">Please enable java script</div>
</noscript>
<script type="text/javascript" src="js/mainscript.js"></script>
</head>
<%@ include file="AdminHeader.jsp"%>
<%
	List<ProductBean> productList = new ProductDAO().getList();
	List<IngredientBean> ingredientJSONList = new IngredientDAO().select();
	List<ProductCompositionBean> productCompositionBeans = new ProductCompositionDAO().getList();

	Gson gson = new Gson();
	String product = gson.toJson(productList);
	String ingredients = gson.toJson(ingredientJSONList);
	String compostion = gson.toJson(productCompositionBeans);
%>
<div class="productRawData" style="display: none;"><%=product%></div>
<div class="ingredientsRawData" style="display: none;"><%=ingredients%></div>
<div class="compositionRawData" style="display: none;"><%=compostion%></div>
<section class="content-header">
	<h1>Add Product Composition</h1>
	<br> <br>
	<div class="col-lg-6">
		<div class="container" style="max-width: 1000px; margin: 0;">
			<div class="subform">
				<label>How many composition(s) you want insert?</label> <input
					type="text" class="form-control howmanytextbox"
					style="width: 300px; margin-bottom: 5px;" value="1" /> <input
					type="button" value="Next" class="btn btn-success nextbutton">
			</div>
			<form action="ProductCompositionInsertServlet" method="post"
				class="mainform" style="display: none;">
				<div class="row">
					<div class="col-md-8">
						<label>Product Name</label> <select name="selProductName"
							class="form-control productID">
							<option value="0" selected="selected">Select Product
								Name</option>
							<%
								for (int i = 0; i < productList.size(); i++) {

									String tmp = "unselected";
									String type = request.getParameter("selProductName");
									if (type == null || type.equals("0"))
										tmp = "unselected";
									else if (productList.get(i).getProductId().equals(type))
										tmp = "selected";
							%>

							<option value=<%=productList.get(i).getProductId()%> <%=tmp%>>
								<%=productList.get(i).getProductName()%></option>
							<%
								}
							%>
						</select><font color="red">${product}</font>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-4 ingredientContainer"></div>
					<div class="col-sm-4 compositionContainer"></div>
				</div>
				<input type="text" name="ingredientsArr" class="ingredientIdBox"
					style="display: none;" /> <input type="text" name="contentArr"
					class="compositionContentBox" style="display: none;" /> <br /> <input
					type="Submit" value="Add" name="submit" class="btn btn-success">&nbsp;&nbsp;<input
					type="reset" value="Reset" name="reset" class="btn  btn-danger">
			</form>
		</div>
	</div>
</section>
<%@ include file="AdminFooter.jsp"%>
<script type="text/javascript">
		var products=$.parseJSON($(".productRawData").text());
		$(".productRawData").remove();
		var compositions=$.parseJSON($(".compositionRawData").text());
		$(".compositionRawData").remove();
		var ingredients=$.parseJSON($(".ingredientsRawData").text());
		$(".ingredientsRawData").remove();
		$(".howmanytextbox").blur(function(){
			if($(this).val()=="")$(this).val("1");
		});	
		var compcount=0;
		$(".nextbutton").click(function(){
			var val=parseInt($(".howmanytextbox").val());
			if(isNaN(val)){
				val=1;
				$(".howmanytextbox").val();
			}
			compcount=val;
			$(".mainform").css("display","block");
			$(".subform").css("display","none");
		});
		function getProductById(id){
			for(var pro of products){
				if(pro.productId==id)return pro;
			}
			return null;
		}
		function getIngredientById(id){
			for(var ingre of ingredients){
				if(ingre.ingredientsId==id)return ingre;
			}
			return null;
		}
		function getCompositionsByProductId(proid){
			var retval=new Array();
			for(var comp of compositions){
				if(comp.productId==proid)retval.push(comp);
			}
			return retval;
		}
		function getRelatedIngredients(proid){
			var retval=new Array();
			var comps=getCompositionsByProductId(proid);
			for(var i=0;i<ingredients.length;i++)retval.push(ingredients[i]);
			for(var i=0;i<retval.length;i++){
				var ingre=retval[i];
				for(var t of comps){
					if(t.ingredientsId==ingre.ingredientsId){
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
			$(".ingredientContainer").children("select").remove();
			$(".compositionContainer").children("input").remove();
			if(val!="0"){
				var relingre=getRelatedIngredients(val);
				for(var i=0;i<compcount;i++){
					var selectString="";
					selectString+="<label>Ingridient</label><select class='form-control ingre"+i+" ingredient' style='margin-bottom:5px;'>";
					selectString+="<option value='0' selected>Select Ingredient</option>";
					for(var ingre of relingre){
						selectString+="<option value='"+ingre.ingredientsId+"'>"+ingre.title+"</option>";
					}
					selectString+="</select>";
					$(".ingredientContainer").append(selectString);
					var compString="";
					compString+="<label>Content</label><input type='text' class='form-control comp"+i+" composition' style='margin-bottom:5px;'/>";
					$(".compositionContainer").append(compString);
				}
				updateValues();
			}
		});
		$("body").on("change",".ingredient",function(){
			updateValues();
		});
		$("body").on("input",".composition",function(){
			updateValues();
		});
		function updateValues(){
			var ingreString="";
			var compString="";
			for(var i=0;i<compcount;i++){
				var ingre=$(".ingre"+i).val();
				var comp=$(".comp"+i).val();
				if(ingre!="0"&&comp!=""){
					ingreString+=ingre+" ";
					compString+=comp+" ";
				}
			}
			ingreString=ingreString.substr(0,ingreString.length-1);
			compString=compString.substr(0,compString.length-1);
			$(".ingredientIdBox").val(ingreString);
			$(".compositionContentBox").val(compString);
		}
	</script>
</body>
</html>