<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.jsp"%>

<form role="form">

  <!-- 제목  -->
   <div class="form-group">
    <label for="formGroupExampleInput">TITLE</label>
    <input type="text"  class="form-control" id="title" name="title"  >
  </div>
  <!-- 작성자  -->
  <div class="form-group">
    <label for="formGroupExampleInput">WRITER</label>
    <input type="text" class="form-control" id="writer" name="writer" >
  </div>
  <!-- 내용  -->
  <div class="form-group">
    <label for="formGroupExampleInput">CONTNET</label>
    <textarea class="form-control" id="content" name= "content" rows="3"  ></textarea>
  </div>

</form>

<!-- 저장  -->
<button type="button" class="btn btn-warning">REGISTER</button>
<!-- 취소 -->
<button type="button" class="btn btn-danger">CANCEL</button>


<%@include file="../include/footer.jsp"%>


<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");
	
	/* 저장 */
	//버튼 클릭이벤트 핸들러작성
	$(".btn-warning").on("click", function(){
		formObj.attr("method", "post");
		formObj.attr("action", "/board/register");
		formObj.submit();
	});

	/* 취소 */
	$(".btn-danger").on("click", function(){
		self.location = "/board/listAll";
	});
	



});

</script>