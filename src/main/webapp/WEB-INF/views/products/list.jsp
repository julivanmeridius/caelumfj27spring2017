<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Página de listagem dos Livros</title>
	</head>
	<style>
		table {
		    width:100%;
		}
		table, th, td {
		    border: 1px solid black;
		    border-collapse: collapse;
		}
		th, td {
		    padding: 5px;
		    text-align: left;
		}
		table#t01 tr:nth-child(even) {
		    background-color: #eee;
		}
		table#t01 tr:nth-child(odd) {
		   background-color:#fff;
		}
		table#t01 th {
		    background-color: black;
		    color: white;
		}
	</style>
	<body>
		<h2>LISTAGEM DE PRODUTOS CADASTRADOS</h2>
		<table>
	        <tr>
	            <th>Título</th>
	            <th>Descrição</th>
	            <th>Páginas</th>
	            <th>Preços</th>	            
	        </tr>
	        <c:forEach items="${products}" var="product">
	            <tr>
	                <td>${product.title}</td>
	                <td>${product.description }</td>
	                <td>${product.numberOfPages }</td>
	                <td>
	                	<c:forEach items ="${product.prices}" var="price">
	                		[${price.value} - ${price.bookType}]
	                	</c:forEach>
	                </td>
	                <td>
	                	<c:url value="/products/${product.id}" var="linkDetalhar" />
	                	<a href="${linkDetalhar}">Detalhar</a>
	                </td>
	            </tr>				
	        </c:forEach>
    	</table>
	</body>
</html>