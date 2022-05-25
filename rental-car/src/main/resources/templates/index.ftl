<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>RentNow - Responsive Car Rental Template</title>

		<!-- Preloader CSS-->
		<style>#preloader:after,#preloader:before{content:"";display:block;left:-1px;top:-1px}#preloader-overlayer,#preloader:after,#preloader:before{position:absolute;height:100%;width:100%}#preloader-overlayer{position:fixed;top:0;left:0;background-color:#112E3B;z-index:999}#preloader{height:40px;width:40px;position:fixed;top:50%;left:50%;margin-top:-20px;margin-left:-20px;z-index:9999}#preloader:before{-webkit-animation:rotation 1s linear infinite;animation:rotation 1s linear infinite;border:2px solid #42DB0C;border-top:2px solid transparent;border-radius:100%}#preloader:after{border:1px solid rgba(255,255,255,.1);border-radius:100%}@media only screen and (min-width:768px){#preloader{height:60px;width:60px;margin-top:-30px;margin-left:-30px}#preloader:before{left:-2px;top:-2px;border-width:2px}}@media only screen and (min-width:1200px){#preloader{height:80px;width:80px;margin-top:-40px;margin-left:-40px}}@-webkit-keyframes rotation{from{-webkit-transform:rotate(0);transform:rotate(0)}to{-webkit-transform:rotate(359deg);transform:rotate(359deg)}}@keyframes rotation{from{-webkit-transform:rotate(0);transform:rotate(0)}to{-webkit-transform:rotate(359deg);transform:rotate(359deg)}}</style>

		<!--
		All CSS Codes Loaded
		Ex: bootstrap, fontawesome, style, etc.
		-->
		<link rel="stylesheet" href="http://cdn.bootstrapmb.com/bootstrap/4.1.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="static/libs/fontawesome/css/fontawesome-all.min.css">
		<link rel="stylesheet" href="static/libs/linearicons/linearicons.css">
		<link rel="stylesheet" href="static/css/rentnow-icons.css">
		<link rel="stylesheet" href="static/libs/flatpickr/flatpickr.min.css">
		<link rel="stylesheet" href="static/css/magnific-popup.css">
		<link rel="stylesheet" href="static/css/style.css">
		<script>
			var base_url = '${request.contextPath}';
		</script>
		<!-- Google Map JS-->
		<script src="http://ditu.google.cn/maps/api/js?key=AIzaSyCOdKtT5fapH3_OfhV3HFeZjqFs4OfNIew"></script>
	</head>
	<body class="rn-preloader">
		<div id="preloader"></div>
		<div id="preloader-overlayer"></div>

		<!-- Header-->
		<header class="rn-header">

			<!-- Menubar-->
			<div class="rn-menubar">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-4">
							<!-- Logo-->
							<a class="brand-name" href="index.html">
								<img class="img-fluid" src="static/images/logo.svg" alt="Logo">
							</a>
						</div>
					</div>
				</div>
			</div>
			<!-- End Menubar-->

		</header>
		<!-- End Header-->

		<!-- Slider-->
		<div class="rn-carousel carousel slide" id="carouselExampleControls" data-ride="carousel">
			<div class="carousel-inner">

				<!-- Slider Item 1-->
				<div class="carousel-item beactive">
					<div class="carousel-caption">
						<h2 class="rn-fade-bottom mb-25">#1 Car Rent Service In Your City</h2>
						<p class="rn-fade-bottom rn-caption-item-2 mb-35">Maecenas viverra porta eros, id tincidunt lorem rhoncus eget. Aliquam erat volutpat. Sed ultricies elementum egestas.</p>
						<a class="btn btn-main btn-lg rn-fade-bottom rn-caption-item-3" href="#">Book Now</a>
					</div>
					<div class="rn-slider-overlayer"></div>
					<img class="d-block w-100" src="static/images/slide1.jpg" alt="slide">
				</div>

				<!-- Slider Item 2-->
				<div class="carousel-item">
					<div class="carousel-caption">
						<h2 class="rn-fade-bottom mb-25">Quality Cars with Unlimited Miles</h2>
						<p class="rn-fade-bottom rn-caption-item-2 mb-35">Maecenas viverra porta eros, id tincidunt lorem rhoncus eget. Aliquam erat volutpat. Sed ultricies elementum egestas.</p>
						<a class="btn btn-main btn-lg rn-fade-bottom rn-caption-item-3" href="#">Book Now</a>
					</div>
					<div class="rn-slider-overlayer"></div>
					<img class="d-block w-100" src="static/images/slide2.jpg" alt="slide">
				</div>

				<!-- Slider Item 3-->
				<div class="carousel-item">
					<div class="carousel-caption">
						<h2 class="rn-fade-bottom mb-25">24/7 Customer Support Guarantee</h2>
						<p class="rn-fade-bottom rn-caption-item-2 mb-35">Maecenas viverra porta eros, id tincidunt lorem rhoncus eget. Aliquam erat volutpat. Sed ultricies elementum egestas.</p>
						<a class="btn btn-main btn-lg rn-fade-bottom rn-caption-item-3" href="#">Book Now</a>
					</div>
					<div class="rn-slider-overlayer"></div>
					<img class="d-block w-100" src="static/images/slide3.jpg" alt="slide">
				</div>

			</div>
			<!-- Slider Controls -->
			<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
				<span class="lnr lnr-chevron-left" aria-hidden="true"></span>
			</a>
			<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
				<span class="lnr lnr-chevron-right" aria-hidden="true"></span>
			</a>
		</div>
		<!-- End slider-->
		<div class="rn-section rn-car-search-results">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">

						<!-- Car Search Filters-->
						<div class="rn-car-search-filters">
							<div class="rn-car-search-filter-item">
								<label>Car Brand:</label>
								<select>
									<option value="Any">Any</option>
									<option value="Rover">Rover</option>
									<option value="Lexus">Lexus</option>
									<option value="BMW">BMW</option>
									<option value="Tesla">Tesla</option>
									<option value="Lamborghini">Lamborghini</option>
								</select>
							</div>
							<div class="rn-car-search-filter-item">
								<label>Passengers:</label>
								<select>
									<option value="Any">Any</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
								</select>
							</div>
							<div class="rn-car-search-filter-item">
								<label>Color:</label>
								<ul class="rn-car-color-filter">
									<li>
										<label>
											<input type="checkbox">
											<span class="rn-color-silver"></span>
										</label>
									</li>
									<li>
										<label>
											<input type="checkbox">
											<span class="rn-color-black"></span>
										</label>
									</li>
									<li>
										<label>
											<input type="checkbox">
											<span class="rn-color-white"></span>
										</label>
									</li>
									<li>
										<label>
											<input type="checkbox">
											<span class="rn-color-red"></span>
										</label>
									</li>
								</ul>
							</div>
							<div class="rn-car-search-filter-item rn-csf-item-last">
								<label>Sort by:</label>
								<select>
									<option value="Default">Default</option>
									<option value="Relavent">Relavent</option>
									<option value="Price: High to Low">Price: High to Low</option>
									<option value="Price: Low to High">Price: Low to High</option>
									<option value="Name: A to Z">Name: A to Z</option>
									<option value="Name: Z to A">Name: Z to A</option>
								</select>
							</div>
						</div>
						<!-- End Car Search Filters-->
						<div>
							<#list carList as car>
							<!-- Car Search Item-->
							<div class="rn-car-search-item">
							<div class="rn-car-search-item-thumb">
								<a href="#">
									<img class="img-fluid" src="static/images/car-search-item-1.jpg" alt="" srcset="static/images/car-search-item-1.jpg 1x, static/images/car-search-item-1.jpg 2x"/>
								</a>
							</div>
							<div class="rn-car-search-item-info">
								<h2 class="rn-car-search-item-title">
									<a href="#">${car.carModel}</a>
								</h2>
								<div class="rn-car-reviews">
									<div class="rn-car-stars">
										<i class="fas fa-star"></i>
										<i class="fas fa-star"></i>
										<i class="fas fa-star"></i>
										<i class="fas fa-star"></i>
										<i class="far fa-star"></i>
									</div>
									<a href="#">stock is ${car.stock}</a>
								</div>
								<p>Mauris semper nisl a massa convallis</p>
								<div class="rn-car-meta">
									<span>
										<i class="rni-car-seat"></i> 3 Passengers
									</span>
									<span>
										<i class="rni-suitcase"></i> 2 Luggages
									</span>
									<span>
										<i class="rni-petrol-station"></i> Gas
									</span>
									<span>
										<i class="rni-car-gear"></i> Auto
									</span>
									<span>
										<i class="rni-car-door"></i> 4 Doors
									</span>
								</div>
								<a class="rn-car-more-info" href="#">More Information</a>
							</div>
							<div class="rn-car-search-item-pricing">
								<div class="rn-car-total-price">
									<span>¥</span><span>${car.fee}</span>/total
								</div>
								<div class="rn-car-price">
									<span>¥</span><span>${car.fee}</span>/day
								</div>
								<#if car.stock < 1 >
								<button class="btn btn-light btn-lg btn-shadow " data-carId = "${car.carId}" >Book Now</button>
								<#else>
                                <button class="btn btn-main btn-lg btn-shadow btn-book"   data-carId = "${car.carId}" >Book Now</button>
							    </#if>
							</div>
						</div>
							<!-- End Car Search Item-->
							</#list>
						</div>

						<!-- Load More Cars-->
						<!--						<div class="text-center">-->
						<!--							<a class="btn btn-lg btn-outline-light mb-40" href="#">Load More</a>-->
						<!--						</div>-->
					</div>
				</div>
			</div>
		</div>

		<!-- Popular Cars Section-->
		<section class="rn-section rn-section-light-gray">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">

						<!-- Section Title-->
						<div class="rn-section-title  rn-title-bg-color-white ">
							<h2 class="rn-title">My Orders</h2>
							<p>tks for your order</p>
							<span class="rn-title-bg">Most Popular Cars</span>
						</div>

					</div>
				</div>
				<div class="row">
					<#if orderListCount != 0 >
					<#list orderList as order>
					<div class="col-lg-6 col-md-6">

						<!-- Car Item-->
						<div class="rn-car-item">
							<div class="rn-car-item-review">
								${order.statusDesc}
							</div>
							<div class="rn-car-item-thumb">
								<a href="#">
									<img class="img-fluid" src="static/images/car-1.jpg" alt="${order.carModel}" srcset="static/images/car-1.jpg 1x, static/images/car-1.jpg 2x"/>
								</a>
							</div>
							<div class="rn-car-item-info">
								<h3>
									<a href="#">${order.carModel}</a>
								</h3>
								<p>Mauris semper nisl a massa convallis</p>
								<div class="rn-car-list-n-price">
									<ul>
										<li>bookTime:${order.bookTime?string["yyyy-MM-dd hh:mm:ss a"]}</li>
										<li>totalFee:${order.totalFee}</li>
										<li>useDays:${order.useDays}</li>
										<li>payTime:${order.bookTime?string["yyyy-MM-dd hh:mm:ss a"]}</li>
									</ul>
									<div class="rn-car-price-wrap">
											<#if order.orderStatus==0>
										<button class="rn-car-price btn-pay" data-orderid="${order.orderId}" data-fee="${order.totalFee}">
											<span class="rn-car-price-format">
												<span >PAY ORDER</span>
											</span>
										</button>
										<#elseif order.orderStatus ==1 >
										<button class="rn-car-price btn-return" data-orderId="${order.orderId}">
											<span class="rn-car-price-format">
												<span>RETURN CAR</span>
											</span>
										</button>
											</#if>

									</div>
								</div>
							</div>
						</div>
						<!-- End Car Item-->

					</div>
					</#list>
					</#if>
				</div>
			</div>
		</section>
		<!-- End Popular Cars Section-->
		<!-- End Recent New/Posts-->
		<!-- Site Footer-->
		<footer class="rn-footer">

			<!-- Footer Widgets-->
			<div class="rn-footer-widgets">
				<div class="container">
					<div class="row">
						<div class="col-md-4">

							<!-- Widget Item-->
							<section class="rn-widget">
								<h2 class="rn-widget-title">About Us</h2>
								<div class="rn-widget-content">
									<a class="brand-name" href="index.html">
										<img src="static/images/logo.svg" alt="Logo">
									</a>
									<p>Sed sit amet ligula ac nulla finibus euismod nec nec diam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent semper, risus eget ornare maximus, ipsum ante semper.</p>
									<ul class="rn-widget-social">
										<li>
											<a href="#">
												<i class="fab fa-facebook-f"></i>
											</a>
										</li>
										<li>
											<a href="#">
												<i class="fab fa-twitter"></i>
											</a>
										</li>
										<li>
											<a href="#">
												<i class="fab fa-instagram"></i>
											</a>
										</li>
										<li>
											<a href="#">
												<i class="fab fa-linkedin-in"></i>
											</a>
										</li>
									</ul>
								</div>
							</section>
							<!-- End Widget Item-->

						</div>
						<div class="col-md-5">

							<!-- Widget Item-->
							<section class="rn-widget">
								<h2 class="rn-widget-title">Quick Links</h2>
								<div class="rn-widget-content">
									<div class="row rn-quick-links">
										<div class="col-6">
											<ul>
												<li>
													<a href="#">About Us</a>
												</li>
												<li>
													<a href="#">Contact Us</a>
												</li>
												<li>
													<a href="#">Support</a>
												</li>
												<li>
													<a href="#">View Booking</a>
												</li>
												<li>
													<a href="#">Affiliate Programme</a>
												</li>
												<li>
													<a href="#">Marketplace</a>
												</li>
											</ul>
										</div>
										<div class="col-6">
											<ul>
												<li>
													<a href="#">Site Map</a>
												</li>
												<li>
													<a href="#">Careers</a>
												</li>
												<li>
													<a href="#">Press</a>
												</li>
												<li>
													<a href="#">Get a Receipt</a>
												</li>
												<li>
													<a href="#">Community</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</section>
							<!-- End Widget Item-->

						</div>
						<div class="col-md-3">

							<!-- Widget Item-->
							<section class="rn-widget">
								<h2 class="rn-widget-title">Contact Us</h2>
								<div class="rn-widget-content">
									<div class="rn-icon-contents">
										<div class="rn-phone rn-icon-content">
											<div class="rn-icon">
												<i class="lnr lnr-phone"></i>
											</div>
											<div class="rn-info">
												<ul>
													<li>(954)-944-1250</li>
													<li>(954)-944-1251</li>
												</ul>
											</div>
										</div>
										<div class="rn-email rn-icon-content">
											<div class="rn-icon">
												<i class="lnr lnr-envelope"></i>
											</div>
											<div class="rn-info">
												<ul>
													<li>support@example.coms</li>
													<li>sale@example.com</li>
												</ul>
											</div>
										</div>
										<div class="rn-address rn-icon-content">
											<div class="rn-icon">
												<i class="lnr lnr-map-marker"></i>
											</div>
											<div class="rn-info">
												<ul>
													<li>1425 Pointe Lane, Miami</li>
													<li>Florida – 33169, USA</li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</section>
							<!-- End Widget Item-->

						</div>
					</div>
				</div>
			</div>
			<!-- End Footer Widgets-->

			<!-- Footer Copyright-->
			<div class="rn-footer-copyright">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-md-6">
							<p>Copyright &copy; RentNow 2018. All rights <a href="http://www.bootstrapmb.com/" title="bootstrapmb">reserved</a>.</p>
						</div>
						<div class="col-md-6 text-right">
							<span class="rn-pyament-methods">
								<span>We Accept</span>
								<img src="static/images/payments.png" alt="payments" srcset="static/images/payments.png 1x, static/images/payments.png 2x">
							</span>
						</div>
					</div>
				</div>
			</div>
			<!-- End Footer Copyright-->

		</footer>
		<!-- End Site Footer-->

		<!--
		All JavaScripts Codes Loaded
		Ex: jquery, bootstrap, etc.
		-->
		<script src="static/js/jquery.min.js"></script>
		<script src="static/js/popper.min.js"></script>
		<script src="http://cdn.bootstrapmb.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script src="static/libs/flatpickr/flatpickr.min.js"></script>
		<script src="static/js/starrr.min.js"></script>
		<script src="static/js/jquery.magnific-popup.min.js"></script>
		<script src="static/js/scripts.js"></script>
		<script src="static/layer/layer.js"></script>
		<script src="static/js/index.js?v=4"></script>
	</body>
</html>