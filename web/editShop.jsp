<%-- 
    Document   : shopForm
    Created on : Jun 8, 2015, 5:08:32 PM
    Author     : Heshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--meta http-equiv="Content-Type" content="text/html; charset=UTF-8"-->
        <title>IntelliGentz</title>
   
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>Edit shop</title>
	 <script
            src="http://maps.googleapis.com/maps/api/js">
                
        </script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script>
		var map;
		var myCenter;
                var markers = [];
		function initialize()
		{
			myCenter=new google.maps.LatLng(6.933279, 79.849905);
			var mapProp = {
 				center:myCenter,
  				zoom:8,
  				mapTypeId:google.maps.MapTypeId.ROADMAP
  			};

                        map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
  			google.maps.event.addListener(map, 'click', function(event) {
                            
                            if(markers.length!=0){
                                clearOverlays();
                                markers = [];
                                setMarker(event.latLng);
                            }
                            else{
                                setMarker(event.latLng);
                            }
                        });
		}
                function clearOverlays(){
                    for(var i=0; i<markers.length;i++){
                        markers[i].setMap(null);
                    }
                    markers.length=0;
                }
		function setMarker(location) {
                    var marker = new google.maps.Marker({position:location,map:map});
                    markers.push(marker);
                    var infowindow = new google.maps.InfoWindow({
    			content: 'Location of your shop'
                        });
                    infowindow.open(map,marker);
                    
                    validateSelectedLocation(location);
		}
                function validateSelectedLocation(location){
                    if(location.lat()>9.78 || location.lng()<79.5 || location.lat()<5.48 || location.lng()>82.4){
                        window.alert("Location you have selected is out of bounds of Sri lanka.\nTry again!");
                        clearOverlays();
                    }
                    document.getElementById("markersLength").innerHTML = (markers.length);
                }
		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
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
                <a class="navbar-brand topnav" href="index.jsp">Application Name</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
					<li>
                        <a><button type="button" class="btn btn-primary" onclick="window.location.assign('index.jsp')" >Home</button></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


    <!-- Header -->
    <a name="about"></a>
    <div class="intro-header">
        <div class="container" style="width:760px;">
            <div class="row" style="margin-top:30px;">
                <div class="col-lg-12" style="background-color:white; opacity:0.95; color:black; width:750px;">
				  <div class="form-group">
					<label>Shop Name</label>
					<input type="text" class="form-control" id="shopName" placeholder="Ex: XYZ(pvt)LTD">
				  </div>
				  <div class="form-group">
					<label>Address</label>
					<input type="text" class="form-control" id="shopAddress" placeholder="Ex: No:25,Katubedda,Moratuwa">
				  </div>
				  <div class="form-group">
					<label>Contact Number</label>
					<input type="tel" class="form-control" id="shopContactNo" placeholder="Ex: 940718665835">
				  </div>
				  <div class="form-group" style="width:160px; float:left;  margin:5px 5px 5px 0px; padding: 0 10px 0 0px;">
					<label style="float:left; width:100%;text-align:left; ">Category</label><p></p>
							
							  <p  style="margin-left:10px; float:left; "><input style="float:left;" type="checkbox" id="categoryClothes" onclick="document.getElementById('subCategoryWomenClothes').style.opacity=Math.abs(document.getElementById('subCategoryWomenClothes').style.opacity-1);" value="option1" name="womenClothes"><span style="margin-left:5px;">Fashion for women</p>
							  
							  <p style="margin-left:10px; float:left; "><input style="float:left;" type="checkbox" id="categoryClothes" onclick="document.getElementById('subCategoryMenClothes').style.opacity=Math.abs(document.getElementById('subCategoryMenClothes').style.opacity-1);" value="option1" name="manClothes"><span style="margin-left:5px;">Fashion for men</p>
							
							  <p style="margin-left:10px; float:left; "><input  style="float:left;" type="checkbox" id="categoryVehicle" onclick="document.getElementById('subCategoryVehicles').style.opacity=Math.abs(document.getElementById('subCategoryVehicles').style.opacity-1);" value="option2" name="vehicles"><span style="margin-left:5px;"> Vehicles</p>
							
							  <p style="margin-left:10px; float:left; "><input style="float:left;" type="checkbox" id="categoryElecEquip" onclick="document.getElementById('subCategoryElectronic').style.opacity=Math.abs(document.getElementById('subCategoryElectronic').style.opacity-1);" value="option3" name="electronicsEquipments"><span style="margin-left:5px;"> Electronic Equip</p>
							
					
				  </div>
				  <div class="form-group" style="float:left; width:100%;  margin:10px 10px 10px 0px; padding: 0 10px 0 0px;">
					<label style="float:left; width:100%;text-align:left; ">Subcatergory</label>
							
							 <div class="form-group" style=" opacity:0; width:165px; float:left; margin:5px 5px 5px 0px; padding: 0 10px 0 0px;" id="subCategoryWomenClothes">
								<label style="float:left; width:100%;text-align:left; ">Fashion for women</label>
								
								  <p style="margin-left:10px; text-align:left;"><input type="checkbox" id="inlineCheckbox1" value="option1"><span style="margin-left:5px;">Shirt</span></p>
								
								  <p style="margin-left:10px; text-align:left;"><input type="checkbox" id="inlineCheckbox2" value="option2"> <span style="margin-left:5px;">Trouser</span></p>
								
								  <p style="margin-left:10px; text-align:left;"><input type="checkbox" id="inlineCheckbox3" value="option3"> <span style="margin-left:5px;">Under ware</span></p>
								 
								  <p style="margin-left:10px; text-align:left;"><input type="checkbox" id="inlineCheckbox3" value="option3"><span style="margin-left:5px;"> Shoes</span></p>
								
								
							</div>
							<div class="form-group" style=" opacity:0; float:left; margin:5px 5px 5px 0px; padding: 0 10px 0 0px;" id="subCategoryMenClothes">
								<label style="float:left; width:100%;text-align:left; ">Fashion for men</label>
							
								  <p style="margin-left:10px;text-align:left;" ><input style="float:left;" type="checkbox" id="inlineCheckbox1" value="option1" name=""><span style="margin-left:5px;">Shirt</span></p>
								
								  <p style="margin-left:10px;text-align:left;" ><input  style="float:left;" type="checkbox" id="inlineCheckbox2" value="option2"> <span style="margin-left:5px;">Trouser</span></p>
								
								  <p style="margin-left:10px;text-align:left;" ><input style="float:left;" type="checkbox" id="inlineCheckbox3" value="option3"> <span style="margin-left:5px;">Under ware</span></p>
								  
								  <p style="margin-left:10px;text-align:left; "><input style="float:left;" type="checkbox" id="inlineCheckbox3" value="option3"> <span style="margin-left:5px;">Shoes</span></p>
								
							</div>
							<div class="form-group" style="opacity:0; float:left; margin:5px 5px 5px 0px; padding: 0 10px 0 0px;" id="subCategoryVehicles">
								<label style="float:left; width:100%;text-align:left; ">Vehicles</label>
							
								  <p style="margin-left:10px; text-align:left;"><input style="float:left;" type="checkbox" id="inlineCheckbox1" value="option1"><span style="margin-left:5px;">Car</span></p>
								
								  <p style="margin-left:10px; text-align:left;"><input  style="float:left;" type="checkbox" id="inlineCheckbox2" value="option2"> <span style="margin-left:5px;">Van</span></p>
								
								  <p style="margin-left:10px; text-align:left;"><input style="float:left;" type="checkbox" id="inlineCheckbox3" value="option3"> <span style="margin-left:5px;">Heavy Vehicles</span></p>
								
								
							</div>
							<div class="form-group" style="opacity:0; float:left; margin:5px 5px 5px 0px; padding: 0 10px 0 0px; " id="subCategoryElectronic">
								<label style="float:left; width:100%;text-align:left;">Electronic Equip</label>
							
								  <p style="margin-left:10px; text-align:left;"><input style="float:left;" type="checkbox" id="inlineCheckbox1" value="option1"><span style="margin-left:5px;">Phones & tabs</span></p>
								
								  <p style="margin-left:10px; text-align:left;"><input  style="float:left;" type="checkbox" id="inlineCheckbox2" value="option2"> <span style="margin-left:5px;">Computer Accessories</span></p>
								
								  <p style="margin-left:10px; text-align:left;"><input style="float:left;" type="checkbox" id="inlineCheckbox3" value="option3"><span style="margin-left:5px;"> Tv,Radio</span></p>
								
								
							</div>
							
					
				  </div>
                                  <div class="form-group" style="width:400px; float:left;  margin:5px 5px 5px 0px; padding: 0 10px 0 0px;">
					<label style="float:left; width:100%;text-align:left; ">Time frame</label><p></p>
							
                                        <p style="margin-left:10px; float:left; "><input style="float:left;" type="checkbox" id="anyTime" onclick="document.getElementById('subCategoryElectronic').style.opacity=Math.abs(document.getElementById('subCategoryElectronic').style.opacity-1);" value="option3"><span style="margin-left:5px;"></span> Any time</p>
							
                                        <p  style="margin-left:10px; float:left;"><input style="float:left; margin-right:5px; margin-top:10px;" type="checkbox" id="anyDay" onclick="document.getElementById('subCategoryWomenClothes').style.opacity=Math.abs(document.getElementById('subCategoryWomenClothes').style.opacity-1);" value="option1">Any day<span style="margin-right:25px;"></span>From<input type="time" style="height:30px; margin:0 10px 0 10px;"><span style="margin-right:10px;"></span>To<input type="time" style="height:30px; margin:0 10px 0 10px;"></p>
                                        
                                        <p  style="margin-left:10px; float:left;"><input style="float:left; margin-right:5px; margin-top:10px;" type="checkbox" id="weekDays" onclick="document.getElementById('subCategoryWomenClothes').style.opacity=Math.abs(document.getElementById('subCategoryWomenClothes').style.opacity-1);" value="option1">Weekdays<span style="margin-right:10px;"></span>From<input type="time" style="height:30px; margin:0 10px 0 10px;"><span style="margin-right:10px;"></span>To<input type="time" style="height:30px; margin:0 10px 0 10px;"></p>
                                        
                                        <p  style="margin-left:10px; float:left;"><input style="float:left; margin-right:5px; margin-top:10px;" type="checkbox" id="weekEnds" onclick="document.getElementById('subCategoryWomenClothes').style.opacity=Math.abs(document.getElementById('subCategoryWomenClothes').style.opacity-1);" value="option1">Weekends<span style="margin-right:10px;"></span>From<input type="time" style="height:30px; margin:0 10px 0 10px;"><span style="margin-right:10px;"></span>To<input type="time" style="height:30px; margin:0 10px 0 10px;"></p>
					
				  </div>
				<div class="form-group" style=" float:left; margin:10px 10px 10px 10px; padding: 0 10px 0 0px;">
					<p style="color:black; font-size:20px;">Select the location of your shop by clicking on the map</p>
					<p class="importantNote" style=" margin:10px 10px 10px 10px; color:red;">Be careful when selecting the location. All the processing is done by this data.</p>
					<div id="googleMap" style="width:700px;height:380px;align:center; padding:10px 10px 10px 10px; box-shadow: 2px 2px 15px grey;">
				</div>
				  <div class="form-group" style="float:center; margin-top:10px; color:black; position:flex;">
					<p>
					  <input type="checkbox"> Check this for verification
					</p>
				  
				  <button type="submit" class="btn btn-default">Submit</button>
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
	<style>
	label{
		font-size:18px;
		float:left;
		margin-top:10px;
		margin-left:5px;
		margin-right:10px;
	}
	.form-control{
		width:90%;
	}
	</style>
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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
	<script>
	}
	function checkBoxFunction(){
	//if(document.getElementById('checkBox').checked==true){
			document.getElementById('submitButton').disabled=!document.getElementById('submitButton').disabled;
	}
	</script>	
	</script>
    </body>
</html>
