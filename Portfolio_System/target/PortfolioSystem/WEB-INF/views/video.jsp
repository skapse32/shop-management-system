<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Spring MVC Starter Application</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/screen.css"/>"/>
	</head>

	<body>
		<div id="container">
			<div class="dualbrand">
				<img src="<c:url value="/static/resources/gfx/dualbrand_logo.png"/>"/>
			</div>
			<div id="content">
				<h1>Welcome to JBoss!</h1>

				<div>
					<p>You have successfully deployed a Spring MVC web application.</p>
					<h3>Your application can run on:</h3>
					<img src="<c:url value="/static/resources/gfx/dualbrand_as7eap.png"/>"/>
				</div>

				<form:form commandName="newVideo" id="reg">
					<h2>Member Registration</h2>
					<p>Enforces annotation-based constraints defined on the model class.</p>
					<table>
						<tbody>
							<tr>
								<td><form:label path="code">Name:</form:label></td>
								<td><form:input path="code"/></td>
								<td><form:errors class="invalid" path="name"/></td>
							</tr>
						</tbody>
					</table>
					<table>
						<tr>
							<td>
								<input type="submit" value="Register" class="register"/>
							</td>
						</tr>
					</table>
				</form:form>
				<h2>Members</h2>
				<c:choose>
					<c:when test="${videos.size()==0}">
						<em>No videos.</em>
					</c:when>
					<c:otherwise>
						<table class="simpletablestyle">
							<thead>
								<tr>
									<th>Id</th>
									<th>REST URL</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${videos}" var="video">
									<tr>
										<td>${video.videoId}</td>
										<td><a href="<c:url value="/rest/videos/${video.videoId}"/>">/rest/videos/${video.videoId}</a></td>
								</c:forEach>
							</tbody>
						</table>
						<table class="simpletablestyle">
							<tr>
								<td>
									REST URL for all members: <a href="<c:url value="/rest/videos"/>">/rest/members</a>
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<div id="aside">
				<p>Learn more about JBoss Enterprise Application Platform 6.</p>
				<ul>
					<li><a
						href="http://red.ht/jbeap-6-docs">Documentation</a></li>
					<li><a href="http://red.ht/jbeap-6">Product Information</a></li>
				</ul>
				<p>Learn more about JBoss AS 7.</p>
				<ul>
					<li><a
						href="https://docs.jboss.org/author/display/AS7/Getting+Started+Developing+Applications+Guide">Getting Started Developing Applications Guide</a></li>
					<li><a href="http://jboss.org/jbossas">Community Project Information</a></li>
				</ul>
			</div>
			<div id="footer">
			    <p>
					This project was generated from a Maven archetype from
			        	JBoss.<br />
			    </p>
			</div>
		</div>
	</body>
</html>
