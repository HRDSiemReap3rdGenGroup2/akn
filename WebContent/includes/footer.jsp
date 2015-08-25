<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!-- Footer -->
<footer id="footer">
	<div class="container">
		<div class="column-one-third">
			<h5 class="line">
				<span>ទំនាក់ទំនង</span>
			</h5>
			<div class="flickrfeed">
				<p>អស័យដ្ឋាន: ផ្ទះលេខ#12, ផ្លូវ 323, សង្កាត់​បឹងកក់ II </p>
				<p>Tel: (855)23 99 13 14</p>
				<p>(855)77 77 12 36 (ខ្មែរ, អង់គ្លេស)</p>
				<p>អ៊ីម៉ែល: info.kshrd@gmail.com</p>
				<p>
					ទំនាក់ទំនង : <a href="contact" style="color:#f00;">ពត៌មានលម្អិត</a>
				</p>
			</div>
		</div>

		<div class="column-one-third">
			<h5 class="line">
				<span>ប្រភេទពត៌មាន</span>
			</h5>
			<ul class="footnav">
				<c:forEach items="${requestScope.menu }" var="i">
    	           	<li><a href="category?id=${i.index}"><i class="icon-right-open"></i>${i.name}</a></li>
                </c:forEach>
			</ul>
		</div>

		<div class="column-one-third">
			<h5 class="line">
				<span>Facebook</span>
			</h5>
			<div class="fb-page" data-href="https://www.facebook.com/KhmerAcademy.Org" data-width="300" data-height="298" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true" data-show-posts="false"><div class="fb-xfbml-parse-ignore"><blockquote cite="https://www.facebook.com/KhmerAcademy.Org"><a href="https://www.facebook.com/KhmerAcademy.Org">Khmer Academy</a></blockquote></div></div>
		</div>
		<p class="copyright">Copyright 2015. All Rights Reserved</p>
	</div>
</footer>
<!-- / Footer -->
