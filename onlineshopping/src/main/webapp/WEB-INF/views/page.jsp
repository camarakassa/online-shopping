<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />



<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>


<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}'
	
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap Datatable  CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">



<!-- Custom styles for this template -->
<link href="${css}/app.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation  -->

		<%@ include file="./shared/navbar.jsp"%>

		<!-- Page content  -->

		<div class="content">

			<!-- Chargement du contenu  -->

			<c:if test="${userClickHome == true}">
				<%@ include file="home.jsp"%>
			</c:if>

			<!-- Cette page est chargé si et seulement si l'utilisateur clique sur A Propos -->
			<c:if test="${userClickAbout == true}">
				<%@ include file="about.jsp"%>
			</c:if>

			<!-- Cette page est chargé si et seulement si l'utilisateur clique sur Nous Contacter -->
			<c:if test="${userClickContact == true}">
				<%@ include file="contact.jsp"%>
			</c:if>


			<!-- Cette page est chargé si et seulement si l'utilisateur clique sur Liste des Produits -->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@ include file="listProducts.jsp"%>
			</c:if>
			
			
			<!-- Pour afficher un seul produit -->
			<c:if
				test="${userClickShowProduct == true}">
				<%@ include file="singleProduct.jsp"%>
			</c:if>

		</div>
		<!-- /.container -->



		<!-- Footer -->

		<%@ include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.min.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- Datatable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Datatable Bootstrap -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		

		<!-- Mon code javascript  -->
		<script src="${js}/app.js"></script>


	</div>

</body>

</html>
