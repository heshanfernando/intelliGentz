<%-- 
    Document   : userAccount
    Created on : Jun 8, 2015, 4:59:16 PM
    Author     : Feshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IntelliGentz</title>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>UserAccount</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/landing-page.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
            <style>
            button.navbar-toggle:hover{
                    color:green;
            }
            </style>
    </head>
    
   <body onload="createRow()">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="index.html">Application Name</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
					<li>
                        <a><button  type="button" class="btn btn-primary" onclick="window.location.assign('index.jsp')" >Home</button></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


    <!-- Header -->
    <a name="about"></a>
    <div class="intro-header" >
        <div class="container">
            <div class="row" >
                <div class="col-lg-12">
                    <div class="intro-message" style="background-color:#E8E8E8; opacity:0.95;">
                        <div style=" width:100%; position:absolute; top:10px; margin: 10px 0 0 0 ; padding-top: 10px;"><b><p style=" color:black; float:right; font-size:17px; margin:0 10px 0 0;">Hi UserName!</p></b></div>
                        <div align="left" style=" position:absolute; top:25px; margin-left: 10px; ">
                                <a><button  type="button" class="btn btn-primary" onclick="window.location.assign('shopForm.jsp')" >Add shop</button></a>
                                <a><button  type="button" class="btn btn-primary" onclick="window.location.assign('editAccount.jsp')" >Edit Account</button></a>
                                <a><button  type="button" class="btn btn-primary" onclick="window.location.assign('userAccount.jsp')" >User Account</button></a>
                        </div>
                        <div style=" width:100%; position:absolute; top:70px;" ><p style="text-shadow:2px 2px 5px #5e5e5e; opacity:0.8;  color:black; font-size:22px;"> History Records</p></div>
                        <table class="table table-hover" style="position:absolute; top:25%; color:black;" id="infoTable" >
							<thead>
								<tr>
									<th>Order</th>
									<th>Time</th>
									<th>status</th>
								</tr>
							</thead>
						</table>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.intro-header -->

    <!-- Footer -->
    <footer >
        <div class="container" >
            <div class="row">
                <div class="col-lg-12">
                    <p class="copyright text-muted small">Copyright &copy; Your Company 2014. All Rights Reserved</p>
                </div>
            </div>
        </div>
    </footer>
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script>
	/*function createRow() {
		var table = document.getElementById("infoTable");
		var row = table.insertRow(1);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		cell1.innerHTML = "NEW CELL1";
		cell2.innerHTML = "NEW CELL2";
		cell3.innerHTML = "NEW CELL1";
		cell4.innerHTML = "NEW CELL2";
		cell5.innerHTML = "NEW CELL1";
		cell6.innerHTML = "NEW CELL2";
		cell7.innerHTML = "NEW CELL1";
	}
	/*var RowElement = {
		ShopID:1,Shop_Name:"Heshan and Sons",Address:"No:20,katubadda,moratuwa",Telephone_Number:0718665835,Category:["Car","Clothes"],Types:["Shirt","Tie","Jeans","Car","Van"]Brand:["Emarold","Nisan","Toyota","JBoss","NLM","Mitsubishi","Suziki"]
	}*/
	</script>
        <style>
            th{text-align: center;}
        </style>
    </body>
</html>
