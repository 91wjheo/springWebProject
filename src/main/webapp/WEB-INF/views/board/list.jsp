<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.jsp"%>
<button type="button" class="btn btn-info" id="register">REGISTER</button>

<table class="table table-striped table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">TITLE</th>
      <th scope="col">WRITER</th>
      <th scope="col">CONTENT</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATEDATE</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach var="boardVO" items="${pagingList}">
        <tr>
          <td scope="row">${boardVO.bno}</td>
          
          
          <td>
          	<a href="/board/read?bno=${boardVO.bno}" >${boardVO.title}</a>
          </td>
          <td>${boardVO.writer}</td>
          <td>${boardVO.content}</td>
          <td>${boardVO.regdate}</td>
          <td>${boardVO.updatedate}</td>
        </tr>
  </c:forEach>
    
    
  </tbody>
</table>

<!-- 등록 결과 확인 모달창  -->
	<div class="modal fade" tabindex="-1" role="dialog" id="resultModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalTitle">등록/수정 완료</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>처리가 완료되었습니다.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 등록 결과 확인 모달창  -->





<%@include file="../include/footer.jsp"%>

<script>
	var modifyResult = "${modifyResult}";
	var deleteResult = "${deleteResult}";
	var registerResult = "${registerResult}";
	
	// 수정완료시 모달창
	if(modifyResult === "success"){
		$("#modalTitle").html("수정완료");
		$('#resultModal').modal('show');
	}

	// 삭제완료시 모달창
	if(deleteResult === "success"){
		$("#modalTitle").html("삭제완료");
		$('#resultModal').modal('show');
	}

	$("#register").on("click", function(){
		
		self.location = "/board/register";
		
	});
	
	// 등록완료시 모달창
	if(registerResult === "success"){
		$("#modalTitle").html("등록완료");
		$('#resultModal').modal('show');
	}
	
	
	
	
	
</script>




