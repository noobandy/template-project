<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE | User grid</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.0.2 -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="${pageContext.request.contextPath}/resources/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- DATA TABLES -->
<link
	href="${pageContext.request.contextPath}/resources/css/datatables/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link
	href="${pageContext.request.contextPath}/resources/css/AdminLTE.css"
	rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.${pageContext.request.contextPath}/resources/js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body>

	<section class="content-header">
		<h1>
			Data Tables <small>advanced tables</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Tables</a></li>
			<li class="active">Data tables</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">Hover Data Table</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive">
						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<th>Id</th>
								<th>User Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Gender</th>
								<th>DOB</th>
								<th>Email</th>
								<th>Contact</th>
								<th>Expire on</th>
								<th>Admin</th>
								<th>Enabled</th>
							</thead>
							<tbody>

							</tbody>
							<tfoot>
								<tr>
									<th>Id</th>
									<th>User Id</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Gender</th>
									<th>DOB</th>
									<th>Email</th>
									<th>Contact</th>
									<th>Expire on</th>
									<th>Admin</th>
									<th>Enabled</th>
								</tr>
							</tfoot>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
	<!-- /.content -->



	<!-- jQuery 2.0.2 -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- DATA TABES SCRIPT -->
	<script
		src="${pageContext.request.contextPath}/resources/js/plugins/datatables/jquery.dataTables.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/plugins/datatables/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js"
		type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script
		src="${pageContext.request.contextPath}/resources/js/AdminLTE/demo.js"
		type="text/javascript"></script>
	<!-- page script -->
	<script type="text/javascript">
            $(function() {
               $("#example1").dataTable({
                			"bProcessing": true,
                            "bServerSide": true,
                            "sAjaxSource": "${pageContext.request.contextPath}/ajax/userData",
                            "aoColumns": [
                                          { "mData": "id","sName": "id","bSearchable":false},
                                          { "mData": "userId","sName": "userAccount.userId","bSearchable":true},
                                          { "mData": "firstName","sName": "userProfile.firstName","bSearchable":true},
                                          { "mData": "lastName","sName": "userProfile.lastName","bSearchable":true},
                                          { "mData": "gender","sName": "userProfile.gender","bSearchable":false},
                                          { "mData": "dob","sName": "userProfile.dob","bSearchable":false},
                                          { "mData": "emailId","sName": "userProfile.emailId","bSearchable":true},
                                          { "mData": "contactNumber","sName": "userProfile.contactNumber","bSearchable":true},
                                          { "mData": "expireOn","sName": "userAccount.expireOn","bSearchable":false},
                                          { "mData": "admin","sName": "userAccount.admin","bSearchable":false,
                                        	  "fnRender" : function(obj) {
                                                  if (obj.aData.admin)
                                                   return '<input type="checkbox" name="aCheckBox" class="dt_checked" checked value="'+obj.aData.admin+'\"/>';

                                                  return '<input type="checkbox" name="aCheckBox"  class="dt_checked" value="'+obj.aData.admin+'\"/>';
                                                 }
                                          },
                                          { "mData": "enabled","sName": "userAccount.enabled","bSearchable":false,
                                        	  "fnRender" : function(obj) {
                                                  if (obj.aData.enabled)
                                                   return '<input type="checkbox" name="aCheckBox" class="dt_checked" checked value="'+obj.aData.enabled+'\"/>';

                                                  return '<input type="checkbox" name="aCheckBox"  class="dt_checked" value="'+obj.aData.enabled+'\"/>';
                                                 }
                                        	  }   
                                          ]
                		});
            });
        </script>

</body>
</html>