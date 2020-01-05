<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.jsp"%>

<form role="form">
  <!-- 번호 -->
  <div class="form-group">
    <label for="formGroupExampleInput">#</label>
    <input type="text" value="${boardVO.bno}" class="form-control" id="bno" name="bno" readonly>
  </div>
  <!-- 제목  -->
   <div class="form-group">
    <label for="formGroupExampleInput">TITLE</label>
    <input type="text" value="${boardVO.title}" class="form-control" id="title" name="title" >
  </div>
  <!-- 작성자  -->
  <div class="form-group">
    <label for="formGroupExampleInput">WRITER</label>
    <input type="text" value="${boardVO.writer}" class="form-control" id="writer" name="writer">
  </div>
  <!-- 내용  -->
  <div class="form-group">
    <label for="formGroupExampleInput">CONTNET</label>
    <textarea class="form-control" id="content" name= "content" rows="3">${boardVO.content}</textarea>
  </div>
  <!-- 수정시간  -->
  <div class="form-group">
    <label for="formGroupExampleInput">UPDATEDATE</label>
    <input type="text" class="form-control" value="${boardVO.updatedate}" id="updatedate" name= "updatedate" readonly>
  </div>
  <!-- 등록시간  -->
  <div class="form-group">
    <label for="formGroupExampleInput">REGDATE</label>
    <input type="text" class="form-control" value="${boardVO.regdate}" id="regdate" name="regdate" readonly>
  </div>
</form>

<!--수정  -->
<button type="button" class="btn btn-warning">SAVE</button>
<!--삭제 -->
<button type="button" class="btn btn-danger">CANCEL</button>



<%@include file="../include/footer.jsp"%>


<script>
$(document).ready(function(){
	var formObj = $("form[role='form']");
	
	/* 수정 */
	//버튼 클릭이벤트 핸들러작성
	$(".btn-warning").on("click", function(){
		formObj.attr("method", "post");
		formObj.attr("action", "/board/modify");
		formObj.submit();
	});

	/* 취소 */
	$(".btn-danger").on("click", function(){
		self.location = "/board/listAll";
	});





});

</script>