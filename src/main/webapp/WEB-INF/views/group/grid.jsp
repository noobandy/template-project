<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLTE | Group grid</title>
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
				<div class="btn-group">
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/user/newUser"><i class="fa fa-plus"></i></a>
					<a class="btn btn-primary"><i class="fa fa-edit"></i></a>
					<a class="btn btn-danger"><i class="fa fa-trash-o"></i></a>
				</div>
			</div>
		</div>
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
								<th>Group Name</th>
								<th>Deny Group?</th>
								<th>Enabled</th>
							</thead>
							<tbody>

							</tbody>
							<tfoot>
								<tr>
								<th>Id</th>
								<th>Group Name</th>
								<th>Deny Group?</th>
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
                            "sAjaxSource": "${pageContext.request.contextPath}/ajax/groupData",
                            "aoColumns": [
                                          { "mData": "id","sName": "id","bSearchable":false,
                                        	  "fnRender" : function(obj) {
                                                   return '<input type="radio" name="selectedGroup" class="dt_checked" value="'+obj.aData.id+'\"/>';
                                                 }  
                                          },
                                          { "mData": "groupName","sName": "groupName","bSearchable":true},
                                          { "mData": "denyGroup","sName": "denyGroup","bSearchable":false,
                                        	  "fnRender" : function(obj) {
                                                  if (obj.aData.denyGroup)
                                                   return '<input type="checkbox" name="aCheckBox" class="dt_checked" checked value="'+obj.aData.denyGroup+'\"/>';

                                                  return '<input type="checkbox" name="aCheckBox"  class="dt_checked" value="'+obj.aData.denyGroup+'\"/>';
                                                 }
                                          },
                                          { "mData": "enabled","sName": "enabled","bSearchable":false,
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