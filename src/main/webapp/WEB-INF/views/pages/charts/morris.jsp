<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>AdminLTE | Morris.js Charts</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/resources/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris charts -->
        <link href="${pageContext.request.contextPath}/resources/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/resources/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.${pageContext.request.contextPath}/resources/js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Morris Charts <small>Preview sample</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Charts</a></li>
			<li class="active">Morris</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<div class="row">
			<div class="col-md-6">
				<!-- AREA CHART -->
				<div class="box box-primary">
					<div class="box-header">
						<h3 class="box-title">Area Chart</h3>
					</div>
					<div class="box-body chart-responsive">
						<div class="chart" id="revenue-chart" style="height: 300px;"></div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

				<!-- DONUT CHART -->
				<div class="box box-danger">
					<div class="box-header">
						<h3 class="box-title">Donut Chart</h3>
					</div>
					<div class="box-body chart-responsive">
						<div class="chart" id="sales-chart"
							style="height: 300px; position: relative;"></div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

			</div>
			<!-- /.col (LEFT) -->
			<div class="col-md-6">
				<!-- LINE CHART -->
				<div class="box box-info">
					<div class="box-header">
						<h3 class="box-title">Line Chart</h3>
					</div>
					<div class="box-body chart-responsive">
						<div class="chart" id="line-chart" style="height: 300px;"></div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

				<!-- BAR CHART -->
				<div class="box box-success">
					<div class="box-header">
						<h3 class="box-title">Bar Chart</h3>
					</div>
					<div class="box-body chart-responsive">
						<div class="chart" id="bar-chart" style="height: 300px;"></div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->

			</div>
			<!-- /.col (RIGHT) -->
		</div>
		<!-- /.row -->

	</section>
	<!-- /.content -->


	<!-- jQuery 2.0.2 -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>

        <!-- Morris.js charts -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/plugins/morris/morris.min.js" type="text/javascript"></script>

        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="${pageContext.request.contextPath}/resources/js/AdminLTE/demo.js" type="text/javascript"></script>
        <!-- page script -->
        <script type="text/javascript">
									$(function() {
										"use strict";

										// AREA CHART
										var area = new Morris.Area(
												{
													element : 'revenue-chart',
													resize : true,
													data : [ {
														y : '2011 Q1',
														item1 : 2666,
														item2 : 2666
													}, {
														y : '2011 Q2',
														item1 : 2778,
														item2 : 2294
													}, {
														y : '2011 Q3',
														item1 : 4912,
														item2 : 1969
													}, {
														y : '2011 Q4',
														item1 : 3767,
														item2 : 3597
													}, {
														y : '2012 Q1',
														item1 : 6810,
														item2 : 1914
													}, {
														y : '2012 Q2',
														item1 : 5670,
														item2 : 4293
													}, {
														y : '2012 Q3',
														item1 : 4820,
														item2 : 3795
													}, {
														y : '2012 Q4',
														item1 : 15073,
														item2 : 5967
													}, {
														y : '2013 Q1',
														item1 : 10687,
														item2 : 4460
													}, {
														y : '2013 Q2',
														item1 : 8432,
														item2 : 5713
													} ],
													xkey : 'y',
													ykeys : [ 'item1', 'item2' ],
													labels : [ 'Item 1',
															'Item 2' ],
													lineColors : [ '#a0d0e0',
															'#3c8dbc' ],
													hideHover : 'auto'
												});

										// LINE CHART
										var line = new Morris.Line({
											element : 'line-chart',
											resize : true,
											data : [ {
												y : '2011 Q1',
												item1 : 2666
											}, {
												y : '2011 Q2',
												item1 : 2778
											}, {
												y : '2011 Q3',
												item1 : 4912
											}, {
												y : '2011 Q4',
												item1 : 3767
											}, {
												y : '2012 Q1',
												item1 : 6810
											}, {
												y : '2012 Q2',
												item1 : 5670
											}, {
												y : '2012 Q3',
												item1 : 4820
											}, {
												y : '2012 Q4',
												item1 : 15073
											}, {
												y : '2013 Q1',
												item1 : 10687
											}, {
												y : '2013 Q2',
												item1 : 8432
											} ],
											xkey : 'y',
											ykeys : [ 'item1' ],
											labels : [ 'Item 1' ],
											lineColors : [ '#3c8dbc' ],
											hideHover : 'auto'
										});

										//DONUT CHART
										var donut = new Morris.Donut({
											element : 'sales-chart',
											resize : true,
											colors : [ "#3c8dbc", "#f56954",
													"#00a65a" ],
											data : [ {
												label : "Download Sales",
												value : 12
											}, {
												label : "In-Store Sales",
												value : 30
											}, {
												label : "Mail-Order Sales",
												value : 20
											} ],
											hideHover : 'auto'
										});
										//BAR CHART
										var bar = new Morris.Bar(
												{
													element : 'bar-chart',
													resize : true,
													data : [ {
														y : '2006',
														a : 100,
														b : 90
													}, {
														y : '2007',
														a : 75,
														b : 65
													}, {
														y : '2008',
														a : 50,
														b : 40
													}, {
														y : '2009',
														a : 75,
														b : 65
													}, {
														y : '2010',
														a : 50,
														b : 40
													}, {
														y : '2011',
														a : 75,
														b : 65
													}, {
														y : '2012',
														a : 100,
														b : 90
													} ],
													barColors : [ '#00a65a',
															'#f56954' ],
													xkey : 'y',
													ykeys : [ 'a', 'b' ],
													labels : [ 'CPU', 'DISK' ],
													hideHover : 'auto'
												});
									});
								</script>

    </body>
</html>