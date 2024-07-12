<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="org.springframework.util.StringUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pagedListHolder" required="true"
	type="org.springframework.beans.support.PagedListHolder"%>
<%@ attribute name="pagedLink" required="true" type="java.lang.String"%>

<c:if test="${pagedListHolder.pageCount > 1}">
	<nav aria-label="Page navigation">
		<ul class="pagination">
			<!-- PREVIOUS - VI TRI KHONG PHAI TRANG DAU TIEN-->
			<c:if test="${!pagedListHolder.firstPage}">
				<li class="page-item"><a class="page-link"
					href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPage() - 1))%>"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
				</a></li>
			</c:if>

			<c:if test="${pagedListHolder.firstLinkedPage > 0}">
				<li class="page-item"><a class="page-link"
					href="<%=StringUtils.replace(pagedLink, "~", "0")%>">1</a></li>
			</c:if>

			<c:if test="${pagedListHolder.firstLinkedPage > 1}">
				<li class="page-item disabled"><span class="page-link">...</span></li>
			</c:if>

			<c:forEach begin="${pagedListHolder.firstLinkedPage}"
				end="${pagedListHolder.lastLinkedPage}" var="i">
				<c:choose>
					<c:when test="${pagedListHolder.page == i}">
						<li class="page-item active" aria-current="page"><span
							class="page-link">${pagedListHolder.page + 1}</span></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(jspContext.getAttribute("i")))%>">${i + 1}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<!-- PAGE IN THE MIDDLE - PREVIOUS ... 4 5 6 .. NEXT -->
			<c:if
				test="${pagedListHolder.lastLinkedPage < pagedListHolder.pageCount - 2}">
				<li class="page-item disabled"><span class="page-link">...</span></li>
			</c:if>

			<!-- LAST PAGE -->
			<c:if
				test="${pagedListHolder.lastLinkedPage < pagedListHolder.pageCount - 1}">
				<li class="page-item"><a class="page-link"
					href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPageCount() - 1))%>">${pagedListHolder.pageCount}</a></li>
			</c:if>

			<!-- NEXT - VI TRI HIEN TAI KHONG PHAI CUOI CUNG-->
			<c:if test="${!pagedListHolder.lastPage}">
				<li class="page-item"><a class="page-link"
					href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPage() + 1))%>"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Next</span>
				</a></li>
			</c:if>

		</ul>
	</nav>
</c:if>
