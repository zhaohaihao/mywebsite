<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
	<head>
		<title>contact</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="${ctx}/css/main.css" />
	</head>
	<body>
		<div class="page-wrap">

			<!-- Main -->
				<section id="main">

					<!-- Header -->
						<header id="header">
							<div>Snapshot <span>by TEMPLATED</span></div>
						</header>

					<!-- Section -->
						<section>
							<div class="inner">
								<header>
									<h1>Generic</h1>
								</header>
								<p>Faucibus parturient mus phasellus vestibulum suspendisse dui vel ridiculus nibh diam placerat tellus scelerisque facilisi mus vestibulum arcu mus praesent in blandit. Conubia ullamcorper cum rhoncus vitae dapibus venenatis integer in donec egestas lacus nibh vestibulum habitasse accumsan parturient malesuada sociis auctor scelerisque vehicula urna eu proin euismod. Id facilisi suspendisse parturient leo mus condimentum natoque scelerisque ullamcorper odio tristique ultricies arcu ac condimentum facilisi scelerisque class commodo. Scelerisque sagittis magna mi duis iaculis id erat pharetra vestibulum condimentum hac suspendisse tempor leo aliquet penatibus parturient donec parturient parturient. Vehicula suspendisse sem a adipiscing est ad donec ultricies senectus magnis convallis a fringilla adipiscing vulputate dui elementum diam ipsum eleifend condimentum placerat facilisi viverra mollis scelerisque. Commodo cum vestibulum hendrerit sit condimentum at rutrum vulputate scelerisque erat convallis himenaeos consequat a hac ultrices nam vel suspendisse nascetur dictum vulputate sed at.</p>
								<h2>Ultricies Senectus Magnis</h2>
								<p>Scelerisque sagittis magna mi duis iaculis id erat pharetra vestibulum condimentum hac suspendisse tempor leo aliquet penatibus parturient donec parturient parturient. Vehicula suspendisse sem a adipiscing est ad donec ultricies senectus magnis convallis a fringilla adipiscing vulputate dui elementum diam ipsum eleifend condimentum placerat facilisi viverra mollis scelerisque. Commodo cum vestibulum hendrerit sit condimentum at rutrum vulputate scelerisque erat convallis himenaeos consequat a hac ultrices nam vel suspendisse nascetur dictum vulputate sed at.</p>
								<section class="columns double">
									<div class="column">
										<span class="image left special"><img src="${ctx}/images/pic01.jpg" alt="" /></span>
										<h3>Parturient Consequat Neque</h3>
										<p>
											Adipiscing dis a mus a convallis condimentum molestie penatibus iaculis pulvinar vestibulum enim lacus suscipit mi dictumst hendrerit sit condimentum at rutrum vulputate vestibulum habitasse nam fusce a nascetur. Ut ullamcorper suspendisse malesuada tempus vestibulum commodo habitasse suspendisse magnis.
										</p>
									</div>
									<div class="column">
										<span class="image left special"><img src="${ctx}/images/pic02.jpg" alt="" /></span>
										<h3>Ridiculus Torquent Quam Accumsan</h3>
										<p>
											At sem phasellus elit class dapibus lectus posuere donec morbi in cras commodo faucibus ipsum vehicula fringilla. Risus hendrerit sit condimentum at rutrum vulputate fringilla dis curae metus ipsum imperdiet vulputate sapien dolorem ligula sapien curae consequat vestibulum urna. Nulla vulputate cum augue non arcu.
										</p>
									</div>
								</section>
							</div>
						</section>

					<!-- Contact -->
						<section id="contact">
							<!-- Social -->
								<div class="social column">
									<h3>About Me</h3>
									<p>Mus sed interdum nunc dictum rutrum scelerisque erat a parturient condimentum potenti dapibus vestibulum condimentum per tristique porta. Torquent a ut consectetur a vel ullamcorper a commodo a mattis ipsum class quam sed eros vestibulum quisque a eu nulla scelerisque a elementum vestibulum.</p>
									<p>Aliquet dolor ultricies sem rhoncus dolor ullamcorper pharetra dis condimentum ullamcorper rutrum vehicula id nisi vel aptent orci litora hendrerit penatibus erat ad sit. In a semper velit eleifend a viverra adipiscing a phasellus urna praesent parturient integer ultrices montes parturient suscipit posuere quis aenean. Parturient euismod ultricies commodo arcu elementum suspendisse id dictumst at ut vestibulum conubia quisque a himenaeos dictum proin dis purus integer mollis parturient eros scelerisque dis libero parturient magnis.</p>
									<h3>Follow Me</h3>
									<ul class="icons">
										<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
										<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
									</ul>
								</div>

							<!-- Form -->
								<div class="column">
									<h3>Get in Touch</h3>
									<form action="#" method="post">
										<div class="field half first">
											<label for="name">Name</label>
											<input name="name" id="name" type="text" placeholder="Name">
										</div>
										<div class="field half">
											<label for="email">Email</label>
											<input name="email" id="email" type="email" placeholder="Email">
										</div>
										<div class="field">
											<label for="message">Message</label>
											<textarea name="message" id="message" rows="6" placeholder="Message"></textarea>
										</div>
										<ul class="actions">
											<li><input value="Send Message" class="button" type="submit"></li>
										</ul>
									</form>
								</div>

						</section>

					<!-- Footer -->
						<footer id="footer">
							<div class="copyright">
							</div>
						</footer>
				</section>
		
			<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="index.html"><span class="icon fa-home"></span></a></li>
						<li><a href="gallery.html"><span class="icon fa-camera-retro"></span></a></li>
						<li><a href="generic.html" class="active"><span class="icon fa-file-text-o"></span></a></li>
						<li><a href="javascript:void(0);"><span class="icon fa-paper-plane"></span></a></li>
					</ul>
				</nav>
		</div>

		<!-- Scripts -->
			<script src="${ctx}/js/jquery.min.js"></script>
			<script src="${ctx}/js/jquery.poptrox.min.js"></script>
			<script src="${ctx}/js/jquery.scrolly.min.js"></script>
			<script src="${ctx}/js/skel.min.js"></script>
			<script src="${ctx}/js/util.js"></script>
			<script src="${ctx}/js/main.js"></script>

	</body>
</html>