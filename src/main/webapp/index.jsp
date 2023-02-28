
<!DOCTYPE html>

<html>
<head>

<style>
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<title></title>
<%@include file="componects/all_css.jsp"%>
</head>
<body>
	<%@include file="componects/navbar.jsp"%>

	<!-- --carusoles -->

	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="img/background.jpg"
					alt="First slide" height="500px">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="img/background3.jpg"
					alt="Second slide" height="500px">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="img/background4.jpg"
					alt="Third slide" height="500px">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>


	<!-- -next door -->

	<div class="container p-3">
		<p class="text-center fs-2">Key Features of our Hospital</p>

		<div class="row">
			<div class="col-md-8 p-5">

				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card">

							<div class="card-body">

								<p class="fs-5">100% safty</p>

								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Consequuntur excepturi id consequatur eos quae? Reprehenderit,
									totam cum animi est eveniet, ullam quas molestias, qui nulla
									quibusdam,</p>

							</div>
						</div>

					</div>

					<div class="col-md-6">
						<div class="card paint-card">

							<div class="card-body">

								<p class="fs-5">Clean Enveriment</p>

								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Consequuntur excepturi id consequatur eos quae? Reprehenderit,
									totam cum animi est eveniet, ullam quas molestias, qui nulla
									quibusdam,</p>
							</div>
						</div>

					</div>

					<div class="col-md-6">
						<div class="card paint-card">

							<div class="card-body">

								<p class="fs-5">Friendily Doctor</p>
								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Consequuntur excepturi id consequatur eos quae? Reprehenderit,
									totam cum animi est eveniet, ullam quas molestias, qui nulla
									quibusdam,</p>
							</div>
						</div>

					</div>

					<div class="col-md-6">
						<div class="card paint-card">

							<div class="card-body">

								<p class="fs-5">Medical Reserch</p>

								<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
									Consequuntur excepturi id consequatur eos quae? Reprehenderit,
									totam cum animi est eveniet, ullam quas molestias, qui nulla
									quibusdam,</p>
							</div>
						</div>

					</div>

				</div>

			</div>

			<div class="col-md-4">
				<img src="img/doctor1.jpg">
			</div>

		</div>



	</div>
	
	<hr>
	<div class="container py-5">
	 <div class="text-center py-5" >

      <h1 class="text-center">Our
          <span class="text-primary">Team</span>
          <hr /  class="w-25 m-auto">
      </h1>
     </div>
     
     <div class="row"  >  

<div class="col-sm-12 col-md-4 col-lg-4 col-12"  >

<!--card    Using grid markup-->
<div class="card bg-danger">
<div class="card-body text-center ">
   <!--img-->

   <img src="img/doctor1.jpg" class="img-fluid rounded-circle border border-primary p-2" >
   
  <h5 class="card-title">yuvraj</h5>
  <p class="card-text">Brain Doctor</p>
  <a href="#" class="btn btn-primary">Read More</a>
</div>
</div>
</div>

<div class="col-sm-12 col-md-4 col-lg-4 col-12" >

<div class="card bg-primary text-white">
<div class="card-body text-center">
   <!--img-->
   <img src="img/doctor1.jpg"  class="img-fluid rounded-circle border border-dark p-2" >
  <h5 class="card-title">Krishna</h5>
  <p class="card-text">Heart Doctor</p>
  <a href="#" class="btn btn-primary">Read More</a>
</div>
</div>
</div>

<div class="col-sm-12 col-md-4 col-lg-4 col-12" >
<div class="card bg-success">
<div class="card-body text-center">
   <!--img-->
   
   <img src="img/doctor1.jpg" class="img-fluid rounded-circle border border-primary p-2">
  <h5 class="card-title">Alshya</h5>
  <p class="card-text">Eye Doctor</p>
  <a href="#" class="btn btn-primary">Read More</a>
</div>
</div>
</div>


</div>
  </div>
     
	<%@include file="componects/footer.jsp"%>

</body>
</html>
